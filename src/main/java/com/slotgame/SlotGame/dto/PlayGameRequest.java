package com.slotgame.SlotGame.dto;


public class PlayGameRequest {

    private Long Id;
    private String username;
    private String game_name;
    private Long game_Id;
    private double betamount;

    public Long getGame_Id() {
        return game_Id;
    }

    public Long getId() {
        return Id;
    }

    public String getUsername() {
        return username;
    }

    public String getGame_name() {
        return game_name;
    }

    public void setBetamount(double betamount) {
        this.betamount = betamount;
    }

    public double getBetamount() {
        return betamount;
    }
}
