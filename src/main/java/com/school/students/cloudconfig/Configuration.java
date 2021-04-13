package com.school.students.cloudconfig;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@RefreshScope
@ConfigurationProperties("student")
@Component
public class Configuration {
	
	private String profileData;

	public String getProfileData() {
		return profileData;
	}

	public void setProfileData(String profileData) {
		this.profileData = profileData;
	}

	@Override
	public String toString() {
		return "Configuration : " +
				" profileData = '" + profileData + '\'' ;
	}
}
