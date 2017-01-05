package InterviewClassics;

/**
 * Created by tangjian on 2017/1/5.
 */
public class Question1_1 {
    public static void main(String[] args) {

        System.out.println(isUniqueChars("abcd"));
        System.out.println(isUniqueChars("dfadd"));

    }

    //假定只有字符串范围是  a-z
    static  boolean isUniqueChars(String str){
        if (str == null)return true;
        char[] chars = str.toCharArray();
        int k = 0;
        int n = 0;
        for(int i = 0 ; i < chars.length;i++){
            n = chars[i]-'a';
            if ( (k &(1<<n)) > 0)return false;
            k|= 1<<n;
        }

        return true;
    }

}
