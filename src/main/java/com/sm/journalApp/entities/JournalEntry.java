package com.sm.journalApp.entities;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.sql.Date;


/*
✅ POJO stands for: Plain Old Java Object
1. ➡️ Simple Java class
2. ➡️ Has private fields
3. ➡️ Provides public getters/setters
4. ➡️ No special restrictions (don’t extend framework classes, no heavy annotations)
5. ➡️ Mainly used to hold data
*/
//@Setter
//@Getter
@Data // @Setter + @Setter + toString more
// @Document // MongoDB document for journal entries with id, title, content fields
@Document(collection = "journal_Entries")
public class JournalEntry {
    @Id // Map => Primary Key
       // marks this field as the primary key (unique identifier) in MongoDB
    private String id;
    private String title;
    private String content;
    private Date date;
/*
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
 */
}
