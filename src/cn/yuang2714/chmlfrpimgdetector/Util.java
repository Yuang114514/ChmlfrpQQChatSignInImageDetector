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
    
    public static String calculateTime(long time) {
        String s = Long.toString(time);
        if (s.length() <= 2) return s;
        return s.substring(0, 2) + "." + s.substring(2, Math.min(5, s.length()));
    }
}
