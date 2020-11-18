package com.jaytest.model;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpClient {

	private static HttpClient CLIENT;

	private final static int CONNECT_TIMEOUT = 5000; // in milliseconds

	/**
	 * 采用单例方式来访问操作
	 *
	 * @return
	 */
	public static synchronized HttpClient getInstance() {

		if (CLIENT == null) {
			CLIENT = new HttpClient();
		}
		return CLIENT;
	}

	/**
	 * POST方法
	 * @param sendUrl
	 *            ：访问URL
	 * @param sendParam
	 *            ：参数串
	 * @param backEncodType
	 *            ：返回的编码
	 * @return
	 */
	public String doPost(String sendUrl, String sendParam,
			String backEncodType) {

		StringBuffer receive = new StringBuffer();
		BufferedWriter wr = null;

		try {
			if (backEncodType == null || backEncodType.equals("")) {
				backEncodType = "UTF-8";
			}

			URL url = new URL(sendUrl);
			HttpURLConnection URLConn = (HttpURLConnection) url
					.openConnection();

			URLConn.setDoOutput(true);
			URLConn.setDoInput(true);
			URLConn.setRequestMethod("POST");
			URLConn.setUseCaches(false);
			URLConn.setAllowUserInteraction(true);
			HttpURLConnection.setFollowRedirects(true);
			URLConn.setInstanceFollowRedirects(true);
			URLConn.setConnectTimeout(CONNECT_TIMEOUT);
			URLConn.setReadTimeout(CONNECT_TIMEOUT);

			URLConn.setRequestProperty("Content-Type", "application/json;charset=utf-8");
			URLConn.setRequestProperty("Content-Length", String.valueOf(sendParam.getBytes().length));

			DataOutputStream dos = new DataOutputStream(URLConn.getOutputStream());
			dos.writeBytes(sendParam);
			BufferedReader rd = new BufferedReader(new InputStreamReader(URLConn.getInputStream(), backEncodType));
			String line;
			while ((line = rd.readLine()) != null) {
				receive.append(line).append("\r\n");
			}
			rd.close();
		} catch (IOException e) {
//			receive.append("访问产生了异常-->").append(e.getMessage());
			receive.append("500");
			e.printStackTrace();
		} finally {
			if (wr != null) {
				try {
					wr.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				wr = null;
			}
		}

		return receive.toString();
	}

	public String doGet(String sendUrl, String backEncodType) {

		StringBuffer receive = new StringBuffer();
		BufferedReader in = null;
		try {
			if (backEncodType == null || backEncodType.equals("")) {
				backEncodType = "UTF-8";
			}

			URL url = new URL(sendUrl);
			HttpURLConnection URLConn = (HttpURLConnection) url.openConnection();

			URLConn.setDoInput(true);
			URLConn.setDoOutput(true);
			URLConn.setConnectTimeout(CONNECT_TIMEOUT);
			URLConn.setReadTimeout(CONNECT_TIMEOUT);
			URLConn.connect();
			URLConn.getOutputStream().flush();
			in = new BufferedReader(new InputStreamReader(URLConn.getInputStream(), backEncodType));

			String line;
			while ((line = in.readLine()) != null) {
				receive.append(line).append("\r\n");
			}

		} catch (IOException e) {
			receive.append("访问产生了异常-->").append(e.getMessage());
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException ex) {
					ex.printStackTrace();
				}
				in = null;

			}
		}

		return receive.toString();
	}
}