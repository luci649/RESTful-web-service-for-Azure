package com.rest.jersey.calculator;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.json.JSONException;
import org.json.JSONObject;

@Path("/calc") //The root path
@Consumes(MediaType.APPLICATION_JSON) //Input data type
public class RESTServerCalc {
	@GET //Invocation method
	@Produces(MediaType.APPLICATION_JSON) //Output data type
	//Invocation: http://localhost:8080/RESTCalculator/calc?a=6&b=7&op=add
	public Response Calculator(@QueryParam("a") double a, @QueryParam("b") double b, @QueryParam("op") String op) 	throws JSONException {
		JSONObject json = new JSONObject();
		double c;
	    switch(op) {
	        case "+":
	        case "add":
	            c = a + b;
	            break;
	        case "-":
	        case "sub":
	            c = a - b;
	            break;
	        case "*":
	        case "mul":
	            c = a * b;
	            break;
	        case "/":
	        case "div":
	            if (b==0) {
	        	return Response.status(400).entity("400 Arithmetic exception: division by zero error").build();
	            } 
	            else {c = a / b;};
	            break;
	        default:
        		return Response.status(400).entity("400 Invalid Operator").build();	
	    }
		json.put("a", a);
		json.put("b", b);
		json.put("op", op);
		json.put("c", c);
		String result = ""+json;
		return Response.status(200).entity(result).build();	
	}
}
