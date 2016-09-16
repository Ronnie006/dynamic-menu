package ph.com.smart.rma.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.PostLoad;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name="RMA_MENU_OFFERS")
@JsonInclude(Include.NON_NULL)
public class MenuOffer {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="OFFER_ID")
	Long offerId;
	
	@Column(name="OFFER_NAME")
	String title;
	
	@Column(name="KEYWORD")
	String keyword;
	
	@Column(name="ACCESS_CODE")
	String accessCode;
	
	@Column(name="BRAND_ID")
	Long brandId;
	
	@Column(name="LEVEL_ID")
	Long levelId;
	
	@Column(name="SRP")
	String srp;
	
	@Column(name="SPIEL")
	String promoSpiel;

	@OrderBy("levelId ASC")
	@OneToMany
	@JoinColumn(name="PRE_REQ",referencedColumnName="OFFER_ID")
	public List<MenuOffer> items;

	@JsonIgnore
	public Long getOfferId() {
		return offerId;
	}

	public void setOfferId(Long offerId) {
		this.offerId = offerId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getAccessCode() {
		return accessCode;
	}

	public void setAccessCode(String accessCode) {
		this.accessCode = accessCode;
	}

	@JsonIgnore
	public Long getLevelId() {
		return levelId;
	}

	public void setLevelId(Long levelId) {
		this.levelId = levelId;
	}

	public String getSrp() {
		return srp;
	}

	public void setSrp(String srp) {
		this.srp = srp;
	}
	
	public String getPromoSpiel() {
		return promoSpiel;
	}

	public void setPromoSpiel(String promoSpiel) {
		this.promoSpiel = promoSpiel;
	}
	
	@JsonIgnore
	public Long getBrandId() {
		return brandId;
	}

	public void setBrandId(Long brandId) {
		this.brandId = brandId;
	}

	public List<MenuOffer> getItems() {
		return items;
	}

	public void setItems(List<MenuOffer> items) {
		this.items = items;
	}

	@PostLoad
	public void checkItemsIfEmpty(){
		if(items.isEmpty()){
			items=null;
		}
	}
}
