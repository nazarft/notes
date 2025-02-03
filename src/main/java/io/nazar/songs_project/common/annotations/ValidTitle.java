package io.nazar.songs_project.common.annotations;

import io.nazar.songs_project.common.validations.TitleValidator;
import jakarta.validation.Constraint;
import lombok.ToString;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TitleValidator.class)
public @interface ValidTitle {
    String message() default "Title should not be empty";

    Class<?>[] groups() default {};

    Class<?>[] payload() default {};
}
