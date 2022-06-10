import java.util.*;

public class PossibleWords extends ArrayList<String> {

    final private WordsList wordsList;

    public PossibleWords() {

        wordsList = new WordsList();
        this.addAll(wordsList);
    }

    public void trimList(UserGuess userGuess) {

        for (String word : wordsList) {
            for (int j = 0; j < word.length(); j++) {
                if (Character.toString(word.charAt(j)).equalsIgnoreCase(Character.toString(userGuess.getUserGuess().charAt(j)))) {
                    if (userGuess.getGuessRes()[j] != 1) {
                        this.remove(word);
                        break;
                    }
                } else {
                    if (userGuess.getGuessRes()[j] == 1) {
                        this.remove(word);
                        break;
                    }

                    if (!word.contains(Character.toString(userGuess.getUserGuess().charAt(j)))) {
                        if (userGuess.getGuessRes()[j] == 2) {
                            this.remove(word);
                            break;
                        }
                    }
                }
            }
        }
    }

    public void displayPossibleWords() {

        System.out.println("\nPossible Words: ");

        for (String word : this) {
            System.out.println(word);
        }

        System.out.println();
    }
}
