package com.slotgame.SlotGame.service.impl;

import com.slotgame.SlotGame.dto.BalanceResponseDto;
import com.slotgame.SlotGame.dto.GameHistoryDto;
import com.slotgame.SlotGame.dto.TopUpRequestDto;
import com.slotgame.SlotGame.dto.UserDto;
import com.slotgame.SlotGame.entity.GameHistoryEntity;
import com.slotgame.SlotGame.entity.UserEntity;
import com.slotgame.SlotGame.repository.GameHistoryRepository;
import com.slotgame.SlotGame.repository.GameRepository;
import com.slotgame.SlotGame.repository.UserRepository;
import com.slotgame.SlotGame.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameHistoryRepository gameHistoryRepository;

    @Override
    public BalanceResponseDto RetrieveUserBalance(BalanceResponseDto balanceResponseDto) {
        UserEntity user = userRepository.findByUsername(balanceResponseDto.getUsername())
                .orElseGet(() -> {
                    UserEntity newUser = new UserEntity();
                    newUser.setUsername(balanceResponseDto.getUsername());
                    userRepository.save(newUser);
                    return newUser;

                });
        System.out.println("Username is: " + user.getUsername());
        System.out.println("Balance is: " + user.getBalance());
        return balanceResponseDto;
    }

    @Override
    public TopUpRequestDto TopUpRequest(TopUpRequestDto topUpRequestDto) {
            UserEntity user = userRepository.findByUsername(topUpRequestDto.getUsername())
                    .orElseThrow(IllegalArgumentException::new);
            user.setBalance(user.getBalance().add(topUpRequestDto.getBalance()));
            userRepository.save(user);
            System.out.println("Username is: " + user.getUsername());
            System.out.println("New Balance after TopUp is: " + user.getBalance());

        return topUpRequestDto;
    }

    @Override
    public List<GameHistoryDto> gameHistory(GameHistoryDto gameHistoryDto) {
        List<GameHistoryDto> gameHistoryDtos = gameHistoryRepository.findGameHistoryEntitiesByUser_Username(gameHistoryDto.getUsername());

        return gameHistoryDtos.stream().map(gameHistoryDto1 -> new GameHistoryDto(
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
