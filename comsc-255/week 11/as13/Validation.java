package as13;

import javax.swing.JOptionPane;

public class UserValidation {
    
    // Exception classes
    public static class IdNotWholeNumberException extends Exception {
        public IdNotWholeNumberException() {
            super("Not a whole number");
        }
    }
    
    public static class IdOutOfRangeException extends Exception {
        public IdOutOfRangeException() {
            super("Out of range");
        }
    }
    
    public static class NotAlphabeticException extends RuntimeException {
        public NotAlphabeticException() {
            super("Not alphabetic");
        }
    }
    
    public static class NotSpecifiedException extends RuntimeException {
        public NotSpecifiedException() {
            super("Not specified");
        }
    }
    
    // Validation methods
    public static void validateId(String sId) 
            throws IdNotWholeNumberException, IdOutOfRangeException {
        int idInt;
        try {
            idInt = Integer.parseInt(sId);
        } catch (NumberFormatException ex) {
            throw new IdNotWholeNumberException();
        }
        
        if (idInt < 1 || idInt > 999) {
            throw new IdOutOfRangeException();
        }
    }
    
    public static void validateName(String name) {
        if (name.equals("")) {
            throw new NotSpecifiedException();
        } else if (!name.matches("[a-zA-Z]+")) {
            throw new NotAlphabeticException();
        }
    }
    
    // Main method
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
            } catch (IdOutOfRangeException e) {
                String msg = e.getMessage();
                System.out.println(msg);
            } catch (NotAlphabeticException e) {
                String msg = e.getMessage();
                System.out.println(msg);
            } catch (NotSpecifiedException e) {
                String msg = e.getMessage();
                System.out.println(msg);
            }
        }
    }
}