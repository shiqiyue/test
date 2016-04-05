package mongo_test;

import java.net.UnknownHostException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Lists;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

public class MongoInit {

	private static final Logger log = LoggerFactory.getLogger(MongoInit.class);

	public static DB init() {
	
		log.info("读取mongo配置信息");
		String ip = MongoConfig.ip;
		int port = MongoConfig.port;
		String dbName = MongoConfig.dbName;
		List<ServerAddress> serverAddress = Lists.newArrayList();
		ServerAddress addessOne;
		try {
			addessOne = new ServerAddress(ip, port);
		} catch (UnknownHostException e) {
			log.error("未知的mongo地址");
			return null;
		}
		serverAddress.add(addessOne);
		log.info("mongo初始化");
		MongoClient mongoClient = new MongoClient(serverAddress);
		DB db = mongoClient.getDB(dbName);
		log.info("mongo初始化完成");
		return db;
	}
}
