package android.car.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({ElementType.FIELD})
public @interface ValueTypeDef {
  Class type() default Object.class;
}


/* Location:              C:\Users\mwy19\Desktop\Monjaro\jd-gui-windows-1.6.6\ecarx.adaptapi.jar!\android\car\annotation\ValueTypeDef.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */