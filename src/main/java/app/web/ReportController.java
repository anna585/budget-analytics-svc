package app.web;

import app.service.ReportService;
import app.web.dto.ReportRequest;
import app.web.dto.ReportResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @PostMapping("/api/v1/analytics/report")
    public ReportResponse generateReport(
            @RequestBody ReportRequest reportRequest){

      return reportService.postReport(reportRequest);
    }

    @GetMapping("/api/v1/analystics/report-history")
    public ResponseEntity<List<ReportResponse>> getHistory(
            @RequestParam String userId) {

        List<ReportResponse> responseList = reportService.getReportHistory(userId);
        return ResponseEntity.ok(responseList);
    }

    @DeleteMapping("/api/v1/analytics/report-history/{reportId}")
    public ResponseEntity<Void> deleteReport(
            @PathVariable String reportId){

        reportService.deleteReport(reportId);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }


}
