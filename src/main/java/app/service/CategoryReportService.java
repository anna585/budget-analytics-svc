package app.service;

import app.repository.CategoryReportRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryReportService {

    private final CategoryReportRepository categoryReportRepository;


}
