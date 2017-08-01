package com.andruha.controller.common;

import com.andruha.model.entity.User;
import com.andruha.service.implementations.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.validation.Valid;
import java.util.List;

/**
 * Created by andrusha on 30.07.17.
 */
@Controller
public class SignUpController {
    private UserServiceImpl userService;

    @Autowired
    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.GET)
    public String getSignUpPage() {
        return "index.html";
    }

    @RequestMapping(value = "/signUp", method = RequestMethod.POST)
    public String  signUp(@Valid @RequestBody User user, BindingResult result) {
        if (result.hasErrors()) {
            return "/signUp";
        }
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        user = userService.addUser(user);
        List<GrantedAuthority> authorities =
                AuthorityUtils.createAuthorityList("ROLE_USER");
        UserDetails userDetails = new org.springframework.security.core.userdetails
                .User(user.getUserName(),user.getPassword(), authorities);
        Authentication auth =
                new UsernamePasswordAuthenticationToken(userDetails, user.getPassword(), authorities);
        SecurityContextHolder.getContext().setAuthentication(auth);
        return "redirect:/";
    }

}
