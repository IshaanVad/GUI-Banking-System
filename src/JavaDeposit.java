import javax.swing.*;
import java.util.Objects;
import static java.lang.Double.parseDouble;

public class JavaDeposit {
    public static void deposit(){

        double depositAmount;
        String[] data3 = {"Withdraw", "withdraw", "Deposit", "deposit", "No", "no"};

        depositAmount = parseDouble(JOptionPane.showInputDialog("How much would you like to deposit?"));
        JOptionPane.showMessageDialog(null, "You have desposited $" + depositAmount);

        while(true){
            String c = JOptionPane.showInputDialog("Would you like to do anything else today?\nWithdraw, Deposit, or No?");
            if (Objects.equals(c, data3[0]) || Objects.equals(c, data3[1])) {
                JavaWithdraw javaWithdraw = new JavaWithdraw();
                javaWithdraw.withdraw();
                break;
            } else if (Objects.equals(c, data3[2]) || Objects.equals(c, data3[3])) {
                JavaDeposit javaDeposit = new JavaDeposit();
                javaDeposit.deposit();
                break;
            } else if (Objects.equals(c, data3[4]) || Objects.equals(c, data3[5])) {
                JavaNo javaNo = new JavaNo();
                javaNo.No();
                break;
            } else {
                JOptionPane.showMessageDialog(null, "This was an invalid response. Please try again.");

            }
        }
    }
}
