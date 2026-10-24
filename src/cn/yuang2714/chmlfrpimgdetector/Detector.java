package cn.yuang2714.chmlfrpimgdetector;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Detector {
    static void main() throws Exception {
        BufferedImage img = ImageIO.read(new File(IO.readln("请输入要识别的图片路径：")));
        
        getBackgrondColor(img);
    }
    
    private static Color getBackgrondColor(BufferedImage img) {
        IO.println("开始寻找背景色...");
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
        for (Map.Entry<Color, Integer> entry : colors.entrySet()) {
            IO.println(entry);
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentColor = entry.getKey();
            }
        }
        IO.println("找到背景色：" + Util.toHex(mostFrequentColor) + "，出现 " + maxCount + "次");
        
        return mostFrequentColor;
    }
}
