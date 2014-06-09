package oop.ex6.filescript.Section.Filter;

import java.io.File;

/**
 * This class represents a Greater Than type filter. Given a double input 
 * value, this class will accept only the files that their size is greater than 
 * the given value.
 * @implements Filter
 * @author taldovrat1988
 */
public class FilterGreater implements Filter {
	
	private double filterValue;
	
	/**
	 * Creates a new Greater Than Filter object.
	 * @param filterValue - A String representation of the double to be greater
	 * than.
	 */
	public FilterGreater(String filterValue) {
		this.filterValue = Double.parseDouble(filterValue)*K;
	}

	@Override
	/**
	 * Overrides the accept method in The FileFilter class. Accepts the files 
	 * that their size is greater than the given input value.
	 * @param The file to accept.
	 * @return true if the the file size is greater than the given value.
	 */
	public boolean accept(File pathname) {
		return acceptGreater(pathname, this.filterValue);
	}
	
	/**
	 * A static implementation of the accept method. Created for uses of the
	 * FilterNot class.
	 * @param pathname - the file to accept 
	 * @param filterValue - A String representation of the double to be greater
	 * than.
	 * @return true if the the file size is greater than the given value.
	 */
	public static boolean acceptGreater(File pathname, double value) {
		return pathname.length() > value; 
	}
}
