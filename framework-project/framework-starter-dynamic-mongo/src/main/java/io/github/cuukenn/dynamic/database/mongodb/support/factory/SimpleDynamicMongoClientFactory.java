/*
 * Copyright 2022 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.github.cuukenn.dynamic.database.mongodb.support.factory;

import com.mongodb.client.MongoClient;
import io.github.cuukenn.dynamic.database.mongodb.properties.DynamicMongoProperties;
import io.github.cuukenn.dynamic.database.mongodb.support.DynamicMongoClientBuilder;
import io.github.cuukenn.dynamic.database.mongodb.support.DynamicMongoClientFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @author changgg
 */
public class SimpleDynamicMongoClientFactory implements DynamicMongoClientFactory, InitializingBean, DisposableBean {
	private final Logger logger = LoggerFactory.getLogger(SimpleDynamicMongoClientFactory.class);
	private final DynamicMongoProperties properties;
	private final DynamicMongoClientBuilder mongoClientBuilder;
	private Map<String, MongoClient> dynamicMongoClients;

	public SimpleDynamicMongoClientFactory(DynamicMongoProperties properties, DynamicMongoClientBuilder mongoClientBuilder) {
		this.properties = properties;
		this.mongoClientBuilder = mongoClientBuilder;
	}

	@Override
	public MongoClient getDynamicMongoClient(String key) {
		return dynamicMongoClients != null ? dynamicMongoClients.get(key) : null;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		Map<String, MongoProperties> config;
		if ((config = properties.getConfig()) == null || config.isEmpty()) {
			logger.warn("no dynamic mongodb config!!!");
			return;
		}
		dynamicMongoClients = new HashMap<>(config.size());
		for (Map.Entry<String, MongoProperties> entry : config.entrySet()) {
			logger.info("init dynamic mongo database for {}", entry.getKey());
			dynamicMongoClients.put(entry.getKey(), mongoClientBuilder.build(entry.getKey(), entry.getValue()));
		}
	}

	@Override
	public void destroy() throws Exception {
		for (Map.Entry<String, MongoClient> entry : dynamicMongoClients.entrySet()) {
			logger.info("closing dynamic mongo client for name:{} ...", entry.getKey());
			try {
				MongoClient client;
				if ((client = entry.getValue()) != null) {
					client.close();
				}
			} catch (RuntimeException e) {
				logger.error("close dynamic mongo client failed for name:{},msg:{}", entry.getKey(), e.getMessage());
			}
		}
	}
}
