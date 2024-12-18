package com.slotgame.SlotGame.repository;

import com.slotgame.SlotGame.entity.GameHistoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameHistoryRepository extends JpaRepository<GameHistoryEntity, Long> {

}
