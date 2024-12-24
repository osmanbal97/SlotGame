package com.slotgame.SlotGame.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PlayGameRequestDto {

    private Long Id;
    private String username;
    private String message;
    private double win_amount_result;
    private String game_name;
    private Long game_Id;
    private double betamount;
    private double finalbalance;


    public PlayGameRequestDto(String username, String message, double win_amount_result, double betamount, double finalbalance) {
        this.username = username;
        this.message = message;
        this.win_amount_result = win_amount_result;
        this.betamount = betamount;
        this.finalbalance = finalbalance;
    }
    public PlayGameRequestDto() {

    }

    public double getFinalbalance() {
        return finalbalance;
    }

    public void setFinalbalance(double finalbalance) {
        this.finalbalance = finalbalance;
    }

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

    public void setId(Long id) {
        Id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public double getWin_amount_result() {
        return win_amount_result;
    }

    public void setWin_amount_result(double win_amount_result) {
        this.win_amount_result = win_amount_result;
    }

    public void setGame_name(String game_name) {
        this.game_name = game_name;
    }

    public void setGame_Id(Long game_Id) {
        this.game_Id = game_Id;
    }
}
