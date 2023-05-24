import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Base64;
public class DESExample2 { 
 public static void main(String[] args) throws Exception { 
 // Generate a random 64-bit key
 KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
 SecureRandom secureRandom = new SecureRandom();
 keyGenerator.init(secureRandom);
 SecretKey secretKey = keyGenerator.generateKey();
 // Create a DES cipher object with the key and mode of operation
 Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
 cipher.init(Cipher.ENCRYPT_MODE, secretKey);
 // Encrypt a plaintext message
 String plaintext = "This is a secret message";
 byte[] plaintextBytes = plaintext.getBytes();
 byte[] encryptedBytes = cipher.doFinal(plaintextBytes);
 // Decrypt a ciphertext message
 cipher.init(Cipher.DECRYPT_MODE, secretKey);
 byte[] decryptedBytes = cipher.doFinal(encryptedBytes);
 String decryptedText = new String(decryptedBytes);
 // Print the results
 System.out.println("Key: " + 
Base64.getEncoder().encodeToString(secretKey.getEncoded()));
 System.out.println("Plaintext: " + plaintext);
 System.out.println("Ciphertext: " + 
Base64.getEncoder().encodeToString(encryptedBytes));
 System.out.println("Decrypted ciphertext: " + decryptedText);
} 
}
