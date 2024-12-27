package net.engineeringdigest.journalApp.entity;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection="users")
@Getter
@Setter
@Data
@NoArgsConstructor
public class User {

 @Id
    private ObjectId id;
 @Indexed(unique = true)//for unique value

    private String username;

    private String password;
@DBRef //foreign key
private List<JournalEntry> journalEntries= new ArrayList<>();


}
