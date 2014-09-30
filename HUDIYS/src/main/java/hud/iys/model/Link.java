package hud.iys.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.Table;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="LINK")
public class Link {

	 private Long linkId;
	 private Long fromId;
	 private Long fromTypeId;
	 private Long toId;
	 private Long toTypeId;
	 
	 @Id
	 @Column(name="LinkID")
	 @GeneratedValue(strategy=GenerationType.AUTO)
	public Long getLinkId() {
		return linkId;
	}
	public void setLinkId(Long linkId) {
		this.linkId = linkId;
	}
	
	 @Column(name="fromId")
	public Long getFromId() {
		return fromId;
	}
	public void setFromId(Long fromId) {
		this.fromId = fromId;
	}
	
	 @Column(name="fromTypeId")
	public Long getFromTypeId() {
		return fromTypeId;
	}
	public void setFromTypeId(Long fromTypeId) {
		this.fromTypeId = fromTypeId;
	}
	
	@Column(name="toId")
	public Long getToId() {
		return toId;
	}
	public void setToId(Long toId) {
		this.toId = toId;
	}
	
	@Column(name="toTypeId")
	public Long getToTypeId() {
		return toTypeId;
	}
	public void setToTypeId(Long toTypeId) {
		this.toTypeId = toTypeId;
	}
	 
	 
	 
	 
}