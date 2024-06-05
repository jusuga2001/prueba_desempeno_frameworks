package com.riwi.prueba_desempeno.api.dto.response;

import java.time.LocalDateTime;

import com.riwi.prueba_desempeno.domain.entities.ClassEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentResp {
    private Long id;
    private String name;
    private String email;
    private LocalDateTime created_at;
    private Boolean active;
    private ClassBasicResp classEntity;   
}
