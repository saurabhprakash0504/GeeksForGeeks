package com.random;

public class BasicCalculator2 {

    public static void main(String[] args) {

        BasicCalculator2 obj = new BasicCalculator2();
        String s = " 3+5 / 2 ";
        int res = obj.calculate(s);
        System.out.println(res);
    }

    public int calculate(String s) {
        int i = 0;
        int len = s.length();

        int prev = 0;
        int res = 0;
        char prev_opr = '+';


        while (i < len) {
            int curr = 0;
            char c = s.charAt(i);
            if (Character.isDigit(c)) {

                while (i < len && Character.isDigit(s.charAt(i))) {
                    int tem = s.charAt(i) - '0';
                    curr = curr * 10 + tem;
                    i++;
                }
                i--;

                switch (prev_opr) {

                    case '+':
                        res = res + curr;
                        prev = curr;
                        break;
                    case '-':
                        res = res - curr;
                        prev = -curr;
                        break;
                    case '*':

                        res = res - prev;
                        res = res + (prev * curr);
                        prev = curr * prev;
                        break;

                    case '/':
                        res = res - prev;
                        res = res + (int) (prev / curr);
                        prev = (int) (prev / curr);
                        break;
                }

                i++;

            } else if (c == ' ') {
                i++;
            } else {
                prev_opr = c;
                i++;
            }

        }

        return res;

    }
}
