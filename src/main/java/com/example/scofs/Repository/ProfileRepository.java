package com.example.scofs.Repository;

import com.example.scofs.model.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProfileRepository extends CrudRepository<Profile, Long> {
    List<Profile> findAllByDeleted(boolean deleted);
    Optional<Profile> findByName(String name);
}

