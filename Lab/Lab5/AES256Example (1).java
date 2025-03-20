import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class AES256Example {

    // Tạo key co dinh theo chuan AES-256 (bit)
    private static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);  
        return keyGen.generateKey();
    }

    // Ma hoa chuoi bang AES, tra ve chuoi ma hoa bieu dien duoi dinh dang Base64 (De doc)
    // Truyen vao chuoi + key
    public static String encrypt(String plainText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes); 
    }

    // Giai ma de Test thu xem ma hoa dung khong\
    // Truyen vao chuoi da ma hoa (Base64, tra ve chuoi ban dau)
    public static String decrypt(String encryptedText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }

    public static void main(String[] args) {
        try {
            // Tao Khoa bi mat
            SecretKey key = generateKey();

            // Dua vao mot chuoi ban dau
            String message = "A bottle of water";
            String encryptedMessage = encrypt(message, key);
            System.out.println("Chuoi sau khi ma hoa: " + encryptedMessage);

            // Giai ma de test thu ma hoa ban dau co dung khong (Base64)
            String decryptedMessage = decrypt(encryptedMessage, key);
            System.out.println("Chuoi goc: " + decryptedMessage);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}