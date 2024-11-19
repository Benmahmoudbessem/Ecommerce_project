package org.example.ecommerce.service;

import org.example.ecommerce.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.example.ecommerce.repository.UserRepository;
import java.util.List;

@Service
public class UserService {
        @Autowired
        UserRepository userRepository;

        public User createUser(User user) {return userRepository.save(user);}
        public List<User> getAllUser() { return userRepository.findAll();}
        public User getUserByID(int id){return userRepository.findById(id).get();}
        public User UpdateUser(User user){return userRepository.saveAndFlush(user);}
        public void deleteUser(int id){ userRepository.deleteById(id);}

    }


