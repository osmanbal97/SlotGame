package com.slotgame.SlotGame.controller;


import com.slotgame.SlotGame.dto.TopUpRequestDto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.InputMismatchException;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {

    @PutMapping("/topup-balance")
    public ResponseEntity<?> TopUpBalance(@RequestBody TopUpRequestDto user){
        String username=user.getUsername();
        BigDecimal balance=user.getBalance();
        if (balance.doubleValue()<0) {
            return ResponseEntity.badRequest().body("Top Up Amount should be greater than 0");
        }else {
            user.setBalance(balance);
            System.out.println("User: " + username);
            System.out.println("New balance is: "+ balance);
            return ResponseEntity.ok("success");
        }
    }


}
