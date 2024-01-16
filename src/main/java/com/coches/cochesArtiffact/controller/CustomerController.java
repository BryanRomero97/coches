package com.coches.cochesArtiffact.controller;

import com.coches.cochesArtiffact.dominio.dto.CustomerDto;
import com.coches.cochesArtiffact.dominio.dto.ResponseCustomerDto;
import com.coches.cochesArtiffact.dominio.service.ICustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

    private final ICustomerService iCustomerService;

    @GetMapping()
    public ResponseEntity<List<CustomerDto>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(iCustomerService.getAll());
    }

    @GetMapping(path = "/{cardId}")
    public ResponseEntity<CustomerDto> getCustomerByCardId(@PathVariable String cardId){
        return ResponseEntity.of(iCustomerService.getCustomerByCardId(cardId));
    }

    @GetMapping(path = "/{email}")
    public ResponseEntity<CustomerDto> getCustomerByEmail(@PathVariable String email){
        return ResponseEntity.of(iCustomerService.getCustomerByEmail(email));
    }

    @PostMapping()
    public ResponseEntity<ResponseCustomerDto> save(@RequestBody CustomerDto customerDto){
        try {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body(iCustomerService.save(customerDto));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build() ;
        }

    }
    public ResponseEntity<CustomerDto> update(@RequestBody CustomerDto customerDto) {

        Optional<CustomerDto> customerDto1 = iCustomerService.update(customerDto);

        if (customerDto1.isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(customerDto);
        }
    }


    @DeleteMapping(path = "/{cardId}")
    public ResponseEntity<Boolean> delete(@PathVariable String cardId){

        return new ResponseEntity<>(this.iCustomerService.delete(cardId) ? HttpStatus.OK : HttpStatus.NOT_FOUND);

    }




}
