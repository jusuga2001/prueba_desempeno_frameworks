package com.riwi.prueba_desempeno.api.controllers;

import java.util.Objects;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.prueba_desempeno.api.dto.request.ClassReq;
import com.riwi.prueba_desempeno.api.dto.response.ClassBasicResp;
import com.riwi.prueba_desempeno.infrastructure.abstract_services.IClassService;
import com.riwi.prueba_desempeno.utils.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/clases")
@AllArgsConstructor
public class ClassController {

    private final IClassService classService;

    @PostMapping
    public ResponseEntity<ClassBasicResp> insert(
        @Validated @RequestBody ClassReq request
    ){
        return  ResponseEntity.ok(this.classService.create(request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ClassBasicResp> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.classService.get(id));
    }

    @GetMapping
    public ResponseEntity<Page<ClassBasicResp>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestHeader(required = false) SortType sortType
    ){

        if (Objects.isNull(sortType)) sortType = SortType.NONE;
        
        return ResponseEntity.ok(this.classService.getAll(page -1, size, sortType));
    }
}
