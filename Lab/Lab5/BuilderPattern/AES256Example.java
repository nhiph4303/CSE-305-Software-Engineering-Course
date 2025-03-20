import java.io.*;
import java.util.*;
import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

public class AES256Example {
    static Scanner sc = new Scanner(System.in);
    private static final String KEY_FILE = "aes_key.key"; // 🔑 File lưu khóa AES

    public static SecretKey getOrCreateKey() throws Exception {
        File keyFile = new File(KEY_FILE);
        if (keyFile.exists()) {
            return loadKey(); //
        } else {
            SecretKey key = generateKey();
            saveKey(key);
            return key;
        }
    }

    public static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        return keyGen.generateKey();
    }

    public static void saveKey(SecretKey key) throws IOException {
        byte[] encoded = key.getEncoded();
        String keyString = Base64.getEncoder().encodeToString(encoded);
        try (FileWriter writer = new FileWriter(KEY_FILE)) {
            writer.write(keyString);
        }
    }

    public static SecretKey loadKey() throws IOException {
        String keyString;
        try (Scanner scanner = new Scanner(new File(KEY_FILE))) {
            keyString = scanner.nextLine();
        }
        byte[] decoded = Base64.getDecoder().decode(keyString);
        return new SecretKeySpec(decoded, "AES");
    }

    public static String encrypt(String plainText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }

    public static String decrypt(String encryptedText, SecretKey key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
        return new String(decryptedBytes);
    }

    public static String readFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine()).append("\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found!");
            return null;
        }
        return content.toString().trim();
    }

    public static void writeFile(String filePath, String data) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(data);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            SecretKey key = getOrCreateKey();

            System.out.print("Enter the file path to encrypt: ");
            String contractFilePath = sc.nextLine();

            String contractData = readFile(contractFilePath);
            if (contractData == null) {
                System.out.println("No contract data found!");
                return;
            }

            String encryptedData = encrypt(contractData, key);
            System.out.println("Encrypted Contract: " + encryptedData);

            String encryptedFilePath = contractFilePath + "_encrypted.txt";
            writeFile(encryptedFilePath, encryptedData);
            System.out.println("Encrypted contract saved to: " + encryptedFilePath);

            System.out.print("Do you want to decrypt the file? (yes/no): ");
            String choice = sc.nextLine().trim().toLowerCase();

            if (choice.equals("yes")) {
                String readEncryptedData = readFile(encryptedFilePath);
                if (readEncryptedData != null) {
                    String decryptedData = decrypt(readEncryptedData, key);
                    System.out.println("Decrypted Contract: \n" + decryptedData);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sc.close();
        }
    }
}
