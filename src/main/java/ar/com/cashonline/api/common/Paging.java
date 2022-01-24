package ar.com.cashonline.api.common;

public class Paging {

	private final Integer page;
	private final Integer size;
	private final Long total;

	public Paging(Integer page, Integer size, Long total) {
		this.page = page;
		this.size = size;
		this.total = total;
	}

	public Integer getPage() {
		return page;
	}

	public Integer getSize() {
		return size;
	}

	public Long getTotal() {
		return total;
	}
}
