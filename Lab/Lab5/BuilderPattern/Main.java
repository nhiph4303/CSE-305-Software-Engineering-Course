import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import javax.crypto.SecretKey;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Client client = new Client();

        System.out.print("Enter Contract Type (Permanent, LongTerm, ShortTerm): ");
        String contractType = sc.nextLine().trim();

        Contract builder;
        switch (contractType.toLowerCase()) {
            case "permanent":
                builder = new Permanent();
                break;
            case "longterm":
                builder = new LongTerm();
                break;
            case "shortterm":
                builder = new ShortTerm();
                break;
            default:
                System.out.println("Invalid contract type.");
                return;
        }

        System.out.print("Enter Contract ID: ");
        String contractID = sc.nextLine().trim();

        System.out.print("Enter Property ID: ");
        String propertyID = sc.nextLine().trim();

        System.out.print("Enter Tenant ID: ");
        String tenantID = sc.nextLine().trim();

        System.out.print("Enter Rent Amount: ");
        double rentAmount = sc.nextDouble();
        sc.nextLine();

        RentalContract contract = client.requestCreateRentalContract(builder, contractID, propertyID, tenantID,
                rentAmount, contractType);

        System.out.println("\nRental contract created successfully!");
        System.out.println(contract.toString());

        String filePath = saveContractToFile(contract);

        encryptAndSaveContract(filePath);

        System.out.print("\nDo you want to save a document related to this contract? (yes/no): ");
        String saveDoc = sc.nextLine().trim().toLowerCase();

        if (saveDoc.equals("yes")) {
            saveDocument();
        }
    }

    public static String saveContractToFile(RentalContract contract) {
        try {
            String projectDirectory = System.getProperty("user.dir");
            File directory = new File(projectDirectory + "/contracts"); 
    
            if (!directory.exists()) {
                boolean created = directory.mkdirs();
                if (created) {
                    System.out.println("Directory 'contracts' created in: " + directory.getAbsolutePath());
                } else {
                    System.out.println("Error: Could not create 'contracts' directory.");
                    return null;
                }
            }
    
            String fileName = directory.getAbsolutePath() + "/" + contract.getContractType() + contract.getContractID() + "_Contract.txt";
    
            System.out.println("Saving contract to: " + fileName);
    
            FileWriter writer = new FileWriter(fileName, true);
            writer.write(contract.toString() + "\n");
            writer.close();
    
            System.out.println("Contract saved successfully: " + fileName);
            return fileName;
        } catch (IOException e) {
            System.out.println("Error saving contract to file: " + e.getMessage());
            return null;
        }
    }

    public static void encryptAndSaveContract(String filePath) {
        if (filePath == null) {
            System.out.println("Error: No contract file found to encrypt.");
            return;
        }

        try {
            SecretKey key = AES256Example.generateKey();

            String contractData = AES256Example.readFile(filePath);
            if (contractData == null) {
                System.out.println("No contract data found!");
                return;
            }

            String encryptedData = AES256Example.encrypt(contractData, key);
            System.out.println("Encrypted Contract: " + encryptedData);

            String encryptedFilePath = filePath + "_encrypted.txt";
            AES256Example.writeFile(encryptedFilePath, encryptedData);
            System.out.println("Encrypted contract saved to: " + encryptedFilePath);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void saveDocument() {
        System.out.print("Enter Document Type (Normal, Confidential): ");
        String docType = sc.nextLine().trim().toLowerCase();

        System.out.print("Enter Document Name: ");
        String fileName = sc.nextLine().trim();

        System.out.print("Enter Document Content: ");
        String content = sc.nextLine().trim();

        Document document;
        if (docType.equals("normal")) {
            document = new NormalDoc(fileName, content);
        } else if (docType.equals("confidential")) {
            document = new ConfidentialDoc(fileName, content);
        } else {
            System.out.println("Invalid document type!");
            return;
        }

        document.buildDoc();
    }
}
