import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class InputDialogExample {
    public static void main(String[] args) {
        JTextField textField = new JTextField();
        Object[] message = {"Enter something:", textField};
        
        int option = JOptionPane.showConfirmDialog(null, message, "Input", JOptionPane.OK_CANCEL_OPTION);
        
        if (option == JOptionPane.OK_OPTION) {
            String input = textField.getText();
            System.out.println("User entered: " + input);
        } else if (option == JOptionPane.CANCEL_OPTION) {
            System.out.println("User clicked Cancel.");
        }
    }
}
