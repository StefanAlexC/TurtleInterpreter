package turtle;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

  /**
   * The Main function of the Turtle package, which processes the input and
   * output sources
   * @param args Provides the input and output paths
   * @throws FileNotFoundException
   */
    public static void main(String[] args) throws FileNotFoundException {

      Scanner input;
      PrintStream output;

      input = determineInputSource(args);
      output = determineOutputSource(args);

      TurtleInterpreter turtleInterpreter = new TurtleInterpreter(input,
          output);

      turtleInterpreter.processCommands();
    }

  /**
   * Handles the input sources
   * @param args If args has at least one element, the first one represents
   * the file from which the program reads, otherwise standard input will be
   * used
   * @return Returns a Scanner that reads from the desired location
   */
  private static Scanner determineInputSource(String[] args) throws FileNotFoundException{
    if (args.length > 0) {
      //Reading from file
      return new Scanner(new File(args[0]));
    }
    else {
      //Reading from standard Input
      return new Scanner(System.in);
    }
  }

  /**
   * Handles the output source
   * @param args If args has two elements, the second one specifies the file
   * in which the program writes, otherwise standard output will be used
   * @return Returns the PrintStream that writes in the desired location
   */
  private static PrintStream determineOutputSource(String[] args) throws FileNotFoundException {
    if (args.length == 2) {
      //Writing to file
      return new PrintStream(new File(args[1]));
    } else {
      //Writing to standard Output
      return System.out;
    }

  }
}
