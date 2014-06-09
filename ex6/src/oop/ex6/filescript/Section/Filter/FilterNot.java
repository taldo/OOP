package oop.ex6.filescript.Section.Filter;

import java.io.File;
/**
 * This class represents a case when the user requests the opposite of a given
 * filter. For example, if the user input is all#NOT, it means that the user 
 * wants exactly the opposite of the all filter.
 * @author taldovrat1988
 * @implements Filter
 */
public class FilterNot implements Filter {
	
	private String nameOfFilter;
	private String filterValue;
	
	/**
	 * creates a new Not Filter object.
	 * @param nameOfFilter - accept the opposite of the given string 
	 * representation of the filter.
	 * @param filterValue - the input value of the filter. Changes from filter
	 * to filter.
	 */
	public FilterNot(String nameOfFilter, String filterValue) {
		this.nameOfFilter = nameOfFilter;
		this.filterValue = filterValue;
	}
	
	@Override
	/**
	 * This method overrides the accept method from the FileFilter class. This
	 * goes over all the cases of the different types of filters and returns
	 * the opposite of the filters original accept method.
	 * @param pathname - the file to accept.
	 */
	public boolean accept(File pathname) {
		switch(this.nameOfFilter) {
		
		case(FilterFactory.ALL): return !FilterAll.acceptAll(pathname); 
		
		case(FilterFactory.HIDDEN): return !FilterHidden.acceptHidden(pathname, this.filterValue);
		
		case(FilterFactory.WRITABLE): return !FilterWritable.acceptWritable(pathname, this.filterValue);
		
		case(FilterFactory.EXECUTABLE): return !FilterExecutable.acceptExecutable(pathname, this.filterValue);
		
		case(FilterFactory.PREFIX): return !FilterPrefix.acceptPrefix(pathname, this.filterValue);
		
		case(FilterFactory.SUFFIX): return !FilterSuffix.acceptSuffix(pathname, this.filterValue);
		
		case(FilterFactory.CONTAINS): return !FilterContains.acceptContains(pathname, this.filterValue);
		
		case(FilterFactory.FILE): return !FilterFile.acceptFile(pathname, this.filterValue);
		
		case(FilterFactory.GREATER_THAN): return !FilterGreater.acceptGreater(pathname, Double.parseDouble(this.filterValue)*1000);
		
		case(FilterFactory.SMALLER_THAN): return !FilterSmaller.acceptSmaller(pathname, Double.parseDouble(this.filterValue)*1000);
		
		case(FilterFactory.BETWEEN): return !FilterBetween.acceptBetween(pathname, this.filterValue);  
		
		default: return FilterAll.acceptAll(pathname);
		}
	}

}
