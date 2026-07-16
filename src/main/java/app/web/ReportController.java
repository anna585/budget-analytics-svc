package app.web;

import app.service.ReportService;
import app.web.dto.ReportRequest;
import app.web.dto.ReportResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/api/v1/analytics/report")
    public ReportResponse generateReport(
            @RequestBody ReportRequest reportRequest){

      return reportService.postReport(reportRequest);
    }

}
