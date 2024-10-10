package com.security.security.service;

import com.security.security.entity.User;
import com.security.security.exception.GenericException;
import com.security.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
  @Autowired
  UserRepository userRepository;

  @Override
  @Transactional
  public UserDetails loadUserByUsername(String username)  {
    User user = userRepository.findByUsername(username)
            .orElseThrow(() -> new GenericException(HttpStatus.NOT_FOUND," User Not Found with username: " + username,"Incorrect Username"));
    return UserDetailsImpl.build(user);
  }

}
