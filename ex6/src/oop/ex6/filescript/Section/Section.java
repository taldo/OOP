package oop.ex6.filescript.Section;

import oop.ex6.filescript.Section.Filter.Filter;
import oop.ex6.filescript.Section.Order.Order;

public class Section {

	private Filter filter;
	private Order order;
	
	public Section(Filter filter, Order order) {
		
		this.filter = filter;
		this.order = order;
	}
	
	public Filter getFilter() {
		return this.filter;
	}
	
	public Order getOrder() {
		return this.order;
	}
}
