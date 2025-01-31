
import java.util.Scanner;

public class CreditCard {

    private int cardNo;
    private int cvv;
    private String cardHolder;
    private double balance;
    private long accNo;
    private int pin;
    private String status;

    public CreditCard() {
    }

    public CreditCard(long accNo, double balance, String cardHolder, int cardNo, int cvv, int pin, String status) {
        this.accNo = accNo;
        this.balance = balance;
        this.cardHolder = cardHolder;
        this.cardNo = cardNo;
        this.cvv = cvv;
        this.pin = pin;
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("cardNo=").append(cardNo);
        sb.append(", cvv=").append(cvv);
        sb.append(", cardHolder=").append(cardHolder);
        sb.append(", balance=").append(balance);
        sb.append(", accNo=").append(accNo);
        sb.append(", pin=").append(pin);
        sb.append(", status=").append(status);
        return sb.toString();
    }

    public int getCardNo() {
        return cardNo;
    }

    public void setCardNo(int cardNo) {
        this.cardNo = cardNo;
    }

    public void viewBalance(long cardNo) {

    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance += balance;
    }

    public CreditCard[] fetchCreditCards(String bankName, long accNo) {

        CreditCard[] cardArr = new FileHandler(bankName + " credit cards.txt").fetchCreditCardData(accNo);

        for (int i = 0; i < cardArr.length && cardArr[i] != null; i++) {
            System.out.println(i + 1 + ". " + cardArr[i].getCardNo());
        }

        return cardArr;
    }

    public boolean validatePIN(int pin) {
        return this.pin == pin;
    }

    public CreditCard[] fetchCreditCards(String bankName) {

        CreditCard[] cards = new FileHandler(bankName + " credit cards.txt").fetchAllCreditCardData();

        return cards;
    }

    public boolean deposit(CreditCard[] cards, int cardNo, String bankName) {
        Scanner scanner = new Scanner(System.in);
        try {

            boolean isDeposit = false;
            for (int i = 0; i < cards.length && cards[i] != null; i++) {
                if (cardNo == cards[i].getCardNo()) {
                    System.out.println("Enter the PIN");
                    int pin = scanner.nextInt();
                    if (!cards[i].validatePIN(pin)) {
                        System.out.println("Enter a valid PIN");
                        return false;

                    }
                    System.out.println("Enter the Amount to deposit");
                    double balance = scanner.nextDouble();
                    cards[i].setBalance(balance);
                    isDeposit = true;
                    break;

                }
            }
            if (isDeposit) {
                new FileHandler(bankName + " credit cards.txt").replaceCreditCardData(cards);
                return true;
            }
            return false;
        } catch (Exception err) {

            System.err.println(err);
            return false;
        }

    }

    public boolean blockCreditCard(CreditCard[] cards, int cardNo, String bankName){
        Scanner scanner = new Scanner(System.in);
        try{
            boolean isBlocked = false;
            for (int i = 0; i < cards.length && cards[i] != null; i++) {
                if (cardNo == cards[i].getCardNo()) {
                    System.out.println("Enter the PIN");
                    int pin = scanner.nextInt();
                    if (!cards[i].validatePIN(pin)) {
                        System.out.println("Enter a valid PIN");
                        return false;

                    }
                    cards[i].setStatus("inactive");
                    isBlocked = true;
                    break;

                }
            }
            if(isBlocked){
                new FileHandler(bankName + " credit cards.txt").replaceCreditCardData(cards);
                return true;
            }
            return false;

        }
        catch (Exception e){
            System.err.println(e.getMessage());
            return false;
        }

    }
}
