package app.exception.statistic;

import app.exception.ApiException;
import org.springframework.http.HttpStatus;

public class StatisticException extends ApiException {

    public StatisticException() {
        super(
                "User list cannot be null."
        );
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
