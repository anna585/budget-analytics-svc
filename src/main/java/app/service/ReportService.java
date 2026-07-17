package app.service;

import app.model.mapper.ReportMapper;
import app.model.entities.CategoryType;
import app.model.entities.Report;
import app.repository.report.ReportRepository;
import app.web.dto.*;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ReportService {

    private final ReportRepository reportRepository;


    public ReportResponse postReport(ReportRequest reportRequest) {


        List<TransactionDto> transactions = reportRequest.getTransactions();

        BigDecimal income = calculateIncome(transactions);

        BigDecimal expenses = calculateExpenses(transactions);

        BigDecimal balance = calculateBalance(income, expenses);

        Map.Entry<CategoryType, BigDecimal> largest = findLargestCategory(reportRequest);

        String largestCategory =
                largest != null ? largest.getKey().name() : "NONE";

        BigDecimal savingRate = calculateSavingRate(balance, income);

        Report report = Report.builder()
                .userId(UUID.fromString(reportRequest.getUserId()))
                .start(reportRequest.getStart())
                .end(reportRequest.getEnd())
                .income(income)
                .expenses(expenses)
                .balance(balance)
                .largestExpense(CategoryType.valueOf(largestCategory))
                .savingRate(savingRate)
                .generatedAt(LocalDate.now())
                .build();

        reportRepository.save(report);

        return ReportMapper.toDto(report);

    }

    public SummaryResponse getSummary(List<TransactionDto> transactions) {


        BigDecimal incomeMonthly = calculateIncome(transactions);

        BigDecimal expenseMonthly = calculateExpenses(transactions);

        BigDecimal balanceMonthly = calculateBalance(incomeMonthly, expenseMonthly);

        BigDecimal savingMonthly = calculateSavingRate(balanceMonthly, incomeMonthly);


        return SummaryResponse.builder()
                .monthlyIncome(incomeMonthly)
                .monthlyExpense(expenseMonthly)
                .monthlyBalance(balanceMonthly)
                .monthlySavingRade(savingMonthly)
                .build();

    }


    private BigDecimal calculateSavingRate(BigDecimal balance, BigDecimal income) {

        if (income.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ZERO;
        }

        return balance
                .multiply(BigDecimal.valueOf(100))
                .divide(income, 2, RoundingMode.HALF_UP);

    }

    private Map.Entry<CategoryType, BigDecimal> findLargestCategory(ReportRequest reportRequest) {

        List<TransactionDto> transactions = reportRequest.getTransactions();

        Map<CategoryType, BigDecimal> totals = transactions
                .stream()
                .filter(t -> t.getType() == TransactionType.EXPENSE)
                .collect(Collectors.groupingBy(
                TransactionDto::getCategory,
                Collectors.reducing(
                        BigDecimal.ZERO,
                        TransactionDto::getAmount,
                        BigDecimal::add
                )
        ));


         return totals.entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElse(null);
    }

    private BigDecimal calculateBalance(BigDecimal income, BigDecimal expenses) {

        return income.subtract(expenses);
    }

    private BigDecimal calculateExpenses(List<TransactionDto> transactions) {

        return transactions
                .stream()
                .filter(t -> t.getType() == TransactionType.EXPENSE)
                .map(TransactionDto::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateIncome(List<TransactionDto> transactions) {

        return  transactions
                .stream()
                .filter(t -> t.getType() == TransactionType.INCOME)
                .map(TransactionDto::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }


}
