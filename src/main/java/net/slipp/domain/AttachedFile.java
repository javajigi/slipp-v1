package net.slipp.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AttachedFile {
	@Id
	private Long id;
	private ServiceType serviceType;
	private Long contentsId;
	private String blobKey;
	
	public AttachedFile() {
	}

	public AttachedFile(ServiceType serviceType, Long contentsId, String blobKey) {
		this.serviceType = serviceType;
		this.contentsId = contentsId;
		this.blobKey = blobKey;
	}

	public Long getId() {
		return id;
	}

	public ServiceType getServiceType() {
		return serviceType;
	}
	
	public Long getContentsId() {
	    return contentsId;
    }
	
	public String getBlobKey() {
		return blobKey;
	}
}
