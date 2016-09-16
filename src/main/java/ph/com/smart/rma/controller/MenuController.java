package ph.com.smart.rma.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ph.com.smart.rma.model.MenuBrand;
import ph.com.smart.rma.model.MenuOffer;
import ph.com.smart.rma.repository.MenuBrandRepository;
import ph.com.smart.rma.repository.MenuOfferRepository;

@RestController
public class MenuController {
	
	@Autowired
	MenuBrandRepository menuBrandRepository;
	
	@Autowired
	MenuOfferRepository menuOfferRepository;
	
	
	@RequestMapping(value="/brands",method=RequestMethod.GET)
	public List<MenuBrand> getBrands(){
		List<MenuBrand> menuBrands = menuBrandRepository.findAll();
		return menuBrands;
	}
	
	@RequestMapping(value="/offers",method=RequestMethod.GET)
	public List<MenuOffer> getOffers(){
		List<MenuOffer> menuOffers = menuOfferRepository.findAll();
		return menuOffers;
	}
	
}
