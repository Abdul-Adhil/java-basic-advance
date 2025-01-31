
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileHandler {

    private final String fileName;

    FileHandler(String fileName) {
        this.fileName = fileName;
    }

    public String filePath() {
        try {
            File folder = new File("data");
            if (!folder.exists()) {
                folder.mkdir();
            }

            File file = new File("data", fileName);

            if (!file.exists()) {
                if (file.createNewFile()) {
                    return file.getAbsolutePath();
                }
            } else {
                return file.getAbsolutePath();
            }

        } catch (Exception e) {
            System.err.println("Error occured while get the file path"
                    + e.getMessage());
        }
        return null;

    }

    public void displayContent() {

        try (BufferedReader br = new BufferedReader(new FileReader(filePath()))) {
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void addCustomer(String content) {

        try (FileWriter writer = new FileWriter(filePath(), true)) {
            writer.write(content + System.lineSeparator());

            System.out.println("Operation successful");
        } catch (Exception e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public void addData(String content) {
        try (FileWriter writer = new FileWriter(filePath(), true)) {
            writer.write(content + System.lineSeparator());

            System.out.println("Operation successful");
        } catch (Exception e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public void replaceCustomerData(Customer[] customersData) {
        File file = new File("data", fileName);
        System.out.println(file.exists());
        if (file.exists()) {
            file.delete();
        }

        try (FileWriter writer = new FileWriter(filePath(), true)) {
            for (int i = 0; i < customersData.length; i++) {
                System.out.println("card acc--> " + customersData[i].toString());
                writer.write(customersData[i].toString() + System.lineSeparator());
            }

          
        } catch (Exception e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public void replaceCreditCardData(CreditCard[] creditCardsData) {
        File file = new File("data", fileName);
        if (file.exists()) {
            file.delete();
        }
        try (FileWriter writer = new FileWriter(filePath(), true)) {
            for (int i = 0; i < creditCardsData.length && creditCardsData[i] != null; i++) {
                writer.write(creditCardsData[i].toString() + System.lineSeparator());
            }
        } catch (Exception e) {
            System.err.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }

    public Customer[] getCustomerData() {
        Customer[] customers = new Customer[100];
        try (BufferedReader br = new BufferedReader(new FileReader(filePath()))) {
            String line;

            Customer currentCustomer = null;
            int customerCount = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                String name = parts[0].split("=")[1];
                int age = Integer.parseInt(parts[1].split("=")[1]);
                int creditCardCount = Integer.parseInt(parts[2].split("=")[1]);
                String pan = parts[3].split("=")[1];
                String accounts = (parts[4].split("=").length) != 1 ? (parts[4].split("=")[1]) : "";

                currentCustomer = new Customer(name, age, accounts, creditCardCount, pan);
                System.out.println(currentCustomer);
                customers[customerCount++] = currentCustomer;
            }

            return customers;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public BankAccount[] getFileContent() {
        BankAccount[] acc = new BankAccount[2];

        try (BufferedReader br = new BufferedReader(new FileReader(filePath()))) {

            String line;
            BankAccount currentBk = null;
            int accCount = 0;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(", ");
                long accNo = Long.parseLong(parts[0].split("=")[1]);
                String name = parts[1].split("=")[1];
                double balance = Double.parseDouble(parts[2].split("=")[1]);
                String pan = parts[3].split("=")[1];
                currentBk = new BankAccount(accNo, balance, name, pan);
                acc[accCount++] = currentBk;
            }

            // for (BankAccount bk : acc) {
            //     System.out.println(bk.toString());
            // }
            return acc;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public CreditCard[] fetchCreditCardData(long accNo) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath()))) {
            CreditCard[] cards = new CreditCard[20];
            String line;
            int cardCount = 0;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(", ");
                if (Long.parseLong(parts[4].split("=")[1]) == accNo) {
                    int cardNo = Integer.parseInt(parts[0].split("=")[1]);
                    int cvv = Integer.parseInt(parts[1].split("=")[1]);
                    String cardHolder = parts[2].split("=")[1];
                    double balance = Double.parseDouble(parts[3].split("=")[1]);
                    int pin = Integer.parseInt(parts[5].split("=")[1]);
                    String status = parts[6].split("=")[1];
                    cards[cardCount++] = new CreditCard(accNo, balance, cardHolder, cardNo, cvv, pin, status);
                }
            }

            return cards;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public CreditCard[] fetchAllCreditCardData() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath()))) {
            CreditCard[] cards = new CreditCard[20];
            String line;
            int cardCount = 0;
            while ((line = br.readLine()) != null) {

                String[] parts = line.split(", ");
                int cardNo = Integer.parseInt(parts[0].split("=")[1]);
                int cvv = Integer.parseInt(parts[1].split("=")[1]);
                String cardHolder = parts[2].split("=")[1];
                double balance = Double.parseDouble(parts[3].split("=")[1]);
                long accNo = Long.parseLong(parts[4].split("=")[1]);
                int pin = Integer.parseInt(parts[5].split("=")[1]);
                String status = parts[6].split("=")[1];
                cards[cardCount++] = new CreditCard(accNo, balance, cardHolder, cardNo, cvv, pin, status);

            }

            return cards;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

}
