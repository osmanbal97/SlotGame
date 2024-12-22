package com.slotgame.SlotGame.dto;

import java.math.BigDecimal;

public class TopUpRequestDto {
    private Long id;
    private String username;
    private BigDecimal balance;

    public TopUpRequestDto() {
    }

    public TopUpRequestDto(Long id, String username, BigDecimal balance) {
        this.id = id;
        this.username = username;
        this.balance = balance;
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
