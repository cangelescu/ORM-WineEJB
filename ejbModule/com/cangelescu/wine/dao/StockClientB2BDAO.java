package com.cangelescu.wine.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cangelescu.wine.dto.ClientB2BDTO;
import com.cangelescu.wine.dto.OrderStockDTO;
import com.cangelescu.wine.dto.StockClientB2BDTO;
import com.cangelescu.wine.model.ClientB2B;
import com.cangelescu.wine.model.OrderStock;
import com.cangelescu.wine.model.StockClientB2B;

/**
 * Session Bean implementation class StockClientB2BDAO
 */
@Stateless
public class StockClientB2BDAO implements StockClientB2BDAORemote {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insert(StockClientB2BDTO entity) {
		StockClientB2B stockClientB2B = new StockClientB2B();
		dtoToStockClientB2B(entity, stockClientB2B);
		entityManager.persist(stockClientB2B);
	}

	@Override
	public StockClientB2BDTO findById(int id) {
		StockClientB2BDTO stockClientB2BDTO = new StockClientB2BDTO();
		StockClientB2B stockClientB2B = entityManager.find(StockClientB2B.class, id);
		stockClientB2BToDto(stockClientB2B, stockClientB2BDTO);
		return stockClientB2BDTO;
	}

	@Override
	public void delete(StockClientB2BDTO entity) {
		StockClientB2B stockClientB2B = new StockClientB2B();
		dtoToStockClientB2B(entity, stockClientB2B);
		entityManager.remove(stockClientB2B);
	}

	@Override
	public void update(StockClientB2BDTO entity) {
		StockClientB2B stockClientB2B = new StockClientB2B();
		dtoToStockClientB2B(entity, stockClientB2B);
		entityManager.merge(stockClientB2B);
	}

	public static void dtoToStockClientB2B(StockClientB2BDTO stockClientB2BDTO, StockClientB2B stockClientB2B) {
		ClientB2B clientB2B = new ClientB2B();
		ClientB2BDAO.dtoToClientB2B(stockClientB2BDTO.getClientB2B(), clientB2B);
		List<OrderStock> supplierStocks = new ArrayList<>();
		stockClientB2B.setId(stockClientB2BDTO.getId());
		stockClientB2B.setQuantity(stockClientB2BDTO.getQuantity());
		stockClientB2B.setPrice(stockClientB2BDTO.getPrice());
		stockClientB2B.setQuantity(stockClientB2BDTO.getQuantity());
		stockClientB2B.setClientB2B(clientB2B);
		stockClientB2B.setOrderStock(supplierStocks);
	}

	public static void stockClientB2BToDto(StockClientB2B stockClientB2B, StockClientB2BDTO stockClientB2BDTO) {
		ClientB2BDTO clientB2BDTO = new ClientB2BDTO();
		ClientB2BDAO.clientB2BToDto(stockClientB2B.getClientB2B(), clientB2BDTO);
		List<OrderStockDTO> supplierStocksDTO = new ArrayList<>();
		stockClientB2BDTO.setId(stockClientB2B.getId());
		stockClientB2BDTO.setQuantity(stockClientB2B.getQuantity());
		stockClientB2BDTO.setPrice(stockClientB2B.getPrice());
		stockClientB2BDTO.setQuantity(stockClientB2B.getQuantity());
		stockClientB2BDTO.setClientB2B(clientB2BDTO);
		stockClientB2BDTO.setOrderStock(supplierStocksDTO);
	}

}
