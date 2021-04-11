package com.school.students.cloudconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@ConfigurationProperties("student")
@Component
public class Configuration {
	
	private String greeting;
	private String connection;
	
	
	public String getGreeting() {
		return greeting;
	}
	public void setGreeting(String greeting) {
		this.greeting = greeting;
	}
	public String getConnection() {
		return connection;
	}
	public void setConnection(String connection) {
		this.connection = connection;
	}
	
	@Override
	public String toString() {
		return "Configuration [greeting=" + greeting + ", connection=" + connection + "]";
	}

}
