package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/23.
 */
public class Question42 {


    public static void main(String[] args) {
      /*  String sentence = reverseSentence("I am a student.");
        System.out.println(sentence);


 */
        String str = "abcdefg";
        System.out.println(str);
        str = leftRotateString(str, 2);
        System.out.println(str);
    }

    public static String reverseSentence(String sentence) {
        if (sentence == null || sentence.isEmpty()) return null;
        sentence = reverseCore(sentence.toCharArray(), 0, sentence.length() - 1);
        System.out.println(sentence);
        char[] chars = sentence.toCharArray();
        int startIndex = 0;
        int endIndex = -1;

        for (int i = 0; i <= (chars.length - 1); i++) {
            if (chars[i] == ' ') {
                System.out.println("start :" + startIndex + "; end :" + endIndex);
                reverseCore(chars, startIndex, endIndex);
                endIndex++;
                startIndex = endIndex;
                startIndex++;
            } else {
                endIndex++;
            }
        }
        return new String(chars);
    }


    public static String reverseCore(char[] chars, int startIndex, int endIndex) {
        int n = startIndex + endIndex;
        for (int i = startIndex; i <= n / 2; i++) {
            char temp = chars[i];
            chars[i] = chars[n - i];
            chars[n - i] = temp;
        }
        return new String(chars);
    }


    static String leftRotateString(String str, int count) {
        if (str == null || str.isEmpty()) return null;
        if (str.length() < count || count <= 0) {
            throw new RuntimeException("Input Error");
        }


        int endIndex = str.length()-1;

        str = reverseCore(str.toCharArray(), 0, endIndex);
        System.out.println(str);

        str = reverseCore(str.toCharArray(), 0, endIndex - count);
        System.out.println(str);

        str = reverseCore(str.toCharArray(), endIndex - count+1, endIndex);
        System.out.println(str);
        return str;
    }


}
