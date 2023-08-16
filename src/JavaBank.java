import java.util.Objects;
import javax.swing.*;

public class JavaBank {

    public static void main(String[] args) {

        String[] data = {"Withdraw", "withdraw", "Deposit", "deposit", "No", "no"};

            /*JFrame jf = new JFrame(); jf. setSize(1650,1080);     //GUI Frame Window
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
            frame.setUndecorated(true);
            frame.setVisible(true);*/

            /*JOptionPane.showMessageDialog(null,       //Warning Message GUI
                "Eggs are not supposed to be green.",
                "Insane warning",
                JOptionPane.WARNING_MESSAGE);*/

        JOptionPane.showMessageDialog(null, "Welcome to The Bank", "Bank", JOptionPane.INFORMATION_MESSAGE);

        while(true){
            String a = JOptionPane.showInputDialog(null,"What would you like to do today?\nWithdraw or Deposit", "Selection Screen", JOptionPane.QUESTION_MESSAGE);
            if (Objects.equals(a, data[0]) || Objects.equals(a, data[1])) {
                JavaWithdraw javaWithdraw = new JavaWithdraw();
                javaWithdraw.withdraw();
                break;
            } else if (Objects.equals(a, data[2]) || Objects.equals(a, data[3])) {
                JavaDeposit javaDeposit = new JavaDeposit();
                javaDeposit.deposit();
                break;
            } else if (Objects.equals(a, data[4]) || Objects.equals(a, data[5])) {
                JavaNo javaNo = new JavaNo();
                javaNo.No();
                break;
            } else {
                JOptionPane.showMessageDialog(null, "This was an invalid response. Please try again.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
