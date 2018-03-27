package com.cangelescu.wine.convertor;

import java.util.ArrayList;
import java.util.List;

import com.cangelescu.wine.dto.ClientB2CDTO;
import com.cangelescu.wine.dto.OrderDTO;
import com.cangelescu.wine.model.ClientB2C;
import com.cangelescu.wine.util.SuperConverter;

public class ClientB2CtoDTOConvertor implements SuperConverter<ClientB2C, ClientB2CDTO> {

	@Override
	public ClientB2CDTO apply(ClientB2C t) {
		ClientB2CDTO clientB2CDTO = new ClientB2CDTO();
		List<OrderDTO> orderDTO = new ArrayList<>();
		clientB2CDTO.setId(t.getId());
		clientB2CDTO.setAddress(t.getAddress());
		clientB2CDTO.setCnp(t.getCnp());
		clientB2CDTO.setEmail(t.getEmail());
		clientB2CDTO.setFirstName(t.getFirstName());
		clientB2CDTO.setLastName(t.getLastName());
		clientB2CDTO.setOrders(orderDTO);
		clientB2CDTO.setPassword(t.getPassword());
		clientB2CDTO.setRegisterDate(t.getRegisterDate());
		clientB2CDTO.setUsername(t.getUsername());
		return clientB2CDTO;
	}

}
