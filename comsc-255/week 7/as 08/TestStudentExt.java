package as08;

import java.io.*;
import javax.swing.*;
import java.util.StringTokenizer;

public class TestStudentExt {
    public static void main(String[] args) throws Exception {
        // Show where we're looking for the file
        File currentDir = new File(".");
        System.out.println("Current directory: " + currentDir.getAbsolutePath());
        
        File inFile = new File("in.txt");
        System.out.println("Looking for in.txt at: " + inFile.getAbsolutePath());
        System.out.println("File exists: " + inFile.exists());

        // Create a BufferedReader object for inputting from a file in.txt
        BufferedReader br = new BufferedReader(new FileReader("in.txt"));

        // Create a PrintWriter object for outputting to a text file out.txt
        PrintWriter pw = new PrintWriter(new FileWriter("out.txt"));

        // Rest of your code remains the same...
        String in = br.readLine();
        int studentCount = Integer.parseInt(in);
        StudentExt[] st = new StudentExt[studentCount];

        for (int i = 0; i < studentCount; i++) {
            in = br.readLine();
            StringTokenizer stk = new StringTokenizer(in, ",");
            
            int id = Integer.parseInt(stk.nextToken().trim());
            String name = stk.nextToken().trim();
            int nExams = Integer.parseInt(stk.nextToken().trim());

            double[] scores = new double[nExams];
            for (int j = 0; j < nExams; j++) {
                scores[j] = Double.parseDouble(stk.nextToken().trim());
            }

            String gradeType = stk.nextToken().trim();
            st[i] = new StudentExt(id, name, scores, gradeType);
        }

        // Process and output grades (same as before)
        String outA = "", outB = "", outC = "", outD = "", outF = "", outCr = "", outNcr = "";

        for (int i = 0; i < studentCount; i++) {
            String grade = st[i].findGrade();
            String outputLine = st[i].getId() + " " + st[i].getName() + " (" + grade + ")\n";
            
            switch (grade) {
                case "A": outA += outputLine; break;
                case "B": outB += outputLine; break;
                case "C": outC += outputLine; break;
                case "D": outD += outputLine; break;
                case "F": outF += outputLine; break;
                case "CR": outCr += outputLine; break;
                case "NCR": outNcr += outputLine; break;
            }
        }

        String outAll = outA + outB + outC + outD + outF + outCr + outNcr;
        pw.print(outAll);
        pw.flush();

        br.close();
        pw.close();
        System.out.println("Program completed successfully!");
    }
}