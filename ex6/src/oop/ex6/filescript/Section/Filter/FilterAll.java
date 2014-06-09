package oop.ex6.filescript.Section.Filter;

import java.io.File;
/**
 * This Filter class accepts all files. 
 * @implements Filter
 * @author taldovrat1988
 *
 */
public class FilterAll implements Filter {
	
	@Override
	/**
	 * Overrides the accept method in The FileFilter class. Accepts all files.
	 * @return true always.
	 */
	public boolean accept(File file) {
		return acceptAll(file);
	}
	/**
	 * A static implementation of the accept method. Created for uses of the
	 * FilterNot class.
	 * @param file - the file to accept.
	 * @return true always.
	 */
	public static boolean acceptAll(File file) {
		return true;	
	}
}
