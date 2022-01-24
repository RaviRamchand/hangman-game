import java.util.Random;

public enum Snacks {
    PIZZA,
    POPCORN,
    ICE_CREAM,
    CAKE,
    PIE,
    WAFFLES,
    DONUTS;

    public static Snacks getRandomSnack(){
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
