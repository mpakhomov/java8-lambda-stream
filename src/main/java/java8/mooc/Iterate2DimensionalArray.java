package java8.mooc;

import com.mpakhomov.IntPair;
import com.mpakhomov.Pair;

import java.util.stream.IntStream;

/**
 * @author mpakhomov
 * @since 7/31/2015
 */
public class Iterate2DimensionalArray {
    public static void main(String[] args) {
        int[][] array = new int[][] {new int[]{1, 2}, new int[]{3, 4}, new int[]{5, 6}};
        IntStream.range(0, array.length)
                .boxed()
                .flatMap(i -> IntStream.range(0, array[i].length).boxed().map(j -> new Pair<>(i, j)))
                .forEach((Pair<Integer> p) -> System.out.println(array[p.x][p.y]));
    }
}
