package sn.sa.devweb.repository;
import sn.sa.devweb.domain.Transaction;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Spring Data  repository for the Transaction entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    @Query("select transaction from Transaction transaction where transaction.idUserExp.login = ?#{principal.username}")
    List<Transaction> findByIdUserExpIsCurrentUser();

    @Query("select transaction from Transaction transaction where transaction.idUserRec.login = ?#{principal.username}")
    List<Transaction> findByIdUserRecIsCurrentUser();

}
