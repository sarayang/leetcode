package Bloomberg;

/**
 * Created by YANGSONG on 2018-10-10.
 */
public class CandyCrash {
    public String candyCrash(String s) {
        if (s.length() == 0) {
            return "";
        }

        int i = 0;
        while (i < s.length()) {
            int j = i;
            while (j < s.length() && s.charAt(i) == s.charAt(j)) {
                j++;
            }
            if ((j - i) >= 3) {
                if (j == s.length()) {
                    s = s.substring(0, i);
                } else {
                    s = s.substring(0, i) + s.substring(j, s.length());
                }
                i = 0;
            } else {
                i++;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        CandyCrash candy = new CandyCrash();
        String ss = "DDDDD";
        String st = "AABBCCDDDCBA";
        String se = "ABBCCCBA";
        String sr = "ABCDE";
        System.out.println(candy.candyCrash(ss));
        System.out.println(candy.candyCrash(st));
        System.out.println(candy.candyCrash(se));
        System.out.println(candy.candyCrash(sr));
    }
}
