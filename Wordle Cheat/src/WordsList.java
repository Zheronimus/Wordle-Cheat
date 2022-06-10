import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class WordsList extends ArrayList<String> {

    public WordsList() {

        this.addAll(Arrays.asList(fileAsString("src/CSW2019.txt").split(" ")));
    }

    public String fileAsString(String path) {

        String word;
        Scanner scanner = null;
        StringBuilder sb = new StringBuilder();

        try {
            scanner = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (scanner.hasNextLine()) {
            word = scanner.nextLine();
            sb.append(word + " ");
        }

        scanner.close();

        return sb.toString();
    }

    public int binarySearch(String word) {

        int l = 0, r = this.size() - 1;

        while (l <= r) {
            int m = l + (r - l) / 2;

            int res = word.toLowerCase().compareTo(this.get(m).toLowerCase());

            if (res == 0) {
                return m;
            } if (res > 0) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }
}
