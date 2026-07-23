package app.exception.report;

import app.exception.ApiException;
import org.springframework.http.HttpStatus;

public class NoTransactionsForReportException extends ApiException {


    public NoTransactionsForReportException() {

        super(
                "Cannot create report without transactions"
        );
    }

    @Override
    public HttpStatus getHttpStatus() {
        return HttpStatus.BAD_REQUEST;
    }
}
