package oop.ex6.filescript.Exceptions;

/**
 * This class is thrown every time there is an error while trying to create
 * a Filter or Order object. this Exception generate a warning message that 
 * notifies the user that something is wrong in the command file the user 
 * supplied and the number of line that generated the error. Unlike the 
 * BadCommandFileException, this exception doesn't cause the program to 
 * terminate, but continues the program after printing out the warning message. 
 * @extends Exception
 * @author taldovrat1988
 *
 */
public class TypeOneException extends Exception {

	/**
	 * The error message to be printed. the line number would be added to the
	 * end of the message according to the line that caused the error. 
	 */
	public static final String WARNING_MESSAGE = "Warning in line ";
	private Integer lineNumber;
	
	/**
	 * Creates a TypeOneException object with the index of the line that caused
	 * the error.
	 * @param indexOfBadRow - The line that caused the error.
	 */
	public TypeOneException(Integer indexOfBadRow) {
		super(WARNING_MESSAGE);
		this.lineNumber = indexOfBadRow+1;
		
	}
	
	@Override
	/**
	 * @return A String - the default warning message + bad line number.
	 */
	public String getLocalizedMessage() {
		return WARNING_MESSAGE+this.lineNumber.toString();
		
	}
	
}
