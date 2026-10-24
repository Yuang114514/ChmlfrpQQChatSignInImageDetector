package cn.yuang2714.chmlfrpimgdetector;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class CodeGenerator {
    void main() throws Exception {
        genArrays();
        genMatrices();
        genNumberTrues();
    }
    
    private static void genArrays() {
        for (int i = 0; i < 64; i++) {
            boolean[] res = intToBooleanArray(i, 6);
            
            IO.println(
                    Arrays.toString(res)
                          .replace("[", "")
                          .replace("]", "")
                          .replace(" ", "")
                          .replace(",", "")
                          .replace("true", "W")
                          .replace("false", "I")
                            + " = " +
                            Arrays.toString(res)
                                  .replace('[', '{')
                                  .replace(']', '}')
                                  .replace("true", "W")
                                  .replace("false", "I")
                                  .replace(", ", ",")
                            + ",");
        }
    }
    
    public static boolean[] intToBooleanArray(long possibility, int rows) {
        
        boolean[] answer = new boolean[rows];
        
        for (int i = 0 ; i < rows ; i++) {
            boolean value = ((possibility >> i) & 1) == 1;
            answer[rows - i - 1] = value;
        }
        
        return answer;
    }
    
    private static final Map<Integer, String> names = Map.of(
            1,"ONE",
            2, "TWO",
            3, "THREE",
            4, "FOUR",
            5, "FIVE",
            6, "SIX",
            7, "SEVEN",
            8, "EIGHT",
            9, "NINE",
            0, "ZERO"
    );
    
    private static void genMatrices() throws IOException {
        BufferedImage font = ImageIO.read(Objects.requireNonNull(CodeGenerator.class.getResource("/numbers.png")));
        
        StringBuilder builder = new StringBuilder("public static final boolean[][]\n    ");
        for (int number = 0; number < 10; number++) {
            builder.append(names.get(number == 9 ? 0 : number + 1)).append(" = {\n");
            for (int y = 0; y < 10; y++) {
                builder.append("    {");
                for (int x = 0; x < 6; x++) {
                    if (font.getRGB(number * 7 + x, y) == 0xFF_FF_FF_FF) builder.append("W");
                    else builder.append("I");
                    builder.append(",");
                }
                builder.append("},\n");
            }
            builder.append("    }, ");
        }
        builder.append("\n;");
        
        IO.println(builder);
    }
    
    private static void genNumberTrues() {
        StringBuilder builder = new StringBuilder();
        for (NumberMatrix i : NumberMatrices.ITERATOR) {
            builder.append(i.number()).append("：");
            int count = 0;
            for (boolean[] j : i.matrix()) {
                for (boolean k : j) if (k) count++;
            }
            builder.append(count).append("\n");
        }
        IO.println(builder);
    }
}
