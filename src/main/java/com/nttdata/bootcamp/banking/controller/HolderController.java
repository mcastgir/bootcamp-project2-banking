/**
 * Resumen.
 * Objeto                   : HolderController.java
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

import com.nttdata.bootcamp.banking.model.document.Holder;
import com.nttdata.bootcamp.banking.service.HolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de controladora para invocar a métodos CRUD con rest api.
 */
@RestController
@RequestMapping("/api/holders")
public class HolderController {

    /** Declaración de la clase service */
    @Autowired
    private HolderService holderService;

    /**
     * Método que realiza la acción insertar datos del document
     * @return Mono retorna el Holder, tipo Mono
     */
    @PostMapping
    public Mono<Holder> create(@RequestBody Holder holder){
        return this.holderService.insert(holder);
    }

    /**
     * Método que realiza la acción actualizar datos del document
     * @return Mono retorna el Holder, tipo Mono
     */
    @PutMapping
    public Mono<Holder> update(@RequestBody Holder holder){
        return this.holderService.update(holder);
    }

    /**
     * Método que realiza la acción borrar datos del document
     * @return Mono retorna el Void, tipo Mono
     */
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return this.holderService.delete(id);
    }

    /**
     * Método que realiza la acción buscar datos por id del document
     * @return Mono retorna el Holder, tipo String
     */
    @GetMapping("/{id}")
    public Mono<Holder> find(@PathVariable String id) {
        return this.holderService.find(id);
    }

    /**
     * Método que realiza la acción buscar todos los datos del document
     * @return Flux retorna el Holder, tipo Flux
     */
    @GetMapping
    public Flux<Holder> findAll() {
        return this.holderService.findAll();
    }

}
