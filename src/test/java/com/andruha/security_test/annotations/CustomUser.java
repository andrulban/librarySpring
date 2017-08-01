package com.andruha.security_test.annotations;

import com.andruha.security_test.factories.CustomUserSecurityContextFactory;
import org.springframework.security.test.context.support.WithSecurityContext;

import java.lang.annotation.*;

/**
 * Created by andrusha on 01.08.17.
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
@WithSecurityContext(factory = CustomUserSecurityContextFactory.class)
public @interface CustomUser {
    String userName() default "user";
    String email() default "user@gmail.com";
    int permission() default 0;
    long id() default 0L;
}
