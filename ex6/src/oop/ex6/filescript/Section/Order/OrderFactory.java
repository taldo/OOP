package oop.ex6.filescript.Section.Order;

import oop.ex6.filescript.Exceptions.TypeOneException;
import oop.ex6.filescript.Section.SectionFactory.TempSection;
/**
 * This class is a "factory" for creating Order type objects. This class is 
 * responsible for returning the new Order type objects according to the input
 * given to it. 
 * @author taldovrat1988
 */
public abstract class OrderFactory {
	
	private static final String ABS = "abs";
	private static final String ABS_REVERSE = "abs#REVERSE";
	
	private static final String TYPE = "type";
	private static final String TYPE_REVERSE = "type#REVERSE";
	
	private static final String SIZE = "size";
	private static final String SIZE_REVERSE = "size#REVERSE";
	/**
	 * Creates and returns the Order type object according to the given.
	 * TempSection input object. 
	 * @param temp - The TempSection object that holds all the relevant info 
	 * for creating the correct order.
	 * @return The correct Order type object.
	 * @throws TypeOneException
	 */
	public static Order createOrder(TempSection temp) throws TypeOneException {
		
		switch(temp.orderName){ 
			
			case(ABS): return new OrderAbs();
			
			case(ABS_REVERSE): return new OrderReverse(ABS);
				
			case(TYPE): return new OrderType();
			
			case(TYPE_REVERSE): return new OrderReverse(TYPE);
			
			case(SIZE): return new OrderSize();
			
			case(SIZE_REVERSE): return new OrderReverse(SIZE);
			
			default: 
				throw new TypeOneException(temp.orderIndex);
		}
	}
	
}
