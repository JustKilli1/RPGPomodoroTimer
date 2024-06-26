package net.justkilli.rpgpomodorotimer.timetemplate.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Database Table Representation of an TimeTemplate.
 * */
@Entity
@NoArgsConstructor
@Getter
public class TimeTemplate {

    /**
     * The unique ID of this Object.
     * */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timeTemplateId;

    /**
     * The Duration of a Work cycle.
     * */
    private int workDuration;

    /**
     * The Duration of a Normal Pause.
     * */
    private int normalPauseDuration;

    /**
     * The Duration of a Big Pause.
     * */
    private int bigPauseDuration;

    /**
     * How much work / normal pause Cycles there should be before a Big Pause.
     * */
    private int workCycles;

    /**
     * Constructor with all Field except the TimeTemplateId field.
     * Should be used when creating a new TimeTemplate Entry in the Database.
     * */
    public TimeTemplate(int workDuration, int normalPauseDuration, int bigPauseDuration, int workCycles) {
        this.workDuration = workDuration;
        this.normalPauseDuration = normalPauseDuration;
        this.bigPauseDuration = bigPauseDuration;
        this.workCycles = workCycles;
    }
}

