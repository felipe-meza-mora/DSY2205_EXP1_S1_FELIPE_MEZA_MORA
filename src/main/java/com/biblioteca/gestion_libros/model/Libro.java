package com.biblioteca.gestion_libros.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

@Entity
@Table(name = "LIBRO", schema = "SPRINGBOOT_FEL")
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El título es obligatorio")
    @Size(max = 100, message = "El título no puede tener más de 100 caracteres")
    @Column(name = "TITULO")
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    @Size(max = 50, message = "El autor no puede tener más de 50 caracteres")
    @Column(name = "AUTOR")
    private String autor;

    @NotNull(message = "El año de publicación es obligatorio")
    @Min(value = 1450, message = "El año de publicación no puede ser anterior a 1450")
    @Max(value = 2024, message = "El año de publicación no puede ser posterior al año actual")
    @Column(name = "ANIO_PUBLICACION")
    private Integer anioPublicacion;

    @NotBlank(message = "El género es obligatorio")
    @Size(max = 30, message = "El género no puede tener más de 30 caracteres")
    @Column(name = "GENERO")
    private String genero;

    public Libro() {}

    public Libro(String titulo, String autor, Integer anioPublicacion, String genero) {
        this.titulo = titulo;
        this.autor = autor;
        this.anioPublicacion = anioPublicacion;
        this.genero = genero;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}