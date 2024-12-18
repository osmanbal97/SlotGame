package com.slotgame.SlotGame.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "users")
public class UserEntity {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(unique = true, nullable = false, updatable = false,name= "user_id")
    private Long id;

    @Column(unique=true, nullable=false)
    private String username;

    @Column(nullable = false)
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

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Long getId() {

        return id;
    }
}
