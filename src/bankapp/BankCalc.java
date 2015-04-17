package bankapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class BankCalc {
    public static void main(String[] args) throws IOException
    {
        // MAIN WORKS FINE!
        boolean bool = true;
        while (bool) {
            double balance = getBalance();
            balance += getValidDeposit();
            setBalance(balance);
            
            System.out.println("Type yes to deposit again, hit enter to terminate");
            Scanner sc = new Scanner(System.in);
            String str = sc.nextLine();
            if (!str.equals("yes")) { bool = false; }
        }
    }
    
    // Gets desired user deposit from console
    // INPUT: none (read double from user console)
    // OUTPUT: double deposit
 
    public static double getValidDeposit() {
        boolean valid = false;
        while (!valid) {
            // get deposit amount from user
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your deposit amount: ");
            double deposit = sc.nextDouble();
            String depositString = String.valueOf(deposit);
            for (int i = 0; i < depositString.length(); i++) {
                char decimal = depositString.charAt(i);
                if ('.' == decimal) {
                    if (depositString.length() == (i + 3)) {
                        // if correct length
                        valid = true;
                        System.out.println("Valid deposit amount = " + depositString);
                        return deposit;
                    } else if (depositString.length() > (i + 3)) {
                        // if too long, ask user to enter valid value; run getDeposit again
                        valid = false;
                        System.out.println("Please enter valid monetary value.");
                    } else if (depositString.length() < (i + 3)) {
                        // if too short, append "0" and r
                        valid = true;
                        depositString = depositString.concat("0");
                        System.out.println("Valid deposit amount = " + depositString);
                        return deposit;
                    } else {}
                }
            }
        }
        return 0;
    }
    
    // Reads current balance from bankaccount.txt
    // INPUT: none (read string from file)
    // OUTPUT: double balance
    public static double getBalance () {
        // create charset and file path
        Charset charset = Charset.forName("US-ASCII");
        Path file = Paths.get("C:\\Users\\nkeyes\\Documents\\NetBeansProjects\\NatJavaApp\\src\\bankaccount\\bankaccount.txt");
        
        // declare line and balance variables
        String line;
        double balance = 0;
        
        // try/catch to read file content in; reads all lines, which I'll only need when the append functionality is added
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            while ((line = reader.readLine()) != null) {
                balance = Double.valueOf(line);
                System.out.println("Current balance = " + line);
            }
        } catch (IOException x) {
            // catch IO error if thrown
            System.err.format("IOException: %s%n", x);
        }
        
        return balance;
    }
    
    // Calculates new balance and writes new balance to bankaccount.txt
    // INPUT: double balance
    // OUTPUT: none (write string to file)
    public static void setBalance(double balance) {
        String balStr = validate(balance);
        System.out.println("New balance = " + balStr);
        Charset charset = Charset.forName("US-ASCII");
        Path file = Paths.get("C:\\Users\\nkeyes\\Documents\\NetBeansProjects\\NatJavaApp\\src\\bankaccount\\bankaccount.txt");
        try (BufferedWriter writer = Files.newBufferedWriter(file, charset)) {
            // try: writer = new BufferedWriter(new FileWriter(my_file_name, true)); in order to append ***
            writer.write(balStr + "\n");
            writer.close();
        }
        catch (IOException x) {
            // catch IO error if thrown
            System.err.format("IOException: %s%n", x);
        }
    }
    
    // Validates that input is correct format
    // INPUT: double bal
    // OUTPUT: String balance
    public static String validate(double n) {
        String num = String.valueOf(n);
        num = num.concat("0");
        for (int i = 0; i < num.length(); i++) {
            char dot = num.charAt(i);
            if (dot == '.') {
                if (num.length() > (i + 3)) { num = num.substring(0,i + 3); } 
                else { }
            }
        }
        return num;
    }
}
