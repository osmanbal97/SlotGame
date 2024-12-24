package com.slotgame.SlotGame.service.impl;
import com.slotgame.SlotGame.dto.GameListDto;
import com.slotgame.SlotGame.dto.PlayGameRequestDto;
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

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public GameHistoryRepository gameHistoryRepository;


    public List<GameListDto> getAllGames() {
        List<GameEntity> gameEntities = gameRepository.findAll();
        return gameEntities.stream()
                .map(game -> new GameListDto(
                        game.getGameName(),
                        game.getMinimumPlayAmount(),
                        game.getWinRate()
                ))
                .collect(Collectors.toList());
    }

    @Override
    public PlayGameRequestDto Playgame(PlayGameRequestDto playGameRequestDto) {
        UserEntity user = userRepository.findByUsername(playGameRequestDto.getUsername())
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı!"));

        GameEntity game = gameRepository.findById(playGameRequestDto.getGame_Id())
                .orElseThrow(() -> new RuntimeException("Oyun bulunamadı!"));

        boolean isBalanceSufficient = user.getBalance().compareTo(BigDecimal.valueOf(playGameRequestDto.getBetamount())) >= 0;

        if (!isBalanceSufficient) {
            throw new RuntimeException("Bakiye Yeterli Değil!");
        } else if (playGameRequestDto.getBetamount() < game.getMinimumPlayAmount().doubleValue()){
            throw new RuntimeException("Bet miktarı minimum oynama miktarından düşük!");
        }else{

            boolean winner = isWinner(game.getWinRate().doubleValue());
            BigDecimal oldbalance = user.getBalance();
            double winAmount = winner ? CalculateWinAmount(playGameRequestDto.getBetamount(), game.getWinRate()) : 0.0;
            BigDecimal newBalance = winner ? user.getBalance().add(BigDecimal.valueOf(winAmount)) : user.getBalance().subtract(BigDecimal.valueOf(playGameRequestDto.getBetamount()));

            user.setBalance(newBalance);
            userRepository.save(user);

            saveGameHistory(user, game, LocalDateTime.now(),
                    playGameRequestDto.getBetamount(), winAmount, newBalance);


            PlayGameRequestDto response = new PlayGameRequestDto();
            String status = winner ? "Kazandınız!" : "Kaybettiniz!";
            response.setMessage(status);
            response.setUsername(user.getUsername());
            response.setGame_name(game.getGameName());
            response.setBetamount(playGameRequestDto.getBetamount());
            response.setWin_amount_result(winAmount);
            response.setFinalbalance(newBalance.doubleValue());

            return response;
        }

    }

    @Override
    public double CalculateWinAmount(double betamount, BigDecimal winrate) {
        if (betamount <0 || winrate.doubleValue() <=0 ) {
            throw new InputMismatchException("Veriler 0'dan büyük olmalıdır");
        }
        return betamount * (1 /winrate.doubleValue());
    }

    @Override
    public void saveGameHistory(UserEntity user, GameEntity game, LocalDateTime playDate, double betAmount, double winAmount, BigDecimal currentBalance) {

            GameHistoryEntity gameHistory = new GameHistoryEntity();
            gameHistory.setUser(user);
            gameHistory.setGame(game);
            gameHistory.setPlayDate(playDate);
            gameHistory.setBetamount(BigDecimal.valueOf(betAmount));
            gameHistory.setWinamount(BigDecimal.valueOf(winAmount));
            gameHistory.setCurrentbalance(currentBalance);
            gameHistoryRepository.save(gameHistory);
    }

    @Override
    public boolean isWinner(double winRate) {

        double randomValue = Math.random();
        return randomValue < winRate;
    }

}



