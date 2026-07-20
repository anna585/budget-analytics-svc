package app.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatisticResponse {

    private long totalUsers;
    private long totalTransactions;
    private long totalBudget;
    private long totalSavings;
}
