public class VigenereCipher {

    private String key;
    private String alphabet;

    public VigenereCipher(String key)
    {
        this.key = key.toLowerCase();
        this.alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    @Override
    public String toString() {
        return "VigenereCipher{" +
                "key='" + key + '\'' +
                ", alphabet='" + alphabet + '\'' +
                '}';
    }

    public String encode (String currMsg)
    {
        char msg[] = currMsg.toCharArray();
        int msgLen = msg.length;
        int i,j;

        char key[] = new char[msgLen];
        char encryptedMsg[] = new char[msgLen];

        for(i = 0, j = 0; i < msgLen; ++i, ++j)
        {
            if(j == currMsg.length())
            {
                j = 0;
            }
            key[i] = currMsg.charAt(j);
        }

        //encryption code
        for(i = 0; i < msgLen; ++i) {
            encryptedMsg[i] = (char) (((msg[i] + key[i]) % 26) + 'A');
        }

        return String.valueOf(encryptedMsg);

    }

    public String decode (String currMsg)
    {
        char msg[] = currMsg.toCharArray();
        int msgLen = msg.length;
        int i,j;

        char key[] = new char[msgLen];
        char encryptedMsg[] = new char[msgLen];
        char decryptedMsg[] = new char[msgLen];

        for(i = 0, j = 0; i < msgLen; ++i, ++j)
        {
            if(j == currMsg.length())
            {
                j = 0;
            }
            key[i] = currMsg.charAt(j);
        }

        for(i = 0; i < msgLen; ++i) {
            decryptedMsg[i] = (char) ((((encryptedMsg[i] - key[i]) + 26) % 26) + 'A');
        }

        return String.valueOf(decryptedMsg);
    }

}
