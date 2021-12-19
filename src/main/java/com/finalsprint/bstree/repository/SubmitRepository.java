// This is the SubmitRepository class

package com.finalsprint.bstree.repository;

import com.finalsprint.bstree.model.FinalSubmit;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
public class SubmitRepository {
    @PersistenceContext
    private EntityManager entityManager;

    // Insert into database
    @Transactional
    public void insertWithQuery(FinalSubmit finalSubmit) {
        entityManager.createNativeQuery("INSERT INTO submit (number1, " +
                        "number2, number3, number4, number5, number6, number7, number8, number9, number10) " +
                        "VALUES (?,?,?,?,?,?,?,?,?,?)")
                .setParameter(1, finalSubmit.getNumber1())
                .setParameter(2, finalSubmit.getNumber2())
                .setParameter(3, finalSubmit.getNumber3())
                .setParameter(4, finalSubmit.getNumber4())
                .setParameter(5, finalSubmit.getNumber5())
                .setParameter(6, finalSubmit.getNumber6())
                .setParameter(7, finalSubmit.getNumber7())
                .setParameter(8, finalSubmit.getNumber8())
                .setParameter(9, finalSubmit.getNumber9())
                .setParameter(10, finalSubmit.getNumber10())
                .executeUpdate();
    }

    @Transactional
    public void insertWithEntityManager(FinalSubmit finalSubmit) {
        this.entityManager.persist(finalSubmit);
    }
}
