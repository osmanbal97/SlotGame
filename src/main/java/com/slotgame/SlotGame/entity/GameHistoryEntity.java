package com.slotgame.SlotGame.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import org.hibernate.annotations.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@Entity
@Table(name ="game_history")
public class GameHistoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false,name = "history_id")
    private Long historyId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)  // Cascade silme işlemi
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private GameEntity game;

    @Column(nullable = false,name= "play_date")
    private LocalDateTime playDate;

    @Column(nullable = false, name="winamount")
    private BigDecimal winamount;

    @Column(nullable = false, name="bet_amount")
    private BigDecimal betamount;

    @Column(nullable = false,name = "currentbalance")
    private BigDecimal currentbalance;

    public GameHistoryEntity() {

    }

    public BigDecimal getCurrentbalance() {
        return currentbalance;
    }

    public void setCurrentbalance(BigDecimal currentbalance) {
        this.currentbalance = currentbalance;
    }

    public BigDecimal getBetamount() {
        return betamount;
    }

    public void setBetamount(BigDecimal betamount) {
        this.betamount = betamount;
    }

    public BigDecimal getWinamount() {
        return winamount;
    }

    public void setWinamount(BigDecimal winamount) {
        this.winamount = winamount;
    }

    public Long getHistoryId() {
        return historyId;
    }

    public UserEntity getUser() {
        return user;
    }

    public GameEntity getGame() {
        return game;
    }

    public String getUserName() {
        return user.getUsername();
    }

    public String getGameName() {
        return game.getGameName();
    }

    public LocalDateTime getPlayDate() {
        return playDate;
    }

    public void setHistoryId(Long historyId) {
        this.historyId = historyId;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setGame(GameEntity game) {
        this.game = game;
    }

    public void setPlayDate(LocalDateTime playDate) {
        this.playDate = playDate;
    }

    public GameHistoryEntity(Long historyId, UserEntity user, GameEntity game, LocalDateTime playDate, BigDecimal winamount, BigDecimal betamount, BigDecimal currentbalance) {
        this.historyId = historyId;
        this.user = user;
        this.game = game;
        this.playDate = playDate;
        this.winamount = winamount;
        this.betamount = betamount;
        this.currentbalance = currentbalance;
    }
}