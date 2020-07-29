package com.github.ooa.chudq.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;


public class HttpUtils {
	/**
	 * @description 
	 * ����ģʽ�£�HttpClient����Ӧ�ٶ�Ҫ����һЩ����λΪ���룬���ܲ�������
	 * org.apache.httpcomponents.httpclient-4.5.2.jar
	 * @param param
	 * @return
	 */
	public static String POST_HttpClient(String url,Map<?,?> param){
		CloseableHttpClient client = HttpClientBuilder.create().build(); 
		HttpPost post = new HttpPost(url);
		String res = null;
	    try {
	      List<NameValuePair> params = new ArrayList<>();
	      Iterator<?> iterator = param.entrySet().iterator();
		    while(iterator.hasNext()){
		    	Map.Entry<?, ?> map = (Entry<?, ?>) iterator.next();
		    	params.add(new BasicNameValuePair(map.getKey().toString(), map.getValue().toString()));
		    }
	      post.setEntity(new UrlEncodedFormEntity(params, HTTP.UTF_8));
	      HttpResponse response = client.execute(post);
	      res = EntityUtils.toString(response.getEntity());
	    } catch (UnsupportedEncodingException e) {
	      e.printStackTrace();
	    } catch (ClientProtocolException e) {
	      e.printStackTrace();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	    return res;
	}; 
	
	/**
	 * @description �ǵ���ģʽ�£�OkHttp�����ܸ��ã�HttpClient�������ӱȽϺ�ʱ����Ϊ�����������Щ��Դ����д�ɵ���ģʽ
	 * @param param
	 * @return
	 */
	public static String POST_OkHttp(Map<?,?> param){
		//OKHttpClent client;
		return null;
	}; 
	
	/**
	 * @description JDK �Դ���HttpURLConnection
	 * @param param
	 * @return
	 */
	public static String POST_HttpURLConnection(String host, Map<?,?> param){
		URL url;
		String result = null;
		try {
			url = new URL(host);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("POST");
			connection.setDoOutput(true);
			OutputStream outputStream = connection.getOutputStream();
		    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
		    Iterator<?> iterator = param.entrySet().iterator();
		    while(iterator.hasNext()){
		    	Map.Entry<?, ?> map = (Entry<?, ?>) iterator.next();
		    	writer.write(map.getKey() + "=" + map.getValue());
		    }
		    writer.close();
		    outputStream.close();
		    
		    // read response
	        BufferedReader in = new BufferedReader( new InputStreamReader(connection.getInputStream()));

	        String inputLine;
	        StringBuffer response = new StringBuffer();
	        while ((inputLine = in.readLine()) != null) { response.append(inputLine); }
	        in.close();

	        result = new String(response.toString().getBytes(),"UTf-8");

	        // disconnect
	        connection.disconnect();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}; 
	
}
