package com.jxy.jxyapi.config;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ValidationProfiles {
    String[] profiles() default {};
}
