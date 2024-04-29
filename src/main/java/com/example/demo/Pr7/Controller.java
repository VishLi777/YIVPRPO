package com.example.demo.Pr7;

import com.example.demo.Pr7.dto.TransactionRqDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private Service service;

    @GetMapping("/getBalance/{cardNumber}")
    public String getBalance(@PathVariable String cardNumber){
        return service.getBalance(cardNumber);
    }

    @PostMapping("/createTransaction")
    public String createTransaction(@RequestBody TransactionRqDto transactionRqDto){
        return service.createTransaction(transactionRqDto);
    }


}
