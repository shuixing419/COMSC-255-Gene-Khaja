package as15;

import javax.swing.JOptionPane;

public class ExceptionHandlingProgram {
    public static void main(String[] args) {
        while (true) {
            String id = JOptionPane.showInputDialog("Enter Id");
            if (id.equalsIgnoreCase("0")) {
                JOptionPane.showMessageDialog(null, "Bye");
                return;
            }

            String name = JOptionPane.showInputDialog("Enter name");
            String out;

            try {
                validateId(id);
                out = "Validated id: " + id + "\n";
                JOptionPane.showMessageDialog(null, out);
                
                validateName(name);
                out = "Validated name: " + name + "\n";
                JOptionPane.showMessageDialog(null, out);
            } catch (IdNotWholeNumberException e) {
                String msg = e.getMessage();
                System.out.println(msg);
                // e.printStackTrace();
            } catch (IdOutOfRangeException e) {
                String msg = e.getMessage();
                System.out.println(msg);
                // e.printStackTrace();
            } catch (NotAlphabeticException e) {
                String msg = e.getMessage();
                System.out.println(msg);
                // e.printStackTrace();
            } catch (NotSpecifiedException e) {
                String msg = e.getMessage();
                System.out.println(msg);
                // e.printStackTrace();
            }
        }
    }
}