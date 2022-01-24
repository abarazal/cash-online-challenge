package ar.com.cashonline.api.common;

import java.util.List;

public class PagedResult<T> {

	private final List<T> items;
	private final Paging paging;

	public PagedResult(List<T> items, Integer page, Integer size, Long total) {
		this.items = items;
		this.paging = new Paging(page, size, total);
	}
	
	public List<T> getItems() {
		return items;
	}

	public Paging getPaging() {
		return paging;
	}
}
