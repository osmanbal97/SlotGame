package com.slotgame.SlotGame.service;

import com.slotgame.SlotGame.dto.GameHistoryDto;
import com.slotgame.SlotGame.dto.GameListDto;
import com.slotgame.SlotGame.dto.PlayGameRequestDto;
import com.slotgame.SlotGame.entity.GameEntity;
import com.slotgame.SlotGame.entity.UserEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public interface GameService {
    List<GameListDto> getAllGames();
    PlayGameRequestDto Playgame(PlayGameRequestDto playGameRequestDto);
    double CalculateWinAmount(double betamount, BigDecimal winrate);
    void saveGameHistory(UserEntity user, GameEntity game, LocalDateTime playDate,
                         double betAmount, double winAmount, BigDecimal currentBalance);
    boolean isWinner(double winRate);
}
