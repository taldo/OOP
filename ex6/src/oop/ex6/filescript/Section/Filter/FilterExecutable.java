package oop.ex6.filescript.Section.Filter;

import java.io.File;
/**
 * This class represents a Executable type filter. Given a String input value,
 * this class would accept only the files that are executable or not. the given
 * input String would determine if this class would accept the files that are
 * executable or not depending on a YES/No input value.
 * @implements Filter
 * @author taldovrat1988
 */
public class FilterExecutable implements Filter {

	private String filterValue;
	/**
	 * Creates a new Contains Filter object.
	 * @param filterValue - A YES or NO input String that determines which type
	 * of files to accept. is executable files or not.
	 */
	public FilterExecutable(String filterValue){
		this.filterValue = filterValue;
	}

	@Override
	/**
	 * Overrides the accept method in The FileFilter class. Accepts the files 
	 * that are or are not executable, according to the input String.
	 * @param The file to accept.
	 * @return true if the input String is "YES" and the file is executable 
	 * or if the input String is no and the file is no executable. false 
	 * otherwise.
	 */
	public boolean accept(File pathname) {
		if (this.filterValue.equals(YES)) {
			return pathname.canExecute();
		}
		else {
			return !pathname.canExecute();
		}	
	}
	/**
	 * A static implementation of the accept method. Created for uses of the
	 * FilterNot class.
	 * @param pathname - the file to accept 
	 * @param filterValue - YES or NO values, determines which types of files 
	 * to accept. 
	 * @return true if the input String is "YES" and the file is executable 
	 * or if the input String is no and the file is not executable. false 
	 * otherwise.
	 */
	public static boolean acceptExecutable(File file, String filterValue) {
		FilterExecutable exec = new FilterExecutable(filterValue);
		return exec.accept(file);
		
	}
}
