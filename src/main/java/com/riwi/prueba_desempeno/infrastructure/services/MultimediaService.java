package com.riwi.prueba_desempeno.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import com.riwi.prueba_desempeno.api.dto.request.MultimediaReq;
import com.riwi.prueba_desempeno.api.dto.response.MultimediaBasicResp;
import com.riwi.prueba_desempeno.domain.repositories.MultimediaRepository;
import com.riwi.prueba_desempeno.infrastructure.abstract_services.IMultimediaService;
import com.riwi.prueba_desempeno.utils.enums.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MultimediaService implements IMultimediaService{
    
    @Autowired
    private MultimediaRepository multimediaRepository;
    
    @Override
    public MultimediaBasicResp create(MultimediaReq rq) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'create'");
    }

    @Override
    public MultimediaBasicResp get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public MultimediaBasicResp update(MultimediaReq rq, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<MultimediaBasicResp> getAll(int page, int size, SortType sort) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }
    
}
