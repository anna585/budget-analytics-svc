package app.repository;

import app.model.entities.CategoryReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryReportRepository extends JpaRepository<CategoryReport, UUID> {
}
