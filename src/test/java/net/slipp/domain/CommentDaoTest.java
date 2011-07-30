package net.slipp.domain;

import static net.slipp.domain.CommentTest.COMMENT1;
import static net.slipp.domain.CommentTest.COMMENT2;
import static net.slipp.domain.CommentTest.COMMENT3;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import net.slipp.support.AbstractDaoTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CommentDaoTest extends AbstractDaoTest {
	private CommentDao dut;
	
	@Before
	public void setUp(){
		helper.setUp();
		dut = new CommentDao();
		dut.setObjectifyFactory(objectifyFactory);
	}
	
	@Test
	public void base() throws Exception {
		dut.put(COMMENT1);
		Comment comment = dut.findById(COMMENT1.getId());
		assertNotNull(comment);
		assertThat(comment, is(COMMENT1));
	}
	
	@Test
	public void findServiceType() throws Exception {
		dut.put(COMMENT1);
		dut.put(COMMENT2);
		dut.put(COMMENT3);
		
		List<Comment> comments = dut.findByServiceType(ServiceType.diaries, COMMENT1.getCommentedId());
		assertThat(comments.size(), is(3));
	}
	
	@After
	public void tearDown() {
		helper.tearDown();
	}
}
