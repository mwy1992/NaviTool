package com.ecarx.xui.adaptapi;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Retention(RetentionPolicy.CLASS)
@Target({ElementType.METHOD, ElementType.PARAMETER, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PACKAGE, ElementType.TYPE})
public @interface VendorDefinition {
  String author() default "";
  
  String date() default "";
  
  String project() default "";
  
  String requirement() default "";
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\com\ecarx\xui\adaptapi\VendorDefinition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */