package oop.ex6.filescript.Exceptions;

/**
 * This class is thrown every time there is an error 
 * with the structure of the command file. The structure of the command file 
 * is the format and order of the text lines within the command file. The 
 * correct structure is detailed in the main method of the MyFileScript class
 * javadoc.
 * If a BadCommandFile is thrown - the program would terminate immediately.
 * @extends Exception
 * @author taldovrat1988
 *
 */
public class BadCommandFileException extends Exception {
	
	private static final String ERROR_MESSAGE = "ERROR";
	
	/**
	 * Default constructor - generates a new BadCommandFileException object
	 * with the default error message "ERROR".
	 */
	public BadCommandFileException() {
		super(ERROR_MESSAGE);
	}
	
	@Override
	/**
	 * Overrides the localized message method.
	 * @return The default error message "ERROR".
	 */
	public String getLocalizedMessage() {
		return ERROR_MESSAGE;				
	}
}
