package oop.ex6.filescript.Section.Filter;

import java.io.File;
/**
 * This class represents a Between type filter. Given two double input values,
 * this class would accept only the files that their size is between (or equal)
 * the two given values.
 * @implements Filter
 * @author taldovrat1988
 *
 */
public class FilterBetween implements Filter {
	//the filter value given at the constructor.
	private String downAndUp;
	
	private double downLimit;
	private double upLimit;
	/**
	 * Creates a new Between Filter from the given String. 
	 * @param downAndUp - This String is of the format VALUE#VALUE, the format
	 * is checked prior to the constructor so that if the constructor is 
	 * triggered, this will necessary be the input String format.  
	 */
	public FilterBetween (String downAndUp) {
		this.downAndUp = downAndUp;
		//creates a String array with the two values without the # mark.
		String[] downUp = downAndUp.split("#");
		/*parses the values from the string array to doubles. also checks prior 
		 * to the runtime of the constructor so String values are correct
		 */
		this.downLimit = Double.parseDouble(downUp[0])*K;
		this.upLimit = Double.parseDouble(downUp[1])*K;
	}

	@Override
	/**
	 * Overrides the accept method in The FileFilter class. Accepts only the
	 * files that their size is between the two input double values.
	 * @param The file to accept.
	 * @return true if the file size is between (or equal) the two input 
	 * doubles.
	 */
	public boolean accept(File pathname) {
		return acceptBetween(pathname, this.downAndUp);
	}
	
	/**
	 * A static implementation of the accept method. Created for uses of the
	 * FilterNot class.
	 * @param pathname - the file to accept.
	 * @param downAndUp - The String containing the double values in the format
	 * of VALUE#VALUE.
	 * @return true if the file size is between the double values..
	 */
	public static boolean acceptBetween(File pathname, String downAndUp) {
		FilterBetween f = new FilterBetween(downAndUp);
		return (pathname.length() >= f.downLimit && pathname.length() <= f.upLimit);
	}
}
