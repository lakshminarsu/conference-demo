package com.conference.demo.services;

import com.conference.demo.models.Session;
import com.conference.demo.repositroies.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;

    public List<Session> getAllSessions() {
        return sessionRepository.findAll();
    }

    public Session getSession(Long id) {
        Optional<Session> session = sessionRepository.findById(id);
        if (session.isPresent()) {
            return session.get();
        }
        return null;
    }

    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }

    public Session updateSession(Long id, Session session) {
       Session existingSession = sessionRepository.findById(id).get();
        BeanUtils.copyProperties(session, existingSession, "id");
        return sessionRepository.saveAndFlush(existingSession);
    }

    public Session createSession(Session session) {
        return sessionRepository.saveAndFlush(session);
    }
}
