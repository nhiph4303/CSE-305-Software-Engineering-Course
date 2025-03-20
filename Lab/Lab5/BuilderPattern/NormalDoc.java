import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NormalDoc extends Document {
    
    public NormalDoc(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        this.setExtension(".txt");
        this.setEncryption(false);
    }

    @Override
    public void buildDoc() {
        try {
            String projectDirectory = System.getProperty("user.dir");
            File directory = new File(projectDirectory + "/documents");

            if (!directory.exists()) {
                directory.mkdirs();
            }

            String filePath = directory.getAbsolutePath() + "/" + fileName + extension;
            FileWriter writer = new FileWriter(filePath);
            writer.write(content);
            writer.close();

            System.out.println("Normal document saved: " + filePath);
        } catch (IOException e) {
            System.out.println("Error saving normal document: " + e.getMessage());
        }
    }
}
