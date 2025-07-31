//package com.sm.journalApp.controllers;
//
//import com.sm.journalApp.entities.JournalEntry;
//import com.sm.journalApp.entities.User;
//import com.sm.journalApp.services.JournalEntryService;
//import com.sm.journalApp.services.UserService;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//import java.util.List;
//import java.util.Optional;
//
//@RestController()  // Component + Additional Functionality
//@RequestMapping("/journal") // Add Mapping on Entire Class
//public class JournalEntryControllerV3 {
//    @Autowired
//    private JournalEntryService journalEntryService;
//
//    @Autowired
//    private UserService userService;
//
//    @GetMapping("/get-all/{userName}")
//    public ResponseEntity<?> getAllJournalEntriesOfUser(@PathVariable String userName) {
//        User user = userService.findByUserName(userName);
//        List<JournalEntry> all = user.getJournalEntries();
//        if (all != null && !all.isEmpty()){
//            return new ResponseEntity<>(all,HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
//
//
//
//    @GetMapping("id/{myId}")
//    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable ObjectId myId){
//        Optional<JournalEntry> journalEntry = journalEntryService.getById(myId);
//        return journalEntry.map(entry ->
//                new ResponseEntity<>(entry, HttpStatus.OK)).orElseGet(() ->
//                new ResponseEntity<>(HttpStatus.NOT_FOUND));
//    }
//
//    @PostMapping("/create-post/{userName}")
//    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry, @PathVariable String userName){
//        try {
//            myEntry.setDate(LocalDateTime.now());
//            journalEntryService.saveEntry(myEntry,userName);
//            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//    }
//    /*    @PostMapping("/create-post")
//    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
//        myEntry.setDate(LocalDateTime.now());
//        journalEntryService.saveEntry(myEntry);
//        return myEntry;
//    }*/
//
//
////    @DeleteMapping("id/{myId}")
////    public ResponseEntity<?> deleteJournalEntryById(@PathVariable ObjectId myId){
/////*        journalEntryService.deleteById(myId);
////        return new ResponseEntity<>(HttpStatus.NO_CONTENT);*/
////        if (journalEntryService.getById(myId).isPresent()) {
////            journalEntryService.deleteById(myId);
////            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
////        } else {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        }
////    }
//    @DeleteMapping("id/{userName}/{myId}")
//    public  ResponseEntity<?>  deleteJournalEntryById(@PathVariable ObjectId myId, @PathVariable String userName){
//        journalEntryService.deleteById(myId,userName);
//        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//    }
//
///*    @PutMapping("id/{myId}")
//    public JournalEntry updateJournalEntryById(
//            @PathVariable ObjectId myId,
//            @RequestBody JournalEntry newEntry){
//        JournalEntry oldEntry = journalEntryService.getById(myId).orElse(null);
//        if (oldEntry != null){
//            oldEntry.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().isEmpty() ? newEntry.getTitle() : oldEntry.getTitle());
//            oldEntry.setContent(newEntry.getContent() != null && !newEntry.getContent().isEmpty() ? newEntry.getContent() : oldEntry.getContent());
//            journalEntryService.saveEntry(oldEntry); // persist the updated entity
//        }
//        return oldEntry;
//    }*/
//
//
//    @PutMapping("id/{userName}/{myId}")
//    public ResponseEntity<JournalEntry> updateJournalEntryById(
//            @PathVariable ObjectId myId,
//            @RequestBody JournalEntry newEntry,
//            @PathVariable String userName){
//        JournalEntry oldEntry = journalEntryService.getById(myId).orElse(null);
//        if (oldEntry != null){
////            oldEntry.setTitle(newEntry.getTitle() != null && !newEntry.getTitle().isEmpty() ? newEntry.getTitle() : oldEntry.getTitle());
//            oldEntry.setTitle(!newEntry.getTitle().isEmpty() ? newEntry.getTitle() : oldEntry.getTitle());
//            oldEntry.setContent(newEntry.getContent() != null && !newEntry.getContent().isEmpty() ? newEntry.getContent() : oldEntry.getContent());
//            journalEntryService.saveEntry(oldEntry); // persist the updated entity
//            return  new ResponseEntity<>(oldEntry, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        //
//    }
//}
//
//
