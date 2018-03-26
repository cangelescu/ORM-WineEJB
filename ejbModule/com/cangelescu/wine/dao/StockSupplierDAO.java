package com.cangelescu.wine.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cangelescuwine.dto.PromoDTO;
import com.cangelescuwine.dto.StockClientB2BDTO;
import com.cangelescuwine.dto.StockSupplierDTO;
import com.cangelescuwine.dto.SupplierDTO;
import com.cangelescuwine.dto.WineDTO;
import com.example.finalprojectejb.model.Promo;
import com.example.finalprojectejb.model.StockClientB2B;
import com.example.finalprojectejb.model.StockSupplier;
import com.example.finalprojectejb.model.Supplier;
import com.example.finalprojectejb.model.Wine;

/**
 * Session Bean implementation class StockSupplierDAO
 */
@Stateless
public class StockSupplierDAO implements StockSupplierDAORemote {
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public StockSupplierDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(StockSupplierDTO entity) {
		StockSupplier stockSupplier=new StockSupplier();
		dtoToStockSupplier(entity, stockSupplier);
		entityManager.persist(stockSupplier);
		
	}

	@Override
	public StockSupplierDTO findById(int id) {
		StockSupplierDTO stockSupplierDTO = new StockSupplierDTO();
		StockSupplier stocSupplier= entityManager.find(StockSupplier.class, id);
	    stockSupplierToDto(stocSupplier, stockSupplierDTO);
		return stockSupplierDTO;
	}

	@Override
	public void delete(StockSupplierDTO entity) {
		StockSupplier stockSupplier=new StockSupplier();
		dtoToStockSupplier(entity, stockSupplier);
		entityManager.remove(stockSupplier);
		
	}

	@Override
	public void update(StockSupplierDTO entity) {
		StockSupplier stockSupplier=new StockSupplier();
		dtoToStockSupplier(entity, stockSupplier);
		entityManager.merge(stockSupplier);
		
	}
	
	public static void dtoToStockSupplier(StockSupplierDTO stockSupplierDTO, StockSupplier stockSupplier) {

		StockClientB2B stockClientB2B=new StockClientB2B();
		StockClientB2BDAO.dtoToStockClientB2B(stockSupplierDTO.getStockClientB2B(), stockClientB2B);
		
		Supplier supplier=new Supplier();
	//	SupplierDAO.dtoToSupplier(stockSupplierDTO.getSupplier(),supplier);
		
		Wine wine =new Wine();
		//WineDAO.dtoToWine(stockSupplierDTO.getWine(), wine);
		
		List<Promo> promotions=new ArrayList<Promo>();
		for(int i=0;i<stockSupplierDTO.getPromotions().size();i++) {
			Promo promo=new Promo();
			PromoDAO.dtoToPromo(stockSupplierDTO.getPromotions().get(i), promo);
			promotions.add(promo);
		}

		stockSupplier.setId(stockSupplierDTO.getId())
			.setPrice(stockSupplierDTO.getPrice())
			.setQuantity(stockSupplierDTO.getQuantity())
			.setStockClientB2B(stockClientB2B)
			.setSupplier(supplier)
			.setWine(wine)
			.setPromotions(promotions);
	}

	public static void stockSupplierToDto(StockSupplier stockSupplier, StockSupplierDTO stockSupplierDTO) {
		StockClientB2BDTO stockClientB2BDTO =new StockClientB2BDTO();
		StockClientB2BDAO.stockClientB2BToDto(stockSupplier.getStockClientB2B(), stockClientB2BDTO);
		
		SupplierDTO supplierDTO=new SupplierDTO();
	//	SupplierDAO.supplierToDto(stockSupplier.getSupplier(),supplierDTO);
		
		WineDTO wineDTO =new WineDTO();
		//WineDAO.wineToDto(stockSupplier.getWine(), wineDTO);
		
		List<PromoDTO> promotionsDTO=new ArrayList<PromoDTO>();
		for(int i=0;i<stockSupplier.getPromotions().size();i++) {
			PromoDTO promoDTO=new PromoDTO();
			PromoDAO.promoToDto(stockSupplier.getPromotions().get(i), promoDTO);
			promotionsDTO.add(promoDTO);
		}

		stockSupplierDTO.setId(stockSupplier.getId())
			.setPrice(stockSupplier.getPrice())
			.setQuantity(stockSupplier.getQuantity())
			.setStockClientB2B(stockClientB2BDTO)
			.setSupplier(supplierDTO)
			.setWine(wineDTO)
			.setPromotions(promotionsDTO);
	}

}
