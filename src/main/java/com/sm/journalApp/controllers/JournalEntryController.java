package com.sm.journalApp.controllers;
import com.sm.journalApp.entities.JournalEntry;
import com.sm.journalApp.services.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.*;


/*
✅ @RestController

1. ➡️ Combines @Controller + @ResponseBody

2. ➡️ Marks the class as a Spring MVC controller (handles HTTP requests).

3. ➡️ Returns data (JSON / XML) directly, not a view.

4. ➡️ Auto-registered as a Spring component (like @Component / @Service).

5. ➡️ Ideal for building REST APIs.
*/

@RestController()  // Component + Additional Functionality
@RequestMapping("/journal") // Add Mapping on Entire Class
public class JournalEntryController {
    @Autowired
    private JournalEntryService journalEntryService;
/*
1. Methods inside a controller class should be public
2. So that Spring Framework can detect and invoke them
3. Also allows external HTTP requests to trigger them
4. Non-public methods (like private or protected)
   will not be mapped to HTTP endpoints
*/

    @GetMapping("/get-all")
    public List<JournalEntry> getAll() {
        return journalEntryService.getAll();
    }


/*  1. @PathVariable binds URL path data (like /id/5) to method parameter
    2. Lets Spring extract values directly from the URL
    3. Used to make REST ful endpoints cleaner and meaningful
    @PathVariable Long myId
*/


    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myId){
        return journalEntryService.getById(myId).orElse(null);
    }

/*
    ✅ Here’s your statement converted into clear key points:

    Selecting "raw" and "JSON" in Postman means the request body will be JSON.

    This allows the server to parse & process JSON data correctly.

    Ensures the data is structured and follows JSON format conventions.

    Helps in accurate data transmission and reception between client & server.*//*


 */
/*
    ✅ About @RequestBody JournalEntry myEntry (not code):

    1. Tells Spring to take data from the HTTP request body (like JSON sent by Postman or frontend).

    2.Automatically converts that data into a Java object (JournalEntry).

    3. Means you don’t have to parse JSON manually.

    4. Lets you directly work with a fully populated Java object inside your method.

    5. Used mainly in POST, PUT APIs where data is sent in the body.
    */


    @PostMapping("/create-post")
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntry);
        return myEntry;
    }

    @DeleteMapping("id/{myId}")
    public boolean deleteJournalEntryById(@PathVariable ObjectId myId){
        journalEntryService.deleteById(myId);
        return true;
    }

    @PutMapping("id/{myId}")
    public JournalEntry updateJournalEntryById(
            @PathVariable ObjectId myId,
            @RequestBody JournalEntry newEntry){
        JournalEntry oldEntry = journalEntryService.getById(myId).orElse(null);
        if (oldEntry != null){
            oldEntry.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().isEmpty() ? newEntry.getTitle() : oldEntry.getTitle());
            oldEntry.setContent(newEntry.getContent() != null && !newEntry.getContent().isEmpty() ? newEntry.getContent() : oldEntry.getContent());
            journalEntryService.saveEntry(oldEntry); // persist the updated entity
        }
        return oldEntry;
    }
}


