package cn.yuang2714.chmlfrpimgdetector;

import java.util.Iterator;
import java.util.List;

public class NumberMatrices implements Iterable<NumberMatrix> {
    public static final NumberMatrices ITERATOR = new NumberMatrices();
    
    private static final boolean 
            I = false,
            W = true
    ;
    
    //看不懂的眯上眼，就能看出数字了
    //这是从numbers.png里抠的点阵，由CodeGenerator生成
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
            {I,W,I,I,W,I},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {W,I,I,I,I,W},
            {I,W,I,I,W,I},
            {I,I,W,W,I,I},
            }
    ;
    
    public static final List<NumberMatrix> matrices = List.of(
            //public record NumberMatrix(boolean[][] matrix, int number, int offset) {}
            //offset是X轴偏移量，用来调整包围盒
            new NumberMatrix(ONE, 1, -2),
            new NumberMatrix(TWO, 2, -1),
            new NumberMatrix(THREE, 3, -1),
            new NumberMatrix(FOUR, 4, -4),
            new NumberMatrix(FIVE, 5, 0),
            new NumberMatrix(SIX, 6, -2),
            new NumberMatrix(SEVEN, 7, 0),
            new NumberMatrix(EIGHT, 8, -1),
            new NumberMatrix(NINE, 9, -1),
            new NumberMatrix(ZERO, 0, -2)
    );
    
    @Override
    public Iterator<NumberMatrix> iterator() {
        return matrices.iterator();
    }
}
