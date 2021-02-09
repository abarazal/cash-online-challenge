package ar.com.cashonline.api.common;

import java.util.List;

public class PagedResult<T> {

	private List<T> items;
	private Paging paging;

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
