import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import javax.crypto.SecretKey;

public class ConfidentialDoc extends Document {

    public ConfidentialDoc(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        this.setExtension(".zip");
        this.setEncryption(true);
    }

    @Override
    public void buildDoc() {
        try {
            String projectDirectory = System.getProperty("user.dir");
            File directory = new File(projectDirectory + "/documents");

            if (!directory.exists()) {
                directory.mkdirs();
            }

            SecretKey key = AES256Example.getOrCreateKey();
            String encryptedContent = AES256Example.encrypt(content, key);

            if (encryptedContent == null || encryptedContent.isEmpty()) {
                System.out.println("❌ Encryption failed! No data to write.");
                return;
            }

            String zipFilePath = directory.getAbsolutePath() + "/" + fileName + extension;
            FileOutputStream fos = new FileOutputStream(zipFilePath);
            ZipOutputStream zos = new ZipOutputStream(fos);
            ZipEntry entry = new ZipEntry(fileName + ".txt");

            zos.putNextEntry(entry);
            zos.write(encryptedContent.getBytes());
            zos.closeEntry();
            zos.close();
            fos.close();

            System.out.println("Confidential document encrypted & saved as ZIP: " + zipFilePath);
        } catch (Exception e) {
            System.out.println("Error encrypting confidential document: " + e.getMessage());
        }
    }
}
