/**
 * Resumen.
 * Objeto                   : AccountController.java
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

import com.nttdata.bootcamp.banking.model.document.Account;
import com.nttdata.bootcamp.banking.service.AccountService;
import com.nttdata.bootcamp.banking.util.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Clase de controladora para invocar a métodos CRUD con rest api.
 */
@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    /** Declaración de la clase service */
    @Autowired
    private AccountService accountService;

    /**
     * Método que realiza la acción insertar datos del document
     * @return Mono retorna el Account, tipo Mono
     */
    @PostMapping
    public Mono<ResponseEntity<ApiResponse>> create(@RequestBody Account account){
        Mono<Account> accountMono = this.accountService.insert(account);
        return accountMono.map(data -> ResponseEntity.ok(ApiResponse.success("Insert Account",
                "Successful result", data)))
                .onErrorResume(e -> Mono.just(new ResponseEntity<>(ApiResponse.failed(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()),
                        HttpStatus.INTERNAL_SERVER_ERROR)));
    }

    /**
     * Método que realiza la acción actualizar datos del document
     * @return Mono retorna el Account, tipo Mono
     */
    @PutMapping
    public Mono<ResponseEntity<ApiResponse>> update(@RequestBody Account account){
        Mono<Account> accountMono = this.accountService.update(account);
        return accountMono.map(data -> ResponseEntity.ok(ApiResponse.success("Update Account",
                        "Successful result", data)))
                .onErrorResume(e -> Mono.just(new ResponseEntity<>(ApiResponse.failed(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()),
                        HttpStatus.INTERNAL_SERVER_ERROR)));
    }

    /**
     * Método que realiza la acción borrar datos del document
     * @return Mono retorna el Void, tipo Mono
     */
    @DeleteMapping("/{id}")
    public Mono<ResponseEntity<ApiResponse>> delete(@PathVariable String id) {
        Mono<Void> voidMono = this.accountService.delete(id);
        return voidMono.map(data -> ResponseEntity.ok(ApiResponse.success("Delete Account",
                        "Successful result", data)))
                .onErrorResume(e -> Mono.just(new ResponseEntity<>(ApiResponse.failed(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()),
                        HttpStatus.INTERNAL_SERVER_ERROR)));
    }

    /**
     * Método que realiza la acción buscar datos por id del document
     * @return Mono retorna el Account, tipo String
     */
    @GetMapping("/{id}")
    public Mono<ResponseEntity<ApiResponse>> find(@PathVariable String id) {
        Mono<Account> accountMono = this.accountService.find(id);
        return accountMono.map(data -> ResponseEntity.ok(ApiResponse.success("Find Account",
                        "Successful result", data)))
                .onErrorResume(e -> Mono.just(new ResponseEntity<>(ApiResponse.failed(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()),
                        HttpStatus.INTERNAL_SERVER_ERROR)));
    }

    /**
     * Método que realiza la acción buscar datos por código del document
     * @return Mono retorna el Account, tipo String
     */
    @GetMapping("/findByAccountNumber/{accountNumber}")
    public Mono<ResponseEntity<ApiResponse>> findByAccountNumber(@PathVariable String accountNumber) {
        Mono<Account> accountMono = this.accountService.findByAccountNumber(accountNumber);
        return accountMono.map(data -> ResponseEntity.ok(ApiResponse.success("Find By AccountNumber Account",
                        "Successful result", data)))
                .onErrorResume(e -> Mono.just(new ResponseEntity<>(ApiResponse.failed(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()),
                        HttpStatus.INTERNAL_SERVER_ERROR)));
    }

    /*@GetMapping("/findAllByCodeClient/{code}")
    public Flux<Account> findAllByCodeClient(@PathVariable String code) {
        return this.accountService.findByCodeClient(code);
    }*/

    @GetMapping("/findAllByCodeClient/{code}")
    public Mono<ResponseEntity<Flux<Account>>> findAllByCodeClient(@PathVariable String code) {
        return Mono.just(
                ResponseEntity.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(this.accountService.findByCodeClient(code))
        );
        /*return Mono.just(ResponseEntity.ok(ApiResponse.success("Find By AccountNumber Account",
                "Successful result", this.accountService.findByCodeClient(code))))
                .onErrorResume(e -> Mono.just(new ResponseEntity<>(ApiResponse.failed(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value()),
                        HttpStatus.INTERNAL_SERVER_ERROR)));*/
    }

    /**
     * Método que realiza la acción buscar todos los datos del document
     * @return Flux retorna el Account, tipo Flux
     */
    @GetMapping
    public Flux<Account> findAll() {
        return this.accountService.findAll();
    }

}
