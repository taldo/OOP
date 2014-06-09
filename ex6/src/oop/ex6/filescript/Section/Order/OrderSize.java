package oop.ex6.filescript.Section.Order;

import java.io.File;

/**
 * This class represents an Size type order. given two files, this class returns
 * a positive number - +1 if one file is bigger, a negative number - -1 if the 
 * other file is bigger, and 0 if the two files are equal. The comparison is 
 * done through the files sizes. 
 * @implements Order
 * @author taldovrat1988
 */
public class OrderSize implements Order {
	
public static final String NAME_OF_ORDER = "type Order";

	@Override
	/**
	 * Overrides the compare method in The Comparator<File> class. This method
	 * compares two files and returns which one is bigger according to their
	 * size. if they are equal, the files are compared by their absolute 
	 * values.
	 * @param o1 - File 1 - compare with the second file
	 * @param o2 - File 2 - compare to the first file.
	 * @return +1 if o1 is bigger, -1 if o2 is bigger, if they are equal, the 
	 * returned value is based on the comparison of their absolute values.
	 */
	public int compare(File o1, File o2) {
		return compareSize(o1, o2);
	}
	/**
	 * A static implementation of the compare method. Created for uses of the
	 * OrderReverse class.
	 * compares two files and returns which one is bigger according to their
	 * size. if they are equal, the files are compared by their absolute values
	 * @param o1 - File 1 - compare with the second file
	 * @param o2 - File 2 - compare to the first file.
	 * @return +1 if o1 is bigger, -1 if o2 is bigger, if they are equal, the 
	 * returned value is based on the comparison of their absolute values.
	 */
	public static int compareSize(File o1, File o2) {

		if (o1.length() > o2.length()) {
			return 1;
		}
		else if (o1.length() < o2.length()) {
			return -1;
		}
		else {
			return OrderAbs.compareAbs(o1,  o2);
		}
	}
}

