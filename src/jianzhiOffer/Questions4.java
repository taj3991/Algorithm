package jianzhiOffer;

/**
 * Created by tangjian on 2016/12/7.
 */
public class Questions4 {

    public static void main(String[] args) {
        String str = "we are happy#   ";
        //char[] result = replaceWhileSpaceUsingExtralSpace(str.toCharArray());
        char[] result = replaceWhilteSpaceInOriginCharArr(str.toCharArray());
        String replacedStr = new String(result);
        System.out.println(replacedStr);
    }




    static char[] replaceWhilteSpaceInOriginCharArr(char [] charArr){
        if (charArr == null || charArr.length == 0) return charArr;

        int whileSpaceCharNum = 0;
        int originalLength = 0;
        for(int i = 0 ; i < charArr.length ; i++){
            if (charArr[i] == 32) whileSpaceCharNum++;
             originalLength  ++;
            if(charArr[i] == '#')break;
        }
        int newLen = originalLength+whileSpaceCharNum*2;
        if (newLen > charArr.length) throw  new RuntimeException("Char array length is not enough to store the result.Current lenght is "+charArr.length+" min lenght is "+newLen);

        newLen = newLen -1;
        for(int i = originalLength-1 ; i >=0; i-- ){
            if (charArr[i] == 32){
                charArr[newLen--] = '%';
                charArr[newLen--] = '2';
                charArr[newLen--] = '0';
            }else {
                charArr[newLen--] = charArr[i];
            }
            if (i == newLen) break;

        }
        return charArr;
    }




    public static  char[] replaceWhileSpaceUsingExtralSpace(char[] charArr){
        if (charArr == null || charArr.length == 0) return charArr;
        int len = applyLength(charArr);
        char [] newCharArr = new char[len];
        int index = 0;
        for(int  i = 0 ; i <charArr.length ; i++){
            if (charArr[i] == 32){
                newCharArr[index++] ='%';
                newCharArr[index++] ='2';
                newCharArr[index++] ='0';
            }else{
                newCharArr[index++] = charArr[i];
            }
        }
        return newCharArr;
    }

    private static int applyLength(char[] charArr) {
     /*   int len =0;
        len = charArr.length*3;*/
        int whileSpaceCharNum = 0;
        for(int i = 0 ; i < charArr.length ; i++){
            if (charArr[i] == 32) whileSpaceCharNum++;
        }
        return charArr.length+whileSpaceCharNum*2;
    }

}
