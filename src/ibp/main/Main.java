package ibp.main;

import ibp.utils.RestQuery;

public class Main {
	public static void main(String[] args) throws Exception {		
		RestQuery.httpGet("https://api.carbonintensity.org.uk/intensity");
		RestQuery.httpPost("http://httpbin.org/post");
	}
}
