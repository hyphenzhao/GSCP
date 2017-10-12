package com.usyd.gscp.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "forumcontent")
public class ForumContent {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@JoinColumn(table="user", name="id")
	private int userId;
	
	@Column(name = "title", columnDefinition="TEXT")
	private String title;
	
	@Column(name = "content", columnDefinition="TEXT")
	private String content;
	
	@Temporal(TemporalType.DATE)
    private Date date;
	
	@Column(name = "visability")
	private boolean visability;
	
	public boolean isVisability() {
		return visability;
	}

	public void setVisability(boolean visability) {
		this.visability = visability;
	}

	@PrePersist
	protected void onCreate() {
		date = new Date();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
