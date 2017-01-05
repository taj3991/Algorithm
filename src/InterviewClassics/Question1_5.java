package InterviewClassics;

/**
 * Created by tangjian on 2017/1/5.
 */
public class Question1_5 {

    public static void main(String[] args) {

        System.out.println(zipStr("aaabbbccddff"));
    }
    static String zipStr(String str){
       if (str == null || str.isEmpty())return null;
        char[] chars = str.toCharArray();
        char lastChar = chars[0];
        int count = 1;
        StringBuilder sb =  new StringBuilder(chars.length);
        for(int i = 1 ; i < chars.length; i++){
            char temp = chars[i];
            if (temp == lastChar){
                count++;
            }else{
                sb.append(lastChar).append(count);
                count = 1;
                lastChar = temp;
            }
        }
        sb.append(lastChar).append(count);
        String result = sb.toString();
        return result.length() <= chars.length?result:str;

    }
}
