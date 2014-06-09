package oop.ex6.filescript.Section.Filter;

import java.io.File;

/**
 * This class represents a Prefix type filter. Given a String input value,
 * this class would accept only the files that their names start with the given
 * string.
 * @implements Filter
 * @author taldovrat1988
 */
public class FilterPrefix implements Filter {

	private String prefix;
	/**
	 * Creates a new Prefix Filter object.
	 * @param prefix - the string that the accepted files will start with.
	 */
	public FilterPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	@Override
	/**
	 * Overrides the accept method in The FileFilter class. Accepts the files 
	 * that their names start with the given input String.
	 * @param file - The file to accept.
	 * @return true if the file starts with the input string.
	 */
	public boolean accept(File pathname) {
		return acceptPrefix(pathname, this.prefix);
	}
	
	/**
	 * A static implementation of the accept method. Created for uses of the
	 * FilterNot class.
	 * @param file - the file to accept 
	 * @param filterValue - the wanted prefix.
	 * @return true if the file starts with the input string.
	 */
	public static boolean acceptPrefix(File file, String filterValue) {
		return file.getName().startsWith(filterValue);	
	}
}
