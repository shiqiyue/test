package spring_data_test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

@Configuration
public class Bootstrap {

	
	
	
	public static void main(String[] args) {
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(MongoConfiguration.class);
		rootContext.refresh();
		SeedRepository seedDao = rootContext.getBean(SeedRepository.class);
		Seed seed = new Seed();
		seed.setKey("key");
		seed.setVale("value");
		seed.setName("name");
		seed = seedDao.save(seed);
		System.out.println(seed.toString());
		rootContext.close();
	}
}
