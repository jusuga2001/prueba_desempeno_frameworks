package com.riwi.prueba_desempeno.api.dto.response;

import java.time.LocalDateTime;

import com.riwi.prueba_desempeno.utils.enums.MultimediaType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultimediaResp {
    private Long id;
    private MultimediaType type;
    private String url;
    private LocalDateTime created_at;
    private Boolean active;
    private LessonBasicResp lesson;
}
