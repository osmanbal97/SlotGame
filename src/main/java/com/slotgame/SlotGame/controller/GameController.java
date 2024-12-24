package com.slotgame.SlotGame.controller;

import com.slotgame.SlotGame.dto.GameListDto;
import com.slotgame.SlotGame.dto.PlayGameRequestDto;
import com.slotgame.SlotGame.entity.UserEntity;
import com.slotgame.SlotGame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/v1/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/play")
    public ResponseEntity<PlayGameRequestDto> PlayGame(@RequestBody PlayGameRequestDto playGameRequestDto){
        PlayGameRequestDto result = gameService.Playgame(playGameRequestDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/available-games")
    public ResponseEntity<List<GameListDto>> getAvailableGames() {
        List<GameListDto> games = gameService.getAllGames();
        return ResponseEntity.ok(games);
    }

}
