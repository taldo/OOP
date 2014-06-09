package oop.ex6.filescript.Section.Filter;

import java.io.File;
/**
 * This class represents a Hidden type filter. Given a String input value,
 * this class would accept only the files that are hidden or not.
 * @implements Filter
 * @author taldovrat1988
 */
public class FilterHidden implements Filter {

	//YES/NO value - says which files to accept, hidden or not.
	private String filterValue;
	
	/**
	 * Creates a new Hidden Filter object.
	 * @param filterValue - A String that decides which files to accept - 
	 * hidden or not.
	 */
	public FilterHidden(String filterValue) {
		this.filterValue = filterValue;
	}
	@Override
	/**
	 * Overrides the accept method in The FileFilter class. Accepts the files 
	 * that are hidden or not according to the given input String. If the input
	 * String is YES - the method accepts the hidden files. If the input String
	 * is NO - the method accepts the not hidden files.
	 * @param file - The file to accept.
	 * @return true if the file is hidden or not, depending on the input string
	 */
	public boolean accept(File file) {
		if (this.filterValue.equals(YES)) {
			return file.isHidden();
		}
		else {
			return !file.isHidden();
		}
	}
	
	/**
	 * A static implementation of the accept method. Created for uses of the
	 * FilterNot class.
	 * @param file - the file to accept 
	 * @param filterValue - YES or NO value.
	 * @return if filterValue is YES and file is hidden - returns true. if 
	 * filterValue is NO and the file is not hidden, returns true. return false 
	 * otherwise.
	 */
	public static boolean acceptHidden(File file, String filterValue) {
		FilterHidden hid = new FilterHidden(filterValue);
		return hid.accept(file);
	}
}
