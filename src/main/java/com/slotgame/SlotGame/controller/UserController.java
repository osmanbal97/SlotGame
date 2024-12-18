package com.slotgame.SlotGame.controller;

import com.slotgame.SlotGame.dto.BalanceResponseDto;
import com.slotgame.SlotGame.dto.GameHistoryDto;
import com.slotgame.SlotGame.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private UserService userService;

    @GetMapping("/balance")
    public ResponseEntity<BalanceResponseDto> RetrieveUserBalance(@RequestBody BalanceResponseDto username) {
        try {
            userService.RetrieveUserBalance(username);
            return ResponseEntity.ok(username);
        } catch (NoSuchElementException e) {
            // Kullanıcı bulunamadığında uygun HTTP durum kodu ile hata döndürme
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new BalanceResponseDto("Error: Kullanıcı bulunamadı!", BigDecimal.ZERO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BalanceResponseDto("Error: Bir hata oluştu", BigDecimal.ZERO));
        }
    }

    @GetMapping("/game-history/{username}")
    public void getGameHistory(@PathVariable GameHistoryDto user, HttpServletResponse response) {

    }


}
