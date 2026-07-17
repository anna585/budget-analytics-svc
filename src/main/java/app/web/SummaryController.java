package app.web;

import app.service.ReportService;
import app.web.dto.SummaryResponse;
import app.web.dto.TransactionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/analytics/summary")
@RequiredArgsConstructor
public class SummaryController {

    private final ReportService reportService;

    @PostMapping
    SummaryResponse generateSummary(@RequestBody List<TransactionDto> transactions){

       return reportService.getSummary(transactions);

    }
}
