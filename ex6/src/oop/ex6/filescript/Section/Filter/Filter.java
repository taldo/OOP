package oop.ex6.filescript.Section.Filter;

import java.io.FileFilter;
/**
 * This interface is the father class of all filter classes. creates a one type
 * of object that can be used in general.
 * @extends FileFilter
 * @author taldovrat1988
 *
 */
public interface Filter extends FileFilter {
	public static final int K = 1024;
	public static String NOT = "NOT", YES = "YES", NO = "NO";
	
}

