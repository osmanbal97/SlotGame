package com.slotgame.SlotGame.dto;

import java.math.BigDecimal;

public class GameListDto {

    private final String game_name;
    private final BigDecimal minimumPlayAmount;
    private final BigDecimal winRate;


    public GameListDto(String gameName, BigDecimal minimumPlayAmount, BigDecimal winRate) {

        game_name = gameName;
        this.minimumPlayAmount = minimumPlayAmount;
        this.winRate = winRate;
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
