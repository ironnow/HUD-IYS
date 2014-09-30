package hud.iys.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="MevzuatIcerikEsleme")
public class MevzuatIcerikEsleme {

	 private Long mevzuatIcerikEslemeId;
	 private Long mevzuatId;
	 private Long mevzuatIcerikTipId;
	 
	 @Id
	 @Column(name="MevzuatIcerikEslemeID")
	 @GeneratedValue(strategy=GenerationType.AUTO)
	 public Long getMevzuatIcerikEslemeId() {
		 return mevzuatIcerikEslemeId;
	 }
	
	 public void setMevzuatIcerikEslemeId(Long id) {
		 this.mevzuatIcerikEslemeId = id;
	 }

	@Column(name="MevzuatID")
	public Long getMevzuatId() {
		return mevzuatId;
	}

	public void setMevzuatId(Long mevzuatId) {
		this.mevzuatId = mevzuatId;
	}

	@Column(name="MevzuatIcerikTipID")
	public Long getMevzuatIcerikTipId() {
		return mevzuatIcerikTipId;
	}

	public void setMevzuatIcerikTipId(Long mevzuatIcerikTipId) {
		this.mevzuatIcerikTipId = mevzuatIcerikTipId;
	}
	
}