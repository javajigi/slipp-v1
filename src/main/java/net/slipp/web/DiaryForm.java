package net.slipp.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang.StringUtils;

import net.slipp.domain.Diary;
import net.slipp.support.DateTimeUtils;

public class DiaryForm {
	private Long id;
	private String title;
	private String contents;
	private String createdDate;
	private int createdHour;
	private int createdMinute;

	public DiaryForm() {
	}

	public DiaryForm(Long id, String title, String contents,
			String createdDate, int createdHour, int createdMinute) {
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.createdDate = createdDate;
		this.createdHour = createdHour;
		this.createdMinute = createdMinute;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public int getCreatedHour() {
		return createdHour;
	}

	public void setCreatedHour(int createdHour) {
		this.createdHour = createdHour;
	}

	public int getCreatedMinute() {
		return createdMinute;
	}

	public void setCreatedMinute(int createdMinute) {
		this.createdMinute = createdMinute;
	}

	public Diary to() {
		return new Diary(getId(), getTitle(), getContents(),
				getCreatedDateTime());
	}

	public DiaryForm from(Diary diary) {
		DiaryForm diaryForm = new DiaryForm();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(diary.getCreatedDate());
		diaryForm.setId(diary.getId());
		diaryForm.setTitle(diary.getTitle());
		diaryForm.setContents(diary.getContents());
		diaryForm.setCreatedDate(getDate(diary.getCreatedDate()));
		diaryForm.setCreatedHour(calendar.get(Calendar.HOUR_OF_DAY));
		diaryForm.setCreatedMinute(calendar.get(Calendar.MINUTE));
		return diaryForm;
	}

	private String getDate(Date createdDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		return sdf.format(createdDate);
	}

	Date getCreatedDateTime() {
		if (StringUtils.isEmpty(getCreatedDate())) {
			return DateTimeUtils.now();
		}
		return getDateTime(getCreatedDate() + " " + getCreatedHour() + ":"
				+ getCreatedMinute());
	}

	Date getDateTime(String source) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			throw new IllegalArgumentException("Illegal Date Format!");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((contents == null) ? 0 : contents.hashCode());
		result = prime * result
				+ ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + createdHour;
		result = prime * result + createdMinute;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DiaryForm other = (DiaryForm) obj;
		if (contents == null) {
			if (other.contents != null)
				return false;
		} else if (!contents.equals(other.contents))
			return false;
		if (createdDate == null) {
			if (other.createdDate != null)
				return false;
		} else if (!createdDate.equals(other.createdDate))
			return false;
		if (createdHour != other.createdHour)
			return false;
		if (createdMinute != other.createdMinute)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
}
