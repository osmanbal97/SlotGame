package com.slotgame.SlotGame.repository;

import com.slotgame.SlotGame.dto.GameHistoryDto;
import com.slotgame.SlotGame.entity.GameEntity;
import com.slotgame.SlotGame.entity.GameHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameHistoryRepository extends JpaRepository<GameHistoryDto, Long> {
    List<GameHistoryDto> findGameHistoryEntitiesByUser_Username(String username);
}
