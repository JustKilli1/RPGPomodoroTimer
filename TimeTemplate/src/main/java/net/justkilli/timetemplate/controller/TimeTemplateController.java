package net.justkilli.timetemplate.controller;

import jakarta.servlet.http.HttpServletRequest;
import net.justkilli.timetemplate.TimeTemplate;
import net.justkilli.timetemplate.repository.TimeTemplateRepository;
import net.justkilli.timetemplate.request.TimeTemplateRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
     * Responsible for communicating with the Database Table TimeTemplate.
     * */
    @Autowired
    private TimeTemplateRepository repository;

    /**
     * Responsible for creating a new TimeTemplate Entry in the Database.
     * @param request The {@link TimeTemplateRequest} Object that contains all relevant Data to create a new TimeTemplate Entry.
     * @return HttpStatus.BAD_REQUEST --> The request was invalid. See {@link TimeTemplateRequest#isValid(TimeTemplateRequest)} <br>
     *         HttpStatus.CREATED --> The Entry was successfully created.
     * */
    @PostMapping("/create_new")
    public ResponseEntity<Void> createNewTimeTemplate(@RequestBody TimeTemplateRequest request) {
        logger.info("Create new Time Template endpoint accessed by: {}", servletRequest.getRemoteAddr());
        if(! TimeTemplateRequest.isValid(request)) return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        TimeTemplate timeTemplate = new TimeTemplate(request.getWorkDuration(), request.getNormalPauseDuration(), request.getBigPauseDuration(), request.getWorkCycles());
        repository.save(timeTemplate);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
