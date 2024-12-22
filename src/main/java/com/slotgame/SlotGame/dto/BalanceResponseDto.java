package com.slotgame.SlotGame.dto;



import java.math.BigDecimal;


public class BalanceResponseDto {
    private String username;
    private BigDecimal balance;

    public BalanceResponseDto(String username, BigDecimal balance) {
        this.username = username;
        this.balance = balance;
    }
    public BalanceResponseDto(String username) {
        this.username = username;
    }

    public BalanceResponseDto() {
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
