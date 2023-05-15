package com.scaler.blogapi.users;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UsersRepositoryTest {
    @Autowired private UsersRepository usersRepository;

    @Test
    public void createUser(){
        UserEntity userEntity = UserEntity.builder().userName("test").email("test@test.com").password("test").build();
        Assertions.assertNotNull(userEntity.getId());
    }

    @Test public void findByUsername(){
        UserEntity userEntity1 = new UserEntity(
                "test1",
                "test1@test.com",
                "test1"
        );
        UserEntity userEntity2 = new UserEntity(
                "test2",
                "test2@test.com",
                "test2"
        );
        usersRepository.save(userEntity1);
        usersRepository.save(userEntity2);
        var user1 = usersRepository.findByUserName("test1");

        var user2 = usersRepository.findByUserName("test2");

        Assertions.assertEquals("test1",user1.getUserName());
        Assertions.assertEquals("test2@test.com",user2.getEmail());
    }
}
