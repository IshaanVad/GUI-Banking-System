import javax.swing.*;
import java.util.Objects;
import static java.lang.Double.parseDouble;

public class JavaWithdraw {

    public static void withdraw(){

        double withdrawAmount;
        String[] data2 = {"Withdraw", "withdraw", "Deposit", "deposit", "No", "no"};

        withdrawAmount = parseDouble(JOptionPane.showInputDialog("How much would you like to withdraw?"));
        JOptionPane.showMessageDialog(null, "You have withdrawn $" + withdrawAmount);

        while(true){
            String b = JOptionPane.showInputDialog("Would you like to do anything else today?\nWithdraw, Deposit, or No?");
            if (Objects.equals(b, data2[0]) || Objects.equals(b, data2[1])) {
                JavaWithdraw javaWithdraw = new JavaWithdraw();
                javaWithdraw.withdraw();
                break;
            } else if (Objects.equals(b, data2[2]) || Objects.equals(b, data2[3])) {
                JavaDeposit javaDeposit = new JavaDeposit();
                javaDeposit.deposit();
                break;
            } else if (Objects.equals(b, data2[4]) || Objects.equals(b, data2[5])) {
                JavaNo javaNo = new JavaNo();
                javaNo.No();
                break;
            } else {
                JOptionPane.showMessageDialog(null, "This was an invalid response. Please try again.");
            }
        }
    }
}

