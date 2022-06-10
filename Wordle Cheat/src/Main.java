import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        WordsList wordsList = new WordsList();
        PossibleWords possibleWords = new PossibleWords();
        UserGuess userGuess = new UserGuess();
        Scanner in = new Scanner(System.in);
        String terminateChar;

        do {
            do {
                System.out.print("Wordle Guess: ");
                userGuess.setUserGuess(in.next());

                if (userGuess.getUserGuess().length() != 5 || wordsList.binarySearch(userGuess.getUserGuess()) == -1) {
                    System.out.println("Invalid Guess\n");
                }
            } while (userGuess.getUserGuess().length() != 5 || wordsList.binarySearch(userGuess.getUserGuess()) == -1);

            userGuess.setPosResult(in);
            possibleWords.trimList(userGuess);

            System.out.print("\nWas '" + userGuess.getUserGuess() + "' the correct word? ('y' for yes or any other character for no): ");
            terminateChar = in.next();

            possibleWords.displayPossibleWords();
        } while (!terminateChar.equals("y") && possibleWords.size() > 1);
    }
}
