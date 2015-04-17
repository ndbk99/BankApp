package bankapp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

/**
 *
 * @author nkeyes
 */
public class BankCalc_GUI extends javax.swing.JFrame {
    /**
     * Creates new form BankAppGUI
     */
    public BankCalc_GUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        depField = new javax.swing.JTextField();
        depButton = new javax.swing.JButton();
        withButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayBalance = new javax.swing.JTextArea();
        withField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Bank Record app");

        jLabel2.setText("Deposit");

        jLabel3.setText("Withdraw");

        depButton.setText("GO");
        depButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                depButtonActionPerformed(evt);
            }
        });

        withButton.setText("GO");
        withButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Current balance:");

        displayBalance.setColumns(20);
        displayBalance.setRows(5);
        jScrollPane1.setViewportView(displayBalance);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(285, 285, 285))
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(depField)
                            .addComponent(withField, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(depButton)
                            .addComponent(withButton))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(depField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(depButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(withButton)
                    .addComponent(withField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel4)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28))))
        );

        pack();
    }// </editor-fold>                        

    private void depButtonActionPerformed(java.awt.event.ActionEvent evt) {                                          
        String deposit = depField.getText();
        if (validate(deposit)) {
            JOptionPane.showMessageDialog(null, "Deposit: " + deposit);
            setBalance(getBalance() + Double.valueOf(deposit));
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a valid deposit amount.");
        }
        // CURRENTLY REJECTS EVERYTHING-- FIX
    }                                         

    private void withButtonActionPerformed(java.awt.event.ActionEvent evt) {                                           
        String withdrawal = withField.getText();
        if (validate(withdrawal)) {
            JOptionPane.showMessageDialog(null, "Withdrawal: " + withdrawal);
            setBalance(getBalance() - Double.valueOf(withdrawal));
        } else {
            JOptionPane.showMessageDialog(null, "Please enter a valid withdrawal amount.");
        }
    }                                          

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(BankCalc_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(BankCalc_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(BankCalc_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(BankCalc_GUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new BankCalc_GUI().setVisible(true);
            }
        });
    }
    
    // Reads current balance from bankaccount.txt
    // INPUT: none (read string from file)
    // OUTPUT: double balance
    public double getBalance() {
        // create charset and file path
        Charset charset = Charset.forName("US-ASCII");
        Path file = Paths.get("C:\\Users\\nkeyes\\Documents\\NetBeansProjects\\NatJavaApp\\src\\bankaccount\\bankaccount.txt");

        // declare line and balance variables
        String line;
        double balance = 0;

        // try/catch to read file content in
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            while ((line = reader.readLine()) != null) {
                balance = Double.valueOf(line);
            }
        } catch (IOException x) {
            // catch IO error if thrown
            System.err.format("IOException: %s%n", x);
        } catch (NumberFormatException n) {
            //System.err.format("NumberFormatException: %s%n", n);
        }        
        return balance;
    }

    // Calculates new balance and writes new balance to bankaccount.txt
    // INPUT: double balance
    // OUTPUT: none (write string to file)
    public void setBalance(double balance) {
        String myStr = String.valueOf(0.01 * Math.round(100 * balance));
        JOptionPane.showMessageDialog(null, "New balance = " + myStr);
        String fileName = "C:\\Users\\nkeyes\\Documents\\NetBeansProjects\\NatJavaApp\\src\\bankaccount\\bankaccount.txt";
        // append balance to file
        try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(fileName, true)))) {
            out.write("\n" + myStr);
            out.close();
        }
        catch (IOException x) {
            // catch IO error if thrown
            System.err.format("IOException: %s%n", x);
        }
    }

    // Validates that input is correct format
    // INPUT: String num
    // OUTPUT: boolean, tells whether valid or not
    public boolean validate(String num) {
        boolean valid = true;
        if (num.length() < 1) { return false; }
        
        // validate as number
        char[] array = {'0','1','2','3','4','5','6','7','8','9','.'};
        for (int i = 0; i < num.length(); i++) {
            char iChar = num.charAt(i);
            for (int j = 0; j < 11; j++) {
                if (iChar == array[j]) { 
                    valid = true;
                    break;
                }
                else { valid = false; }
            }
            if (valid == false) { return valid; }
            else { /* string is a number => move on to decimal checking */ }
        }
        
        // validate for decimal places
        num = num.concat("0");
        for (int i = 0; i < num.length(); i++) {
            char dot = num.charAt(i);
            if (dot == '.') {
                valid = num.length() <= (i + 4);
                break;
            } else { }
        }
        return valid;
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton depButton;
    private javax.swing.JTextField depField;
    private javax.swing.JTextArea displayBalance;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton withButton;
    private javax.swing.JTextField withField;
    // End of variables declaration                   
}

/*
WORKS:
    Deposit and withdrawal with validation
    Writing new balance to file
    Alerts to deposit amount and new balance amoun
    Appends new balances to text file
TO ADD:
    Display current balance in window as it is updated
    Make sure the rounding is correct
*/