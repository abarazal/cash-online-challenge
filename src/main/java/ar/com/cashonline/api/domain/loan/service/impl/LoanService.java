package ar.com.cashonline.api.domain.loan.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ar.com.cashonline.api.common.PagedResult;
import ar.com.cashonline.api.domain.loan.dto.LoanDTO;
import ar.com.cashonline.api.domain.loan.entity.Loan;
import ar.com.cashonline.api.domain.loan.repository.LoanRepository;
import ar.com.cashonline.api.domain.loan.service.ILoanService;

@Service
public class LoanService implements ILoanService {

	private final LoanRepository loanRepository;
	private final ModelMapper modelMapper;

	public LoanService(LoanRepository loanRepository,
					   ModelMapper modelMapper) {
		this.loanRepository = loanRepository;
		this.modelMapper = modelMapper;
	}

	@Override
	public PagedResult<LoanDTO> getAllLoans(Integer page, Integer size, Long userId) {
		PageRequest pageable = PageRequest.of(page, size);

		Page<Loan> pagedLoan;

		if (userId == null) {
			pagedLoan = loanRepository.findAll(pageable);
		} else {
			pagedLoan = loanRepository.findByUserId(userId, pageable);
		}

		if (pagedLoan.hasContent()) {
			List<Loan> loans = pagedLoan.getContent();
			
			List<LoanDTO> loansDto = loans.stream()
					.map(user -> modelMapper.map(user, LoanDTO.class))
					.collect(Collectors.toList());

			return new PagedResult<>(loansDto, pagedLoan.getNumber(), pagedLoan.getSize(),
					pagedLoan.getTotalElements());
		}
		
		return new PagedResult<>(Collections.emptyList(), 0, 0, 0L);
	}

}
