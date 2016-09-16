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
@Table(name="RMA_MENU_BRANDS")
@JsonInclude(Include.NON_NULL)
public class MenuBrand {
	
	@Id
	@Column(name="BRAND_ID")
//	@GeneratedValue(strategy=GenerationType.AUTO)
	Long id;
	
	@Column(name="BRAND")
	String title;
	
	@Column(name="RESURL")
	String resUrl;

	@JsonIgnore
	public Long getId() {
		return id;
	}
	
	@OrderBy("levelId ASC")
	@OneToMany
	@JoinColumn(name="BRAND_ID", referencedColumnName="BRAND_ID")
	List<MenuOffer> items;

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getResUrl() {
		return resUrl;
	}

	public void setResUrl(String resUrl) {
		this.resUrl = resUrl;
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
