package app.model.entities.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class SummaryDto {

    private BigDecimal income;
    private BigDecimal expenses;
    private BigDecimal balance;
    private BigDecimal savingRate;
}
