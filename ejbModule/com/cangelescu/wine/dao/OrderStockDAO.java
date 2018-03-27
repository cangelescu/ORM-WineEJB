package com.cangelescu.wine.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cangelescu.wine.dto.OrderDTO;
import com.cangelescu.wine.dto.OrderStockDTO;
import com.cangelescu.wine.dto.StockClientB2BDTO;
import com.cangelescu.wine.model.Order;
import com.cangelescu.wine.model.OrderStock;
import com.cangelescu.wine.model.StockClientB2B;

/**
 * Session Bean implementation class OrderStockDAO
 */
@Stateless
public class OrderStockDAO implements OrderStockDAORemote {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insert(OrderStockDTO entity) {
		OrderStock OrderStock = new OrderStock();
		dtoToOrderStock(entity, OrderStock);
		entityManager.persist(OrderStock);
	}

	@Override
	public OrderStockDTO findById(int id) {
		OrderStockDTO OrderStockDTO = new OrderStockDTO();
		OrderStock OrderStock = entityManager.find(OrderStock.class, id);
		OrderStockToDto(OrderStock, OrderStockDTO);
		return OrderStockDTO;
	}

	@Override
	public void delete(OrderStockDTO entity) {
		OrderStock OrderStock = new OrderStock();
		dtoToOrderStock(entity, OrderStock);
		entityManager.remove(OrderStock);
	}

	@Override
	public void update(OrderStockDTO entity) {
		OrderStock OrderStock = new OrderStock();
		dtoToOrderStock(entity, OrderStock);
		entityManager.merge(OrderStock);
	}

	public static void dtoToOrderStock(OrderStockDTO OrderStockDTO, OrderStock OrderStock) {
		Order order = new Order();
		OrderDAO.dtoToOrder(OrderStockDTO.getOrder(), order);
		StockClientB2B stock = new StockClientB2B();
		StockClientB2BDAO.dtoToStockClientB2B(OrderStockDTO.getStockClientB2B(), stock);
		OrderStock.setId(OrderStockDTO.getId());
		OrderStock.setPrice(OrderStockDTO.getPrice());
		OrderStock.setQuantity(OrderStockDTO.getQuantity());
		OrderStock.setOrder(order);
		OrderStock.setStockClientB2B(stock);
	}

	public static void OrderStockToDto(OrderStock OrderStock, OrderStockDTO OrderStockDTO) {
		OrderDTO orderDTO = new OrderDTO();
		OrderDAO.OrderToDto(OrderStock.getOrder(), orderDTO);
		StockClientB2BDTO stockDTO = new StockClientB2BDTO();
		StockClientB2BDAO.stockClientB2BToDto(OrderStock.getStockClientB2B(), stockDTO);
		OrderStockDTO.setId(OrderStock.getId());
		OrderStockDTO.setPrice(OrderStock.getPrice());
		OrderStockDTO.setQuantity(OrderStock.getQuantity());
		OrderStockDTO.setOrder(orderDTO);
		OrderStockDTO.setStockClientB2B(stockDTO);
	}

}
