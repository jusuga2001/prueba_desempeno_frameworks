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

import com.riwi.prueba_desempeno.api.dto.request.LessonReq;
import com.riwi.prueba_desempeno.api.dto.response.LessonResp;
import com.riwi.prueba_desempeno.api.dto.response.StudentResp;
import com.riwi.prueba_desempeno.infrastructure.abstract_services.ILessonService;
import com.riwi.prueba_desempeno.utils.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/lessons")
@AllArgsConstructor
public class LessonController {

    private final ILessonService lessonService;

    @PostMapping
    public ResponseEntity<LessonResp> insert(
        @Validated @RequestBody LessonReq request
    ){
        return  ResponseEntity.ok(this.lessonService.create(request));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<LessonResp> get(@PathVariable Long id) {
        return ResponseEntity.ok(this.lessonService.get(id));
    }

    @GetMapping
    public ResponseEntity<Page<LessonResp>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "5") int size,
        @RequestHeader(required = false) SortType sortType
    ){
        if (Objects.isNull(sortType)) sortType = SortType.NONE;
    
        return ResponseEntity.ok(this.lessonService.getAll(page -1, size, sortType));
    }
}
