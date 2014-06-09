package oop.ex6.filescript.Section;

import oop.ex6.filescript.Exceptions.BadCommandFileException;
import oop.ex6.filescript.Exceptions.TypeOneException;
import oop.ex6.filescript.Section.Filter.Filter;
import oop.ex6.filescript.Section.Filter.FilterFactory;
import oop.ex6.filescript.Section.Order.Order;
import oop.ex6.filescript.Section.Order.OrderFactory;

import java.util.*;

public class SectionFactory {

	public static final int EMPTY_FILE = 0;
	public static final int NO_ORDER_INDEX = 0;
	public static final String FILTER = "FILTER", ORDER = "ORDER";
	public static final String DEFAULT_FILTER = "all";
	public static final String DEFAULT_ORDER = "abs";
	public static final String NO_FILTER_VALUE = null;
	
	public ArrayList<TempSection> tempSections;
	
	public SectionFactory(ListIterator<String> linesIter) throws BadCommandFileException {
		this.tempSections = new ArrayList<TempSection>();
		this.getSectionStructures(linesIter);
	}
	
	public class TempSection {
		
		public String filterName, filterValue, orderName;
		public Integer filterIndex, orderIndex;
		
		public TempSection(Integer filterIndex, String filterName, 
				Integer orderIndex, String orderName) {
			
			this.filterIndex = filterIndex;
			this.filterName = filterName;
			this.orderIndex = orderIndex;
			this.orderName = orderName;
		}
	}
	
	public Section createSection(TempSection temp) {
		
		if (temp == null) {
			return null;
		}
		
		//initialize Filter and Order. 
		Filter filter = null;
		Order order = null;
		
		try {
			filter = FilterFactory.createFilter(temp);
		}
		//catch warnings
		catch (TypeOneException ex) {
			System.out.println(ex.getLocalizedMessage());
			//will always succeed
			try {
				temp.filterName = DEFAULT_FILTER;
				filter = FilterFactory.createFilter(temp);
			}
			catch(TypeOneException exc) {
				System.out.println(exc.getLocalizedMessage());
			}
		}
		
		try {
			order = OrderFactory.createOrder(temp);
		}
		catch (TypeOneException ex) {
			System.out.println(ex.getLocalizedMessage());
			//will always succeed.
			try {
				temp.orderName = DEFAULT_ORDER;
				order = OrderFactory.createOrder(temp);
			}
			catch(TypeOneException exc) {
				System.out.println(exc.getLocalizedMessage());
			}
		}
		//create section
		return new Section(filter, order);
		
	}
	
	public void getSectionStructures(ListIterator<String> linesIter) throws BadCommandFileException {

		if (!linesIter.hasNext()) {
			throw new BadCommandFileException();
		}
		
		//initializing fields that will later on will be used to create the
		//sections.
		String filterName, orderName;
		Integer filterIndex, orderIndex;
		
		//A temp array list, will be used to create the sections from it.
		//ArrayList<TempSection> tempSections = new ArrayList<TempSection>();
		
		//while not at the end of the list:
		while(linesIter.hasNext()) {
			//if line is FILTER
			if(linesIter.next().equals(FILTER)) {
				//check if line after Filter is ORDER and throw exception if 
				//it is
				if(linesIter.next().equals(ORDER)|| linesIter.hasNext() == false) {
					throw new BadCommandFileException();
				}
				//return to the FILTER line.
				linesIter.previous();
				
				//now at FILTER line:
				
				//save the line number of the filter name.
				filterIndex = linesIter.nextIndex();
				//save line after filter to the filter name.
				filterName = linesIter.next();
				
				//check if line after filter name is ORDER
				if(!linesIter.next().equals(ORDER)) {
					throw new BadCommandFileException();
				}
				
				//now at ORDER line in the text:
				
				//if end of text and no order name:
				if(linesIter.hasNext() == false) {
					orderIndex = NO_ORDER_INDEX;
					orderName = Order.DEFUALT_ORDER;
				}
				
				//if no ORDER name but there are more lines:
				else if(linesIter.next().equals(FILTER)) {
					//return to ORDER line
					linesIter.previous();
					//save the order name line number
					orderIndex = NO_ORDER_INDEX;
					//save order name as default order
					orderName = Order.DEFUALT_ORDER;
				}
			
				//if order name exists:
				else {
					
					linesIter.previous();
					orderIndex = linesIter.nextIndex();
					orderName = linesIter.next();
				}
				
				//create the tempSection object from the filter and order names
				//and line numbers.
				this.tempSections.add(new TempSection(filterIndex, filterName, orderIndex, orderName));
			}
			else {
				throw new BadCommandFileException();
			}
		}
	}
		
	public ListIterator<TempSection> getTempSectionIter() {
		return this.tempSections.listIterator();
	}
	
}
