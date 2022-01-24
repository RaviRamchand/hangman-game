import java.util.Random;

public enum SuperHeroes {
    SPIDER_MAN,
    IRON_MAN,
    BLACK_WIDOW,
    CAPTAIN_AMERICA,
    SHANG_CHI,
    VISION,
    SCARLET_WITCH,
    HULK,
    HAWKEYE,
    THOR,
    DOCTOR_STRANGE,
    BLACK_PANTHER;

    //Pick a random enum value
    public static SuperHeroes getRandomHero(){
        Random  random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
