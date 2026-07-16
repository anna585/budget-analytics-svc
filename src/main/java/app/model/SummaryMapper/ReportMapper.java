package app.model.SummaryMapper;

import app.model.entities.Report;
import app.web.dto.ReportResponse;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ReportMapper {

    public static ReportResponse toDto(Report report){

        return ReportResponse.builder()
                .income(report.getIncome())
                .expenses(report.getExpenses())
                .balance(report.getBalance())
                .savingRate(report.getSavingRate())
                .largestExpense(String.valueOf(report.getLargestExpense()))
                .generatedAt(report.getGeneratedAt())
                .build();
    }
}
