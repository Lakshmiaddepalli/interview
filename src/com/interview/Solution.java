package com.interview;

import com.interview.utils.ConsoleWriter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created_By: stefanie
 * Date: 14-12-17
 * Time: 上午8:30
 */
public class Solution {

    List<String> sols;
    String[] map;
    public List<String> letterCombinations(String digits) {
        sols = new ArrayList();
        if(digits == null || digits.length() == 0) return sols;
        map = initMap();
        decode(digits, 0, "");
        return sols;
    }

    private void decode(String digits, int offset, String prefix){
        if(offset >= digits.length()) {
            sols.add(prefix);
            return;
        }
        int digit = digits.charAt(offset) - '0';
        String options = map[digit];
        for(int i = 0; i < options.length(); i++){
            decode(digits, offset + 1, prefix + options.charAt(i));
        }
    }

    public String[] initMap(){
        return new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        List<String> sols = solution.letterCombinations("2");
        System.out.println();
        ConsoleWriter.printCollection(sols);
    }
}
