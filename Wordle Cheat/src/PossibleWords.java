import java.util.*;

public class PossibleWords extends ArrayList<String> {

    final private WordsList wordsList;

    public PossibleWords() {

        wordsList = new WordsList();
        this.addAll(wordsList);
    }

    public void trimList(UserGuess userGuess) {

        for (String word : wordsList) {
            for (int i = 0; i < word.length(); i++) {
                if (Character.toString(word.charAt(i)).equalsIgnoreCase(Character.toString(userGuess.getUserGuess().charAt(i)))) {
                    if (userGuess.getGuessRes()[i] != 1) {
                        this.remove(word);
                        break;
                    }
                } else {
                    if (userGuess.getGuessRes()[i] != 1) {
                        if (userGuess.getGuessRes()[i] == 2) {
                            if (!word.contains(Character.toString(userGuess.getUserGuess().charAt(i)).toUpperCase())) {
                                this.remove(word);
                                break;
                            }
                        }

                        else if (userGuess.getGuessRes()[i] == 0 && !hasDuplicateChars(word, userGuess)) {
                            if (word.contains(Character.toString(userGuess.getUserGuess().charAt(i)).toUpperCase())) {
                                this.remove(word);
                                break;
                            }
                        }
                    } else {
                        this.remove(word);
                        break;
                    }

                    // NEED TO CHECK IF GUESS CONTAINS DUPLICATE AND ONE OF THE CHARACTER IS A "1" AND ONE IS A "2"!!!
                }
            }
        }
    }

    private boolean hasDuplicateChars(String word, UserGuess userGuess) {

        for (int i = 0; i < word.length(); i++) {
            for (int j = i + 1; j < word.length(); j++) {
                if (Character.toString(userGuess.getUserGuess().charAt(i)).equalsIgnoreCase(Character.toString(word.charAt(j)))) {
                    if (userGuess.getGuessRes()[i] != 0 || userGuess.getGuessRes()[j] != 0) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public void displayPossibleWords() {

        System.out.println("\nPossible Words: ");

        for (String word : this) {
            System.out.println(word);
        }

        System.out.println();
    }
}
