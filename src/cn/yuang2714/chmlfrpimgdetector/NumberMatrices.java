package cn.yuang2714.chmlfrpimgdetector;

import java.util.Iterator;
import java.util.List;

public class NumberMatrices implements Iterable<boolean[][]> {
    public static final NumberMatrices ITERATOR = new NumberMatrices();
    
    private static final boolean 
            I = false,
            W = true
    ;
    
    //看不懂的眯上眼，就能看出数字了
    //这是从numbers.png里抠的点阵
    public static final boolean[][]
            ONE = {
            {I,I,W,I,I,I},
            {I,W,W,I,I,I},
            {W,I,W,I,I,I},
            {I,I,W,I,I,I},
            {I,I,W,I,I,I},
            {I,I,W,I,I,I},
            {I,I,W,I,I,I},
            {I,I,W,I,I,I},
            {I,I,W,I,I,I},
            {W,W,W,W,W,I},
            }, TWO = {
            {I,W,W,W,W,I},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {I,I,I,I,I,W},
            {I,I,I,W,W,I},
            {I,I,W,I,I,I},
            {I,W,I,I,I,I},
            {W,I,I,I,I,I},
            {W,I,I,I,I,I},
            {W,W,W,W,W,W},
            }, THREE = {
            {I,W,W,W,W,I},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {I,I,I,I,I,W},
            {I,I,W,W,W,I},
            {I,I,I,I,I,W},
            {I,I,I,I,I,W},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {I,W,W,W,W,I},
            }, FOUR = {
            {I,I,I,I,W,I},
            {I,I,I,W,W,I},
            {I,I,W,I,W,I},
            {I,W,I,I,W,I},
            {W,I,I,I,W,I},
            {W,I,I,I,W,I},
            {W,W,W,W,W,W},
            {I,I,I,I,W,I},
            {I,I,I,I,W,I},
            {I,I,I,I,W,I},
            }, FIVE = {
            {W,W,W,W,W,W},
            {W,I,I,I,I,I},
            {W,I,I,I,I,I},
            {W,I,I,I,I,I},
            {W,W,W,W,W,I},
            {I,I,I,I,I,W},
            {I,I,I,I,I,W},
            {I,I,I,I,I,W},
            {W,I,I,I,I,W},
            {I,W,W,W,W,I},
            }, SIX = {
            {I,I,W,W,W,I},
            {I,W,I,I,I,I},
            {W,I,I,I,I,I},
            {W,I,I,I,I,I},
            {W,W,W,W,W,I},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {I,W,W,W,W,I},
            }, SEVEN = {
            {W,W,W,W,W,W},
            {I,I,I,I,I,W},
            {I,I,I,I,I,W},
            {I,I,I,I,W,I},
            {I,I,I,I,W,I},
            {I,I,I,I,W,I},
            {I,I,I,W,I,I},
            {I,I,I,W,I,I},
            {I,I,I,W,I,I},
            {I,I,I,W,I,I},
            }, EIGHT = {
            {I,W,W,W,W,I},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {I,W,W,W,W,I},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {I,W,W,W,W,I},
            }, NINE = {
            {I,W,W,W,W,I},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {I,W,W,W,W,W},
            {I,I,I,I,I,W},
            {I,I,I,I,I,W},
            {I,I,I,I,I,W},
            {I,I,I,I,W,I},
            {I,W,W,W,I,I},
            }, ZERO = {
            {I,I,W,W,I,I},
            {I,W,I,I,W,W},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {I,W,I,I,W,W},
            {I,I,W,W,I,I},
            }
    ;
    
    @Override
    public Iterator<boolean[][]> iterator() {
        return List.of(ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, ZERO).iterator();
    }
}
