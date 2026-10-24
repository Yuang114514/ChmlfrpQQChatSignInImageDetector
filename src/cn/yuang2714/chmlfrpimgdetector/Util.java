package cn.yuang2714.chmlfrpimgdetector;

import java.awt.*;

public class Util {
    public static String toHex(Color color) {
        return "#" +
                padLeft0(Integer.toHexString(color.getRed())) +
                padLeft0(Integer.toHexString(color.getGreen())) +
                padLeft0(Integer.toHexString(color.getBlue()));
    }
    
    public static String padLeft0(String s) {
        return "0".repeat(2 - s.length()) + s;
    }
    
    public static String cutNumber(float f) {
        String[] number = Float.toString(f).split("\\.", 2);
        return number[0] + "." + number[1].substring(0, Math.min(number[1].length(), 2));
    }
}
