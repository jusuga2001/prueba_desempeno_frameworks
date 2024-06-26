package com.riwi.prueba_desempeno.api.dto.request;

import java.time.LocalDateTime;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
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
public class StudentReq {
    @NotBlank(message = "El nombre es requerido")
    @Size(min = 3, max = 100)
    private String name;
    @Email
    private String email;
    @NotNull(message = "El id de la clase es obligatorio")
    @Min(value = 1, message = "El id debe ser mayor a cero ")
    private Long classId;
    @NotNull
    private Boolean active;    
}
