package practice;

import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

public class PracticeRomanToInteger {
    public static void main(String[] args) {
        System.out.println("The integer value for: "+romanToInt("X X"));


    }
    public static int romanToInt(String s) {
        int result = 0;

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        for(int i =0; i<s.length()-1; i++){
            if(map.get(s.charAt(i))<map.get(s.charAt(i+1))){
                result=result-map.get(s.charAt(i));
            }else{
                result=result+map.get(s.charAt(i));
            }
            System.out.println(result);
        }

        result = result+map.get(s.charAt(s.length()-1));
        System.out.println(map.get(s.charAt(s.length()-1)));
        return result;
    }
}
