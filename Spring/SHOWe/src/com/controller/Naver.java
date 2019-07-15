package com.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import com.vo.Content;
import com.vo.User;
public class Naver {
	public static StringBuilder sb;
	public static StringBuilder ssbb;	
	public Content details(String code) {//��ȭ �ϳ��� �� ������ ����´�.
		String title="";
		String genre="";
		String poster="";
		String director="test";
		String actor1="";
		String actor2="";
		String actor3="";
		int time=0;
		String contry="";
		String grade="";
		String apiurl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=298fb66cdb0e78493a307a5f6cc7b71f&movieCd="+code;
		try {
			URL url = new URL(apiurl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
			}
			ssbb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				ssbb.append(line + "\n");
			}
			br.close();
			con.disconnect();
			String data = ssbb.toString();
			String[] array;
			int k=0;
			array = data.split("\"");
			
			for (int i = 0; i < array.length; i++) {				
				if (array[i].equals("movieNm")) {
					title=array[i+2];					
				}
				if (array[i].equals("genreNm")) {
					genre=array[i+2];					
				}
				if (array[i].equals("showTm")) {
					time=Integer.parseInt(array[i+2]);					
				}
				if (array[i].equals("nationNm")) {
					contry=array[i+2];					
				}
				if (array[i].equals("actors")) {
					actor1=array[i+4];
					actor2=array[i+20];	
					actor3=array[i+36];	
				}
				if (array[i].equals("watchGradeNm")) {
					grade=array[i+2];					
				}
			}
			poster=getImg(title);			
			User u = new User("id123", "pwd123", "emain123","nick123","icon",1);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		Content movie = new Content(1, title, genre, poster, director, actor1, actor2, actor3, time, contry, grade);
		return movie;
	}

	public ArrayList<String> movieinsert(String a, String b) {//a�� ���� b�� ������ ��ȭ 100���� codes�� �����Ѵ�.
		String key = "298fb66cdb0e78493a307a5f6cc7b71f";
		String start = a;
		String end = b;
		String apiurl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key=298fb66cdb0e78493a307a5f6cc7b71f&itemPerPage=100&"
				+ "openStartDt=" + start + "&openEndDt=" + end;
		try {
			URL url = new URL(apiurl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
			}
			ssbb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				ssbb.append(line + "\n");
			}
			br.close();
			con.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		String data = ssbb.toString();
		String[] array;
		array = data.split("\"");
		ArrayList<String> codes = new ArrayList<>();
		String[] code = new String[500];
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals("movieCd")) {
				codes.add(array[i + 2]);
				
			}
		}
		return codes;
	}

	public static String getImg(String title) {
		String clientId = "7V0JoawWKWNz3PukrXhK";// ���ø����̼� Ŭ���̾�Ʈ ���̵�";
		String clientSecret = "U_XEWugoxb";// ���ø����̼� Ŭ���̾�Ʈ ��ũ����";\
		int display = 100; // �˻��������. �ִ�100��
		try {
			String intext = title;
			String text = URLEncoder.encode(intext, "utf-8");
			String apiURL = "https://openapi.naver.com/v1/search/movie.json?query=" + text + "&display=10&start=1"
					+ "&display=" + display + "&";
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
			int responseCode = con.getResponseCode();
			BufferedReader br;
			if (responseCode == 200) {
				br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			} else {
				br = new BufferedReader(new InputStreamReader(con.getErrorStream(), "utf-8"));
			}
			sb = new StringBuilder();
			String line;

			while ((line = br.readLine()) != null) {
				sb.append(line + "\n");
			}
			br.close();
			con.disconnect();			
		} catch (Exception e) {
			System.out.println(e);
		}
		String data = sb.toString();
		String[] array;
		array = data.split("\"");
		String[] t = new String[500];
		String[] image = new String[500];
		double[] rating = new double[500];
		int k = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i].equals("title")) {
				t[k] = array[i + 2];
			}
			if (array[i].equals("image"))
				image[k] = array[i + 2];
			if (array[i].equals("userRating")) {
				rating[k] = Double.parseDouble(array[i + 2]);
				k++;
			}
		}
		return image[0];
	}
}