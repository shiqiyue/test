package spring_data_test;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface SeedRepository extends MongoRepository<Seed, String>{

}
