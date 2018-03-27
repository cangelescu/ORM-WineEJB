package com.cangelescu.wine.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cangelescu.wine.dto.PromoDTO;
import com.cangelescu.wine.dto.StockSupplierDTO;
import com.cangelescu.wine.dto.SupplierDTO;
import com.cangelescu.wine.dto.WineDTO;
import com.cangelescu.wine.model.Promo;
import com.cangelescu.wine.model.StockSupplier;
import com.cangelescu.wine.model.Supplier;
import com.cangelescu.wine.model.Wine;

/**
 * Session Bean implementation class StockSupplierDAO
 */
@Stateless
public class StockSupplierDAO implements StockSupplierDAORemote {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insert(StockSupplierDTO entity) {
		StockSupplier stockSupplier = new StockSupplier();
		dtoToStockSupplier(entity, stockSupplier);
		entityManager.persist(stockSupplier);
	}

	@Override
	public StockSupplierDTO findById(int id) {
		StockSupplierDTO stockSupplierDTO = new StockSupplierDTO();
		StockSupplier stocSupplier = entityManager.find(StockSupplier.class, id);
		stockSupplierToDto(stocSupplier, stockSupplierDTO);
		return stockSupplierDTO;
	}

	@Override
	public void delete(StockSupplierDTO entity) {
		StockSupplier stockSupplier = new StockSupplier();
		dtoToStockSupplier(entity, stockSupplier);
		entityManager.remove(stockSupplier);
	}

	@Override
	public void update(StockSupplierDTO entity) {
		StockSupplier stockSupplier = new StockSupplier();
		dtoToStockSupplier(entity, stockSupplier);
		entityManager.merge(stockSupplier);
	}

	public static void dtoToStockSupplier(StockSupplierDTO stockSupplierDTO, StockSupplier stockSupplier) {
		Supplier supplier = new Supplier();
		// SupplierDAO.dtoToSupplier(stockSupplierDTO.getSupplier(),supplier);
		Wine wine = new Wine();
		// WineDAO.dtoToWine(stockSupplierDTO.getWine(), wine);
		List<Promo> promotions = new ArrayList<Promo>();
		for (int i = 0; i < stockSupplierDTO.getPromos().size(); i++) {
			Promo promo = new Promo();
			PromoDAO.dtoToPromo(stockSupplierDTO.getPromos().get(i), promo);
			promotions.add(promo);
		}

		stockSupplier.setId(stockSupplierDTO.getId());
		stockSupplier.setPrice(stockSupplierDTO.getPrice());
		stockSupplier.setQuantity(stockSupplierDTO.getQuantity());
		stockSupplier.setSupplier(supplier);
		stockSupplier.setWine(wine);
		stockSupplier.setPromos(promotions);
	}

	public static void stockSupplierToDto(StockSupplier stockSupplier, StockSupplierDTO stockSupplierDTO) {
		SupplierDTO supplierDTO = new SupplierDTO();
		// SupplierDAO.supplierToDto(stockSupplier.getSupplier(),supplierDTO);
		WineDTO wineDTO = new WineDTO();
		// WineDAO.wineToDto(stockSupplier.getWine(), wineDTO);
		List<PromoDTO> promotionsDTO = new ArrayList<PromoDTO>();
		for (int i = 0; i < stockSupplier.getPromos().size(); i++) {
			PromoDTO promoDTO = new PromoDTO();
			PromoDAO.promoToDto(stockSupplier.getPromos().get(i), promoDTO);
			promotionsDTO.add(promoDTO);
		}

		stockSupplierDTO.setId(stockSupplier.getId());
		stockSupplierDTO.setPrice(stockSupplier.getPrice());
		stockSupplierDTO.setQuantity(stockSupplier.getQuantity());
		stockSupplierDTO.setSupplier(supplierDTO);
		stockSupplierDTO.setWine(wineDTO);
		stockSupplierDTO.setPromos(promotionsDTO);
	}

}
