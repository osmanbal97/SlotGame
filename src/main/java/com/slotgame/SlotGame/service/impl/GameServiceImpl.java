package com.slotgame.SlotGame.service.impl;


import com.slotgame.SlotGame.dto.GameListDto;
import com.slotgame.SlotGame.dto.PlayGameRequest;
import com.slotgame.SlotGame.entity.GameEntity;
import com.slotgame.SlotGame.entity.GameHistoryEntity;
import com.slotgame.SlotGame.entity.UserEntity;
import com.slotgame.SlotGame.repository.GameHistoryRepository;
import com.slotgame.SlotGame.repository.GameRepository;
import com.slotgame.SlotGame.repository.UserRepository;
import com.slotgame.SlotGame.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameRepository gameRepository;

    private GameEntity gameEntity;

    private UserEntity userEntity;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GameHistoryRepository gameHistoryRepository;



    public List<GameListDto> getAllGames() {
        List<GameEntity> gameEntities = gameRepository.findAll(); // Tüm oyunları al
        return gameEntities.stream()
                .map(game -> new GameListDto(
                        game.getGameId(),
                        game.getGameName(),
                        game.getMinimumPlayAmount(),
                        game.getWinRate()
                ))
                .collect(Collectors.toList()); // Listeyi dön
    }

    @Override
    public void Playgame(PlayGameRequest playGameRequest) {
        UserEntity user = userRepository.findByUsername(playGameRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));


        GameEntity game = gameRepository.findById(playGameRequest.getGame_Id())
                .orElseThrow(() -> new RuntimeException("Oyun bulunamadı"));

        boolean winner = isWinner(game.getWinRate().doubleValue());

        if (winner) {
            double winamount = CalculateWinAmount(playGameRequest.getBetamount(), game.getWinRate());

            GameHistoryEntity gameHistory = new GameHistoryEntity();
            gameHistory.setUser(user);
            gameHistory.setGame(game);
            gameHistory.setPlayDate(LocalDateTime.now());
            gameHistory.setWinamount(BigDecimal.valueOf(winamount));
            gameHistoryRepository.save(gameHistory);

            BigDecimal newbalance = user.getBalance().add(BigDecimal.valueOf(winamount));
            user.setBalance(newbalance);
            userRepository.save(user);

            System.out.println("Tebrikler Kazandınız!");
            System.out.println("Kullanıcı: " + user.getUsername());
            System.out.println("Yeni bakiye: " + user.getBalance());
            System.out.println("Kazanma ihtimali: " + game.getWinRate());
        }else{
            GameHistoryEntity gameHistory = new GameHistoryEntity();
            gameHistory.setUser(user);
            gameHistory.setGame(game);
            gameHistory.setPlayDate(LocalDateTime.now());
            gameHistory.setWinamount(BigDecimal.valueOf(0.0));
            gameHistoryRepository.save(gameHistory);

            BigDecimal newbalance = user.getBalance().subtract(BigDecimal.valueOf(playGameRequest.getBetamount()));
            user.setBalance(newbalance);
            userRepository.save(user);

            System.out.println("Tekrar Deneyin!");
            System.out.println("Kullanıcı: " + user.getUsername());
            System.out.println("Yeni bakiye: " + user.getBalance());
            System.out.println("Kazanma ihtimali: " + game.getWinRate());


        }

    }

    public double CalculateWinAmount(double betamount, BigDecimal winrate) {

        if (betamount <0 || winrate.doubleValue() <=0 ) {
            throw new InputMismatchException("Veriler 0'dan büyük olmalıdır");
        }
            return betamount * (1 /winrate.doubleValue());

    }
    public boolean isWinner(double winRate) {

        double randomValue = Math.random();
        return randomValue < winRate;
    }

}
