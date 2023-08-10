package com.example.scofs.Repository;

import com.example.scofs.model.Admin;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface AdminRepository extends CrudRepository<Admin, Long> {
    List<Admin> findAllByDeleted(boolean deleted);
    Optional<Admin> findByName(String name);
}
