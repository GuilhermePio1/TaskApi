package com.guilhermecamara.taskapi.service;

import com.guilhermecamara.taskapi.model.UserT;
import com.guilhermecamara.taskapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserT user = userRepository.findByUsername(s);

        if(user == null){
            throw new UsernameNotFoundException(s);
        }

        return new UserDetailsImpl(user);
    }
}
