package com.example.rest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {
	public static void main(String[] args) throws Exception {
		
	        String url = "http://localhost:8080/Temp/services/Order/amazon/login/yoyo";
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();

			//add reuqest header
			con.setRequestMethod("POST");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");
			con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");

			String urlParameters = "cloud=amazon&operation=login&command=ravjot";
			
			// Send post request
			con.setDoOutput(true);
			DataOutputStream wr = new DataOutputStream(con.getOutputStream());
			wr.writeBytes(urlParameters);
			wr.flush();
			wr.close();

			int responseCode = con.getResponseCode();
			System.out.println("\nSending 'POST' request to URL : " + url);
			System.out.println("Post parameters : " + urlParameters);
			System.out.println("Response Code : " + responseCode);

			BufferedReader in = new BufferedReader(
			        new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			
			//print result
			System.out.println(response.toString());
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("rav.txt")));
			bw.append(response.toString());
			bw.close();
	        
		/*String output = null;
		try {
			String url = "http://localhost:8080/Temp/services/Order/Give";
			HttpClient client = new HttpClient();
			PostMethod mPost = new PostMethod(url);
			mPost.addParameter("orderId", "1");
			Header mtHeader = new Header();
			mtHeader.setName("content-type");
			mtHeader.setValue("application/xml");
			mtHeader.setName("accept");
			mtHeader.setValue("application/xml");
			mPost.addRequestHeader(mtHeader);
			client.executeMethod(mPost);
			output = mPost.getResponseBodyAsString();
			mPost.releaseConnection();
			System.out.println("output : " + output);
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File("rav.txt")));
			bw.append(output);
			bw.close();
		} catch (Exception e) {
			throw new Exception("Exception in adding bucket : " + e);
		}*/
	}
}
