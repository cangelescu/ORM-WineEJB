package com.cangelescu.wine.convertor;

import com.cangelescu.wine.dto.OrderDTO;
import com.cangelescu.wine.model.Order;
import com.cangelescu.wine.util.SuperConverter;

public class OrderToDTOCnvertor implements SuperConverter<Order, OrderDTO> {

	@Override
	public OrderDTO apply(Order t) {
		OrderDTO orderDTO = new OrderDTO();
		orderDTO.setId(t.getId());
		//orderDTO.setClientB2C(clientB2C);
		orderDTO.setDate(t.getDate());
		orderDTO.setOrderNr(t.getOrderNr());
		//orderDTO.setOrderStock(orderStock);
		return orderDTO;
	}

}
