package com.sm.journalApp.services;
//Controller -> Service -> Repository -> Database
import com.sm.journalApp.entities.JournalEntry;
import com.sm.journalApp.repositories.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class JournalEntryService {
 /*
    Field declaration:
private JournalEntryRepository journalEntryRepository;
➔ means this class needs a repository to work.

Dependency Injection (DI):
Spring automatically injects an instance here (via @Autowired or constructor injection).

No new needed:
You never do new JournalEntryRepository() — Spring provides it.

Spring Data creates implementation at runtime:
➔ When your app starts, Spring Boot generates a proxy class that implements your JournalEntryRepository interface.
➔ Handles all database calls for you (like findAll(), save()).

Managed by IoC container:
➔ Spring manages lifecycle, scope, and injections.
 */
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    public void saveJournalEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }
}


