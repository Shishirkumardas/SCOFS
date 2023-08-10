package com.example.scofs.service;

import com.example.scofs.Repository.ProfileRepository;
import com.example.scofs.model.Profile;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class ProfileService {

    ProfileRepository repository;



    public ProfileService(ProfileRepository repository) {
        this.repository = repository;

    }


    public Profile getByName(String name) {
        return repository.findByName(name).orElse(null);
    }


    public Profile getById(long instanceID) {
        return repository.findById(instanceID).orElse(null);
    }


    public List<Profile> getAll() {
        return getAll(false);
    }


    public Long saveObjectInstance(Map<String, Object> instanceMap) {
        return null;
    }


    @Transactional
    public List<Profile> getAll(boolean isDeleted){
        return repository.findAllByDeleted(isDeleted);
    }

    /**
     * Get an instance of Profile by ID or Name
     */
    public Profile getProfile(String profile) {
        try {
            long profileId = Long.parseLong(profile);
            return getById(profileId);
        } catch (NumberFormatException e) {
            return getByName(profile);
        }
    }

    /**
     * Service function to clear Profile cache.
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
     * Save Profile.
     */
    public Profile save(Profile instance) throws Exception {
        try {
            Profile savedProfile = repository.save(instance);
            //clearCache();
            return savedProfile;
        } catch (Exception e) {
            throw new Exception("Failed to insert/update Profile instance. " + e.getMessage());
        }
    }

    /**
     * Delete Profile.
     */
    public boolean delete(String instance) throws Exception {
        try {
            Profile instanceObject = getProfile(instance);
            if (instanceObject.getId() == 0) {
                throw new Exception("Cannot find entry.");
            }
            repository.delete(instanceObject);
            //clearCache();
            return true;
        } catch (Exception e) {
            throw new Exception("Failed to delete Profile instance. " + e.getMessage());
        }
    }

}

