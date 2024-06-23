package net.justkilli.rpgpomodorotimer.timetemplate.repository;

import net.justkilli.rpgpomodorotimer.timetemplate.entity.UserTimeTemplate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserTimeTemplateRepository extends JpaRepository<UserTimeTemplate, Integer> {
}
