import java.util.ArrayList;

public class PossibleWords extends ArrayList<String> {

    private final WordsList wordsList;
    private final UserGuess userGuess;

    public PossibleWords(UserGuess userGuess) {

        wordsList = new WordsList();
        this.addAll(wordsList);
        this.userGuess = userGuess;
    }

    public void trimList() {

        for (String word : wordsList) {
            for (int i = 0; i < word.length(); i++) {
                String userGuessChar = Character.toString(userGuess.getUserGuess().charAt(i));

                if (Character.toString(word.charAt(i)).equalsIgnoreCase(userGuessChar)) {
                    if (userGuess.getGuessRes()[i] != 1) {
                        this.remove(word);
                        break;
                    }
                } else {
                    if (userGuess.getGuessRes()[i] != 1) {
                        if (userGuess.getGuessRes()[i] == 2) {
                            if (userGuess.hasDuplicateChars()) {
                                if (!duplicateMatch(userGuessChar, userGuess.getUserGuess(), word)) {
                                    this.remove(word);
                                    break;
                                }
                            }

                            if (!word.toLowerCase().contains(userGuessChar)) {
                                this.remove(word);
                                break;
                            }
                        }

                        else if (userGuess.getGuessRes()[i] == 0) {
                            if (word.contains(userGuessChar.toUpperCase())) {
                                this.remove(word);
                                break;
                            }
                        }
                    } else {
                        this.remove(word);
                        break;
                    }
                }
            }
        }
    }

    private boolean duplicateMatch(String dupLetter, String userGuess, String word) {

        int guessDupCount = userGuess.length() - userGuess.replaceAll(dupLetter, "").length();
        int wordDupCount = word.length() - word.toLowerCase().replaceAll(dupLetter, "").length();

        return guessDupCount == wordDupCount;
    }

    public void displayPossibleWords() {

        System.out.println("\nPossible Words: ");

        for (String word : this) {
            System.out.println(word);
        }

        System.out.println();
    }
}

