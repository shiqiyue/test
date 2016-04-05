package spring_data_test;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Seed {

	@Id
	private String id;
	
	private String name;
	
	private String key;
	
	private String vale;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getVale() {
		return vale;
	}

	public void setVale(String vale) {
		this.vale = vale;
	}
	
	
	
}
