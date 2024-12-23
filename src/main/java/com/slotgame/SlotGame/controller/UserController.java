package com.slotgame.SlotGame.controller;

import com.slotgame.SlotGame.dto.BalanceResponseDto;
import com.slotgame.SlotGame.dto.GameHistoryDto;
import com.slotgame.SlotGame.dto.TopUpRequestDto;
import com.slotgame.SlotGame.service.GameHistoryService;
import com.slotgame.SlotGame.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.nio.charset.CharacterCodingException;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private GameHistoryService gameHistoryService;
    @Autowired
    private UserService userService;


    @GetMapping("/balance")
    public ResponseEntity<BalanceResponseDto> RetrieveUserBalance(@RequestBody BalanceResponseDto balanceResponseDto) {
        try {
            BalanceResponseDto retrieve = userService.RetrieveUserBalance(balanceResponseDto);
            return ResponseEntity.ok(retrieve);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new BalanceResponseDto("Kullanıcı bulunamadı!", BigDecimal.ZERO));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BalanceResponseDto("Bir hata oluştu", BigDecimal.ZERO));
        }
    }

    @GetMapping("/game-history/{username}")
    public ResponseEntity<List<GameHistoryDto>> getGameHistory(@PathVariable String username) {
        try {
            List<GameHistoryDto> history = gameHistoryService.gameHistory(new GameHistoryDto(username));
            return ResponseEntity.ok(history);
        } catch (Exception e) {
            throw new NoSuchElementException("Böyle bir kullanıcı yok!");
        }
    }

}
