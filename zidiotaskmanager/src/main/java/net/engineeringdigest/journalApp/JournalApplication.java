package net.engineeringdigest.journalApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement //search for Transaction annotation
public class   JournalApplication {

	public static void main(String[] args) {
		SpringApplication.run(JournalApplication.class, args);
	}
@Bean
	public PlatformTransactionManager add(MongoDatabaseFactory dbfactory){
	return new MongoTransactionManager(dbfactory);
}

}
//PlatformTransactionmanager for interface to perform all the roll back
//MongoTransactionManager implementation of all
//MongodatabaseFactory creates a connection