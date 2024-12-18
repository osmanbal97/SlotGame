package com.slotgame.SlotGame.repository;

import com.slotgame.SlotGame.entity.GameEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameRepository extends JpaRepository<GameEntity, Long> {
    List<GameEntity> findAll();
}
