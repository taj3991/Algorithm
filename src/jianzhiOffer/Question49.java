package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/25.
 */
public class Question49 {
    public static void main(String[] args) {
        int result = parseInt("ab",16);
        System.out.println(result);
       /*  result = Integer.parseInt("132",2);
        System.out.println(result);*/
    }
        static int parseInt(String s,int radix){
            if (s == null) {
                throw new NumberFormatException("null");
            }
            if (radix < Character.MIN_RADIX) {
                throw new NumberFormatException("radix " + radix +
                        " less than Character.MIN_RADIX");
            }
            // 0-9  a-z 总共 36个 .
            if (radix > Character.MAX_RADIX) {
                throw new NumberFormatException("radix " + radix +
                        " greater than Character.MAX_RADIX");
            }

            int result = 0;
            boolean negative = false;
            int i = 0, len = s.length();
            int limit = -Integer.MAX_VALUE;
            int multmin = 0;
            int digit;

            if ( len > 0){
                char firstChar = s.charAt(0);
                if (firstChar < '0') {
                    if (firstChar == '-') {
                        negative = true;
                        limit = 0x80000000;
                    } else if (firstChar != '+') {
                        throw new NumberFormatException("first char " + firstChar +
                                " is not  '-' or '+' s");
                    }
                    if (len == 1) {
                        throw new NumberFormatException("Input error :"+s);
                    }
                    i++;
                }
                multmin = limit / radix;
                while(i < len){
                    digit = Character.digit(s.charAt(i++),radix);
                   if (digit < 0){
                       throw new NumberFormatException("Input error :"+s);
                   }
                   if (result < multmin){
                       throw new NumberFormatException("Input error :"+s);
                   }
                   result *= radix;

                    if (result-digit < limit){
                        throw new NumberFormatException("Input error :"+s);
                    }
                    result -= digit;
                }
            }
        return negative?result:-result;
    }




}
