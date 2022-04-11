package LeetcodeDSA;

public class SmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        // char[] letters = {'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'};
        // char target = 'e';
        char[] letters = {'c', 'f', 'a'};
        char target = 'c';
        char c = nextGreatestLetter(letters, target);
        System.out.println(c);
    }

    public static char nextGreatestLetter(char[] letters, char target) {
        int l = 0;
        int h = letters.length - 1;
        int t = target - 'a';

        while (l < h) {
            int m = l + (h - l) / 2;
            if (letters[m] - 'a' <= t) {
                l = m + 1;
            } else {
                h = m;
            }
        }

        return target >= letters[l] ? letters[0] : letters[l];
    }

}
