package oop.ex6.filescript.Section.Filter;

import java.io.File;
/**
 * This class represents a Writable type filter. Given a String input value
 * this class would accept only the files that the user has writing
 * privileges on them, or not. The input String would determine if this 
 * class would accept the files that are writable or not depending on a 
 * YES/NO input value.
 * @implements Filter
 * @author taldovrat1988
 */
public class FilterWritable implements Filter {

	private String filterValue;
	
	/**
	 * Creates a new Writable Filter object.
	 * @param filterValue - A YES or NO input String that determines which type
	 * of files to accept - is writable files or not.
	 */
	public FilterWritable(String filterValue){
		this.filterValue = filterValue;
	}

	@Override
	/**
	 * Overrides the accept method in The FileFilter class. Accepts the files 
	 * that are or are not writable, according to the input String.
	 * @param The file to accept.
	 * @return true if the input String is "YES" and the file is writable 
	 * or if the input String is no and the file is not writable. false 
	 * otherwise.
	 */
	public boolean accept(File pathname) {
		if (this.filterValue.equals(YES)) {
			return pathname.canWrite();
		}
		else {
			return !pathname.canWrite();
		}
		
	}
	/**
	 * A static implementation of the accept method. Created for uses of the
	 * FilterNot class.
	 * @param pathname - the file to accept 
	 * @param filterValue - YES or NO values, determines which types of files 
	 * to accept. 
	 * @return true if the input String is "YES" and the file is writable 
	 * or if the input String is no and the file is not writable. false 
	 * otherwise.
	 */
	public static boolean acceptWritable(File file, String filterValue) {
		FilterWritable write = new FilterWritable(filterValue);
		return write.accept(file);
		
	}

}
