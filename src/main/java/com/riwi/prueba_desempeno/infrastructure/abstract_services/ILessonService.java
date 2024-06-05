package com.riwi.prueba_desempeno.infrastructure.abstract_services;

import com.riwi.prueba_desempeno.api.dto.request.LessonReq;
import com.riwi.prueba_desempeno.api.dto.response.LessonBasicResp;

public interface ILessonService extends CrudService<LessonReq, LessonBasicResp, Long> {
    
}
