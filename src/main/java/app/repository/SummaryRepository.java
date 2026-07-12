package app.repository;

import app.model.entities.Summary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, UUID> {
}
