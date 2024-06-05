package com.riwi.prueba_desempeno.infrastructure.services;
import java.util.NoSuchElementException;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.prueba_desempeno.api.dto.request.StudentReq;
import com.riwi.prueba_desempeno.api.dto.response.ClassBasicResp;
import com.riwi.prueba_desempeno.api.dto.response.StudentResp;
import com.riwi.prueba_desempeno.domain.entities.ClassEntity;
import com.riwi.prueba_desempeno.domain.entities.Student;
import com.riwi.prueba_desempeno.domain.repositories.ClassRepository;
import com.riwi.prueba_desempeno.domain.repositories.StudentRepository;
import com.riwi.prueba_desempeno.infrastructure.abstract_services.IStudentService;
import com.riwi.prueba_desempeno.utils.enums.SortType;
import com.riwi.prueba_desempeno.utils.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService{
    
    @Autowired
    private final StudentRepository studentRepository;
    @Autowired
    private final ClassRepository classRepository;
    
    @Override
    public StudentResp create(StudentReq request) {
        ClassEntity classEntity = classRepository.findById(request.getClassId()).orElseThrow(()-> new NoSuchElementException("No hay registros en el id suministrado"));

        Student student = requestStudentToEntity(request);
        student.setClassId(classEntity);
        return entityStudentToResponse(studentRepository.save(student)); 
    }

    @Override
    public StudentResp get(Long id) {
        return this.entityStudentToResponse(this.find(id));
    }

    @Override
    public StudentResp update(StudentReq request, Long id) {
        ClassEntity classes = classRepository.findById(request.getClassId()).orElseThrow(()-> new NoSuchElementException("No hay registros en el id suministrado"));
        Student student = this.find(id);

       student = this.requestStudentToEntity(request);
       student.setId(id);
       student.setClassId(classes);

       return this.entityStudentToResponse(this.studentRepository.save(student));
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<StudentResp> getAll(int page, int size, SortType sort) {
        if (page <0) page = 0;

        PageRequest pagination = null;

        switch (sort) {
            case NONE -> pagination = PageRequest.of(page, size);
    
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());  
        }

        return this.studentRepository.findAll(pagination)
                .map(this::entityStudentToResponse);
    }

    private Student requestStudentToEntity(StudentReq request){
        ClassEntity classes = classRepository.findById(request.getClassId()).orElse(null);

        return Student.builder()
        .name(request.getName())
        .email(request.getEmail()) 
        .classId(classes)
        .active(request.getActive())
        .build();
    }

    private StudentResp entityStudentToResponse(Student student){

        ClassBasicResp classBasicResp = ClassBasicResp.builder()
        .id(student.getClassId().getId())
        .name(student.getClassId().getName())
        .description(student.getClassId().getDescription())
        .created_at(student.getClassId().getCreated_at())
        .active(student.getClassId().getActive())
        .build();

        BeanUtils.copyProperties(classBasicResp, student.getClassId());

        return StudentResp.builder()
        .id(student.getId())
        .name(student.getName())
        .email(student.getEmail()) 
        .created_at(student.getCreated_at())
        .active(student.getActive())
        .classEntity(classBasicResp)
        .build();
    }

    private Student find(Long id){
        return this.studentRepository.findById(id)
            .orElseThrow(()-> new BadRequestException("No hay registros con el id suministrado"));
    }


}
