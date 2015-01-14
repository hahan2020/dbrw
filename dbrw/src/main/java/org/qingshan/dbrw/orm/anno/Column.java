package org.qingshan.dbrw.orm.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Column {
	String value() default "";
	boolean pk() default false;
	boolean auto() default false;
	String seqName() default "";
}
