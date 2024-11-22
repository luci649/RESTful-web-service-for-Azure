package com.rest.jersey.calculator;

import java.net.URI;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.client.Entity;
import org.glassfish.jersey.client.ClientConfig;

public class RESTClientCalc {
	private static final String webServiceURI = "https://webapp-241122141130.azurewebsites.net";
	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		URI serviceURI = UriBuilder.fromUri(webServiceURI).build();
		WebTarget webTarget = client.target(serviceURI);
		System.out.println("\nUsing GET QUERY parameters to invoke a RESTful service returning JSON output:");
		System.out.println(webTarget.path("calc")
			.queryParam("a", "74").queryParam("b", "12")
			.queryParam("op", "+").request()
			.accept(MediaType.APPLICATION_JSON).get(String.class));
	}
}
