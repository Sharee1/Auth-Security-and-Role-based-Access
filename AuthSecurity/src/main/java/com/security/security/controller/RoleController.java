package com.security.security.controller;

import com.security.security.dto.MessageResponse;
import com.security.security.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "*", maxAge = 4300)
@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;
    @PostMapping("/addRoles")
    public MessageResponse addRecipe(){
        return roleService.addRolesToDB();

    }

}
