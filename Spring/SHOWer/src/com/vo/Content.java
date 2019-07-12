package com.vo;

import org.springframework.web.multipart.MultipartFile;

public class Content {
	public int id;
	public int category;
	public String title;
	public String open;
	public String close;
	public String genre;
	public String poster;
	public String place;
	public int locx;
	public int locy;
	public String director;
	public String actor1;
	public String actor2;
	public String actor3;
	public int time;
	public String contry;
	public String grade;
	MultipartFile mf;
	public Content() {
	}
	public Content(int category, String title, String open, String close, String genre, String poster,
			String place, int locx, int locy, String director, String actor1, String actor2, String actor3, int time,
			String contry, String grade) {		
		this.category = category;
		this.title = title;
		this.open = open;
		this.close = close;
		this.genre = genre;
		this.poster = poster;
		this.place = place;
		this.locx = locx;
		this.locy = locy;
		this.director = director;
		this.actor1 = actor1;
		this.actor2 = actor2;
		this.actor3 = actor3;
		this.time = time;
		this.contry = contry;
		this.grade = grade;
	}
	
	public Content(int category, String title, String genre, String poster, String director, String actor1,
			String actor2, String actor3, int time, String contry, String grade) {
		//��ȭ �϶�	
		this.category = category;
		this.title = title;
		this.genre = genre;
		this.poster = poster;
		this.director = director;
		this.actor1 = actor1;
		this.actor2 = actor2;
		this.actor3 = actor3;
		this.place="1";
		this.open = "1";
		this.close = "1";
		this.locx = 1;
		this.locy = 1;
		this.time = time;
		this.contry = contry;
		this.grade = grade;
	}
	
	public Content(int category, String title, String open, String close, String genre, String poster,
			String place, int locx, int locy) {
		// ����/���� �϶�		
		this.category = category;
		this.title = title;
		this.open = open;
		this.close = close;
		this.genre = genre;
		this.poster = poster;
		this.place = place;
		this.locx = locx;
		this.locy = locy;
	}

	public MultipartFile getMf() {
		return mf;
	}

	public void setMf(MultipartFile mf) {
		this.mf = mf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getLocx() {
		return locx;
	}

	public void setLocx(int locx) {
		this.locx = locx;
	}

	public int getLocy() {
		return locy;
	}

	public void setLocy(int locy) {
		this.locy = locy;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor1() {
		return actor1;
	}

	public void setActor1(String actor1) {
		this.actor1 = actor1;
	}

	public String getActor2() {
		return actor2;
	}

	public void setActor2(String actor2) {
		this.actor2 = actor2;
	}

	public String getActor3() {
		return actor3;
	}

	public void setActor3(String actor3) {
		this.actor3 = actor3;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public String getContry() {
		return contry;
	}

	public void setContry(String contry) {
		this.contry = contry;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Content [id=" + id + ", category=" + category + ", title=" + title + ", open=" + open + ", close="
				+ close + ", genre=" + genre + ", poster=" + poster + ", place=" + place + ", locx=" + locx + ", locy="
				+ locy + ", director=" + director + ", actor1=" + actor1 + ", actor2=" + actor2 + ", actor3=" + actor3
				+ ", time=" + time + ", contry=" + contry + ", grade=" + grade + "]";
	}

}
