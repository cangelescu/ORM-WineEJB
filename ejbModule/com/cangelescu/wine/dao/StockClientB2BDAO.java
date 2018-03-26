package com.cangelescu.wine.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cangelescu.wine.dto.ClientB2BDTO;
import com.cangelescu.wine.dto.StockClientB2BDTO;
import com.cangelescu.wine.dto.StockSupplierDTO;
import com.example.finalprojectejb.model.ClientB2B;
import com.example.finalprojectejb.model.StockClientB2B;
import com.example.finalprojectejb.model.StockSupplier;

/**
 * Session Bean implementation class StockClientB2BDAO
 */
@Stateless
public class StockClientB2BDAO implements StockClientB2BDAORemote {
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public StockClientB2BDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(StockClientB2BDTO entity) {
		StockClientB2B stockClientB2B=new StockClientB2B();
		dtoToStockClientB2B(entity, stockClientB2B);
		entityManager.persist(stockClientB2B);
		
	}

	@Override
	public StockClientB2BDTO findById(int id) {
		StockClientB2BDTO stockClientB2BDTO = new StockClientB2BDTO();
		StockClientB2B stockClientB2B= entityManager.find(StockClientB2B.class, id);
		stockClientB2BToDto(stockClientB2B, stockClientB2BDTO);
		return stockClientB2BDTO;
	}

	@Override
	public void delete(StockClientB2BDTO entity) {
		StockClientB2B stockClientB2B=new StockClientB2B();
		dtoToStockClientB2B(entity, stockClientB2B);
		entityManager.remove(stockClientB2B);
		
	}

	@Override
	public void update(StockClientB2BDTO entity) {
		StockClientB2B stockClientB2B=new StockClientB2B();
		dtoToStockClientB2B(entity, stockClientB2B);
		entityManager.merge(stockClientB2B);
		
	}
	
public static void dtoToStockClientB2B(StockClientB2BDTO stockClientB2BDTO, StockClientB2B stockClientB2B) {
		
	ClientB2B clientB2B=new ClientB2B();
	ClientB2BDAO.dtoToClientB2B(stockClientB2BDTO.getClientB2B(), clientB2B);
	
	List<StockSupplier> supplierStocks=new ArrayList<StockSupplier>();
		
	stockClientB2B.setId(stockClientB2BDTO.getId())
			.setActive(stockClientB2BDTO.isActive())
			.setLimitQuantity(stockClientB2BDTO.getLimitQuantity())
			.setPrice(stockClientB2BDTO.getPrice())
			.setQuantity(stockClientB2BDTO.getQuantity())
			.setClientB2B(clientB2B)
			.setSupplierStocks(supplierStocks);
	
	//to do supplier stocks
	}

	public static void stockClientB2BToDto( StockClientB2B stockClientB2B, StockClientB2BDTO stockClientB2BDTO) {
		
	ClientB2BDTO clientB2BDTO=new ClientB2BDTO();
	ClientB2BDAO.clientB2BToDto(stockClientB2B.getClientB2B(), clientB2BDTO);
	
	List<StockSupplierDTO> supplierStocksDTO=new ArrayList<StockSupplierDTO>();
		
	stockClientB2BDTO.setId(stockClientB2B.getId())
			.setActive(stockClientB2B.isActive())
			.setLimitQuantity(stockClientB2B.getLimitQuantity())
			.setPrice(stockClientB2B.getPrice())
			.setQuantity(stockClientB2B.getQuantity())
			.setClientB2B(clientB2BDTO)
			.setSupplierStocks(supplierStocksDTO);
	
	
	//todo supplier stocks
	}

}
