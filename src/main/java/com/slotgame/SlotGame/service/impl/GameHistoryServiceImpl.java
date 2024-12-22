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
    public List<GameHistoryDto> gameHistory(GameHistoryDto gameHistoryDto) {
        List<GameHistoryEntity> gameHistoryEntities = gameHistoryRepository.getAllByUser_Username(gameHistoryDto.getUsername());
        return gameHistoryEntities.stream().map(gameHistoryDto1 -> new GameHistoryDto(
                gameHistoryDto.getHistoryId(),
                gameHistoryDto.getUsername(),
                gameHistoryDto.getGame_name(),
                gameHistoryDto.getPlayDate(),
                gameHistoryDto.getWinamount(),
                gameHistoryDto.getBetamount(),
                gameHistoryDto.getCurrentbalance()
        )).collect(Collectors.toList());
    }

}
