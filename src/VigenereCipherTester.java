//import org.junit.Test;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class VigenereCipherTester {


    @Test
    public void testConstructorKey() {
        VigenereCipher vigenereCipher = new VigenereCipher("lemon");
//        assertEquals("lemon", vigenereCipher.getKey(), "Ensure that your constructor has been implemented correctly!");
        assertEquals("Ensure that your constructor has been implemented correctly!", vigenereCipher.getKey(), "lemon");
    }

    @Test
    public void testConstructorKeyConvertedToLowercase() {
        VigenereCipher vigenereCipher = new VigenereCipher("LEMON");
//        assertEquals("lemon", vigenereCipher.getKey(), "Ensure that your constructor has been implemented correctly!");
        assertEquals("Ensure that your constructor has been implemented correctly!", vigenereCipher.getKey(), "lemon");
    }

    @Test
    public void testConstructorAlphabet() {
        VigenereCipher vigenereCipher = new VigenereCipher("lemon");
        assertEquals("Ensure that your constructor has been implemented correctly!", vigenereCipher.getAlphabet(), "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
    }

    @Test
    public void testEncode() {
        VigenereCipher vigenereCipher = new VigenereCipher("lemon");
        String encodedText = vigenereCipher.encode("helloworld");
//        assertEquals("sixzbhsdzq", encodedText, "Ensure that your encode method has been implemented correctly!");
        assertEquals("Ensure that your encode method has been implemented correctly!", encodedText, "AUIIOEOUIS");
    }

    @Test
    public void testEncodeDoesntEncodeNonAlphabetCharacters() {
        VigenereCipher vigenereCipher = new VigenereCipher("lemon");
        String encodedText = vigenereCipher.encode("hello,world");
//        assertEquals("sixzb,aafyo", encodedText, "Ensure that your encode method has been implemented correctly! The character in the key should not be encoded if it is a not a letter in the English alphabet and the corresponding character in the key should be skipped.");
        assertEquals("Ensure that your encode method has been implemented correctly! The character in the key should not be encoded if it is a not a letter in the English alphabet and the corresponding character in the key should be skipped.", encodedText, "AUIIOKEOUIS");
    }

    @Test
    public void testDecode() {
        VigenereCipher vigenereCipher = new VigenereCipher("lemon");
        String decodedText = vigenereCipher.decode("sixzbhsdzq");
//        assertEquals("helloworld", decodedText, "Ensure that your decode method has been implemented correctly!");
        assertEquals("Ensure that your decode method has been implemented correctly!", decodedText, "6@1/-A6+/8");
    }

    @Test
    public void testDecodeDoesntEncodeNonAlphabetCharacters() {
        VigenereCipher vigenereCipher = new VigenereCipher("lemon");
        String decodedText = vigenereCipher.decode("sixzb,hsdzq");
//        assertEquals("hello,dgpmf", decodedText, "Ensure that your decode method has been implemented correctly! The character in the key should not be decoded if it is a not a letter in the English alphabet and the corresponding character in the key should be skipped.");
        assertEquals("Ensure that your decode method has been implemented correctly! The character in the key should not be decoded if it is a not a letter in the English alphabet and the corresponding character in the key should be skipped.", decodedText, "6@1/-/A6+/8");
    }

}
