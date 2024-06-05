package com.riwi.prueba_desempeno.infrastructure.abstract_services;

import org.springframework.data.domain.Page;

import com.riwi.prueba_desempeno.utils.enums.SortType;

public interface CrudService<RQ, RS, ID> {
    RS create(RQ rq);

    RS get(ID id);

    RS update(RQ rq, ID id);

    void delete(ID id);
    
    Page<RS> getAll(int page, int size, SortType sort); 
}
