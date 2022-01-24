import java.util.Random;

public enum Sports {
    HOCKEY,
    BASKETBALL,
    FOOTBALL,
    BASEBALL,
    CURLING,
    SOCCER,
    TENNIS,
    CRICKET;

    public static Sports getRandomSport(){
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
