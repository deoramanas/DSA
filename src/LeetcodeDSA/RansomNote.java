package LeetcodeDSA;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aa", magazine = "ab";
        boolean canConstruct = canConstruct(ransomNote, magazine);
        System.out.println(canConstruct);
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] magazineArr = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            magazineArr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            magazineArr[ransomNote.charAt(i) - 'a']--;
        }
        for (int i = 0; i < magazineArr.length; i++) {
            if (magazineArr[i] < 0) {
                return false;
            }
        }

        return true;
    }
}
