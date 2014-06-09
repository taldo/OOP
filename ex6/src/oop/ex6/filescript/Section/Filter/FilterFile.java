package oop.ex6.filescript.Section.Filter;

import java.io.File;

/**
 * This class represents a FileName type filter. Given a String input value,
 * this class would accept only the files that are the file name is identical 
 * to the given input String.
 * @implements Filter
 * @author taldovrat1988
 */
public class FilterFile implements Filter{
	
	private String fileName;
	/**
	 * Creates a new FileName Filter object.
	 * @param filterValue - A String that is the file name wanted to accept.
	 */
	public FilterFile(String fileName) {
		this.fileName = fileName;		
	}
	
	@Override
	/**
	 * Overrides the accept method in The FileFilter class. Accepts the files 
	 * that are the file name is identical to the given input String.
	 * @param The file to accept.
	 * @return true if the input String is identical to to given file.
	 */
	public boolean accept(File pathname) {
		return acceptFile(pathname, this.fileName);	
	}
	
	/**
	 * A static implementation of the accept method. Created for uses of the
	 * FilterNot class.
	 * @param pathname - the file to accept 
	 * @param filterValue - A name of the wanted files.
	 * @return true if the input String is identical to to given file.
	 */
	public static boolean acceptFile(File file, String filterValue) {
		return file.getName().equals(filterValue);	
	}
}
