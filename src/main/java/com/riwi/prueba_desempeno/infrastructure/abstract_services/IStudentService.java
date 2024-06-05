package com.riwi.prueba_desempeno.infrastructure.abstract_services;

import com.riwi.prueba_desempeno.api.dto.request.StudentReq;
import com.riwi.prueba_desempeno.api.dto.response.StudentResp;

public interface IStudentService extends CrudService<StudentReq, StudentResp, Long> {
    public final String FIELD_BY_SORT = "created_at";
}
