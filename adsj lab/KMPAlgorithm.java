import java.util.*;
public class KMPAlgorithm {
    private static int[] LPSArray(String pattern) {
        int[] lps = new int[pattern.length()];
        int i = 1, j = 0;
        while (i < pattern.length()) {
            if (pattern.charAt(i) == pattern.charAt(j)) {
                ps[i] = j + 1;
                i++;
                j++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                } // inner else closing
            } // outer else closing
        } // while closing
        return lps;
    }// LPSArray closing

    public static void KMPSearch(String text, String pattern) {
        int[] lps = LPSArray(pattern);
        int i = 0, j = 0;
        while (i < text.length()) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
                if (j == pattern.length()) {
                    System.out.println("Pattern found at index " + (i - j));
                    j = lps[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter Text:");
        String text = s.nextLine();
        System.out.println("enter Pattern:");
        String pattern = s.nextLine();
        KMPSearch(text, pattern);
    }
}
