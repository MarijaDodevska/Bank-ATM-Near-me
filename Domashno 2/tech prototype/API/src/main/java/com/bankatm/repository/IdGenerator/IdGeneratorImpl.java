package com.bankatm.api.repository.IdGenerator;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class IdGeneratorImpl implements IdGenerator {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Long nextValue(String seqTableName) {

        Query nq = em.createNativeQuery("insert into " + seqTableName + " (dummy) values('x')");
        int numChanged = nq.executeUpdate();

        if (numChanged != 1) {
            throw new RuntimeException("Error retrieving the next sequence value");
        }

        Query nqLast = em.createNativeQuery("SELECT last_insert_id()");
        Long nextValue = ((Number) nqLast.getSingleResult()).longValue();

        return nextValue;
    }

    @Override
    public Long nextPrefetchedValue(String seqTableName) {
        return nextValue(seqTableName);
    }

}