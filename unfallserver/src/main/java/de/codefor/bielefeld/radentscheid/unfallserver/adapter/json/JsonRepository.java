package de.codefor.bielefeld.radentscheid.unfallserver.adapter.json;


import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * author skonair@gmail.com
 * date 16.08.20
 */
public interface JsonRepository<T, ID extends Serializable>
        extends Repository<T, ID> {

    T findOne(ID primaryKey);

    Iterable<T> findAll();

    Long count();

    boolean exists(ID primaryKey);
}
