package ar.com.cashonline.api.domain.loan.dto;

import java.math.BigDecimal;

public class LoanDTO {

	private Long id;
	private BigDecimal total;
	private Long userId;
	
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public BigDecimal getTotal() {
		return total;
	}
	
	public void setTotal(BigDecimal total) {
		this.total = total;
	}
	
	public Long getUserId() {
		return userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
