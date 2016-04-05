package mongo_test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.WriteResult;

public class TestAdd {

	private static DB db;
	
	@BeforeClass
	public static void init(){
		db = MongoInit.init();
	}
	
	@Test
	@Ignore
	public void testAddThousand() {
		long startTime = System.currentTimeMillis();
		DBCollection c1 = db.getCollection("c1");
		List<DBObject> os = Lists.newArrayList();
		for (int i = 0 ;i < 1000; i++){
			BasicDBObject o = new BasicDBObject("tt", i);
			os.add(o);
		}
		WriteResult result = c1.insert(os);
		System.out.println(result.toString());
		System.out.println("批量添加1000个对象到mongo,用时:" +(System.currentTimeMillis() - startTime) +"ms");
	}
	
	@Test
	@Ignore
	public void testAddThousand2() {
		long startTime = System.currentTimeMillis();
		DBCollection c1 = db.getCollection("c1");
		for (int i = 0 ;i < 1000; i++){
			BasicDBObject o = new BasicDBObject("tt", i);
			c1.save(o);
		}
		System.out.println("添加1000个对象到mongo,用时:" +(System.currentTimeMillis() - startTime) +"ms");
	}
	
	@Test
	public void testAddMillion() {
		long startTime = System.currentTimeMillis();
		DBCollection c1 = db.getCollection("m1");
		List<DBObject> os = Lists.newArrayList();
		for (int i = 0 ;i < 1000000; i++){
			BasicDBObject o = new BasicDBObject("tt", i);
			o.put("cc", i+1);
			o.put("dd", i+2);
			os.add(o);
		}
		WriteResult result = c1.insert(os);
		System.out.println(result.toString());
		System.out.println("批量添加100W个对象到mongo,用时:" +(System.currentTimeMillis() - startTime) +"ms");
	}
	
	@Test
	@Ignore
	public void testAddMillion2() {
		long startTime = System.currentTimeMillis();
		DBCollection c1 = db.getCollection("m1");
		for (int i = 0 ;i < 1000000; i++){
			BasicDBObject o = new BasicDBObject("tt", i);
			c1.save(o);
		}
		System.out.println("添加100W个对象到mongo,用时:" +(System.currentTimeMillis() - startTime) +"ms");
	}
 
}
