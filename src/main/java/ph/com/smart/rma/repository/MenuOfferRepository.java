package ph.com.smart.rma.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ph.com.smart.rma.model.MenuOffer;

public interface MenuOfferRepository extends JpaRepository<MenuOffer, Long> {
	List<MenuOffer> findAllByOrderByLevelId();
}
