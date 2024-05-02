package net.sds.mvvm.bindings;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(BindValues.class)
@Target(ElementType.FIELD)
public @interface Bind {
    String value();
    String target();
    BindingType type() default BindingType.SOURCE_TO_TARGET;
}