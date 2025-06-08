package com.ragheb.dao;

import com.ragheb.entity.Loan;

public interface LoanDao {

    void saveLoan(Loan loan);

    Loan fetchLoanDetailsById(Integer loanId);

    void removeLoan(Integer loanId);
}
