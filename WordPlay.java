import edu.duke.*;
import java.io.*;

/**
 * Write a description of WordPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordPlay {
    public boolean isVowel(char ch) {
        String vowel = "aeiou";
        String upperVowel = vowel.toUpperCase();
        vowel = upperVowel + vowel;
        boolean isVowel = false;
        int num = vowel.length();
        for(int i = 0; i < num; i++) {
            char currChar = vowel.charAt(i);
            if(ch == currChar) {
                isVowel = true;
            }
        }
        return isVowel;
    }
    
    public String replaceVowels(String phrase, char ch) {
        StringBuilder newString = new StringBuilder(phrase);
        int num = phrase.length();
        for(int i = 0; i < num; i++) {
            char currChar = phrase.charAt(i);
            if(isVowel(currChar)) {
                newString.setCharAt(i, ch);
            }
        }
        return newString.toString();
    }
    
    public String emphasize(String phrase, char ch) {
        StringBuilder newString = new StringBuilder(phrase);
        phrase = phrase.toLowerCase();
        int num = phrase.length();
        
        for(int i = 0; i < num; i++) {
            int pos = i + 1;
            char currChar = phrase.charAt(i);
            String s = String.valueOf(currChar);
            if(currChar == ch) {
                if(pos % 2 == 0) {
                    char newChar = replaceVowels(s, '+').charAt(0);
                    newString.setCharAt(i, newChar);
                } else {
                    char newChar = replaceVowels(s, '*').charAt(0);
                    newString.setCharAt(i, newChar);
                }
            }
        }
        
        return newString.toString();
    }
    
    public void testIsVowel() {
        System.out.println("Is F a Vowel: " + isVowel('F'));
        System.out.println("Is a a Vowel: " + isVowel('a'));
        System.out.println("Is A a Vowel: " + isVowel('A'));
        System.out.println("Is z A Vowel: " + isVowel('z'));
    }
    
    public void testReplaceVowel() {
        System.out.println(replaceVowels("Hello World", '*'));
    }
    
    public void testEmphasize() {
        System.out.println(emphasize("dna ctgaaactga", 'a'));
        System.out.println(emphasize("Mary Bella Abracadabra", 'a'));
    }
}
