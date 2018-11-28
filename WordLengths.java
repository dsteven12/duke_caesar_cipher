import java.*;
import edu.duke.*;
/**
 * Write a description of WordLengths here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WordLengths {
    public void countWordLengths(FileResource resource, int[] counts) {
        int index = 0;
        int length = 0;
        for(String word : resource.words()) {
            length = word.length();   
            boolean isCharacter = Character.isLetter(word.charAt(0));
            boolean isLastCharacter = Character.isLetter(word.charAt(length-1));
            if((!isCharacter) || (!isLastCharacter)) {
                if(length <= 0) {
                    length += 0;
                }  
                length -= 1;
            }       
            counts[length] += 1;   
        }   
        System.out.println("This is the max index " + indexOfMax(counts));
        
        for(int i = 0; i < counts.length; i++) {
            if(counts[i] != 0) {
                System.out.println("This is the length " + i + " " + "how frequent " + counts[i]);
            }
        }
    }
    
    public int indexOfMax(int[] values) {
        int maxCounter = 0;
        int valueLength = values.length;
        for(int i = 0; i < valueLength; i++) {
            int currCounter = 0;
            if(values[i] != 0) {
                currCounter = values[i];
                if(currCounter > maxCounter) {
                    maxCounter = currCounter;
                }
            }
        }
        return maxCounter;
    }
    
    public void testCountWordLengths() {
        FileResource fr = new FileResource();
        int[] counts = new int[31];
        countWordLengths(fr, counts);
    }
}
