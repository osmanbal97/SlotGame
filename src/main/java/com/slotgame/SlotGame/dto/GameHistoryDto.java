package com.slotgame.SlotGame.dto;


import com.slotgame.SlotGame.entity.GameEntity;
import com.slotgame.SlotGame.entity.UserEntity;
import java.math.BigDecimal;
import java.time.LocalDateTime;


public class GameHistoryDto {

    private Long historyId;
    private String username;
    private String game_name;
    private LocalDateTime playDate;
    private BigDecimal winamount;
    private BigDecimal betamount;
    private BigDecimal currentbalance;

    public GameHistoryDto(Long historyId, String username, String game_name, LocalDateTime playDate, BigDecimal winamount, BigDecimal betamount, BigDecimal currentbalance) {
        this.historyId = historyId;
        this.username = username;
        this.game_name = game_name;
        this.playDate = playDate;
        this.winamount = winamount;
        this.betamount = betamount;
        this.currentbalance = currentbalance;
    }


    public Long getHistoryId() {
        return historyId;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public LocalDateTime getPlayDate() {
        return playDate;
    }

    public void setPlayDate(LocalDateTime playDate) {
        this.playDate = playDate;
    }

    public BigDecimal getWinamount() {
        return winamount;
    }

    public void setWinamount(BigDecimal winamount) {
        this.winamount = winamount;
    }

    public BigDecimal getBetamount() {
        return betamount;
    }

    public void setBetamount(BigDecimal betamount) {
        this.betamount = betamount;
    }

    public BigDecimal getCurrentbalance() {
        return currentbalance;
    }

    public void setCurrentbalance(BigDecimal currentbalance) {
        this.currentbalance = currentbalance;
    }
}
