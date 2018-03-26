package com.cangelescu.wine.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import com.cangelescu.wine.dto.PromoDTO;
import com.cangelescu.wine.dto.StockClientB2BDTO;
import com.cangelescu.wine.dto.StockSupplierDTO;
import com.cangelescu.wine.dto.SupplierDTO;
import com.cangelescu.wine.dto.WineDTO;
import com.example.finalprojectejb.model.Promo;
import com.example.finalprojectejb.model.StockClientB2B;
import com.example.finalprojectejb.model.StockSupplier;
import com.example.finalprojectejb.model.Supplier;
import com.example.finalprojectejb.model.Wine;

/**
 * Session Bean implementation class SupplierDAO
 */
@Stateless
public class SupplierDAO implements SupplierDAORemote {

    /**
     * Default constructor. 
     */
    public SupplierDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(SupplierDTO entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SupplierDTO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(SupplierDTO entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SupplierDTO entity) {
		// TODO Auto-generated method stub
		
	}
	
	/*public static void dtoToSupplier(SupplierDTO SupplierDTO, StockSupplier stockSupplier) {

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
*/

}
