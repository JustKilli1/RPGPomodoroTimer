package net.justkilli.rpgpomodorotimer.timetemplate.request;

import lombok.Data;

@Data
public class TimeTemplateRequest {

    private int workDuration, normalPauseDuration, bigPauseDuration, workCycles;
}
