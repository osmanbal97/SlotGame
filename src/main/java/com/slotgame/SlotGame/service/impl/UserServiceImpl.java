package com.slotgame.SlotGame.service.impl;

import com.slotgame.SlotGame.dto.BalanceResponseDto;
import com.slotgame.SlotGame.dto.UserDto;
import com.slotgame.SlotGame.entity.UserEntity;
import com.slotgame.SlotGame.repository.UserRepository;
import com.slotgame.SlotGame.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public BalanceResponseDto RetrieveUserBalance(BalanceResponseDto balanceResponseDto) {
        UserEntity user = userRepository.findByUsername(balanceResponseDto.getUsername())
                .orElseGet(() -> {
                    UserEntity newUser = new UserEntity();
                    newUser.setUsername(balanceResponseDto.getUsername());
                    userRepository.save(newUser);
                    return newUser;

                });
        System.out.println("Username is: " + balanceResponseDto.getBalance());
        System.out.println("Balance is: " + balanceResponseDto.getBalance());
        return balanceResponseDto;
    }

    @Override
    public User getGameHistory(UserDto username) {
        return null;
    }


}
