package InterviewClassics;

/**
 * Created by tangjian on 2017/1/8.
 */
public class Question1_8 {

    public static void main(String[] args) {

        boolean isRotation = isRotation("aterbootlew","erbootlewat");
        System.out.println(isRotation);
    }


    static  boolean isRotation(String s1,String s2){
        if (s1 == null || s2 == null)return false;
        if (s1.length() != s2.length() )return false;

        String s = s1+s1;
        System.out.println(s);
        System.out.println(s2);
        return  isSubString(s,s2);



    }
      static  boolean isSubString(String s1,String s2){
           return  s1.contains(s2);
      }
}
