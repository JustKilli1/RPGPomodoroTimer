package net.justkilli.rpgpomodorotimer.timetemplate.controller;

import jakarta.servlet.http.HttpServletRequest;
import net.justkilli.rpgpomodorotimer.timetemplate.entity.UserTimeTemplate;
import net.justkilli.rpgpomodorotimer.timetemplate.request.TimeTemplateRequest;

import net.justkilli.rpgpomodorotimer.timetemplate.service.TimeTemplateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Controller for Creating and Getting TimeTemplates.
 * */
@RestController
@RequestMapping("/api/time_template")
public class TimeTemplateController {

    /**
     * The Logger that's used for this class.
     * */
    private static final Logger logger = LoggerFactory.getLogger(TimeTemplateController.class);

    /**
     * Provides some Information about the Http Request servlet.
     * */
    @Autowired
    private HttpServletRequest servletRequest;

    /**
     * Responsible for creating and retrieving TimeTemplates.
     * */
    @Autowired
    private TimeTemplateService timeTemplateService;

    /**
     * Responsible for creating a new TimeTemplate Entry in the Database.
     * @param request The {@link TimeTemplateRequest} Object that contains all relevant Data to create a new TimeTemplate Entry.
     * @return {@link HttpStatus#BAD_REQUEST} --> The request was invalid. See {@link TimeTemplateService#isValidRequest(TimeTemplateRequest)}<br>
     *         {@link HttpStatus#CREATED} --> The Entry was successfully created.
     * */
    @PostMapping("/create_new")
    public ResponseEntity<Void> createNewTimeTemplate(@RequestBody TimeTemplateRequest request) {
        logger.info("Create new TimeTemplate endpoint accessed by: {}", servletRequest.getRemoteAddr());
        if(!timeTemplateService.isValidRequest(request)) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        timeTemplateService.createAndSaveTimeTemplate(request);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * Gets a UserTimeTemplate with its ID.
     * @param userTimeTemplateId The ID of the UserTimeTemplate.
     * @return A Response Entity that contains the UserTimeTemplate Object which was found or null if no UserTimeTemplate with the provided ID was found.<br>
     *        {@link HttpStatus#NOT_FOUND} --> No Template with the provided ID was found.
     *        {@link HttpStatus#FOUND} --> The Template with the provided ID was found.
     * */
    @GetMapping("/retrieve/{userTimeTemplateId}")
    public ResponseEntity<UserTimeTemplate> getUserTimeTemplate(@PathVariable int userTimeTemplateId) {
        logger.info("Get UserTimeTemplate endpoint accessed by: {}", servletRequest.getRemoteAddr());

        Optional<UserTimeTemplate> result = timeTemplateService.getUserTimeTemplate(userTimeTemplateId);

        return result.isEmpty() ? new ResponseEntity<>(null, HttpStatus.NOT_FOUND) : new ResponseEntity<>(result.get(), HttpStatus.FOUND);
    }
}
