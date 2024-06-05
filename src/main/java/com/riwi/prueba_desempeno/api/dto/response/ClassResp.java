package com.riwi.prueba_desempeno.api.dto.response;

import java.time.LocalDateTime;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassResp {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime created_at;
    private Boolean active;
    private List<StudentBasicResp> student;
    private List<LessonBasicResp> lesson;

}
