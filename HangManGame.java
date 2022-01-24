import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HangManGame {
    public static void main(String[] args) {
        HangManGame methodChange = new HangManGame();
        methodChange.menu();
    }

    //Main menu for the game
    public void menu() {
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Hangman");
        System.out.println("------------");
        System.out.println("1) Superheroes");
        System.out.println("2) Snacks");
        System.out.println("3) Sports");
        System.out.println("4) Exit");
        System.out.println("------------ \n");


        System.out.print("Please choose from the list to get started: ");

        try {
            int menuChoice = input.nextInt();

            HangManGame methodChange = new HangManGame();

            switch (menuChoice) {
                case 1:
                    //Get random superhero value from superhero enum class and send to guessTopic();
                    SuperHeroes hero = SuperHeroes.getRandomHero();
                    methodChange.guessTopic(hero);
                    break;
                case 2:
                    //Get random snack value from snack enum class and send to guessTopic();
                    Snacks snacks = Snacks.getRandomSnack();
                    methodChange.guessTopic(snacks);
                    break;
                case 3:
                    //Get random sports value from sports enum class and send to guessTopic();
                    Sports sports = Sports.getRandomSport();
                    methodChange.guessTopic(sports);
                    break;
                case 4:
                    System.out.println("\n"+"Thanks for playing!\n");
                    System.exit(1);
                default:
                    throw new InputMismatchException();
            }
        } catch (InputMismatchException inputMismatchException) {
            System.err.println("\n" + "Please Enter a number between 1-4\n");
            menu();
        }
    }

    //Generics used to get a random value from either 3 enum classes
    public <T> void guessTopic(T topic) {
        //ArrayList for user guesses
        ArrayList<Character> userGuessList = new ArrayList<>();
        //ArrayList for wrong guesses
        ArrayList<Character> wrongGuess = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        //Variables used to determine if users guess was wrong
        int wrongAnswer = 0;
        int wrongIncrement;

        System.out.println("_____________");
        System.out.println("|\t\t\t|");

        //Convert topic to char array
        char[] topicArray = topic.toString().toCharArray();

        //Replace values with underscores(_) or spaces
        for (int i = 0; i < topicArray.length; i++) {
            if (topicArray[i] != '_') {
                userGuessList.add('_');
            } else {
                userGuessList.add(' ');
            }
        }

        //Print out the spaces for the topic
        for (Character user : userGuessList) {
            System.out.print(user);
        }

        while (userGuessList.contains('_')) {
            //Set wrongIncrement to 0 every increment
            wrongIncrement = 0;

            System.out.print("\n\n" + "Your Guess: ");
            String userGuess = input.next();
            userGuess = userGuess.toUpperCase();
            char charUserGuess = userGuess.charAt(0);

            for (int i = 0; i < topicArray.length; i++) {
                //If user guess is in topic value, replace the underscore with their answer
                if (topicArray[i] == charUserGuess) {
                    userGuessList.set(i, topicArray[i]);
                } else {
                    //If user guess is not in topic value
                    wrongIncrement++;
                    if (wrongIncrement == topicArray.length) {
                        wrongAnswer++;
                        wrongGuess.add(userGuess.charAt(0));

                        System.out.println("_____________");
                        System.out.println("|\t\t\t|");

                        if (wrongAnswer == 1) {
                            System.out.println("|\t\t\to");
                            System.out.println(" ");
                        }
                        if (wrongAnswer == 2) {
                            System.out.println("|\t\t   \\o");
                            System.out.println(" ");
                        }
                        if (wrongAnswer == 3) {
                            System.out.println("|\t\t   \\o/");
                            System.out.println(" ");
                        }
                        if (wrongAnswer == 4) {
                            System.out.println("|\t\t   \\o/");
                            System.out.println("|\t\t\t|");
                            System.out.println(" ");
                        }
                        if (wrongAnswer == 5) {
                            System.out.println("|\t\t   \\o/");
                            System.out.println("|\t\t\t|");
                            System.out.println("|\t\t   /");
                            System.out.println(" ");
                        }
                        if (wrongAnswer == 6) {
                            System.out.println("|\t\t   \\o/");
                            System.out.println("|\t\t\t|");
                            System.out.println("|\t\t   / \\");
                            System.out.println("\n"+"Sorry, the right answer was: " +topic);
                            System.out.println(" ");
                            main(null);
                        }

                        System.out.print("Incorrect Guesses: " +wrongGuess +"\n");
                    }
                }
            }

            //Print users correct answer
            for (Character user : userGuessList) {
                System.out.print(user);
            }
        }

        System.out.println(" ");

        main(null);

    }
}
