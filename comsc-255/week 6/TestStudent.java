package as06;
import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class TestStudent {
    public static void main(String[] args) {
        String in;
        int nStudents, nExams;
        
        in = JOptionPane.showInputDialog("Enter number of students");
        nStudents = Integer.parseInt(in);
        
        // Create an array of nStudents references
        Student[] st = new Student[nStudents];
        
        // Create nStudents objects using loop
        for (int i = 0; i < st.length; i++) {
            // Input one student data
            in = JOptionPane.showInputDialog(
                "Enter one student data with items separated by commas");
            
            // Tokenize student data using StringTokenizer
            String delim = ",";
            String token;
            
            // Create StringTokenizer and supply it with String in and String delim
            StringTokenizer stk = new StringTokenizer(in, delim);
            
            token = stk.nextToken().trim();
            int id = Integer.parseInt(token);
            
            String name = stk.nextToken().trim();
            
            token = stk.nextToken().trim();
            nExams = Integer.parseInt(token);
            
            // create the array scores
            double[] scores = new double[nExams];
            
            // populate the array scores
            for (int j = 0; j < nExams; j++) {
                token = stk.nextToken().trim();
                scores[j] = Double.parseDouble(token);
            }
            
            // Create a Student object with the above data
            st[i] = new Student(id, name, scores);
        }
        
        // Find student grades and display output
        
        // Create an empty output String for each type of grade 
        String outA = "", outB = "", outC = "", outD = "", outF = "";
        
        // find student grades and accumulate output for each type of student
        String grade = "";
        for (int i = 0; i < st.length; i++) {
            grade = st[i].findGrade();
            if (grade.equalsIgnoreCase("A")) {
                // accumulate output in outA for A students
                outA = outA + st[i].getId() + " " + st[i].getName() + " (" + grade + ")\n";
            } else if (grade.equalsIgnoreCase("B")) {
                // accumulate output in outB for B students
                outB = outB + st[i].getId() + " " + st[i].getName() + " (" + grade + ")\n";
            } else if (grade.equalsIgnoreCase("C")) {
                // accumulate output in outC for C students
                outC = outC + st[i].getId() + " " + st[i].getName() + " (" + grade + ")\n";
            } else if (grade.equalsIgnoreCase("D")) {
                // accumulate output in outD for D students
                outD = outD + st[i].getId() + " " + st[i].getName() + " (" + grade + ")\n";
            } else {
                // accumulate output in outF for F students
                outF = outF + st[i].getId() + " " + st[i].getName() + " (" + grade + ")\n";
            }
        }
        
        // concatenate strings
        String outAll = outA + outB + outC + outD + outF;
        
        // display output
        JOptionPane.showMessageDialog(null, outAll);
    }
}