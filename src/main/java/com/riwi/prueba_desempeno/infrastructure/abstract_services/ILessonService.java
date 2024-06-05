package com.riwi.prueba_desempeno.infrastructure.abstract_services;

import com.riwi.prueba_desempeno.api.dto.request.LessonReq;
import com.riwi.prueba_desempeno.api.dto.response.LessonResp;

public interface ILessonService extends CrudService<LessonReq, LessonResp, Long> {
    public final String FIELD_BY_SORT = "created_at"; 
}
