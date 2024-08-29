public class CaesarKey extends Substitution{

    //Creates a caesar key cipher that uses a key
    // Exceptions:
    // IllegalArgumentException - if our key is empty 
    // IllegalArgumentException -  The length of the modified key doesn't match the number 
    // of characters within our ciphers encodable range
    // IllegalArgumentException - if the modified key includes an identical character
    // IllegalArgumentException - Any individual character falls outside the encodable range
    // (our cipher class constants) 
    // Parameters:
    // key - a message that is utilized alongside our range of characters
    // to encode or decode messages
    public CaesarKey(String key){
        if(key.isEmpty()){
            throw new IllegalArgumentException("key is empty!");
        }
    
        for(int i = Cipher.MIN_CHAR; i < Cipher.MAX_CHAR + 1; i++){
            if(key.indexOf((char)i) == -1){
                key += (char)i;
            }
        }
        super.setShifter(key);
    }
}
