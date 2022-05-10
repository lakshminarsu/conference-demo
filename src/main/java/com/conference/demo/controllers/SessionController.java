package com.conference.demo.controllers;

import com.conference.demo.models.Session;
import com.conference.demo.services.SessionService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("sessions")
public class SessionController {
    @Autowired
    private SessionService sessionService;

    @GetMapping
    public List<Session> list() {
        return sessionService.getAllSessions();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session getSession(@PathVariable Long id) {
        return sessionService.getSession(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        sessionService.deleteSession(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        return sessionService.updateSession(id, session);
    }

    @PostMapping
    public Session create(@RequestBody Session session) {
        return sessionService.createSession(session);
    }
}
