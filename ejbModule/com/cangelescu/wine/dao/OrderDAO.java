package com.cangelescu.wine.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cangelescu.wine.dto.ClientB2CDTO;

import com.cangelescu.wine.dto.OrderDTO;
import com.cangelescu.wine.dto.OrderStockDTO;
import com.cangelescu.wine.model.ClientB2C;
import com.cangelescu.wine.model.Order;
import com.cangelescu.wine.model.OrderStock;

/**
 * Session Bean implementation class OrderDAO
 */
@Stateless
public class OrderDAO implements OrderDAORemote {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insert(OrderDTO entity) {
		Order order = new Order();
		dtoToOrder(entity, order);
		entityManager.persist(order);
	}

	@Override
	public OrderDTO findById(int id) {
		OrderDTO OrderDTO = new OrderDTO();
		Order order = entityManager.find(Order.class, id);
		OrderToDto(order, OrderDTO);
		return OrderDTO;
	}

	@Override
	public void delete(OrderDTO entity) {
		Order order = new Order();
		dtoToOrder(entity, order);
		entityManager.remove(order);
	}

	@Override
	public void update(OrderDTO entity) {
		Order order = new Order();
		dtoToOrder(entity, order);
		entityManager.merge(order);
	}

	public static void dtoToOrder(OrderDTO orderDTO, Order order) {
		List<OrderStock> orderItems = new ArrayList<>();
		ClientB2C clientB2C = new ClientB2C();
		ClientB2CDAO.dtoToClientB2C(orderDTO.getClientB2C(), clientB2C);
		order.setId(orderDTO.getId());
		order.setDate(orderDTO.getDate());
		order.setOrderNr(orderDTO.getOrderNr());
		order.setClientB2C(clientB2C);
		order.setOrderStock(orderItems);
	}

	public static void OrderToDto(Order order, OrderDTO orderDTO) {
		List<OrderStockDTO> orderItems = new ArrayList<>();
		ClientB2CDTO clientB2CDTO = new ClientB2CDTO();
		ClientB2CDAO.clientB2CToDto(order.getClientB2C(), clientB2CDTO);
		orderDTO.setId(order.getId());
		orderDTO.setDate(order.getDate());
		orderDTO.setOrderNr(order.getOrderNr());
		orderDTO.setClientB2C(clientB2CDTO);
		orderDTO.setOrderStock(orderItems);
	}

}
