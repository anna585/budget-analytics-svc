package app.web.dto;


import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class ReportResponse {

    private BigDecimal income;
    private BigDecimal expenses;
    private BigDecimal balance;
    private String largestExpense;
    private BigDecimal savingRate;
    private LocalDate generatedAt;
}
