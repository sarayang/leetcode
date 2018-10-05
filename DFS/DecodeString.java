package DFS;

import java.util.Stack;

/**
 * Created by YANGSONG on 2018-10-04.
 */
public class DecodeString {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> countStack = new Stack<>();
        Stack<String> resStack = new Stack<>();
        int idx = 0;
        while (idx < s.length()) {
            if (res.equals("")) {
                System.out.println("empty - index: " + idx);
            } else {
                System.out.println(res + " - index: " + idx);
            }

            if (Character.isDigit(s.charAt(idx))) {
                System.out.println("if");

                int count = 0;
                while (Character.isDigit(s.charAt(idx))) {
                    count = 10 * count + (s.charAt(idx) - '0');
                    idx++;
                }
                countStack.push(count);
                System.out.println(res);
            }
            else if (s.charAt(idx) == '[') {
                System.out.println("1st elseif");

                resStack.push(res);
                res = "";
                idx++;
                System.out.println(res);
            }
            else if (s.charAt(idx) == ']') {
                System.out.println("2nd elseif");

                String stt = resStack.pop();
                System.out.println(stt);
                StringBuilder temp = new StringBuilder(stt);
                int repeatTimes = countStack.pop();
                for (int i = 0; i < repeatTimes; i++) {
                    temp.append(res);
                }
                res = temp.toString();
                idx++;
                System.out.println(res);
            }
            else {
                System.out.println("else");

                res += s.charAt(idx++);
                System.out.println(res);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        DecodeString ds = new DecodeString();
        String s = "3[aub]";
        String res = ds.decodeString(s);
//        System.out.println(res);
    }
}
