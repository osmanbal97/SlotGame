package com.slotgame.SlotGame.service;

import com.slotgame.SlotGame.dto.BalanceResponseDto;
import com.slotgame.SlotGame.dto.GameHistoryDto;
import com.slotgame.SlotGame.dto.TopUpRequestDto;
import java.util.List;

public interface UserService {
    BalanceResponseDto RetrieveUserBalance(BalanceResponseDto user);
    TopUpRequestDto TopUpRequest(TopUpRequestDto user);
    List<GameHistoryDto> gameHistory(GameHistoryDto user);


}
