import java.util.*;
public class CaesarShift extends Substitution{
    
    // Creates a functional caesar shift cipher that uses a number to shift
    // a existant range of characters and match them to a message in 
    // order to encode or decode a message
    //Exception:
    // IllegalArgumentException - if the shift amount is less than or equal to zero
    // Parameters: 
    // shift - the number of times a range of characters will be moved over 
    // in order to create a new key to encode/decode messages
    public CaesarShift(int shift){
        if(shift <= 0){
            throw new IllegalArgumentException("invalid shift");
        }
        Queue<Character> q = new LinkedList<>();
        for(int i = Cipher.MIN_CHAR; i <= Cipher.MAX_CHAR; i++){
            q.add((char)i);
        }
        for(int i = 0; i < shift; i++){
            q.add(q.remove());
        }
        String s = "";
        while(!q.isEmpty()){
            s += q.remove();
        }
        super.setShifter(s);
    }
}
