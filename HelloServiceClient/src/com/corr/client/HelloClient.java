package com.corr.client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.glassfish.jersey.client.ClientConfig;

public class HelloClient {
	
	public static void main(String[] args) {
		String uriString = "http://localhost:8091/HelloWebService/riprest";
		// TODO Auto-generated method stub
		URI uri = UriBuilder.fromUri(uriString).build();
		
		ClientConfig config = new ClientConfig();
		Client client = ClientBuilder.newClient(config);
		
		WebTarget target = client.target(uri);
		String plain = target.path("/riphello")
				.request()
				.accept(MediaType.TEXT_PLAIN)
				.get(String.class);
		System.out.println(plain);
		
		plain = target.path("/riphello/welcome")
				.request()
				.accept(MediaType.TEXT_HTML)
				.get(String.class);
		System.out.println(plain);
		
		plain = target.path("/riphello/welcomexml")
				.request()
				.accept(MediaType.APPLICATION_XML)
				.get(String.class);
		System.out.println(plain);
	}

}
