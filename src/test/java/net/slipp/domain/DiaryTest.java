package net.slipp.domain;

import java.util.Date;

public class DiaryTest {
	private static final long now = System.currentTimeMillis();
	
	public static Diary diary1() {
		return new Diary("title1", "contents1", new Date(now));
	}
	
	public static Diary diary2() {
		return new Diary("title1", "contents1", new Date(now+1000));
	}
	
	public static Diary diary3() {
		return new Diary("title1", "contents1", new Date(now+2000));
	}
}
