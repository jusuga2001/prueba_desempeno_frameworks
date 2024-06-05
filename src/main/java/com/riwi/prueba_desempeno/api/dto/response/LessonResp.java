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
public class LessonResp {
    private Long id;
    private String title;
    private String content;
    private LocalDateTime created_at;
    private Boolean active;
    private ClassResp classEntity;
    private List<MultimediaBasicResp> multimedia;
}
