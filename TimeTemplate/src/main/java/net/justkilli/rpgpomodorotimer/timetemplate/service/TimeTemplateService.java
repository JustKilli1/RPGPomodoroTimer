package net.justkilli.rpgpomodorotimer.timetemplate.service;

import net.justkilli.rpgpomodorotimer.timetemplate.entity.TimeTemplate;
import net.justkilli.rpgpomodorotimer.timetemplate.entity.UserTimeTemplate;
import net.justkilli.rpgpomodorotimer.timetemplate.repository.TimeTemplateRepository;
import net.justkilli.rpgpomodorotimer.timetemplate.repository.UserTimeTemplateRepository;
import net.justkilli.rpgpomodorotimer.timetemplate.request.TimeTemplateRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service responsible for creating and retrieving TimeTemplates.
 * */
@Service
public class TimeTemplateService {

    /**
     * Repository used to communicate with the corresponding TimeTemplate Database Table.
     * */
    @Autowired
    private TimeTemplateRepository timeTemplateRepository;

    @Autowired
    private UserTimeTemplateRepository userTimeTemplateRepository;

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

    /**
     * Creates a new TimeTemplate Object using the provided TimeTemplateRequest data
     * and saves it to the corresponding database table.
     *
     * This method uses the {@link #createTimeTemplate(TimeTemplateRequest)} method to create
     * the TimeTemplate instance before saving it.
     *
     * @param request the data of the new TimeTemplate
     */
    public void createAndSaveTimeTemplate(TimeTemplateRequest request) {
        TimeTemplate timeTemplate = createTimeTemplate(request);
        timeTemplateRepository.save(timeTemplate);
    }

    /**
     * Gets a TimeTemplate with the provided ID.
     * @param timeTemplateId The ID of the TimeTemplate.
     * @return An Optional with the found TimeTemplate, or an Empty Optional if no TimeTemplate with the provided ID was found.
     * */
    public Optional<TimeTemplate> getTimeTemplate(int timeTemplateId){
        return timeTemplateRepository.findById(timeTemplateId);
    }

    /**
     * Gets a UserTimeTemplate with the provided ID.
     * @param userTimeTemplateId The ID of the UserTimeTemplate.
     * @return An Optional with the found UserTimeTemplate, or an Empty Optional if no UserTimeTemplate with the provided ID was found.
     * */
    public Optional<UserTimeTemplate> getUserTimeTemplate(int userTimeTemplateId){
        return userTimeTemplateRepository.findById(userTimeTemplateId);
    }

    /**
     * Creates a TimeTemplate Object with the provided Data.
     * @param request The Request from which the data for the TimeTemplate should be retrieved.
     * @return A new TimeTemplate instance with the provided data.
     * */
    private TimeTemplate createTimeTemplate(TimeTemplateRequest request) {
        return new TimeTemplate(request.getWorkDuration(), request.getNormalPauseDuration(), request.getBigPauseDuration(), request.getWorkCycles());
    }
}
