package ar.com.cashonline.api.domain.loan.service;

import ar.com.cashonline.api.common.PagedResult;
import ar.com.cashonline.api.domain.loan.dto.LoanDTO;

public interface ILoanService {

	PagedResult<LoanDTO> getAllLoans(Integer page, Integer size, Long userId);
}
