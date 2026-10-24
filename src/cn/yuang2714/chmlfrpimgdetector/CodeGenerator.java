package cn.yuang2714.chmlfrpimgdetector;

import java.util.Arrays;

public class CodeGenerator {
    void main() {
        genArrays();
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
}
