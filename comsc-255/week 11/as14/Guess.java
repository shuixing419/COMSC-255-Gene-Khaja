package as14;

//Guess.java
public class Guess {
 private int selection;
 private static int totalGuesses = 0;
 private static int totalGames = 0;

 public Guess() {
     // Randomly select a number between 1 and 7
     selection = ((int) (Math.random() * 7)) + 1;
     totalGames++;
 }

 public void checkGuess(String guess) throws GuessOutOfRangeException,
         GuessTooLargeException, GuessTooSmallException, GuessNotWholeNumberException {
     
     totalGuesses++;
     int n = 0;

     // Convert User's Guess received as a String into an int
     try {
         n = Integer.parseInt(guess);
     } catch (NumberFormatException ex) {
         throw new GuessNotWholeNumberException();
     }

     // User's guess is now converted into an int
     if (n > 7 || n < 1) {
         throw new GuessOutOfRangeException();
     } else if (n > selection) {
         throw new GuessTooLargeException();
     } else if (n < selection) {
         throw new GuessTooSmallException();
     }
     // User's guess matches selection, simply return
 }

 public static int getTotalGuesses() {
     return totalGuesses;
 }

 public static int getTotalGames() {
     return totalGames;
 }

 public static double getAverageGuesses() {
     return (double) totalGuesses / totalGames;
 }
}