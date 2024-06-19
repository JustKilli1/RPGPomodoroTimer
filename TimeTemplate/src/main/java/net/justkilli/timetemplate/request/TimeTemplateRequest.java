package net.justkilli.timetemplate.request;

import lombok.Data;

@Data
public class TimeTemplateRequest {

    private int workDuration, normalPauseDuration, bigPauseDuration, workCycles;

    /**
     * Checks if the provided Request is valid.
     * <ul>
     *     A Request is considered valid if the following characteristics are meet:
     *     <li>The WorkDuration is greater than 0.</li>
     *     <li>The NormalPauseDuration is greater than 0.</li>
     *     <li>The BigPauseDuration is greater or equal to 0.</li>
     *     <li>The WorkCycles are greater than 0.</li>
     * </ul>
     * @param request The request that should be checked.
     * @return true --> The provided Request is valid. <br>
     *         false --> The provided Request is invalid.
     * */
    public static boolean isValid(TimeTemplateRequest request) {
        if(request.workDuration <= 0) return false;
        if(request.normalPauseDuration <= 0) return false;
        if(request.bigPauseDuration < 0) return false;
        if(request.workCycles <= 0) return false;
        return true;
    }

}
