import java.util.*;

public class Kmpalgo2 {

    static void computelpsarray(String s2, int M, int lps[]) {
        int j = 0;
        int i = 1;
        lps[0] = 0;
        // the loop calc lps[i] for i=1 to M-1;
        while (i < M) {
            if (s2.charAt(i) == s2.charAt(j)) {
                j++;
                lps[j] = j;
                i++;
            } else { // if(pat[i] != pat[j])
                if (j != 0) {
                    j = lps[j - 1];

                } else { // if(j == 0)
                    lps[i] = j;
                    i++;
                }
            }
        }
    }

    static void Kmpsearch(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        // create lps[] that will hold longest prefix suffix value for pattern
        int lps[] = new int[len2];
        // preprrocess the pattern (calculate lps array);
        computelpsarray(s2, len2, lps);
        for (int i = 0; i < s2.length(); i++) {
            System.out.print(lps[i] + " ");
        }
        System.err.println();
        boolean found = false;
        int j = 0;
        int i = 0;
        while (i < len1) {
            if (s2.charAt(j) == s1.charAt(i)) {
                j++;
                i++;
            }
            if (j == len2) {
                found = true;
                System.out.println("pattern found at " + (i - j));
                j = lps[j - 1];
            } else if (i < len1 && s2.charAt(j) != s1.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i = i + 1;
                }
            }
        }
        if (!found) {
            System.out.println("Pattern not found");
        }

    }

    public static void main(String[] args) {
        // Naive approch
        // Scanner sc = new Scanner(System.in);
        // String x = sc.next();
        // String y = sc.next();

        // int n = x.length();
        // int m = y.length();
        // int flag = 0;
        // for (int i = 0; i <= n - m; i++) {
        // int j;
        // for (j = 0; j < m; j++) {
        // if (x.charAt(i + j) != y.charAt(j)) {
        // break;
        // }
        // }
        // if (j == m) {
        // flag = 1;
        // System.out.print(i + " ");
        // }
        // }
        // if (flag == 0) {
        // System.err.print("Not found");
        // }

        // Kmp Algoritham

        String s1 = "abcdabcabcdf";
        String s2 = "abc";
        Kmpsearch(s1, s2);
    }
}
