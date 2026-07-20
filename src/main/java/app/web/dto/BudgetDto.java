package app.web.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Month;
import java.util.UUID;


@Data
@Builder
public class BudgetDto {

    private UUID id;
    private BigDecimal monthlyLimit;
    private Month month;
    private int year;
}
