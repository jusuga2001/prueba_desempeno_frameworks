package com.riwi.prueba_desempeno.api.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ClassReq {

    @NotBlank(message = "El nombre de la clase es requerido")
    @Size(min = 3, max = 100)
    private String name;
    private String description;
    @NotNull
    private Boolean active;
}
