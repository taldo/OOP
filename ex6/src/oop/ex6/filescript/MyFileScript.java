package oop.ex6.filescript;
import java.io.File;

/**
 * This class is the manager class of the program. This class is responsible
 * for running the program and generate the printed files.
 * @author taldovrat1988
 *
 */
public class MyFileScript {
	/**
	 * Default Constructor.
	 */
	public MyFileScript() {
		
	}
	
	/**
	 * The main method that runs the entire program
	 * @param args:
	 * 1. The wanted directory
	 * 2. The Command File - A text that Should have this structure:
	 * a. FILTER
	 * b. nameOfFilter
	 * c. ORDER
	 * d. nameOfOrder
	 * can iterate this structure as many times as the user wants. make sure
	 * the structure is correct before running the program. the structure is
	 * case sensitive! any exceptions from this specific structure would 
	 * generate errors. 
	 */
	public static void main(String[] args) {
		try {
			File commandFile = new File(args[1]);
			File dir = new File(args[0]);
	
			Parser testParser = new Parser(dir, commandFile);
			
			//try to create structure, if false, terminate the program.
			if (!testParser.createStructure()) {
				return;
			}
			
			//create sections and print the files.
			testParser.createSections();
		}
		catch (Exception ex) {
			System.out.println(ex.getLocalizedMessage());
			
		}
	}
}
