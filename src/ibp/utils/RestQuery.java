package ibp.utils;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;



public class RestQuery {
	public static void httpGet(String api) throws Exception {
		RequestConfig globalConfig = RequestConfig.custom()
                .setCookieSpec(CookieSpecs.DEFAULT)
                .build();
		CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultRequestConfig(globalConfig)
                .build();
		try {

		    HttpGet httpGet = new HttpGet(api);
		    RequestConfig localConfig = RequestConfig.copy(globalConfig)
	                .setCookieSpec(CookieSpecs.STANDARD)
	                .build();
	        httpGet.setConfig(localConfig); 

			CloseableHttpResponse response1 = httpclient.execute(httpGet);

			try {
				System.out.println(response1.getStatusLine());
				HttpEntity entity1 = response1.getEntity();
				// do something useful with the response body
				String responseXml = EntityUtils.toString(entity1);
				System.out.println(responseXml);
				// and ensure it is fully consumed
				EntityUtils.consume(entity1);
			} finally {
				response1.close();
			}
		} finally {
			httpclient.close();
		}
	}
	
	public static void httpPost(String api) throws Exception {
		RequestConfig globalConfig = RequestConfig.custom()
                .setCookieSpec(CookieSpecs.DEFAULT)
                .build();
		CloseableHttpClient httpclient = HttpClients.custom()
                .setDefaultRequestConfig(globalConfig)
                .build();
		try {

			HttpPost httpPost = new HttpPost(api);
			httpPost.setHeader("content-type", "application/json");
			
//			List <NameValuePair> nvps = new ArrayList <NameValuePair>();
//			nvps.add(new BasicNameValuePair("content-type", "application/json"));
//			nvps.add(new BasicNameValuePair("cache-control", "no-cache"));
//			nvps.add(new BasicNameValuePair("body", "eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ0ZWFtTmFtZSI6IkVxdWlwZSAyIiwic3ViIjoiQ0hBTExFTkdFIiwiYXVkIjoiaHR0cDpcL1wvd3d3Lm9jc3NpbW9yZS5uZXQiLCJuYmYiOjE1MTA2NTE1MzUsImlkIjoyLCJleHAiOjE1OTcwNDc5MzUsImp0aSI6IjEwMzgyMDQ5LTQ3MTQtNDY5Zi1iNTRjLWU5M2E4NDA3NmU5OCJ9.QMW_shT8s-G2xhNyt7TcnyI9BoCxSswW5P4dwqDJNR0GodZSrPABEIoTCNDUC65yWNAuFgamBXlV6u9XH6sD-HUtnPTmFAhcLt0Z3zy3eH3nU8gxFpH-IttFYDb-Tp08xO9li39c9QrEaqEERCrHC0sPHYF1WJXrpauDM9VqXnwEm3PVN3WCrXQCRW6aX15X7PAO7HFrPSOXsfTi_-QJ0RzsPGf415K4lb3FCZFGlUi13Sjhj3lWK3QXec8LwvrZ7YJl7Z9Cz6zEO6R32OGOz7c-Skb8NZH61kMnYoeBtOQJud9xnSI2f8LSw9NB3rsVuWBmfLUzJMC4q7TX09ytDw"));
			
			StringEntity xmlEntity = new StringEntity("\"eyJ0eXAiOiJKV1QiLCJhbGciOiJSUzI1NiJ9.eyJ0ZWFtTmFtZSI6IkVxdWlwZSAyIiwic3ViIjoiQ0hBTExFTkdFIiwiYXVkIjoiaHR0cDpcL1wvd3d3Lm9jc3NpbW9yZS5uZXQiLCJuYmYiOjE1MTA2NTE1MzUsImlkIjoyLCJleHAiOjE1OTcwNDc5MzUsImp0aSI6IjEwMzgyMDQ5LTQ3MTQtNDY5Zi1iNTRjLWU5M2E4NDA3NmU5OCJ9.QMW_shT8s-G2xhNyt7TcnyI9BoCxSswW5P4dwqDJNR0GodZSrPABEIoTCNDUC65yWNAuFgamBXlV6u9XH6sD-HUtnPTmFAhcLt0Z3zy3eH3nU8gxFpH-IttFYDb-Tp08xO9li39c9QrEaqEERCrHC0sPHYF1WJXrpauDM9VqXnwEm3PVN3WCrXQCRW6aX15X7PAO7HFrPSOXsfTi_-QJ0RzsPGf415K4lb3FCZFGlUi13Sjhj3lWK3QXec8LwvrZ7YJl7Z9Cz6zEO6R32OGOz7c-Skb8NZH61kMnYoeBtOQJud9xnSI2f8LSw9NB3rsVuWBmfLUzJMC4q7TX09ytDw\"");
			
			httpPost.setEntity(xmlEntity );
			
			CloseableHttpResponse response2 = httpclient.execute(httpPost);
	
			try {
				System.out.println(response2.getStatusLine());
				HttpEntity entity2 = response2.getEntity();
				// do something useful with the response body
				String responseXml = EntityUtils.toString(entity2);
				System.out.println(responseXml);
				// and ensure it is fully consumed
				EntityUtils.consume(entity2);
			} finally {
				response2.close();
			}
		} finally {
			httpclient.close();
		}
	}
}
