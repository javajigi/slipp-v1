package net.slipp.domain;

import java.util.Date;

public class CommentTest {
	public static final Comment COMMENT1 = new Comment(1L, ServiceType.diaries, 10L, "javajigi", "javajigi@gmail.com", "parent_contents", new Date(), "127.0.0.1");
	public static final Comment COMMENT2 = new Comment(2L, ServiceType.diaries, 10L, "javajigi", "javajigi@gmail.com", "child1", new Date(), "127.0.0.1");
	public static final Comment COMMENT3 = new Comment(3L, ServiceType.diaries, 10L, "javajigi", "javajigi@gmail.com", "child2", new Date(), "127.0.0.1");
}
