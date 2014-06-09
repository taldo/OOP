package oop.ex6.filescript.Section.Order;

import java.io.File;
import java.util.*;
/**
 * This Interface extends Comparator for the type File. A father class for all
 * subrorder classes. This interface represent a general comparison between two 
 * files that can return +1, -1 or 0 depending on the comparison methodology. 
 * @author taldovrat1988
 *
 */
public interface Order extends Comparator<File> {

	public static final String DEFUALT_ORDER = "abs";
	
}
