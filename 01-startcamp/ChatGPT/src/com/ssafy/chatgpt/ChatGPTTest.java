package com.ssafy.chatgpt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class ChatGPTTest {

	   private static String API_KEY = "sk-proj-wa72okoTRzu2QPleVA5qT3BlbkFJ8uK5uRtXyLpRKRoNEatb";
	   private static String GPT_URL = "https://api.openai.com/v1/chat/completions";

	   public static void main(String[] args) throws IOException {
	      URL url = new URL(GPT_URL);
	      HttpURLConnection connection = (HttpURLConnection) url.openConnection();
	      
	      connection.setRequestMethod("POST");
	      connection.setRequestProperty("Content-Type", "application/json");
	      connection.setRequestProperty("Authorization", "Bearer " + API_KEY);
	      connection.setDoInput(true);
	      connection.setDoOutput(true);
	      
	      JSONObject data = new JSONObject();
	      data.put("model", "gpt-3.5-turbo");
	      
	      JSONObject message = new JSONObject();
	      message.put("role", "user");
	      message.put("content", "대전 최고 맛집 소개해줘.");
	      
	      JSONArray messages = new JSONArray();
	      messages.put(message);
	      
	      data.put("messages", messages);
	      
	      BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(connection.getOutputStream()));
	      bw.write(data.toString());
	      bw.flush();
	      bw.close();
	      
	      BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
	      StringBuilder sb = new StringBuilder();
	      String line = null;
	      
	      while ((line = br.readLine()) != null) {
	         sb.append(line);
	      }
	      System.out.println(sb.toString());
	   }
	}








