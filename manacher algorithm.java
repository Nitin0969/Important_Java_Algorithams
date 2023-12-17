import java.lang.reflect.Array;
import java.util.Arrays;

public class Manacheralgo {
    static void printsubstring(String str, int left, int right) {
        for (int i = left; i <= right; i++)
            System.out.print(str.charAt(i));
    }

    public static void longestpalindrome(String s) {
        int strlen = 2 * s.length() + 3;
        char[] schars = new char[strlen];
        schars[0] = '@';
        schars[strlen - 1] = '$';
        int t = 1;
        for (char c : s.toCharArray()) {
            schars[t++] = '#';
            schars[t++] = c;
        }
        schars[t] = '#';
        System.out.println("String : " + Arrays.toString(schars));

        int maxlen = 0;
        int start = 0;
        int maxright = 0;
        int center = 0;
        int p[] = new int[strlen];
        for (int i = 1; i < strlen - 1; i++) {
            if (i < maxlen) {
                p[i] = Math.min(maxright - i, p[2 * center - i]);
            }
            while (schars[i + p[i] + 1] == schars[i - p[i] - 1]) {

                p[i]++;
            }
            if (i + p[i] > maxright) {
                center = i;
                maxright = i + p[i];
            }
            if (p[i] > maxlen) {
                start = (i - p[i] - 1) / 2;
                maxlen = p[i];
            }
        }
        System.out.println("lps : " + Arrays.toString(p));
        System.out.print("the longest palindromic substring is: ");
        printsubstring(s, start, start + maxlen - 1);
        System.out.println();
        System.out.println("length of longest palindrome substring is  " + maxlen);
    }

    public static void main(String[] args) {
        String str = "babad";
        longestpalindrome(str);
    }
}
