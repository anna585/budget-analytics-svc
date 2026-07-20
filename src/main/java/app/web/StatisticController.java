package app.web;

import app.service.StatisticService;
import app.web.dto.StatisticResponse;
import app.web.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StatisticController {

    private final StatisticService statisticService;

    @PostMapping("/api/v1/analytics/statistic")
    public ResponseEntity<StatisticResponse> postStatisticForAllUsers(
            @RequestBody List<UserDto> userList){

        StatisticResponse statisticResponses = statisticService.getTotalStatistic(userList);

        return ResponseEntity.ok(statisticResponses);
    }
}
