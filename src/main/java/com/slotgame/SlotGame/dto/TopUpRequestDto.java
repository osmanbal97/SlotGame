package com.slotgame.SlotGame.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;

public class TopUpRequestDto {
    private Long id;
    private String username;
    private BigDecimal balance;
    private double amount;

    public void setId(Long id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public TopUpRequestDto(String username) {
        this.username = username;
    }

    public TopUpRequestDto(Long id,@JsonProperty("username") String username,
                           @JsonProperty("amount") double amount,
                           BigDecimal balance) {
        this.id = id;
        this.username = username;
        this.amount = amount;
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
