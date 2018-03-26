package com.cangelescu.wine.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cangelescuwine.dto.ClientOrderDTO;
import com.cangelescuwine.dto.OrderItemDTO;
import com.cangelescuwine.dto.StockClientB2BDTO;
import com.example.finalprojectejb.model.ClientOrder;
import com.example.finalprojectejb.model.OrderItem;
import com.example.finalprojectejb.model.StockClientB2B;

/**
 * Session Bean implementation class OrderItemDAO
 */
@Stateless
public class OrderItemDAO implements OrderItemDAORemote {
	
	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Default constructor.
	 */
	public OrderItemDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void insert(OrderItemDTO entity) {
		OrderItem orderItem=new OrderItem();
		dtoToOrderItem(entity, orderItem);
		entityManager.persist(orderItem);

	}

	@Override
	public OrderItemDTO findById(int id) {
		OrderItemDTO orderItemDTO = new OrderItemDTO();
		OrderItem orderItem= entityManager.find(OrderItem.class, id);
	    orderItemToDto(orderItem, orderItemDTO);
		return orderItemDTO;
	}

	@Override
	public void delete(OrderItemDTO entity) {
		OrderItem orderItem=new OrderItem();
		dtoToOrderItem(entity, orderItem);
		entityManager.remove(orderItem);

	}

	@Override
	public void update(OrderItemDTO entity) {
		OrderItem orderItem=new OrderItem();
		dtoToOrderItem(entity, orderItem);
		entityManager.merge(orderItem);

	}

	public static void dtoToOrderItem(OrderItemDTO orderItemDTO, OrderItem orderItem) {

		ClientOrder order = new ClientOrder();
		ClientOrderDAO.dtoToClientOrder(orderItemDTO.getOrder(), order);

		StockClientB2B stock = new StockClientB2B();
		StockClientB2BDAO.dtoToStockClientB2B(orderItemDTO.getStockClientB2B(), stock);

		orderItem.setId(orderItemDTO.getId())
			.setPrice(orderItemDTO.getPrice())
			.setQuantity(orderItemDTO.getQuantity())
			.setOrder(order)
			.setStockClientB2B(stock);

	}

	public static void orderItemToDto(OrderItem orderItem, OrderItemDTO orderItemDTO) {
		ClientOrderDTO orderDTO = new ClientOrderDTO();
		ClientOrderDAO.clientOrderToDto(orderItem.getOrder(), orderDTO);

		StockClientB2BDTO stockDTO = new StockClientB2BDTO();
		StockClientB2BDAO.stockClientB2BToDto(orderItem.getStockClientB2B(), stockDTO);

		orderItemDTO.setId(orderItem.getId())
				.setPrice(orderItem.getPrice())
				.setQuantity(orderItem.getQuantity())
				.setOrder(orderDTO)
				.setStockClientB2B(stockDTO);

	
	}

}
