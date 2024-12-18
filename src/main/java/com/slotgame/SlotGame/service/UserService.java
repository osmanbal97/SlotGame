package com.slotgame.SlotGame.service;

import com.slotgame.SlotGame.dto.BalanceResponseDto;
import com.slotgame.SlotGame.dto.UserDto;
import com.slotgame.SlotGame.entity.UserEntity;
import org.apache.catalina.User;

public interface UserService {
    BalanceResponseDto RetrieveUserBalance(BalanceResponseDto user);
    User getGameHistory(UserDto username);


}
