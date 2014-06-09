package oop.ex6.filescript.Section.Filter;

import java.io.File;
/**
 * This class represents a Smaller Than type filter. Given a double input 
 * value, this class will accept only the files that their size is smaller than 
 * the given value.
 * @implements Filter
 * @author taldovrat1988
 */
public class FilterSmaller implements Filter {
	
	double value;
	/**
	 * Creates a new Smaller Than Filter object.
	 * @param filterValue - A String representation of the double to be smaller
	 * than.
	 */
	public FilterSmaller(String value) {
		this.value = Double.parseDouble(value)*K;//convert to K-bytes
	}

	@Override
	/**
	 * Overrides the accept method in The FileFilter class. Accepts the files 
	 * that their size is smaller than the given input value.
	 * @param The file to accept.
	 * @return true if the the file size is smaller than the given value.
	 */
	public boolean accept(File pathname) {
		return acceptSmaller(pathname, this.value);
	}
	
	/**
	 * A static implementation of the accept method. Created for uses of the
	 * FilterNot class.
	 * @param pathname - the file to accept 
	 * @param filterValue - A String representation of the double to be smaller
	 * than.
	 * @return true if the the file size is greater than the given value.
	 */
	public static boolean acceptSmaller(File pathname, double value) {
		return pathname.length() < value; 
	}
}