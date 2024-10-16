package com.biblioteca.gestion_libros.service;

import com.biblioteca.gestion_libros.model.Libro;
import java.util.List;

public interface LibroService {
    List<Libro> findAll();
    Libro findById(Long id);
    Libro save(Libro libro);
    void deleteById(Long id);
}