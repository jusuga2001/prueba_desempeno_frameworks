package com.riwi.prueba_desempeno.api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassBasicResp {
    private Long id;
    private String name;
    private String description;
    private LocalDateTime created_at;
    private Boolean active;
}
