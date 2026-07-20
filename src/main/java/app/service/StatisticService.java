package app.service;

import app.web.dto.StatisticResponse;
import app.web.dto.UserDto;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Transactional
public class StatisticService {
    public StatisticResponse getTotalStatistic(List<UserDto> userList) {

        long totalUsers = calculateTotalUsers(userList);

        long totalBudgets = calculateTotalBudgets(userList);

        long totalTransactions = calculateTotalTransactions(userList);

        long totalSavingGoals = calculateTotalSavingGoals(userList);

        return StatisticResponse.builder()
                .totalUsers(totalUsers)
                .totalBudget(totalBudgets)
                .totalTransactions(totalTransactions)
                .totalSavings(totalSavingGoals)
                .build();

    }

    private long calculateTotalSavingGoals(List<UserDto> userList) {

        return userList.stream()
                .mapToLong(user -> user.getSaving().size())
                .sum();
    }

    private long calculateTotalTransactions(List<UserDto> userList) {

        return userList.stream()
                .mapToLong(user -> user.getTransactions().size())
                .sum();
    }

    private long calculateTotalBudgets(List<UserDto> userList) {

        return userList.stream()
                .mapToLong(user -> user.getBudgets().size())
                .sum();
    }

    private long calculateTotalUsers(List<UserDto> userList) {

        return userList.size();

    }
}
