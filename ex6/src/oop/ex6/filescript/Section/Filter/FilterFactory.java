package oop.ex6.filescript.Section.Filter;

import oop.ex6.filescript.Exceptions.TypeOneException;
import oop.ex6.filescript.Section.SectionFactory.TempSection;
/**
 * This class is a "factory" for creating Filter type objects. This class is 
 * responsible for returning the new Filter type objects according to the input
 * given to it. 
 * @author taldovrat1988
 */
public abstract class FilterFactory {

	private static int INDEX_OF_NAME = 0;
	private static String NOT = "NOT", YES = "YES", NO = "NO";
	private static int PLACE_OF_VALUE = 1;
	private static int PLACE_OF_VALUE_2 = 2;
	private static int MAX_ALL_VALUES = 2;
	private static int MAX_STRING_VALUES = 3;
	
	/**
	 * All these constants represent the correct different types of input 
	 * Strings that can be given by the user. 
	 */
	public static final String ALL = "all";
	//YES/NO input values
	public static final String HIDDEN = "hidden";
	public static final String WRITABLE = "writable";
	public static final String EXECUTABLE = "executable";
	//String input values
	public static final String PREFIX = "prefix";
	public static final String SUFFIX = "suffix";
	public static final String CONTAINS = "contains";
	public static final String FILE = "file";
	//double input value
	public static final String GREATER_THAN = "greater_than";
	public static final String SMALLER_THAN = "smaller_than";
	//two double input values.
	public static final String BETWEEN = "between";
	
	/**
	 * This method is used to create a filter from a given TempSection object.
	 * The TempSection object holds the the name of the filter, the input
	 * value/s and whether or not it is a NOT Filter, and its line number.
	 * @param temp - the TempSection object that holds the relevant input 
	 * values 
	 * @return The Filter object according to the input values.
	 * @throws TypeOneException
	 */
	public static Filter createFilter(TempSection temp) 
												throws TypeOneException {
		
		/*
		 * create a String array from the filterName field. Holds 
		 * the information about the the of the filter, its values and if it is
		 * a NOT filter.
		 */
		String[] filterValues = temp.filterName.split("#");
		
		if (filterValues[INDEX_OF_NAME].equals(ALL)) {
			//makes sure the input is correct and what type of input is it.
			
			if (filterValues.length == 1) {
				return new FilterAll();
			}
			else if (filterValues.length == MAX_ALL_VALUES && 
					filterValues[PLACE_OF_VALUE].equals(NOT)){
				return new FilterNot(ALL, null);	
			}
			//if the input is not correct, throw an exception.
			else {
				throw new TypeOneException(temp.filterIndex);
			}
		}
		
		//make sure that the input is correct and determine which type of 
		//filter is it. Same check for all these types of filters.
		else if (filterValues[INDEX_OF_NAME].equals(HIDDEN) ||
				filterValues[INDEX_OF_NAME].equals(WRITABLE) ||
				filterValues[INDEX_OF_NAME].equals(EXECUTABLE)) {
			
			for (int i = 1; i < filterValues.length; i++) {
				if (i > 2) {
					throw new TypeOneException(temp.filterIndex); 
				}
				if (i == 1) {
					if (filterValues[i].equals(YES)) {
						continue;
					}
					else if (filterValues[i].equals(NO)) {
						continue;
					}
					else {
						throw new TypeOneException(temp.filterIndex);
					}
				}
				if (i==2) {
					if (filterValues[i].equals(NOT)) {
						return new FilterNot(filterValues[INDEX_OF_NAME], 
								filterValues[1]);
					}
					else {
						throw new TypeOneException(temp.filterIndex);
					}
				}
			}
			
			return getFilterYesNo(filterValues[INDEX_OF_NAME], 
							temp.filterIndex, filterValues[PLACE_OF_VALUE]);
		}
		
		//make sure that the input is correct and determine which type of 
		//filter is it. Same check for all these types of filters.
		else if(filterValues[INDEX_OF_NAME].equals(SUFFIX) ||
				filterValues[INDEX_OF_NAME].equals(PREFIX) ||
				filterValues[INDEX_OF_NAME].equals(CONTAINS) ||
				filterValues[INDEX_OF_NAME].equals(FILE)) {
			
			for (int i = 1; i < filterValues.length; i++) {
				if (i > MAX_STRING_VALUES-1) {
					throw new TypeOneException(temp.filterIndex); 
				}
				
				if (i == 2) {
					if (filterValues[i].equals(NOT)) {
						return new FilterNot(filterValues[INDEX_OF_NAME], 
								filterValues[PLACE_OF_VALUE]);
					}
					else {
						throw new TypeOneException(temp.filterIndex);
					}
				}
			}
			return getFilterString(filterValues[INDEX_OF_NAME], 
					temp.filterIndex, filterValues[PLACE_OF_VALUE]);
		}
		
		//make sure that the input is correct and determine which type of 
		//filter is it. Same check for all these types of filters.
		else if(filterValues[INDEX_OF_NAME].equals(GREATER_THAN) ||
				filterValues[INDEX_OF_NAME].equals(SMALLER_THAN)) {
			
			for (int i = 1; i < filterValues.length; i++) {
				if (i > MAX_STRING_VALUES-1) {
					throw new TypeOneException(temp.filterIndex); 
				}
				
				if(i == 1) {	
					try {
						if(Double.parseDouble(filterValues[i]) < 0) {
							throw new TypeOneException(temp.filterIndex);
						}
					}
					//if error in name - create a default filter instead.
					catch (NumberFormatException ex) {
						System.out.println(ex.getMessage());
						temp.filterName = ALL;
						return FilterFactory.createFilter(temp);
					}
				}
				
				if (i == 2) {
					if (filterValues[i].equals(NOT)) {
						return new FilterNot(filterValues[INDEX_OF_NAME], 
								filterValues[PLACE_OF_VALUE]);
					}
					else {
						throw new TypeOneException(temp.filterIndex);
					}
				}
			}
			
			return getFilterThan(filterValues[INDEX_OF_NAME], temp.filterIndex, filterValues[1]);
			
		}
		//make sure that the input is correct.
		else if(filterValues[INDEX_OF_NAME].equals(BETWEEN)) {
			
			for (int i = 1; i < filterValues.length; i++) {
				if (i > 3) {
					throw new TypeOneException(temp.filterIndex); 
				}
				
				if(i == 1 || i == 2) {	
					try {
						if(Double.parseDouble(filterValues[i]) < 0) {
							throw new TypeOneException(temp.filterIndex);
						}
					}
					//if error in name - create a default filter instead.
					catch (NumberFormatException ex) {
						System.out.println(ex.getMessage());
						temp.filterName = ALL;
						return FilterFactory.createFilter(temp);
					}
					if (i == 2) {
						try {
							if (Double.parseDouble(filterValues[1])>Double.parseDouble(filterValues[2])) {
								throw new TypeOneException(temp.filterIndex);	
							}
						}
						//if error in name - create a default filter instead.
						catch (NumberFormatException ex) {
							System.out.println(ex.getMessage());
							temp.filterName = ALL;
							return FilterFactory.createFilter(temp);
						}
					}
				}
				
				if (i == 3) {
					if (filterValues[i].equals(NOT)) {
						return new FilterNot(filterValues[INDEX_OF_NAME], 
											filterValues[PLACE_OF_VALUE]+"#"+
											filterValues[PLACE_OF_VALUE_2]);
					}
					else {
						throw new TypeOneException(temp.filterIndex);
					}
				}
			}
			String downAndUp = filterValues[PLACE_OF_VALUE]+"#"+
												filterValues[PLACE_OF_VALUE_2];
			
			return new FilterBetween(downAndUp);
		}
			
		else {
			throw new TypeOneException(temp.filterIndex); 
		}
	}
	
	/*
	 * Helper method for the create filter method. returns the correct filter
	 * between all the YES/NO filters.
	 * @param filterName - the name of the filter
	 * @param filterIndex - the line number of the filter in the file
	 * @param filterValue - the input value of the filter - YES/NO  
	 */
	private static Filter getFilterYesNo(String filterName, int filterIndex, 
			String filterValue) throws TypeOneException {
		
		switch(filterName) { 
		
			case(HIDDEN): return new FilterHidden(filterValue);
		
			case(WRITABLE): return new FilterWritable(filterValue);
			
			case(EXECUTABLE): return new FilterExecutable(filterValue);
			
			default:
				throw new TypeOneException(filterIndex);
		
		}
	}
	
	/*
	 * Helper method for the create filter method. returns the correct filter
	 * between all the String filters.
	 * @param filterName - the name of the filter
	 * @param filterIndex - the line number of the filter in the file
	 * @param filterValue - the input value of the filter - a String  
	 */
	private static Filter getFilterString(String filterName, int filterIndex, String filterValue) 
			throws TypeOneException {
		
		switch(filterName) { 
		
		case(PREFIX): return new FilterPrefix(filterValue);
	
		case(SUFFIX): return new FilterSuffix(filterValue);
		
		case(CONTAINS): return new FilterContains(filterValue);
		
		case(FILE): return new FilterFile(filterValue);
		
		default:
			throw new TypeOneException(filterIndex);
	
		}
	}
	/*
	 * Helper method for the create filter method. returns the correct filter
	 * between all the Than filters.
	 * @param filterName - the name of the filter
	 * @param filterIndex - the line number of the filter in the file
	 * @param filterValue - the input value of the filter - a double  
	 */
	private static Filter getFilterThan(String filterName, int filterIndex, String filterValue) 
			throws TypeOneException {
		
		switch(filterName) { 
		
		case(GREATER_THAN): return new FilterGreater(filterValue);
	
		case(SMALLER_THAN): return new FilterSmaller(filterValue);
		
		default:
			throw new TypeOneException(filterIndex);
	
		}
	}
}
