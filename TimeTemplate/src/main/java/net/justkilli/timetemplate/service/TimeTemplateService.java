package net.justkilli.timetemplate.service;

import net.justkilli.timetemplate.repository.TimeTemplateRepository;
import net.justkilli.timetemplate.request.TimeTemplateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service responsible for creating and retrieving TimeTemplates.
 * */
@Service
public class TimeTemplateService {

    /**
     * Repository used to communicate with the corresponding TimeTemplate Database Table.
     * */
    @Autowired
    private TimeTemplateRepository repository;

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
    public boolean isValidRequest(TimeTemplateRequest request) {
        if(request.getWorkDuration() <= 0) return false;
        if(request.getNormalPauseDuration() <= 0) return false;
        if(request.getBigPauseDuration() < 0) return false;
        return request.getWorkCycles() > 0;
    }



}
