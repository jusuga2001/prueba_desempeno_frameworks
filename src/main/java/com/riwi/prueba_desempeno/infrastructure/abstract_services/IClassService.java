package com.riwi.prueba_desempeno.infrastructure.abstract_services;

import com.riwi.prueba_desempeno.api.dto.request.ClassReq;
import com.riwi.prueba_desempeno.api.dto.response.ClassBasicResp;

public interface IClassService extends CrudService<ClassReq, ClassBasicResp, Long> {
    public final String FIELD_BY_SORT = "created_at";
}
