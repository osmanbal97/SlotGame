package com.slotgame.SlotGame.service;

import com.slotgame.SlotGame.dto.GameHistoryDto;

import java.util.List;

public interface GameHistoryService {
    List<GameHistoryDto> gameHistory(GameHistoryDto user);
}
