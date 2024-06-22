package net.justkilli.timetemplate.repository;

import net.justkilli.timetemplate.entity.UserTimeTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTimeTemplateRepository extends JpaRepository<UserTimeTemplate, Integer> {
}
