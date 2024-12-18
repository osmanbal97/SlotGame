package com.slotgame.SlotGame.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

public class GameDto {


    private final Long game_id;
    private final String game_name;
    private final BigDecimal minimumPlayAmount;
    private final BigDecimal winRate;

    public GameDto(Long game_id, String game_name, BigDecimal minimumPlayAmount, BigDecimal winRate) {
        this.game_id = game_id;
        this.game_name = game_name;
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
