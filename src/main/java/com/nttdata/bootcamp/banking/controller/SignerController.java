/**
 * Resumen.
 * Objeto                   : SignerController.java
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

import com.nttdata.bootcamp.banking.model.document.Signer;
import com.nttdata.bootcamp.banking.service.SignerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de controladora para invocar a métodos CRUD con rest api.
 */
@RestController
@RequestMapping("/api/signers")
public class SignerController {

    /** Declaración de la clase service */
    @Autowired
    private SignerService signerService;

    /**
     * Método que realiza la acción insertar datos del document
     * @return Mono retorna el Signer, tipo Mono
     */
    @PostMapping
    public Mono<Signer> create(@RequestBody Signer signer){
        return this.signerService.insert(signer);
    }

    /**
     * Método que realiza la acción actualizar datos del document
     * @return Mono retorna el Signer, tipo Mono
     */
    @PutMapping
    public Mono<Signer> update(@RequestBody Signer signer){
        return this.signerService.update(signer);
    }

    /**
     * Método que realiza la acción borrar datos del document
     * @return Mono retorna el Void, tipo Mono
     */
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable String id) {
        return this.signerService.delete(id);
    }

    /**
     * Método que realiza la acción buscar datos por id del document
     * @return Mono retorna el Signer, tipo String
     */
    @GetMapping("/{id}")
    public Mono<Signer> find(@PathVariable String id) {
        return this.signerService.find(id);
    }

    /**
     * Método que realiza la acción buscar todos los datos del document
     * @return Flux retorna el Signer, tipo Flux
     */
    @GetMapping
    public Flux<Signer> findAll() {
        return this.signerService.findAll();
    }

}
