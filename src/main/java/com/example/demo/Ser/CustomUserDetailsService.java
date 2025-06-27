package com.example.demo.Ser;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Admin;
import com.example.demo.Model.Restaurant;
import com.example.demo.Model.User;
import com.example.demo.Repo.AdminRepo;
import com.example.demo.Repo.RestaurantRepo;
import com.example.demo.Repo.UserRepo;
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private RestaurantRepo restaurantRepo;

    @Autowired
    private AdminRepo adminRepo; // 🔥 Add this

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    	
    	   Optional<Admin> adminOpt = adminRepo.findByEmail(email);
           if (adminOpt.isPresent()) {
               Admin admin = adminOpt.get();
               return new org.springframework.security.core.userdetails.User(
                   admin.getEmail(),
                   admin.getPassword(),
                   Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + admin.getRole()))
               );
           }
           
           
        Optional<User> userOpt = userRepo.findByEmail(email);
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
            );
        }

        Optional<Restaurant> resOpt = restaurantRepo.findByEmail(email);
        if (resOpt.isPresent()) {
            Restaurant res = resOpt.get();
            return new org.springframework.security.core.userdetails.User(
                res.getEmail(),
                res.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + res.getRole()))
            );
        }

   

        throw new UsernameNotFoundException("User not found");
    }
}
