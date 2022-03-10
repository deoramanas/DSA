package LeetcodeDSA;

public class ValidAnagram {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        boolean anagram = isAnagram(s, t);
        System.out.println(anagram);
    }

    public static boolean isAnagram(String s, String t) {
        int word[] = new int[26];

        for (int i = 0; i < s.length(); i++) {
            word[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            word[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < word.length; i++) {
            if (word[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
