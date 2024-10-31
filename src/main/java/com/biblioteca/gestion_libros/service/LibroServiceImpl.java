package com.biblioteca.gestion_libros.service;

import com.biblioteca.gestion_libros.model.Libro;
import com.biblioteca.gestion_libros.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public List<Libro> findAll() {
        return libroRepository.findAll();
    }

    @Override
    public Libro findById(Long id) {
        Optional<Libro> libro = libroRepository.findById(id);
        return libro.orElse(null); 
    }

    @Override
    public Optional<Libro> update(Long id, Libro libro) {
        Optional<Libro> libroOptional = libroRepository.findById(id);
        if (libroOptional.isPresent()) {
            Libro libroToUpdate = libroOptional.get();
            libroToUpdate.setTitulo(libro.getTitulo());
            libroToUpdate.setAutor(libro.getAutor());
            libroToUpdate.setAnioPublicacion(libro.getAnioPublicacion());
            libroToUpdate.setGenero(libro.getGenero());
            return Optional.of(libroRepository.save(libroToUpdate));
        }
        return Optional.empty();
    }

    @Override
    public Libro save(Libro libro) {
        return libroRepository.save(libro);
    }

    @Override
    public void deleteById(Long id) {
        libroRepository.deleteById(id);
    }
}