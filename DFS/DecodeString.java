package DFS;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by YANGSONG on 2018-10-04.
 */
public class DecodeString {
    public String decodeString(String s) {
        if (s.length() == 0) {
            return "";
        }
        Deque<String> string = new LinkedList<>();
        Deque<Integer> integ = new LinkedList<>();
        String res = "";
        // char[] cha = s.toCharArray();
        int i = 0;
        while (i < s.length()) {
            if (Character.isDigit(s.charAt(i))) {
                int count = 0;
                while (Character.isDigit(s.charAt(i))) {
                    int j = Integer.parseInt(s.substring(i, i+1));
                    count = count * 10 + j;
                    i++;
                }
                integ.offer(count);
            } else if (s.charAt(i) == '[') {
                string.offer(res);
                res = "";
                i++;
            } else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder(string.pollLast());
                int num = integ.pollLast();
                for (int m = 0; m < num; m++) {
                    sb.append(res);
                }
                res = sb.toString();
                i++;
            } else {
                res += s.charAt(i);
                i++;
            }
        }
        return res;
    }



    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        String s = "3[aub]";
        String res = ds.decodeString(s);
        System.out.println(res);
    }
}
