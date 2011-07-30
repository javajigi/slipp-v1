package net.slipp.domain;

import java.io.StringWriter;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import net.slipp.support.UrlGeneratable;

import org.eclipse.mylyn.wikitext.confluence.core.ConfluenceLanguage;
import org.eclipse.mylyn.wikitext.core.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.core.parser.builder.HtmlDocumentBuilder;

import com.googlecode.objectify.annotation.Unindexed;

@Entity
public class Diary implements UrlGeneratable {
	@Id
	Long id;
	@Unindexed
	private String title;
	@Unindexed
	private String contents;
	private Integer commentCount = 0;
	private Date createdDate;

	public Diary() {
	}

	public Diary(String title, String contents, Date createdDate) {
		this(null, title, contents, createdDate);
	}

	public Diary(Long id, String title, String contents, Date createdDate) {
		this.id = id;
		this.title = title;
		this.contents = contents;
		this.createdDate = createdDate;
	}

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getContents() {
		return contents;
	}

	public String getDisplayContents() {
		StringWriter writer = new StringWriter();
		HtmlDocumentBuilder builder = new HtmlDocumentBuilder(writer);
		builder.setEmitAsDocument(false);
		MarkupParser parser = new MarkupParser(new ConfluenceLanguage());
		parser.setBuilder(builder);
		parser.parse(getContents());
		return writer.toString();
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void commented() {
		commentCount++;
	}

	public Integer getCommentCount() {
		return commentCount;
	}
	
	@Override
	public String getUrl() {
		return "/diaries/" + getId();
	}

	@Override
	public String toString() {
		return "Diary [id=" + id + ", title=" + title + ", contents=" + contents + ", createdDate=" + createdDate + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
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
		Diary other = (Diary) obj;
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
