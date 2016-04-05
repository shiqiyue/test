package mongo_test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class MongoInstance {

	private static final Logger log = LoggerFactory.getLogger(MongoInstance.class);

	private static MongoClient mongClient;

	private static DB db;

	public static MongoClient getMongClient() {
		return mongClient;
	}

	public static void setMongClient(MongoClient mongClient) {
		if (mongClient == null) {
			MongoInstance.mongClient = mongClient;
		} else {
			log.warn("重复填充mongoclient实体");
		}
	}

	public static DB getDb() {
		return db;
	}

	public static void setDb(DB db) {
		if (db == null) {
			MongoInstance.db = db;
		} else {
			log.warn("重复填充db实体");
		}
	}

	public static boolean isFulled() {
		return mongClient != null && db != null;
	}

}
