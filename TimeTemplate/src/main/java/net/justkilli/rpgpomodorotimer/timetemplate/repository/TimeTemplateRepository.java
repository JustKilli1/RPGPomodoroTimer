package net.justkilli.rpgpomodorotimer.timetemplate.repository;

import net.justkilli.rpgpomodorotimer.timetemplate.entity.TimeTemplate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository responsible for communicating with the TimeTemplate Database table.
 * */
@Repository
public interface TimeTemplateRepository extends JpaRepository<TimeTemplate, Integer> {

}