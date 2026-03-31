import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class App {
    public static void main(String[] args) throws Exception {
        String texto = "Hello World";
        System.out.println("Criptografando...");
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(128);
        SecretKey secretKey = keyGen.generateKey();
        System.out.println("Chave: "+Arrays.toString(secretKey.getEncoded()));

        String textoCriptografado = criptografar(texto, secretKey);
        System.out.println("Texto cifrado: "+textoCriptografado);

        String textoDecifrado = descriptografar(textoCriptografado, secretKey);
        System.out.println("Texto decifrado: "+textoDecifrado);
    }


    public static String criptografar(String textoOriginal, SecretKey chave) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, chave);
        byte[] textoByte = cipher.doFinal(textoOriginal.getBytes());
        return Base64.getEncoder().encodeToString(textoByte);
    }

    
    public static String descriptografar(String textoCripto, SecretKey chave) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, chave);
        byte[] textoByte = Base64.getDecoder().decode(textoCripto);
        byte[] doFinal = cipher.doFinal(textoByte);
        return new String(doFinal);
    }
}
