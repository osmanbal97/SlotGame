package com.slotgame.SlotGame.repository;

import com.slotgame.SlotGame.dto.GameHistoryDto;
import com.slotgame.SlotGame.entity.GameEntity;
import com.slotgame.SlotGame.entity.GameHistoryEntity;
import com.slotgame.SlotGame.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface GameHistoryRepository extends JpaRepository<GameHistoryEntity, Long> {
    List<GameHistoryEntity> getAllByUser_Username(String username);

}
