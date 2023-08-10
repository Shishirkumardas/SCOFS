package com.example.scofs.service;

import com.example.scofs.Repository.EventRepository;
import com.example.scofs.model.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

public class EventService {

    EventRepository repository;
    private CacheService cacheService;


    public EventService(EventRepository repository, CacheService cacheService) {
        this.repository = repository;
        this.cacheService=cacheService;
    }


    public Event getByName(String name) {
        return repository.findByName(name).orElse(null);
    }


    public Event getById(long instanceID) {
        return repository.findById(instanceID).orElse(null);
    }


    public List<Event> getAll() {
        return getAll(false);
    }


    public Long saveObjectInstance(Map<String, Object> instanceMap) {
        return null;
    }


    @Transactional
    public List<Event> getAll(boolean isDeleted){
        return repository.findAllByDeleted(isDeleted);
    }

    /**
     * Get an instance of Event by ID or Name
     */
    public Event getEvent(String event) {
        try {
            long eventId = Long.parseLong(event);
            return getById(eventId);
        } catch (NumberFormatException e) {
            return getByName(event);
        }
    }

    /**
     * Service function to clear Event cache.
     */
//    public boolean clearCache() {
//        try {
//            cacheService.evictCachedByClassName(this.getClass().getName());
//            return true;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return false;
//        }
//    }

    /**
     * Save Event.
     */
    public Event save(Event instance) throws Exception {
        try {
            Event savedEvent = repository.save(instance);
           //clearCache();
            return savedEvent;
        } catch (Exception e) {
            throw new Exception("Failed to insert/update Event instance. " + e.getMessage());
        }
    }

    /**
     * Delete Event.
     */
    public boolean delete(String instance) throws Exception {
        try {
            Event instanceObject = getEvent(instance);
            if (instanceObject.getId() == 0) {
                throw new Exception("Cannot find entry.");
            }
            repository.delete(instanceObject);
            //clearCache();
            return true;
        } catch (Exception e) {
            throw new Exception("Failed to delete Event instance. " + e.getMessage());
        }
    }

}
