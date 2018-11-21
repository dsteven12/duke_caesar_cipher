import edu.duke.*;
import java.io.*;
import java.util.*;

public class CaesarCipher {
    public boolean isCharacter(char ch) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = alphabet.toLowerCase();
        alphabet = alphabet + lowerAlphabet;
        boolean isCharacter = false;
        int num = alphabet.length();
        for(int i = 0; i < num; i++) {
            char currChar = alphabet.charAt(i);
            if(ch == currChar) {
                isCharacter = true;
            }
        }
        return isCharacter;
    }
    
    public String replaceCharacter(String phrase, char ch) {
        StringBuilder newString = new StringBuilder(phrase);
        int num = phrase.length();
        for(int i = 0; i < num; i++) {
            char currChar = phrase.charAt(i);
            if(isCharacter(currChar)) {
                newString.setCharAt(i, ch);
            }
        }
        return newString.toString();
    }
    
    
    public String encrypt(String input, int key) {
        //Make a StringBuilder with message (encrypted)
        StringBuilder encrypted = new StringBuilder(input);
        //Write down the alphabet
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String lowerAlphabet = alphabet.toLowerCase();
        //Compute the shifted alphabet
        String shiftedAlphabet = alphabet.substring(key)+
        alphabet.substring(0,key);
        String shiftedLowerAlphabet = lowerAlphabet.substring(key)+
        lowerAlphabet.substring(0,key);
        //Concat Upper + LowerCase Alphabets 
        alphabet = alphabet + lowerAlphabet;
        //Concat shiftedUpper + shiftedLower Alphabets
        shiftedAlphabet = shiftedAlphabet + shiftedLowerAlphabet;
        //Count from 0 to < length of encrypted, (call it i)
        for(int i = 0; i < encrypted.length(); i++) {
            //Look at the ith character of encrypted (call it currChar)
            char currChar = encrypted.charAt(i);
            //Find the index of currChar in the alphabet (call it idx)
            int idx = alphabet.indexOf(currChar);
            
            //If currChar is in the alphabet
            if(idx != -1){
                //Get the idxth character of shiftedAlphabet (newChar)
                char newChar = shiftedAlphabet.charAt(idx);
                //Replace the ith character of encrypted with newChar
                encrypted.setCharAt(i, newChar);
            } 
            //Otherwise: do nothing
        }
        //Your answer is the String inside of encrypted
        return encrypted.toString();
    }
    
    public String encryptTwoKeys(String input, int key1, int key2) {
        StringBuilder newInput = new StringBuilder(input);
        int num = input.length();
        
        for(int i = 0; i < num; i++) {
            char currChar = input.charAt(i);
            String s = String.valueOf(currChar);
            if(i % 2 == 0) {
                char newChar = encrypt(s, key1).charAt(0);
                newInput.setCharAt(i, newChar);
            } else {
                char newChar = encrypt(s, key2).charAt(0);
                newInput.setCharAt(i, newChar);
            }
                
        }
        return newInput.toString();
    }
    
    public ArrayList bruteForceDecrypt(String input) {
        int n = 26;
        ArrayList<Integer> crackKey = new ArrayList<Integer>(n);
        ArrayList<String> results = new ArrayList<String>(n);
        for(int i = 1; i <= n; i++) {
            crackKey.add(i);
        }
        
        for(int i = 0; i < crackKey.size(); i++) {
            results.add(encrypt(input, crackKey.get(i))); 
        }
        return results;
    }
    
    public void testEncrypt() {
               
        System.out.println(encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
        System.out.println(encrypt("First Legion", 23));
        System.out.println(encrypt("First Legion", 17));
        
        System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 15));
    }
    
    public void testEncryptTwoKeys() {
        System.out.println(encryptTwoKeys("At noon be in the conference room with your hat on for a surprise party. YELL LOUD!", 8, 21));
    }
    
    public void testBruteForceDecrypt() {
        ArrayList<String> results = new ArrayList<String>(bruteForceDecrypt("Lujyfwapvu huk zljbypaf hyl mbukhtluahs whyaz vm avkhf'z Pualyula."));
        int size = results.size();
        for(int i = 0; i < size; i++) {
            int pos = i + 1;
            System.out.println(pos + ": " + results.get(i));
        }
    }
}

