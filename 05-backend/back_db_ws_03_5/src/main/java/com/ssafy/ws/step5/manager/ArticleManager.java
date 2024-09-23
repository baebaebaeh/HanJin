package com.ssafy.ws.step5.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ssafy.ws.step5.dto.Article;
import com.ssafy.ws.step5.dto.Comment;

public class ArticleManager {
	private List<Article> articles = new ArrayList<>();
	private Map<Integer, List<Comment>> comments = new HashMap<>();
	
	private ArticleManager() {}
	private static ArticleManager instance = new ArticleManager();
	public static ArticleManager getInstance() {
		return instance;
	}
	
	public List<Article> selectAll() {
		return articles;
	}
	public Article selectOne(int articleId) {
		return null;
	}
	public void insert(Article a) {
		
	}
	public void removeArticle(int articleId) {
		
	}
	public void insert(Comment comment) {
		
	}
	public void removeComment(int articleId, int commentId) {
		
	}
	public List<Comment> selectArticle(int articleId) {
		return null;
	}
	public List<Article> addHistory(List<Article> history, Article article) {
		return history;
	}
}
