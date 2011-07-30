package net.slipp.domain;

import static net.slipp.domain.DiaryTest.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import net.slipp.support.AbstractDaoTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DiaryDaoTest extends AbstractDaoTest {
	private DiaryDao dut;
	
	@Before
	public void setup() {
		helper.setUp();
		assertNotNull(objectifyFactory);
		
		dut = new DiaryDao();
		dut.setObjectifyFactory(objectifyFactory);
	}
	
	@Test
	public void base() throws Exception {
		Diary diary = diary1();
		dut.put(diary);
		
		Long id = diary.id;
		assertThat(dut.findById(diary.id), is(diary));
		
		diary = new Diary(id, "title1", "contents1", new Date());
		dut.put(diary);
		assertThat(diary.id, is(id));
		assertThat(dut.findById(diary.id), is(diary));	
		
		dut.delete(diary.id);
		assertThat(dut.findById(diary.id), nullValue());
	}
	
	@Test
	public void list() throws Exception {
		Diary diary1 = diary1();
		dut.put(diary1);
		Diary diary2 = diary2();
		dut.put(diary2);
		
		List<Diary> diaries = dut.finds(3);
		assertThat(diaries.size(), is(2));
		assertThat(diaries, is(Arrays.asList(diary2, diary1)));
	}
	
	@Test
	public void findsBeforeDiary() throws Exception {
		Diary diary1 = diary1();dut.put(diary1);
		Diary diary2 = diary2();dut.put(diary2);
		Diary diary3 = diary3();dut.put(diary3);
		
		List<Diary> diaries = dut.findsBeforeDiary(diary3);
		assertThat(diaries.size(), is(2));
		assertThat(diaries, is(Arrays.asList(diary2, diary1)));
	}
	
	@Test
	public void commented() throws Exception {
		Diary diary = diary1();
		diary.commented();
		assertThat(diary.getCommentCount(), is(1));
	}
	
	@After
	public void teardown() {
		helper.tearDown();
	}
}
