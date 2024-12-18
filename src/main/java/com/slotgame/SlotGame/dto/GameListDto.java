package com.slotgame.SlotGame.dto;

import java.math.BigDecimal;

public class GameListDto {
    private final Long game_id;
    private final String game_name;
    private final BigDecimal minimumPlayAmount;
    private final BigDecimal winRate;


    public GameListDto(Long gameId, String gameName, BigDecimal minimumPlayAmount, BigDecimal winRate) {
        game_id = gameId;
        game_name = gameName;
        this.minimumPlayAmount = minimumPlayAmount;
        this.winRate = winRate;
    }

    public Long getGame_id() {
        return game_id;
    }

    public String getGame_name() {
        return game_name;
    }

    public BigDecimal getMinimumPlayAmount() {
        return minimumPlayAmount;
    }

    public BigDecimal getWinRate() {
        return winRate;
    }
}
