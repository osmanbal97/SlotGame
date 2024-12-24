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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Override
    public BalanceResponseDto RetrieveUserBalance(String username) {
        UserEntity user = userRepository.findByUsername(username)
                .orElseThrow(() -> new NoSuchElementException("Kullanıcı Bulunamadı!"));
        System.out.println("Username is: " + user.getUsername());
        System.out.println("Balance is: " + user.getBalance());
        return new  BalanceResponseDto(user.getUsername(), user.getBalance());
    }

    @Override
    public TopUpRequestDto TopUpRequest(String username, double amount) {
            UserEntity user = userRepository.findByUsername(username)
                    .orElseThrow(() -> new NoSuchElementException("Kullanıcı Bulunamadı!"));
            if (amount < 0){
                throw new IllegalArgumentException("Yüklenecek miktar negatif olamaz!");
            }else {
                System.out.println("Yükleme öncesi bakiye: " + user.getBalance());
                BigDecimal newBalance = user.getBalance().add(BigDecimal.valueOf(amount));
                user.setBalance(newBalance);
                userRepository.save(user);
                System.out.println("Kullanıcı adı: " + user.getUsername());
                System.out.println("Yükleme sonrası bakiye: " + user.getBalance());
                System.out.println("Yüklenen miktar: " + amount);
                TopUpRequestDto topupuser = new TopUpRequestDto(user.getId(), user.getUsername(), amount, user.getBalance());
                return topupuser;
            }

    }

}
