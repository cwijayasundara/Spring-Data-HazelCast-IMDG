package com.cham.springdatahazelcast;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.hazelcast.HazelcastKeyValueAdapter;
import org.springframework.data.hazelcast.repository.config.EnableHazelcastRepositories;
import org.springframework.data.keyvalue.core.KeyValueOperations;
import org.springframework.data.keyvalue.core.KeyValueTemplate;

@SpringBootApplication
@EnableHazelcastRepositories(basePackages = "com.cham.springdatahazelcast.repository")
public class SpringDataHazelcastApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataHazelcastApplication.class, args);
	}

	@Bean
	HazelcastInstance hazelcastInstance(){
		return HazelcastClient.newHazelcastClient();
	}

	@Bean
	public KeyValueOperations keyValueTemplate(){
		return new KeyValueTemplate(new HazelcastKeyValueAdapter(hazelcastInstance()));
	}
}
