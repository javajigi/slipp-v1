package net.slipp.domain;

import java.io.StringWriter;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.eclipse.mylyn.wikitext.confluence.core.ConfluenceLanguage;
import org.eclipse.mylyn.wikitext.core.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.core.parser.builder.HtmlDocumentBuilder;

import com.googlecode.objectify.annotation.Unindexed;

@Entity
public class Comment {
	@Id
	private Long id;
	private ServiceType serviceType;
	private String nickname;
	private String email;
	@Unindexed
	private String contents;
	private Date createdDate;
	@Unindexed
	private String ipAddress;
	private Long commentedId;

	public Comment() {
	}

	public Comment(ServiceType serviceType, Long commentedId, String nickname, String email, String contents, Date createdDate, String ipAddress) {
		this(null, serviceType, commentedId, nickname, email, contents, createdDate, ipAddress);
	}
	
	public Comment(Long id, ServiceType serviceType, Long commentedId, String nickname, String email, String contents, Date createdDate, String ipAddress) {
		this.id = id;
		this.serviceType = serviceType;
		this.commentedId = commentedId;
		this.nickname = nickname;
		this.email = email;
		this.contents = contents;
		this.createdDate = createdDate;
		this.ipAddress = ipAddress;
	}

	public Long getId() {
		return id;
	}
	
	public ServiceType getServiceType() {
		return serviceType;
	}

	public String getNickname() {
		return nickname;
	}

	public String getEmail() {
		return email;
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

	public String getIpAddress() {
		return ipAddress;
	}
	
	public Long getCommentedId() {
		return commentedId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((commentedId == null) ? 0 : commentedId.hashCode());
		result = prime * result + ((contents == null) ? 0 : contents.hashCode());
		result = prime * result + ((createdDate == null) ? 0 : createdDate.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((ipAddress == null) ? 0 : ipAddress.hashCode());
		result = prime * result + ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result + ((serviceType == null) ? 0 : serviceType.hashCode());
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
		Comment other = (Comment) obj;
		if (commentedId == null) {
			if (other.commentedId != null)
				return false;
		} else if (!commentedId.equals(other.commentedId))
			return false;
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (ipAddress == null) {
			if (other.ipAddress != null)
				return false;
		} else if (!ipAddress.equals(other.ipAddress))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (serviceType != other.serviceType)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", serviceType=" + serviceType + ", nickname=" + nickname + ", email=" + email
				+ ", contents=" + contents + ", createdDate=" + createdDate + ", ipAddress=" + ipAddress
				+ ", commentedId=" + commentedId + "]";
	}
}
