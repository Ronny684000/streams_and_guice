package utils;

import java.util.Random;

public class RandomUtils {

    public static int getRandomNumber(int bound) {
        return new Random().nextInt(bound);
    }
}
