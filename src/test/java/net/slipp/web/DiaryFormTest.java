package net.slipp.web;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;
import net.slipp.domain.Diary;

import org.junit.Test;

public class DiaryFormTest {
	private DiaryForm dut = new DiaryForm();
	
	@Test
	public void getCreatedDateTime() throws Exception {
		dut.setCreatedDate("2010-11-15");
		dut.setCreatedHour(3);
		dut.setCreatedMinute(30);
		
		assertThat(dut.getCreatedDateTime(), notNullValue());
	}
	
	@Test
	public void getCreatedDateTime_when_is_null_createdDate() throws Exception {
		assertThat(dut.getCreatedDateTime(), notNullValue());
	}
	
	@Test
	public void diaryFormToDiary() throws Exception {
		dut = new DiaryForm(1L, "title", "contents", "2010-11-15", 3, 30);
		Diary diary = dut.to();
		Diary expected = new Diary(1L, "title", "contents", dut.getDateTime("2010-11-15 03:30"));
		assertThat(diary, is(expected));
	}
	
	@Test
	public void diaryFormFromDiary() throws Exception {
		Diary diary = new Diary(1L, "title", "contents", dut.getDateTime("2010-11-15 03:30"));
		DiaryForm diaryForm = dut.from(diary);
		
		DiaryForm expected = new DiaryForm(1L, "title", "contents", "2010-11-15", 3, 30);
		assertThat(diaryForm, is(expected));
	}
}
