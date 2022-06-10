import java.util.Scanner;

public class UserGuess {

    private String userGuess;
    private final int[] guessRes = new int[5];

    public UserGuess() {

    }

    public void setUserGuess(String userGuess) {
        this.userGuess = userGuess;
    }

    public String getUserGuess() {
        return userGuess;
    }

    public int[] getGuessRes() {
        return guessRes;
    }

    public void setPosResult(Scanner in) {

        System.out.println("Insert '1' for correct position, '2' for correct letter, or '0' for neither: ");

        for (int i = 0; i < 5; i++) {
            int pos = in.nextByte();

            if (pos >= 0 && pos < 3) {
                this.guessRes[i] = pos;
            }
        }
    }
}
