package com.slotgame.SlotGame.service;

import com.slotgame.SlotGame.dto.BalanceResponseDto;
import com.slotgame.SlotGame.dto.GameHistoryDto;
import com.slotgame.SlotGame.dto.TopUpRequestDto;

import java.math.BigDecimal;
import java.util.List;

public interface UserService {
    BalanceResponseDto RetrieveUserBalance(BalanceResponseDto user);
    TopUpRequestDto TopUpRequest(String username, double amount);



}
