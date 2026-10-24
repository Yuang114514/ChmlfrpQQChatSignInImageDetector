package cn.yuang2714.chmlfrpimgdetector;

import java.awt.*;

public class Util {
    public static String toHex(Color color) {
        return "#" +
                Integer.toHexString(color.getRed()) +
                Integer.toHexString(color.getGreen()) +
                Integer.toHexString(color.getBlue());
    }
}
