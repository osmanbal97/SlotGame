package com.slotgame.SlotGame.service.impl;

import com.slotgame.SlotGame.dto.GameHistoryDto;
import com.slotgame.SlotGame.entity.GameHistoryEntity;
import com.slotgame.SlotGame.repository.GameHistoryRepository;
import com.slotgame.SlotGame.service.GameHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GameHistoryServiceImpl implements GameHistoryService {
    @Autowired
    private GameHistoryRepository gameHistoryRepository;



    @Override
    public List<GameHistoryDto> gameHistory(String username) {
        List<GameHistoryEntity> gameHistoryEntities = gameHistoryRepository.getAllByUser_Username(username);
        return gameHistoryEntities.stream().map(gameHistoryDto1 -> new GameHistoryDto(
                gameHistoryDto1.getHistoryId(),
                gameHistoryDto1.getUserName(),
                gameHistoryDto1.getGameName(),
                gameHistoryDto1.getPlayDate(),
                gameHistoryDto1.getWinamount(),
                gameHistoryDto1.getBetamount(),
                gameHistoryDto1.getCurrentbalance()
        )).collect(Collectors.toList());
    }


}
