package edu.hm.cs.a1_reflection_123;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by MatHe on 29.03.2017.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
public @interface RenderMe {
     /**
      *
      * @return string of the renderer to use.
      */
     String with() default "edu.hm.cs.a1_reflection_123.Renderer";
}
