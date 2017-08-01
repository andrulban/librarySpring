package com.andruha.security_test.factories;

import com.andruha.model.entity.User;
import com.andruha.security_test.annotations.CustomUser;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.test.context.support.WithSecurityContextFactory;

/**
 * Created by andrusha on 01.08.17.
 */
public class CustomUserSecurityContextFactory implements WithSecurityContextFactory<CustomUser> {

    @Override
    public SecurityContext createSecurityContext(CustomUser customUser) {
        SecurityContext context = SecurityContextHolder.createEmptyContext();

        User principal = new User();
        principal.setUserName(customUser.userName());
        principal.setEmail(customUser.email());
        principal.setId(customUser.id());
        principal.setPermission(customUser.permission());
        Authentication auth =
                new UsernamePasswordAuthenticationToken(principal, "password", AuthorityUtils.createAuthorityList("ROLE_USER"));
        context.setAuthentication(auth);
        return context;
    }
}
