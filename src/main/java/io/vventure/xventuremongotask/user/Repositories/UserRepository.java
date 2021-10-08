package io.vventure.xventuremongotask.user.Repositories;

import io.vventure.xventuremongotask.user.Entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String> {
}
