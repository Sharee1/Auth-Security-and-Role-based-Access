package com.security.security.service;

import com.security.security.dto.MessageResponse;
import com.security.security.entity.ERole;
import com.security.security.entity.Role;
import com.security.security.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;
    public MessageResponse addRolesToDB(){
        List<Role> existingRoles = roleRepository.findAll();
        if(!ObjectUtils.isEmpty(existingRoles)){
          roleRepository.deleteAll(existingRoles);
        }
        Role roleAdmin = new Role();
        roleAdmin.setName(ERole.ROLE_ADMIN);
        roleRepository.save(roleAdmin);
        Role roleUser = new Role();
        roleUser.setName(ERole.ROLE_USER);
        roleRepository.save(roleUser);
        return new MessageResponse("Roles added successfully");
    }
}
