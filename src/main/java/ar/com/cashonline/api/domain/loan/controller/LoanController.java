package ar.com.cashonline.api.domain.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ar.com.cashonline.api.common.PagedResult;
import ar.com.cashonline.api.domain.loan.dto.LoanDTO;
import ar.com.cashonline.api.domain.loan.service.impl.LoanService;

@RestController
@RequestMapping("/api/loans")
public class LoanController {

	@Autowired
	private LoanService loanService;

	@GetMapping
	public PagedResult<LoanDTO> getAllLoans(@RequestParam(required = true) Integer page,
			@RequestParam(required = true) Integer size, @RequestParam(required = false) Long userId) {

		return loanService.getAllLoans(page, size, userId);
	}
}
