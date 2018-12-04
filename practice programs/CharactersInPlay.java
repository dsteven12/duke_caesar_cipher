
/**
 * Write a description of CharactersInPlay here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import edu.duke.*;
import java.util.ArrayList;

public class CharactersInPlay {
    private ArrayList<String> characterNames;
    private ArrayList<Integer> characterCounts;
    
    public CharactersInPlay() {
        characterNames = new ArrayList<String>();
        characterCounts = new ArrayList<Integer>();
    }
    
    private void update(String person) {
        int index = characterNames.indexOf(person);
        if(index == -1) {
            characterNames.add(person);
            characterCounts.add(1);
        } 
        else {
            int count = characterCounts.get(index);
            characterCounts.set(index, count + 1);
        }
    }
    
    private void findAllCharacters() {
        characterNames.clear();
        characterCounts.clear();
        
        FileResource fr = new FileResource();
        for(String line : fr.lines()) {
            line = line.toLowerCase().trim();
            int dotIndex = line.indexOf(".");
            if(dotIndex != -1) {
                String characterName = line.substring(0, dotIndex);
                update(characterName);
            }
        }
        
    }
    
    private void charactersWithNumParts(int num1, int num2) {
        for(int i = 0; i < characterCounts.size(); i++) {
            if(characterCounts.get(i) >= num1 && characterCounts.get(i) <= num2) {
                System.out.println(characterNames.get(i) + "\t" + characterCounts.get(i));
            }
        }
    }
    
    public int findMax(){
        int max = characterCounts.get(0);
        int maxIndex = 0;
        for(int k=0; k < characterCounts.size(); k++){
            if (characterCounts.get(k) > max){
                max = characterCounts.get(k);
                maxIndex = k;
            }
        }
        return max;
    }
    
    public void tester(int num1) {
        findAllCharacters();
        int num2 = findMax();
        charactersWithNumParts(num1, num2); 
        System.out.println("============================================="); 
    }
}
