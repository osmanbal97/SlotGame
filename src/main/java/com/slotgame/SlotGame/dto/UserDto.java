package com.slotgame.SlotGame.dto;



import java.math.BigDecimal;

public class UserDto {
    private Long id;
    private String username;
    private BigDecimal balance;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance){
        this.balance = balance;

    }

}
