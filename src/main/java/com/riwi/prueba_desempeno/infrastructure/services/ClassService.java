package com.riwi.prueba_desempeno.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.prueba_desempeno.api.dto.request.ClassReq;
import com.riwi.prueba_desempeno.api.dto.response.ClassBasicResp;
import com.riwi.prueba_desempeno.domain.entities.ClassEntity;
import com.riwi.prueba_desempeno.domain.repositories.ClassRepository;
import com.riwi.prueba_desempeno.infrastructure.abstract_services.IClassService;
import com.riwi.prueba_desempeno.utils.enums.SortType;
import com.riwi.prueba_desempeno.utils.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClassService implements IClassService {

    @Autowired
    private final ClassRepository classRepository;
    
    @Override
    public ClassBasicResp create(ClassReq request) {
        ClassEntity entity = this.requestToEntity(request);
        return this.entityToResp(this.classRepository.save(entity));
    }

    @Override
    public ClassBasicResp get(Long id) {
        return this.entityToResp(this.find(id));
    }

    @Override
    public ClassBasicResp update(ClassReq rq, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<ClassBasicResp> getAll(int page, int size, SortType sort) {
        if (page <0) page = 0;

        PageRequest pagination = null;

        switch (sort) {
            case NONE -> pagination = PageRequest.of(page, size);
    
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());  
        }

        return this.classRepository.findAll(pagination)
                .map(this::entityToResp);
    }

    private ClassEntity requestToEntity(ClassReq request){

        return ClassEntity.builder()
                .name(request.getName())
                .description(request.getDescription())
                .active(request.getActive())
                .build();
    }

    private ClassBasicResp entityToResp(ClassEntity entity){

        return ClassBasicResp.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .created_at(entity.getCreated_at())
                .active(entity.getActive())
                .build();
    }

    private ClassEntity find(Long id){

        return this.classRepository.findById(id)
            .orElseThrow(()-> new BadRequestException("No hay registros en el id suministrado"));
    }
}
