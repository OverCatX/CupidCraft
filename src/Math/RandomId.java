package Math;

import java.util.SplittableRandom;

public class RandomId {
    public static final SplittableRandom random = new SplittableRandom();

    public static double rand(double min, double max) {
        if (min == max) {
            return max;
        }
        return random.nextDouble(max + 1 - min) + min;

    }

}
