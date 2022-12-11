package com.bankatm.api.repository.IdGenerator;

public interface IdGenerator {

    Long nextValue(String seqTableName);

    Long nextPrefetchedValue(String seqTableName);

}
