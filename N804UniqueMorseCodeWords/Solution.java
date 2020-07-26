package N804UniqueMorseCodeWords;

import java.util.TreeSet;

public class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> treeSet = new TreeSet<>();

        for (int i = 0; i < words.length; i++) {
            StringBuilder result = new StringBuilder();
            String current = words[i];
            for (int j = 0; j < current.length(); j++) {
                result.append(morseCode[current.charAt(j) - 'a']);
            }
            treeSet.add(result.toString());
        }

        return treeSet.size();
    }

    public static void main(String[] args) {
        String[] strings = {"gin", "zen", "gig", "msg"};
        Solution solution = new Solution();
        int n = solution.uniqueMorseRepresentations(strings);
        System.out.println(n);
    }

}
