package urule;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * @author tonghan
 * @since 2019年1月1日
 */
@SpringBootApplication
@ImportResource({"classpath:urule-console-context.xml"})
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class,args);
	}
}
