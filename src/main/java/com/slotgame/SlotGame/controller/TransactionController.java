package com.slotgame.SlotGame.controller;


import com.slotgame.SlotGame.dto.TopUpRequestDto;
import com.slotgame.SlotGame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class TransactionController {
    @Autowired
    UserService userService;

    @PutMapping("/topup-balance")
    public ResponseEntity<TopUpRequestDto> TopUpBalance(@RequestBody TopUpRequestDto user){

        TopUpRequestDto result = userService.TopUpRequest(user.getUsername(),user.getAmount());
        return ResponseEntity.ok(result);
    }
}



