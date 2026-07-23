package app.exception.report;

import app.exception.ApiException;
import org.springframework.http.HttpStatus;

public class ReportNotFoundException extends ApiException {


    public ReportNotFoundException() {
        super(
                "Report Not Found."
        );
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
