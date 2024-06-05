package com.riwi.prueba_desempeno.domain.entities;

import java.time.LocalDateTime;

import com.riwi.prueba_desempeno.utils.enums.MultimediaType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "multimedia")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Multimedia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50, nullable = false)
    @Enumerated(EnumType.STRING)
    private MultimediaType type;
    @Lob
    private String url;
    @Builder.Default
    private LocalDateTime created_at = LocalDateTime.now();
    @Column(nullable = false)
    private Boolean active; 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lesson_id" , referencedColumnName = "id")
    private Lesson lessonId;
}
