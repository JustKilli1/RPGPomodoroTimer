package net.justkilli.timetemplate.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Database Table Representation of an UserTimeTemplate.
 * */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserTimeTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userTimeTemplateId;

    private Long userId;

    @ManyToOne
    @JoinColumn(name = "time_template_id")
    private TimeTemplate timeTemplate;

    private String timeTemplateName;
}
