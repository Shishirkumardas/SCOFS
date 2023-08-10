package com.example.scofs.Repository;

import com.example.scofs.model.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface EventRepository extends CrudRepository<Event, Long> {

    List<Event> findAllByDeleted(boolean deleted);
    Optional<Event> findByName(String name);
}
