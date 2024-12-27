package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import net.engineeringdigest.journalApp.repository.UserRepository;
import org.apache.catalina.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Save a journal entry
    public void saveEntry(User user) {
        User user =userService.findByUserName(username);
        journalEntry.setDate(LocalDateTime.now());
        journalEntry saved= journalEntryRepository.save(journalEntry);
        //user.getJournalEntries().add(saved);
        userService.saveEnrtu(user);

    }

    // Get all journal entries
    public List<User> getAll() {
        return userRepository.findAll();
    }

    // Find a journal entry by ID
    public Optional<User> findById(ObjectId id) {
        return userRepository.findById(id);
    }

    // Delete a journal entry by ID
    public boolean deleteEntryById(ObjectId id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            return true;
        }
        return false;
    }
  public User findByUserName(String userName){
        User user = userRepository.findByUsername(userName);
        user.getJournalEntries().removeIf(x -> x.getId().equals(id));
        userService.saveEntry(user);
        journalEntryRepository.deleteById(id);;
    }


}
