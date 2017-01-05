package InterviewClassics;

/**
 * Created by tangjian on 2017/1/5.
 */
public class Question1_4 {


    public static void main(String[] args) {
        System.out.println(emptyCharReplace("happy bi day"));
    }

    static String emptyCharReplace(String str){
        if (str == null)return  null;
        char[] chars = str.toCharArray();
        int count = 0;
        for(char c:chars){
            if ( c ==' ')count++;
        }
        char[] newChars = new char[count+3*chars.length];
        int len = newChars.length;
        for(int i=chars.length-1;i>=0;i--){
            if(chars[i]==' '){
                newChars[--len] = '0';
                newChars[--len] = '2';
                newChars[--len] = '%';
            }else{
                newChars[--len] = chars[i];
            }
        }
        return  new String(newChars);
    }
}
