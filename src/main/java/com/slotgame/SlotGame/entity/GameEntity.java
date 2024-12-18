package com.slotgame.SlotGame.entity;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name= "games")
public class GameEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, name = "game_id")
    private Long game_id;

    @Column(nullable = false, unique = true, name= "game_name",updatable = false)
    private String game_name;

    @Column(nullable = false,name="minimum_play_amount",updatable = false)
    private BigDecimal minimumPlayAmount;

    @Column(nullable = false, name= "win_rate",updatable = false)
    private BigDecimal winRate;


    public String getGameName() {
        return game_name;
    }

    public BigDecimal getMinimumPlayAmount() {
        return minimumPlayAmount;
    }

    public BigDecimal getWinRate() {
        return winRate;
    }

    public Long getGameId() {
        return game_id;
    }
}
