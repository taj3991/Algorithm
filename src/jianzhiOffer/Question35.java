package jianzhiOffer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by tangjian on 2016/12/20.
 */
public class Question35 {


    public static void main(String[] args) {
       char c = findFirstNotRepeating("azabd".toCharArray());
        System.out.println(c);
    }


    static  char findFirstNotRepeating(char [] chars){

        Map<Character,Integer> map = new LinkedHashMap<>();

        for(char tempChar:chars){
            if (map.get(tempChar) == null){
                map.put(tempChar,1);
            }else {
                int count = map.get(tempChar) + 1;
                map.put(tempChar, count);
            }
        }
        char c =' ';
        for(Map.Entry<Character,Integer> en:map.entrySet()){
            if (en.getValue() == 1){
                c = en.getKey();
                break;
            }
        }
        return  c;
    }

}
