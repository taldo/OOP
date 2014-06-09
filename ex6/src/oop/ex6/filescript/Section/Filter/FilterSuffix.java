package oop.ex6.filescript.Section.Filter;

import java.io.File;
/**
 * This class represents a Suffix type filter. Given a String input value,
 * this class would accept only the files that their names end with the given
 * string.
 * @implements Filter
 * @author taldovrat1988
 */
public class FilterSuffix implements Filter {

	private String suffix;
	/**
	 * Creates a new Suffix Filter object.
	 * @param suffix - the string that the accepted files will end with.
	 */
	public FilterSuffix(String suffix) {
		this.suffix = suffix;		
	}
	
	@Override
	/**
	 * Overrides the accept method in The FileFilter class. Accepts the files 
	 * that their names end with the given input String.
	 * @param file - The file to accept.
	 * @return true if the file ends with the input string.
	 */
	public boolean accept(File pathname) {
		return acceptSuffix(pathname, this.suffix);
	}
	
	/**
	 * A static implementation of the accept method. Created for uses of the
	 * FilterNot class.
	 * @param file - the file to accept 
	 * @param filterValue - the wanted suffix.
	 * @return true if the file ends with the input string.
	 */
	public static boolean acceptSuffix(File file, String filterValue) {
		return file.getName().endsWith(filterValue);	
	}
}