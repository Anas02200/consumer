package com.test.Kadmin.jpaRepos;

import com.test.Kadmin.entities.OngoingTransactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OngoingTransactionsRepo  extends JpaRepository<OngoingTransactions, Long> {
}
