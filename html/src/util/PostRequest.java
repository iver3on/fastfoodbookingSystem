package util;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.mime.MultipartEntity;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.entity.mime.content.StringBody;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

public class PostRequest {

	/**
	 * 发送get请求
	 * 
	 * @return 返回httpResponese对象
	 * 
	 */
	public static HttpResponse getHttpResponse(String url) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet getMethod = new HttpGet(url);
		HttpResponse response = null;
		String str = null;
		try {
			response = httpClient.execute(getMethod);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 发送get请求
	 * 
	 * @param url
	 * @return 请求结果
	 */
	public static String getHttpPost(String url) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpGet getMethod = new HttpGet(url);
		HttpResponse response = null;
		String str = null;
		try {
			response = httpClient.execute(getMethod);
			HttpEntity entity = response.getEntity();
			str = EntityUtils.toString(entity);
			// Do not feel like reading the response body
			// Call abort on the request object
			getMethod.abort();

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// When HttpClient instance is no longer needed,
			// shut down the connection manager to ensure
			// immediate deallocation of all system resources
			httpClient.getConnectionManager().shutdown();
		}
		return str;
	}

	/**
	 * 发送post请求
	 * 
	 * @param url
	 * @param params
	 * @return
	 */
	public static String postHttpReqest(String url, Map<String, String> params) {
		HttpClient httpClient = new DefaultHttpClient();
		HttpPost postMethod = postForm(url, params);
		String body = null;
		body = invoke((DefaultHttpClient) httpClient, postMethod);
		httpClient.getConnectionManager().shutdown();
		return body;

	}

	/**
	 * 发送post请求
	 * 
	 * @param url
	 * @param params
	 * @return
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 */
	public static String postHttpReqest(String url, Object obj, String objName)
			throws Exception {
		HttpClient httpClient = new DefaultHttpClient();
		Class objClass = obj.getClass();
		Map<String, String> params = new HashMap<String, String>();
		Field[] fields = objClass.getDeclaredFields();
		Method[] methods = objClass.getDeclaredMethods();
		Set<String> methodSet = new HashSet<String>();
		for (Method m : methods) {
			methodSet.add(m.getName());
		}
		for (Field field : fields) {
			Class fieldType = field.getType();
			String fieldName = field.getName();
			if (fieldType.equals("java.util.ArrayList")) {
				if (methodSet.contains(fieldName.substring(0, 1).toUpperCase()
						+ fieldName.substring(1))) {
					Method method = objClass.getMethod("get"
							+ fieldName.substring(0, 1).toUpperCase()
							+ fieldName.substring(1), null);
					if (method != null) {
						List list = (List) method.invoke(obj, null);
						for (int i = 0; i < list.size(); i++) {
							String value = (String) list.get(i);
							params.put(objName + "." + fieldName, value);
						}
					}
				}

			} else {
				if (methodSet.contains(fieldName.substring(0, 1).toUpperCase()
						+ fieldName.substring(1))) {
					Method method = objClass.getMethod("get"
							+ fieldName.substring(0, 1).toUpperCase()
							+ fieldName.substring(1), null);
					Object rlt = method.invoke(obj, null);
					params.put(objName + "." + fieldName, (String) rlt);
				}
			}
		}
		HttpPost postMethod = postForm(url, params);
		String body = null;
		body = invoke((DefaultHttpClient) httpClient, postMethod);
		httpClient.getConnectionManager().shutdown();
		return body;
	}

	/**
	 * 设置参数产生httpPOST
	 * 
	 * @param url
	 * @param params
	 * @param password
	 * @return
	 */
	private static HttpPost postForm(String url, Map<String, String> params) {

		HttpPost httpost = new HttpPost(url);
		List<NameValuePair> nvps = new ArrayList<NameValuePair>();
		if (params != null) {
			Set<String> keySet = params.keySet();
			for (String key : keySet) {
				nvps.add(new BasicNameValuePair(key, params.get(key)));
			}

			try {
				httpost.setEntity(new UrlEncodedFormEntity(nvps, HTTP.UTF_8));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		return httpost;
	}

	/**
	 * 发送请求并解析响应
	 * 
	 * @param httpclient
	 * @param httpost
	 * @return
	 */
	private static String invoke(DefaultHttpClient httpclient,
			HttpUriRequest httpost) {

		HttpResponse response = sendRequest(httpclient, httpost);
		String body = paseResponse(response);

		return body;
	}

	/**
	 * 解析响应
	 * 
	 * @param response
	 * @return
	 */
	private static String paseResponse(HttpResponse response) {
		HttpEntity entity = response.getEntity();

		String body = null;
		try {
			body = EntityUtils.toString(entity);
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return body;
	}

	/**
	 * 发送http请求
	 * 
	 * @param httpclient
	 * @param httpost
	 * @return
	 */
	private static HttpResponse sendRequest(DefaultHttpClient httpclient,
			HttpUriRequest httpost) {
		HttpResponse response = null;

		try {
			response = httpclient.execute(httpost);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return response;
	}

	/**
	 * 
	 * @param url
	 * @param filepath
	 */
	public static void submitPost(String url, String filepath) {

		HttpClient httpclient = new DefaultHttpClient();

		try {

			HttpPost httppost = new HttpPost(url);
			File file = new File(filepath);
			File[] files = file.listFiles(new FileFilter() {

				public boolean accept(File pathname) {
					if (!pathname.getPath().endsWith(".data")) {
						return false;
					}
					return true;
				}
			});
			MultipartEntity reqEntity = new MultipartEntity();
			for (File f : files) {
				FileBody fileBody = new FileBody(f);
				StringBody comment = new StringBody(f.getAbsolutePath());
				reqEntity.addPart("file1", fileBody);

			}

			httppost.setEntity(reqEntity);

			HttpResponse response = httpclient.execute(httppost);

			int statusCode = response.getStatusLine().getStatusCode();

			if (statusCode == HttpStatus.SC_OK) {

				System.out.println("服务器正常响应.....");

				HttpEntity resEntity = response.getEntity();

				System.out.println(EntityUtils.toString(resEntity));// httpclient自带的工具类读取返回数据

				System.out.println(resEntity.getContent());

				EntityUtils.consume(resEntity);
			}

		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpclient.getConnectionManager().shutdown();
			} catch (Exception ignore) {

			}
		}
	}

	public static void main(String[] args) {
		String response = PostRequest.getHttpPost("http://www.baidu.com");
		System.out.println(response);
	}
}
