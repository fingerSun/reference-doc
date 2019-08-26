package swaggerdemo.swagger;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/** 
* @ClassName: ApiReturnJson 
* @Description: 返回对象的定义 (描述这个类的作用) 
* @author TangCai
* @date 2019年2月22日 下午4:56:33  
*/
  	
@Target({ElementType.PARAMETER, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ApiReturnJson {
    ApiReturnJsonPro[] value(); //对象属性值
}
