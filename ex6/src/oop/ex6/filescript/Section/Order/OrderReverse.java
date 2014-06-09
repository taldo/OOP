package oop.ex6.filescript.Section.Order;
import java.io.File;

/**
 * This class represents a case when the user requests the reverse of a given
 * order. For example, if the user input is abs#REVERSE, it means that the user 
 * wants exactly the reverse order of the abs order.
 * @author taldovrat1988
 * @implements Filter
 */public class OrderReverse implements Order {

	private static final String SIZE = "size";
	private static final String TYPE = "type";
	
	private String nameOfOrder;
	/**
	 * Creates a new OrderReverse object.
	 * @param nameOfOrder
	 */
	public OrderReverse(String nameOfOrder) {
		this.nameOfOrder = nameOfOrder;
	}

	@Override
	/**
	 * Overrides the compare method in The Comparator<File> class. This method
	 * uses the compare methods of the other orders and returns the opposite
	 * int for the given order.
	 * @param o1 - File 1 - compare with the second file
	 * @param o2 - File 2 - compare to the first file.
	 * @return +1 if o2 is bigger, -1 if o1 is bigger, if they are equal, the 
	 * returned value is based on the comparison of their absolute values in
	 * reverse!
	 */
	public int compare(File o1, File o2) {

		switch(nameOfOrder) {
		
		case(SIZE): {
			return OrderSize.compareSize(o2, o1);
		}
		case(TYPE): {
			return OrderType.compareType(o2, o1);
		}
		default:
			return OrderAbs.compareAbs(o2, o1);
		}
	}	
	
}
