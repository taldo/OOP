package oop.ex6.filescript.Section.Order;

import java.io.File;
/**
 * This class represents an Abs type order. given two files, this class returns
 * a positive number - +1 if one file is bigger, a negative number - -1 if the 
 * other file is bigger, and 0 if the two files are equal. The comparison is 
 * done through the files absolute value. 
 * @implements Order
 * @author taldovrat1988
 */
public class OrderAbs implements Order {
	
	@Override
	/**
	 * Overrides the compare method in The Comparator<File> class. This method
	 * compares two files and returns which one is bigger according to their
	 * absolute value.
	 * @param o1 - File 1 - compare with the second file
	 * @param o2 - File 2 - compare to the first file.
	 * @return +1 if o1 is bigger, -1 if o2 is bigger, 0 if they are equal.
	 */
	public int compare(File o1, File o2) {
		return compareAbs(o1, o2);
	}
	
	/**
	 * A static implementation of the compare method. Created for uses of the
	 * OrderReverse class.
	 * compares two files and returns which one is bigger according to their
	 * absolute value.
	 * @param o1 - File 1 - compare with the second file
	 * @param o2 - File 2 - compare to the first file.
	 * @return +1 if o1 is bigger, -1 if o2 is bigger, 0 if they are equal.
	 */
	public static int compareAbs(File o1, File o2) {
		if (o1.getName().compareTo(o2.getName()) > 0) {
			return 1;
		}
		else if (o1.getName().compareTo(o2.getName()) < 0) {
			return -1;
		}
		else {
			return 0;
		}
	}
}
