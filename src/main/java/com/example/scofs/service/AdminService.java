package com.example.scofs.service;


import com.example.scofs.Repository.AdminRepository;
import com.example.scofs.model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class AdminService {



    private final AdminRepository repository;

    @Autowired
    public AdminService(AdminRepository repository) {
        this.repository = repository;
    }


    public Admin getByName(String name) {
        return repository.findByName(name).orElse(null);
    }


    public Admin getById(long instanceID) {
        return repository.findById(instanceID).orElse(null);
    }


    public List<Admin> getAll() {
        return getAll(false);
    }


    public Long saveObjectInstance(Map<String, Object> instanceMap) {
        return null;
    }


    @Transactional
    public List<Admin> getAll(boolean isDeleted){
        return repository.findAllByDeleted(isDeleted);
    }

    /**
     * Get an instance of Admin by ID or Name
     */
    public Admin getAdmin(String event) {
        try {
            long eventId = Long.parseLong(event);
            return getById(eventId);
        } catch (NumberFormatException e) {
            return getByName(event);
        }
    }

    /**
     * Service function to clear Admin cache.
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
     * Save Admin.
     */
    public Admin save(Admin instance) throws Exception {
        try {
            Admin savedAdmin = repository.save(instance);
            //clearCache();
            return savedAdmin;
        } catch (Exception e) {
            throw new Exception("Failed to insert/update Admin instance. " + e.getMessage());
        }
    }

    /**
     * Delete Admin.
     */
    public boolean delete(String instance) throws Exception {
        try {
            Admin instanceObject = getAdmin(instance);
            if (instanceObject.getId() == 0) {
                throw new Exception("Cannot find entry.");
            }
            repository.delete(instanceObject);
            //clearCache();
            return true;
        } catch (Exception e) {
            throw new Exception("Failed to delete Admin instance. " + e.getMessage());
        }
    }

}

