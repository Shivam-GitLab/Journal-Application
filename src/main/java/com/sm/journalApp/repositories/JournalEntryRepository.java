package com.sm.journalApp.repositories;

import com.sm.journalApp.entities.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository // Optional, but a good practice
public interface JournalEntryRepository extends MongoRepository<JournalEntry, String> {
}