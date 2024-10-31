package com.biblioteca.gestion_libros.service;

import com.biblioteca.gestion_libros.model.Libro;
import java.util.Optional;
import java.util.List;

public interface LibroService {
    //Metodo para obtener todos los libros
    List<Libro> findAll();
    //Metodo para obtener un libro por su id
    Libro findById(Long id);
    //Metodo para guardar un libro
    Libro save(Libro libro);
    //Metodo para eliminar un libro por su id
    void deleteById(Long id);
    //Metodo para actualizar un libro
    Optional<Libro> update(Long id, Libro libro);
}