package com.slotgame.SlotGame.service;

import com.slotgame.SlotGame.dto.GameListDto;
import com.slotgame.SlotGame.dto.PlayGameRequest;

import java.math.BigDecimal;
import java.util.List;

public interface GameService {
    List<GameListDto> getAllGames();
    void Playgame(PlayGameRequest playGameRequest);
    public double CalculateWinAmount(double betamount, BigDecimal winrate);
}
