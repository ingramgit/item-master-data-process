package com.ingram.dataverse.consumer;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.logging.Logger;

/**
 * This class was automatically generated by the data modeler tool.
 */

public class RestWebServiceConsumer implements java.io.Serializable {

    static final long serialVersionUID = 1L;
    static Logger logger = Logger.getLogger(RestWebServiceConsumer.class.getName());

    public RestWebServiceConsumer() {
    }


    public static String get(String uri) throws Exception {
    	    HttpClient client = HttpClient.newHttpClient();
    	    HttpRequest request = HttpRequest.newBuilder()
    	          .uri(URI.create(uri))
    	          .build();
    
    	    HttpResponse<String> response =
    	          client.send(request, BodyHandlers.ofString());
            
    	    logger.info("Status Code = " + response.statusCode() + ", Response = "+ response.body());
    	    return response.body();
	}
	
	public static Object post(String uri, String data) throws Exception {
    	    HttpClient client = HttpClient.newBuilder().build();
    	    HttpRequest request = HttpRequest.newBuilder()
    	            .uri(URI.create(uri))
    	            .POST(BodyPublishers.ofString(data))
    	            .build();
    
    	    HttpResponse<?> response = client.send(request, BodyHandlers.discarding());
    	    logger.info("Status Code = " + response.statusCode() + ", Response = "+ response.body());
    	    return response.body();
	}

}