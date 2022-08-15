/**
 * Resumen.
 * Objeto                   : MovementController.java
 * Descripción              : Clase de controladora para invocar a métodos CRUD con rest api.
 * Fecha de Creación        : 04/08/2022.
 * Proyecto de Creación     : Bootcamp-01.
 * Autor                    : Marvin Castro.
 * ---------------------------------------------------------------------------------------------------------------------------
 * Modificaciones
 * Motivo                   Fecha             Nombre                  Descripción
 * ---------------------------------------------------------------------------------------------------------------------------
 * Bootcamp-01              05/08/2022        Oscar Candela           Realizar la creación de un método nuevo.
 */

package com.nttdata.bootcamp.banking.controller;

import com.nttdata.bootcamp.banking.model.document.Movement;
import com.nttdata.bootcamp.banking.service.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de controladora para invocar a métodos CRUD con rest api.
 */
@RestController
@RequestMapping("/api/movements")
public class MovementController {

    /** Declaración de la clase service */
    @Autowired
    private MovementService movementService;

    /**
     * Método que realiza la acción insertar datos del document
     * @return Mono retorna el Movement, tipo Mono
     */
    @PostMapping
    public Mono<Movement> create(@RequestBody Movement movement){
        return this.movementService.insert(movement);
    }

    /**
     * Método que realiza la acción actualizar datos del document
     * @return Mono retorna el Movement, tipo Mono
     */
    @PutMapping
    public Mono<Movement> update(@RequestBody Movement movement){
        return this.movementService.update(movement);
    }

    /**
     * Método que realiza la acción borrar datos del document
     * @return Mono retorna el Void, tipo Mono
     */
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return this.movementService.delete(id);
    }

    /**
     * Método que realiza la acción buscar datos por id del document
     * @return Mono retorna el Movement, tipo String
     */
    @GetMapping("/{id}")
    public Mono<Movement> find(@PathVariable String id) {
        return this.movementService.find(id);
    }

    /**
     * Método que realiza la acción buscar datos por código del document
     * @return Mono retorna el Movement, tipo String
     */
    @GetMapping("/findByCode/{code}")
    public Mono<Movement> findByCode(@PathVariable String code) {
        return this.movementService.findByCode(code);
    }

    /**
     * Método que realiza la acción buscar todos los datos del document
     * @return Flux retorna el Movement, tipo Flux
     */
    @GetMapping
    public Flux<Movement> findAll() {
        return this.movementService.findAll();
    }

}
