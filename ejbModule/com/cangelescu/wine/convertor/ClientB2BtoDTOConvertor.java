package com.cangelescu.wine.convertor;

import java.util.ArrayList;
import java.util.List;

import com.cangelescu.wine.dto.ClientB2BDTO;
import com.cangelescu.wine.dto.StockClientB2BDTO;
import com.cangelescu.wine.model.ClientB2B;
import com.cangelescu.wine.util.SuperConverter;

public class ClientB2BtoDTOConvertor implements SuperConverter<ClientB2B, ClientB2BDTO> {

	@Override
	public ClientB2BDTO apply(ClientB2B t) {
		ClientB2BDTO clientB2BDTO = new ClientB2BDTO();
		List<StockClientB2BDTO> stockClientB2BDTO = new ArrayList<>();
		clientB2BDTO.setId(t.getId());
		clientB2BDTO.setAddress(t.getAddress());
		clientB2BDTO.setCompanyName(t.getCompanyName());
		clientB2BDTO.setCui(t.getCui());
		clientB2BDTO.setPassword(t.getPassword());
		clientB2BDTO.setSubscribed(t.isSubscribed());
		clientB2BDTO.setStockClientB2B(stockClientB2BDTO);
		clientB2BDTO.setUsername(t.getUsername());
		clientB2BDTO.setVisibility(t.isVisibility());
		return clientB2BDTO;
	}

}
