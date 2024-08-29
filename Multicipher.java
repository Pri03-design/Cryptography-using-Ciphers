import java.util.*;
public class MultiCipher extends Cipher{
    
    private List<Cipher> ciphers;
    
    // Creates a multicipher that uses many differnt ciphers 
    // Exception:
    // IllegalArgumentException - if there are no ciphers being used 
    // to create and use the multi cipher
    // Parameters: 
    // ciphers - the different ciphers utilized to encode or decode a message
    public MultiCipher(List<Cipher> ciphers){
        if(ciphers == null){
            throw new IllegalArgumentException("does not use any ciphers");
        }
        this.ciphers = new ArrayList<>(ciphers);
    }

    // This method encodes a message by using many different ciphers
    // Paramters: 
    // input - the unique message that is going to be encoded
    // Returns
    // returns the encoded message
    public String encrypt(String input) {
        String result = input;
        for (int i = 0; i <= ciphers.size() - 1; i++) {
            result = ciphers.get(i).encrypt(result);
        }
        return result;
    }

    // This method decodes a message by using many different ciphers
    // Paramters: 
    // input - the unique message that is going to be decoded
    // Returns
    // returns the decoded message
    public String decrypt(String input) {
        String result = input;
        for (int i = ciphers.size() - 1; i >= 0; i--) {
            result = ciphers.get(i).decrypt(result);
        }
        return result;
    }
}
