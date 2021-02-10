package ar.com.cashonline.api.domain.loan.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.cashonline.api.domain.loan.entity.Loan;

public interface LoanRepository extends JpaRepository<Loan, Long> {

	Page<Loan> findByUserId(Long userId, Pageable pageable);
}
