package app.web.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@Builder
public class UserDto {

    private UUID id;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private List<TransactionDto> transactions;
    private List<BudgetDto> budgets;
    private List<SavingGoalsDto> saving;
}
