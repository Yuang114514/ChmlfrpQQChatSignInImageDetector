package cn.yuang2714.chmlfrpimgdetector;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.*;
import java.util.List;

public class Detector {
    static void main(String[] args) throws Exception {
        String path;
        int numberCount = 4;
        if (args.length >= 1) path = args[0];
        else path = IO.readln("请输入要识别的图片路径：");
        if (args.length >= 2) numberCount = Integer.parseInt(args[1]);
        
        BufferedImage img = ImageIO.read(new File(path));
        
        long start = System.nanoTime();
        
        Pair<Color, List<Color>> analyze = analyzeColor(img, numberCount);
        Color background = analyze.left();
        List<Color> noises = analyze.right();
        
        IO.println("开始查找数字......");
        //List<Pair<X坐标，数字>>
        List<Pair<Integer, Integer>> detected = new ArrayList<>();
        for (int y = 0; y < img.getHeight(); y++) {
            for (int x = 0; x < img.getWidth(); x++) {
                Color pixel = new Color(img.getRGB(x, y));
                if (!pixel.equals(background) && !noises.contains(pixel)) {
//                    IO.println("找到异色像素 颜色 " + Util.toHex(pixel) + " 位置 (" + x + "," + y + ")");
                    Optional<Integer> scan = scan(img, x, y, pixel);
                    if (scan.isPresent()) {
                        detected.add(new Pair<>(x, scan.get()));
                        IO.println("找到数字 " + scan.get() + " ，颜色：" + Util.toHex(pixel));
                        
                        //跳过剩余像素
                        x += 5;
                    }
                }
            }
        }
        IO.println("遍历完成，共找到 " + detected.size() + " 个数字");
        
        IO.println("正在按X坐标排序");
        detected.sort(Comparator.comparingInt(Pair::left));
        IO.println("排序完成");
        detected.forEach(p -> IO.println("数字 " + p.right() + " X坐标 " + p.left()));
        
        StringBuilder resultBuilder = new StringBuilder();
        detected.forEach(p -> resultBuilder.append(p.right()));
        
        long end = System.nanoTime();
        IO.println("结果：" + resultBuilder + " 用时：" + Util.calculateTime(end - start) + "ms");
    }
    
    //Pair<背景色, List<杂色>>
    private static Pair<Color, List<Color>> analyzeColor(BufferedImage img, int numberCuont) {
        IO.println("开始分析颜色...");
        //Map<颜色, 数量>
        Map<Color, Integer> colors = new HashMap<>();
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                Color pixel = new Color(img.getRGB(i, j), true);
                colors.put(pixel, colors.getOrDefault(pixel, 0) + 1);
            }
        }
        IO.println("颜色统计完成，共" + colors.size() + "个颜色");
        
        Color mostFrequentColor = Color.BLACK;
        int maxCount = 0;
        List<Color> noise = new ArrayList<>();
        for (Map.Entry<Color, Integer> entry : colors.entrySet()) {
            //出现次数太多或太少就排除掉（十个数字里7最少只有15个像素，5和6并列第一有23个像素
            //见CodeGenerator.genNumberTrues()
            //预期找到4个数字
            if (entry.getValue() < 15 * numberCuont || entry.getValue() > 23 * numberCuont) noise.add(entry.getKey());
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentColor = entry.getKey();
            }
        }
        IO.println("找到背景色：" + Util.toHex(mostFrequentColor) + "，出现 " + maxCount + "次");
        IO.println("找到 " + noise.size() + " 个杂色");
        
        return new Pair<>(mostFrequentColor, noise);
    }
    
    private static Optional<Integer> scan(BufferedImage img, int x, int y, Color foreground) {
        if (x > img.getWidth() - 6 || y > img.getHeight() - 10) return Optional.empty();
        
        Integer i = null;
        for (NumberMatrix matrix : NumberMatrices.ITERATOR) {
            boolean detected = match(
                    img.getSubimage(Math.max(0, x + matrix.offset()), y, 6, 10),
                    matrix.matrix(),
                    foreground
            );
            if (detected) i = matrix.number();
        }
        return Optional.ofNullable(i);
    }
    
    private static boolean match(BufferedImage img, boolean[][] number, Color target) {
        //用位运算抹掉alpha值
        //1010 1110 1011 0010 1110 1000 1001 0110 &
        //0000 0000 1111 1111 1111 1111 1111 1111 =
        //0000 0000 1011 0010 1110 1000 1001 0110
        int targetRGB = target.getRGB() & 0x00_FF_FF_FF;
        
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 6; x++) {
                //用位运算抹掉alpha值
                int currentRGB = img.getRGB(x, y) & 0x00_FF_FF_FF;
                if ((currentRGB == targetRGB) != number[y][x])
                    return false;
            }
        }
        return true;
    }
}
