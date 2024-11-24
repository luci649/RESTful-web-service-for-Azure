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
	private static final String webServiceURI = "http://localhost:8080/RESTCalculator";
	public static void main(String[] args) {
		ClientConfig clientConfig = new ClientConfig();
		Client client = ClientBuilder.newClient(clientConfig);
		URI serviceURI = UriBuilder.fromUri(webServiceURI).build();
		WebTarget webTarget = client.target(serviceURI);
		System.out.println("\nUsing GET QUERY parameters to invoke a RESTful service returning JSON output:");
		System.out.println(webTarget.path("calc").queryParam("a", "74").queryParam("b", "12").queryParam("op", "+")
				.request().accept(MediaType.APPLICATION_JSON).get(String.class));
		System.out.println(webTarget.path("calc").queryParam("a", "7").queryParam("b", "2").queryParam("op", "add")
				.request().accept(MediaType.APPLICATION_JSON).get(String.class));
		System.out.println(webTarget.path("calc").queryParam("a", "40").queryParam("b", "21").queryParam("op", "-")
				.request().accept(MediaType.APPLICATION_JSON).get(String.class));
		System.out.println(webTarget.path("calc").queryParam("a", "10").queryParam("b", "1").queryParam("op", "sub")
				.request().accept(MediaType.APPLICATION_JSON).get(String.class));
		System.out.println(webTarget.path("calc").queryParam("a", "20").queryParam("b", "2").queryParam("op", "*")
				.request().accept(MediaType.APPLICATION_JSON).get(String.class));
		System.out.println(webTarget.path("calc").queryParam("a", "11").queryParam("b", "15").queryParam("op", "mul")
				.request().accept(MediaType.APPLICATION_JSON).get(String.class));
		System.out.println(webTarget.path("calc").queryParam("a", "9").queryParam("b", "3").queryParam("op", "/")
				.request().accept(MediaType.APPLICATION_JSON).get(String.class));
		System.out.println(webTarget.path("calc").queryParam("a", "8").queryParam("b", "4").queryParam("op", "div")
				.request().accept(MediaType.APPLICATION_JSON).get(String.class));
		//System.out.println(webTarget.path("calc").queryParam("a", "40").queryParam("b", "21").queryParam("op", "r")
				//.request().accept(MediaType.APPLICATION_JSON).get(String.class));
		
		System.out.println(webTarget.path("calc").path("convert").queryParam("a", "40").queryParam("currency", "gbp")
				.request().accept(MediaType.APPLICATION_JSON).get(String.class));
		System.out.println(webTarget.path("calc").path("convert").queryParam("a", "300").queryParam("currency", "usd")
				.request().accept(MediaType.APPLICATION_JSON).get(String.class));
	}
}
