package com.riwi.prueba_desempeno.infrastructure.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.prueba_desempeno.api.dto.request.LessonReq;
import com.riwi.prueba_desempeno.api.dto.request.MultimediaReq;
import com.riwi.prueba_desempeno.api.dto.response.ClassBasicResp;
import com.riwi.prueba_desempeno.api.dto.response.LessonResp;
import com.riwi.prueba_desempeno.api.dto.response.MultimediaBasicResp;
import com.riwi.prueba_desempeno.domain.entities.ClassEntity;
import com.riwi.prueba_desempeno.domain.entities.Lesson;
import com.riwi.prueba_desempeno.domain.entities.Multimedia;
import com.riwi.prueba_desempeno.domain.repositories.ClassRepository;
import com.riwi.prueba_desempeno.domain.repositories.LessonRepository;
import com.riwi.prueba_desempeno.infrastructure.abstract_services.ILessonService;
import com.riwi.prueba_desempeno.utils.enums.SortType;
import com.riwi.prueba_desempeno.utils.exceptions.BadRequestException;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class LessonService implements ILessonService {
    
    @Autowired
    private final LessonRepository lessonRepository;
    @Autowired
    private final ClassRepository classRepository;

    @Override
    public LessonResp create(LessonReq request) {
        ClassEntity classEntity = classRepository.findById(request.getClassId()).orElseThrow(()-> new NoSuchElementException("No hay registros en el id suministrado"));

        Lesson lesson = requestLessonToEntity(request);
        lesson.setClassId(classEntity);
        return entityLessonToResponse(lessonRepository.save(lesson)); 
    }

    @Override
    public LessonResp get(Long id) {
        return this.entityLessonToResponse(this.find(id));
    }

    @Override
    public LessonResp update(LessonReq rq, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<LessonResp> getAll(int page, int size,SortType sort) {
        if (page <0) page = 0;

        PageRequest pagination = null;

        switch (sort) {
            case NONE -> pagination = PageRequest.of(page, size);
    
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());  
        }

        return this.lessonRepository.findAll(pagination)
                .map(this::entityLessonToResponse);
    }

    private MultimediaBasicResp entityToResponseMultimedia(Multimedia entity){
        return MultimediaBasicResp.builder()
                .id(entity.getId())
                .type(entity.getType())
                .url(entity.getUrl())
                .created_at(entity.getCreated_at())
                .active(entity.getActive())
                .build();
    }

    private Multimedia requestMultimediaToEntity(MultimediaReq multimediaRequest) {
        return Multimedia.builder()
        .type(multimediaRequest.getType())
        .url(multimediaRequest.getUrl())
        .active(multimediaRequest.getActive())
        .build();
    }

    private Lesson requestLessonToEntity(LessonReq request){
        List<Multimedia> medias = request.getMedias().stream().map(this::requestMultimediaToEntity).collect(Collectors.toList());
        ClassEntity classes = classRepository.findById(request.getClassId()).orElse(null);

        return Lesson.builder()
        .title(request.getTitle())
        .content(request.getContent()) 
        .active(request.getActive())
        .multimedia(medias)
        .classId(classes)
        .build();
    }

    private LessonResp entityLessonToResponse(Lesson lesson){
        List<MultimediaBasicResp> medias = lesson.getMultimedia()
                .stream()
                .map(this::entityToResponseMultimedia)
                .collect(Collectors.toList());

        ClassBasicResp classBasicResp = ClassBasicResp.builder()
        .id(lesson.getClassId().getId())
        .name(lesson.getClassId().getName())
        .description(lesson.getClassId().getDescription())
        .created_at(lesson.getClassId().getCreated_at())
        .active(lesson.getClassId().getActive())
        .build();
         
        BeanUtils.copyProperties(classBasicResp, lesson.getClassId());

        return LessonResp.builder()
        .id(lesson.getId())
        .title(lesson.getTitle())
        .content(lesson.getContent()) 
        .created_at(lesson.getCreated_at())
        .active(lesson.getActive())
        .multimedia(medias)
        .classEntity(classBasicResp)
        .build();
    }

    private Lesson find(Long id){
        return this.lessonRepository.findById(id)
            .orElseThrow(()-> new BadRequestException("No hay registros con el id suministrado"));
    }


    
}
