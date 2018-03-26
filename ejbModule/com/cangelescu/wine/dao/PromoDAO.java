package com.cangelescu.wine.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cangelescu.wine.dto.PromoDTO;
import com.cangelescu.wine.dto.StockSupplierDTO;
import com.example.finalprojectejb.model.Promo;
import com.example.finalprojectejb.model.StockSupplier;


/**
 * Session Bean implementation class PromoDAO
 */
@Stateless
public class PromoDAO implements PromoDAORemote {
	
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public PromoDAO() {
    
    }

	@Override
	public void insert(PromoDTO entity) {
		Promo promo=new Promo();
		dtoToPromo(entity, promo);
		entityManager.persist(promo);
		
	}

	@Override
	public PromoDTO findById(int id) {
		PromoDTO promoDTO = new PromoDTO();
		Promo promo= entityManager.find(Promo.class, id);
	    promoToDto(promo, promoDTO);
		return promoDTO;
	}

	@Override
	public void delete(PromoDTO entity) {
		Promo promo=new Promo();
		dtoToPromo(entity, promo);
		entityManager.remove(promo);
		
	}

	@Override
	public void update(PromoDTO entity) {
		Promo promo=new Promo();
		dtoToPromo(entity, promo);
		entityManager.merge(promo);
		
	}
	
	public static void dtoToPromo(PromoDTO promoDTO, Promo promo) {
		
		StockSupplier stockSupplier=new StockSupplier();
	//	StockSupplierDAO.dtoToStockSupplier(promoDTO.getStockSupplier(), stockSupplier);
		
		promo.setId(promoDTO.getId())
			.setDiscount(promoDTO.getDiscount())
			.setStartDate(promoDTO.getStartDate())
			.setEndDate(promoDTO.getEndDate())
			.setStockSupplier(stockSupplier);
	}

	public static void promoToDto(Promo promo, PromoDTO promoDTO) {
		StockSupplierDTO stockSupplierDTO=new StockSupplierDTO();
	//	StockSupplierDAO.dtoToStockSupplier(promo.getStockSupplier(), stockSupplierDTO);
		
		promoDTO.setId(promo.getId())
		.setDiscount(promo.getDiscount())
		.setStartDate(promo.getStartDate())
		.setEndDate(promo.getEndDate())
		.setStockSupplier(stockSupplierDTO);
	}

}
