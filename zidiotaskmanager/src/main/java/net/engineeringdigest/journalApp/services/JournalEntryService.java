package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.entity.JournalEntry;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.apache.catalina.User;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    // Save a journal entry
    public void saveEntry(JournalEntry journalEntry ,String username) {
        User user =userService.findByUserName(username);
        journalEntry.setDate(LocalDateTime.now());
        journalEntry saved= journalEntryRepository.save(journalEntry);
        //user.getJournalEntries().add(saved);
        userService.saveEnrtu(user);
    }
   @Transactional
   public void saveEntry(JournalEntry journalEntry ) {
        User user =userService.findByUserName(username);
        journalEntry.setDate(LocalDateTime.now());
        journalEntry saved= journalEntryRepository.save(journalEntry);
        user.setUsername(null);
        // user.getJournalEntries().add(saved);
        userService.saveEntry(user);

    }

    // Get all journal entries
    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll();
    }

    // Find a journal entry by ID
    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }

    // Delete a journal entry by ID
    public boolean deleteEntryById(ObjectId id) {
        if (journalEntryRepository.existsById(id)) {
            journalEntryRepository.deleteById(id);
            return true;
        }
        return false;
    }

    // Update a journal entry by ID
    public Optional<JournalEntry> updateEntryById(ObjectId id, JournalEntry journalEntry) {
        if (journalEntryRepository.existsById(id)) {
            journalEntry.setId(id);  // Ensure the ID is set on the entry to update it
            return Optional.of(journalEntryRepository.save(journalEntry));
        }
        return Optional.empty();
    }
}
