package com.exam;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.repo.RoleRepository;
import com.exam.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

    @Autowired
    public RoleRepository roleRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static void main(String[] args) {


        SpringApplication.run(ExamserverApplication.class, args);


    }

    @Override
    public void run(String... args) {

        System.out.println("starting code");

//        try {
//            User adminUser = this.userRepository.findByUsername("sujith");
//
//            if (adminUser == null || adminUser.getUsername().length() == 0) {
//                User user = new User();
//
//                user.setFirstName("Sujith");
//                user.setLastName("Surendran");
//                user.setUsername("sujith");
//                user.setPassword(this.bCryptPasswordEncoder.encode("sujith"));
//                user.setEmail("es.sujit@gmail.com");
//                user.setPhone("9972417982");
//                user.setEnabled(true);
//                user.setProfile("default.png");
//
//                Role role1 = new Role();
//                role1.setRoleId(44L);
//                role1.setRoleName("ADMIN");
//
//                Set<UserRole> userRoleSet = new HashSet<>();
//                UserRole userRole = new UserRole();
//
//                userRole.setRole(role1);
//
//                userRole.setUser(user);
//
//                userRoleSet.add(userRole);
//                this.roleRepository.save(role1);
//                User user1 = this.userRepository.save(user);
//                System.out.println("ADMIN User created: " + user1.getUsername());
//            }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
