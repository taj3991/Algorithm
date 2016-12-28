package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/28.
 */
public class Question53 {

    public static void main(String[] args) {
        String str = "aacd";
        String pattern = "a.*aex.d";
        boolean match = matchCore(str.toCharArray(),0,pattern.toCharArray(),0);
        System.out.println(match);
    }

    static boolean matchCore(char[] chars,int charIndex,char[] pattern,int patternIndex){

        if (chars == null || pattern == null || chars.length == 0 || pattern.length == 0)return  false;

        if (charIndex < chars.length && patternIndex >= pattern.length) return  false;

        if (charIndex >= chars.length && patternIndex < pattern.length) return  false;

        if (charIndex == chars.length && patternIndex == pattern.length )return  true;

        if (patternIndex < pattern.length-1 && pattern[patternIndex+1] =='*'){

            return  matchCore(chars,charIndex+1,pattern,patternIndex+2)
                    || matchCore(chars,charIndex+1,pattern,patternIndex)
                    || matchCore(chars,charIndex,pattern,patternIndex+2);

        }

        if (chars[charIndex] == pattern[patternIndex] || pattern[patternIndex] == '.'){

            return  matchCore(chars,charIndex+1,pattern,patternIndex+1);

        }

        return  false;

    }

}
