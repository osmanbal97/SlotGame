package com.slotgame.SlotGame.controller;

import com.slotgame.SlotGame.dto.GameListDto;
import com.slotgame.SlotGame.dto.PlayGameRequest;
import com.slotgame.SlotGame.entity.GameEntity;
import com.slotgame.SlotGame.entity.UserEntity;
import com.slotgame.SlotGame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/v1/game")
public class GameController {

    private UserEntity user;
    @Autowired
    private GameService gameService;



    @PostMapping("/play")
    public ResponseEntity<?> PlayGame(@RequestBody PlayGameRequest playGameRequest){
        gameService.Playgame(playGameRequest);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping("/available-games")
    public ResponseEntity<List<GameListDto>> getAvailableGames() {
        List<GameListDto> games = gameService.getAllGames(); // Tüm oyunları al
        return ResponseEntity.ok(games); // Listeyi döndür
    }

}
