package com.raksha.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PDFDownloadServiceImple implements PDFDownloadService {
	
	@Autowired
	PDFTemplateService service;

	@Override
	public String getPDFDownloadURL(int policyNumber) {
		
		// TODO Auto-generated method stub
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost request = new HttpPost(API_URL);
		request.addHeader("Authorization", API_KEY);

		try {
			request.setEntity(new StringEntity("{\"html\":\""+service.getHTMLInString(policyNumber)+"\"}"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //I have other data to pass as Entity.

		try {
			HttpResponse response = httpClient.execute(request);
			

			BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), "UTF-8"));
			StringBuilder builder = new StringBuilder();
			for (String line = null; (line = reader.readLine()) != null;) {
			    builder.append(line).append("\n");
			}
				
			JSONParser parser = new JSONParser();
			JSONObject json;
			try {
				json = (JSONObject) parser.parse(builder.toString());
				String url = json.get("pdf").toString();
				url = url.replace(": ", ":");
				return url;
				
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Error";
	}

}
