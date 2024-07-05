package com.oAuth2.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;
import java.util.List;

@ConfigurationProperties(prefix = "com.security.oauth2.jwt")
public class ServerSecurityProperties {

	private static List<String> authenticatedPathMatchers = new ArrayList<>();
	private static String identityClaimLabel;

	public String getIdentityClaimLabel() {
		return identityClaimLabel;
	}

	public void setIdentityClaimLabel(String identityClaimLabel) {
		ServerSecurityProperties.identityClaimLabel = identityClaimLabel;
	}

	public List<String> getAuthenticatedPathMatchers() {
		return authenticatedPathMatchers;
	}

	public void setAuthenticatedPathMatchers(List<String> authenticatedPathMatchers) {
		ServerSecurityProperties.authenticatedPathMatchers = authenticatedPathMatchers;
	}
}
