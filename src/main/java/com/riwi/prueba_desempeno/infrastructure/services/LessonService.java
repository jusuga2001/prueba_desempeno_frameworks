package com.riwi.prueba_desempeno.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.prueba_desempeno.api.dto.request.LessonReq;
import com.riwi.prueba_desempeno.api.dto.response.LessonBasicResp;
import com.riwi.prueba_desempeno.domain.repositories.LessonRepository;
import com.riwi.prueba_desempeno.infrastructure.abstract_services.ILessonService;
import com.riwi.prueba_desempeno.utils.enums.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LessonService implements ILessonService {
    
    @Autowired
    private final LessonRepository lessonRepository;

    @Override
    public LessonBasicResp create(LessonReq rq) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public LessonBasicResp get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public LessonBasicResp update(LessonReq rq, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<LessonBasicResp> getAll(int page, int size,SortType sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    
}
