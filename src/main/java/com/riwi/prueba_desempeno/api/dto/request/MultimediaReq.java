package com.riwi.prueba_desempeno.api.dto.request;

import java.time.LocalDateTime;

import com.riwi.prueba_desempeno.utils.enums.MultimediaType;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultimediaReq {
    @NotNull(message = "El tipo de multimedia es requerido")
    private MultimediaType type;
    private String url;
    @NotNull(message = "El id de lesson es obligatorio")
    @Min(value = 1, message = "El id debe ser mayor a cero ")
    private Long lesson_id;
    @NotNull
    private Boolean active;
    
}
