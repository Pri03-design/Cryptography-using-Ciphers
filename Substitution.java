import java.util.*;
public class Substitution extends Cipher{

    
    private Map<Character, Character> encode;
    private Map<Character, Character> decode;

    // Creates a substitution cipher
    public Substitution(){
        super();
        this.encode = new HashMap<>();
        this.decode = new HashMap<>();
    }
    
    // Creates a substitution cipher with a specified shifter
    // Exceptions:
    // IllegalArgumentException -  The length of the shifter doesn't match the number 
    // of characters within our ciphers encodable range
    // IllegalArgumentException - if the shifter includes an identical character
    // IllegalArgumentException - Any individual character falls outside the encodable range
    // (our cipher class constants) 
    // Parameters:
    //   shifter - The string used to match characters to the shifter
    public Substitution(String shifter){
        this();
        checkSetShifter(shifter);
        setShifter(shifter);
    }

    // This method is used to check certain requirements that the shifter must pass
    // to be valid for encoding and decoding messages
    // Exceptions: 
    // IllegalArgumentException -  The length of the shifter doesn't match the number 
    // of characters within our ciphers encodable range
    // IllegalArgumentException - if the shifter includes an identical character
    // IllegalArgumentException - Any individual character falls outside the encodable range
    // (our cipher class constants) 
    // Parameters:
    // shifter - the unique code that is used to code a message
    private void checkSetShifter(String shifter){
        if(shifter.length() != TOTAL_CHARS){
            throw new IllegalArgumentException("shifter length not matching the num of" 
                    + "characters in cipher's encodable range");
        } 
        for(int i = 0; i < shifter.length(); i++){
            char c = shifter.charAt(i);
            if(shifter.indexOf(c) != i){
                throw new IllegalArgumentException("Contains a duplicate character");
            } 
            if(c < Cipher.MIN_CHAR ||  c > Cipher.MAX_CHAR){
                throw new IllegalArgumentException(" individual character falls outside" + 
                        "the encodable range");
            }
        }
    }
    
    // This method updates the shifter for the substitution cipher by matching the shifter 
    // to characters of a unique message
    // IllegalArgumentException -  The length of the shifter doesn't match the number 
    // of characters within our Cipher's encodable range
    // IllegalArgumentException - if the shifter includes an identical character
    // IllegalArgumentException - Any individual character falls outside the encodable range
    // (our cipher class constants) 
    // Parameters:
    // shifter - used to match shifters characters to characters from the encodable range 
    public void setShifter(String shifter){
        checkSetShifter(shifter);
        for(int i = 0; i < shifter.length(); i++){
            encode.put((char) (Cipher. MIN_CHAR + i), shifter.charAt(i));
            decode.put(shifter.charAt(i), (char) (Cipher.MIN_CHAR + i));
        }
    }

    // This method encodes a message using the shifter
    // Exceptions:
    // IllegalStateException: if the shifter is not set 
    // Parameters:
    // input - the unique message being encoded
    // Returns:
    // returns the encoded message 
    public String encrypt(String input){
        if(encode.isEmpty()){
            throw new IllegalStateException("The shifter was never set");
        }
        String encryptedMesssage = "";
        for(int i = 0; i < input.length(); i++){
            char target = input.charAt(i);
            char updatedTarget = encode.get(target);
            encryptedMesssage += updatedTarget;
            
        } 
        return encryptedMesssage;
    }

    // This method decodes a message using the shifter
    // Exceptions:
    // IllegalStateException: if the shifter is not set 
    // Parameters:
    // input - the unique message being decoded
    // Returns:
    // returns the decoded message 
    public String decrypt(String input){
        if(decode.isEmpty()){
            throw new IllegalStateException("The shifter was never set");
        }
        String decryptedMesssage = "";
        for(int i = 0; i < input.length(); i++){
            char target = input.charAt(i);
            char updatedTarget = decode.get(target);
            decryptedMesssage += updatedTarget;

        } 
        return decryptedMesssage;
    }

}
