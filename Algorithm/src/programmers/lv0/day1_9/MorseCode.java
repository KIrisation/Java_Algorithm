package programmers.lv0.day1_9;

import java.util.HashMap;
import java.util.Map;

public class MorseCode {

    public static void main(String[] args) {
        String hello = solution(".... . .-.. .-.. ---");
        System.out.println(hello);
    }

    public static String solution(String letter) {
        String[] morseCode = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        StringBuilder answer = new StringBuilder();
        String[] letters = letter.split(" ");

        for (int i = 0; i < letters.length; i++) {
            for (int j = 0; j < 26; j++) {
                if (letters[i].equals(morseCode[j])) {
                    answer.append((char) (j + 'a'));
                }
            }
        }

        return answer.toString();
    }

    public static String anotherSolution(String letter) {
        String morseStr = "'.-':'a','-...':'b','-.-.':'c','-..':'d','.':'e','..-.':'f',"
                + "'--.':'g','....':'h','..':'i','.---':'j','-.-':'k','.-..':'l',"
                + "'--':'m','-.':'n','---':'o','.--.':'p','--.-':'q','.-.':'r',"
                + "'...':'s','-':'t','..-':'u','...-':'v','.--':'w','-..-':'x',"
                + "'-.--':'y','--..':'z'";

        String[] morseArr = morseStr.split(",");
        String[] letterArr = letter.split(" ");

        Map<String, String> morse = new HashMap<>();

        for (int i = 0; i < morseArr.length; i++) {
            morseArr[i] = morseArr[i].replace("'", "");
            int idx = morseArr[i].indexOf(":");
            morse.put(morseArr[i].substring(0, idx), morseArr[i].substring(idx + 1));
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (String s : letterArr) {
            stringBuilder.append(morse.get(s));
        }

        return stringBuilder.toString();
    }
}
