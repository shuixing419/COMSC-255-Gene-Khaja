package as07;

import java.util.StringTokenizer;
import javax.swing.JOptionPane;

public class TestStudentExt 
{
    public static void main(String[] args) 
    {
        String in;
        int nStudents, nExams;
        in = JOptionPane.showInputDialog("Enter number of students");
        nStudents = Integer.parseInt(in);
        
        // Create an array of StudentExt references
        StudentExt[] st = new StudentExt[nStudents];
        
        // Create StudentExt objects using loop
        for (int i = 0; i < st.length; i++) 
        {
            // Input one student data
            in = JOptionPane.showInputDialog("Enter one student data, items separated by comma");

            // Tokenize student data using StringTokenizer
            String delim = ",";
            String token;
            StringTokenizer stk = new StringTokenizer(in, delim);
            
            token = stk.nextToken().trim();
            int id = Integer.parseInt(token);  
            String name = stk.nextToken().trim(); 

            token = stk.nextToken().trim();
            nExams = Integer.parseInt(token); 

            // create the array scores
            double[] scores = new double[nExams];
            // populate the array scores
            for (int j = 0; j < nExams; j++) 
            {
                token = stk.nextToken().trim();
                scores[j] = Double.parseDouble(token);
            }

            String gradeType = stk.nextToken().trim(); 
            // Create a StudentExt object
            st[i] = new StudentExt(id, name, scores, gradeType);
        }

        // Find student grades and display output
        // Create an empty output String for each type of grade 
        String outA = "", outB = "", outC = "", outD = "", outF = "", outCr = "", outNcr = ""; 

        // find student grades and accumulate output for each type of student
        String grade = "";
        for (int i = 0; i < st.length; i++) 
        {
            grade = st[i].findGrade();
            if (grade.equalsIgnoreCase("A")) 
            {
                outA = outA + st[i].getId() + " " + st[i].getName() + " (" + grade + ")\n";
            }
            else if (grade.equalsIgnoreCase("B")) 
            {
                outB = outB + st[i].getId() + " " + st[i].getName() + " (" + grade + ")\n"; 
            }
            else if (grade.equalsIgnoreCase("C")) 
            {
                outC = outC + st[i].getId() + " " + st[i].getName() + " (" + grade + ")\n";
            }
            else if (grade.equalsIgnoreCase("D")) 
            {
                outD = outD + st[i].getId() + " " + st[i].getName() + " (" + grade + ")\n";
            }
            else if (grade.equalsIgnoreCase("F")) 
            {
                outF = outF + st[i].getId() + " " + st[i].getName() + " (" + grade + ")\n";
            }
            else if (grade.equalsIgnoreCase("CR")) 
            {
                outCr = outCr + st[i].getId() + " " + st[i].getName() + " (" + grade + ")\n";
            }
            else if (grade.equalsIgnoreCase("NCR")) 
            {
                outNcr = outNcr + st[i].getId() + " " + st[i].getName() + " (" + grade + ")\n";
            }
        }

        String outAll = outA + outB + outC + outD + outF + outCr + outNcr;
        // display output
        JOptionPane.showMessageDialog(null, outAll);
    }
}
