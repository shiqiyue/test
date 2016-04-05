package spring_data_test;

import java.net.UnknownHostException;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;

import mongo_test.MongoConfig;

@Configuration
@EnableMongoRepositories(basePackageClasses = MongoConfiguration.class)
@ComponentScan(basePackageClasses = MongoConfiguration.class, useDefaultFilters = false, includeFilters = {
		@ComponentScan.Filter({ Document.class, Component.class }) })
public class MongoConfiguration extends AbstractMongoConfiguration {

	@Override
	protected String getDatabaseName() {
		// TODO Auto-generated method stub
		return MongoConfig.dbName;
	}

	@Override
	public Mongo mongo() throws Exception {
		String ip = MongoConfig.ip;
		int port = MongoConfig.port;
		List<ServerAddress> serverAddress = Lists.newArrayList();
		ServerAddress addessOne;
		try {
			addessOne = new ServerAddress(ip, port);
		} catch (UnknownHostException e) {
			return null;
		}
		serverAddress.add(addessOne);
		MongoClient mongoClient = new MongoClient(serverAddress);
		return mongoClient;
	}

}
