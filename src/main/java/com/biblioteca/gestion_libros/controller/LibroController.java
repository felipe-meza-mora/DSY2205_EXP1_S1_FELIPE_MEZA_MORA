package com.biblioteca.gestion_libros.controller;

import com.biblioteca.gestion_libros.model.Libro;
import com.biblioteca.gestion_libros.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<Map<String, Object>> getAllLibros() {
        List<Libro> libros = libroService.findAll();
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Se han encontrado " + libros.size() + " libros.");
        response.put("libros", libros);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getLibroById(@PathVariable Long id) {
        Optional<Libro> libro = Optional.ofNullable(libroService.findById(id));
        Map<String, Object> response = new HashMap<>();

        if (libro.isPresent()) {
            response.put("message", "Libro encontrado: " + libro.get().getTitulo());
            response.put("libro", libro.get());
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Libro no encontrado");
            return ResponseEntity.status(404).body(response);
        }
    }

    @PostMapping
    public ResponseEntity<Map<String, Object>> createLibro(@Valid @RequestBody Libro libro) {
        Libro savedLibro = libroService.save(libro);
        Map<String, Object> response = new HashMap<>();
        response.put("message", "Libro añadido correctamente: " + savedLibro.getTitulo());
        response.put("libro", savedLibro);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Map<String, Object>> updateLibro(@PathVariable Long id, @Valid @RequestBody Libro libro) {
        Optional<Libro> libroUpdated = libroService.update(id, libro);
        Map<String, Object> response = new HashMap<>();

        if (libroUpdated.isPresent()) {
            response.put("message", "Libro actualizado correctamente: " + libroUpdated.get().getTitulo());
            response.put("libro", libroUpdated.get());
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Libro no encontrado para actualización");
            return ResponseEntity.status(404).body(response);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteLibro(@PathVariable Long id) {
        Optional<Libro> libro = Optional.ofNullable(libroService.findById(id));
        Map<String, Object> response = new HashMap<>();

        if (libro.isPresent()) {
            libroService.deleteById(id);
            response.put("message", "Libro eliminado correctamente: " + libro.get().getTitulo());
            return ResponseEntity.ok(response);
        } else {
            response.put("message", "Libro no encontrado para eliminar");
            return ResponseEntity.status(404).body(response);
        }
    }
}