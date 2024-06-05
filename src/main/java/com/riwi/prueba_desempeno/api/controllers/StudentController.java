package com.riwi.prueba_desempeno.api.controllers;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.prueba_desempeno.api.dto.request.StudentReq;
import com.riwi.prueba_desempeno.api.dto.response.StudentResp;
import com.riwi.prueba_desempeno.infrastructure.abstract_services.IStudentService;
import com.riwi.prueba_desempeno.utils.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/students")
@AllArgsConstructor
public class StudentController {

    private final IStudentService studentService;

    @PostMapping
    public ResponseEntity<StudentResp> insert(
        @Validated @RequestBody StudentReq request
    ){
        return  ResponseEntity.ok(this.studentService.create(request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<StudentResp> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.studentService.get(id));
    }

    @GetMapping
    public ResponseEntity<Page<StudentResp>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestHeader(required = false) SortType sortType
    ){
        if (Objects.isNull(sortType)) sortType = SortType.NONE;
    
        return ResponseEntity.ok(this.studentService.getAll(page -1, size, sortType));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<StudentResp> update(
        @Validated @RequestBody StudentReq request,
        @PathVariable Long id 
    ){
        return ResponseEntity.ok(this.studentService.update(request, id));
    }
    
}
