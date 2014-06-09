package oop.ex6.filescript.Section.Filter;

import java.io.File;
/**
 * /**
 * This class represents a Contains type filter. Given a String input value,
 * this class would accept only the files that the file name contains the given
 * input String.
 * @implements Filter
 * @author taldovrat1988
 */ 
public class FilterContains implements Filter {

	private String partOfFile;
	/**
	 * Creates a new Contains Filter object.
	 * @param partOfFile - the String that is contained or not.
	 */
	public FilterContains(String partOfFile) {
		this.partOfFile = partOfFile;		
	}
	
	@Override
	/**
	 * Overrides the accept method in The FileFilter class. Accepts only the
	 * files that the file name contains the given input String.
	 * @param The file to accept.
	 * @return true if given String is contained in the file name.
	 */
	public boolean accept(File pathname) {
		return acceptContains(pathname, this.partOfFile);
	}
	
	/**
	 * A static implementation of the accept method. Created for uses of the
	 * FilterNot class.
	 * @param pathname - the file to accept.
	 * @param filterValue - The String that is checked if contained or not,
	 * @return true if given String is contained in the file name.
	 */
	public static boolean acceptContains(File file, String filterValue) {
		return file.getName().contains(filterValue);	
	}
}
