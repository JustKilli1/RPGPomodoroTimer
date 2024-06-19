package net.justkilli.timetemplate.repository;

import net.justkilli.timetemplate.TimeTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository responsible for communicating with the TimeTemplate Database table.
 * */
@Repository
public interface TimeTemplateRepository extends JpaRepository<TimeTemplate, Integer> {

}