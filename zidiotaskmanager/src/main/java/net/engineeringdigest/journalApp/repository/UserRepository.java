package net.engineeringdigest.journalApp.repository;

import org.apache.catalina.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, ObjectId> {
  User findByUsername(String username);
}

