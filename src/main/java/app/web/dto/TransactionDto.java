package app.web.dto;

import app.model.entities.CategoryType;
import lombok.Builder;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@Builder
public class TransactionDto {

    private BigDecimal amount;
    private TransactionType type;
    private CategoryType category;
    private LocalDate date;

}
