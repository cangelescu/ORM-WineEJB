package com.cangelescu.wine.convertor;

import com.cangelescu.wine.dto.AutoRestockDTO;
import com.cangelescu.wine.dto.StockClientB2BDTO;
import com.cangelescu.wine.model.AutoRestock;
import com.cangelescu.wine.util.SuperConverter;

public class AutoRestockToDTO implements SuperConverter<AutoRestock, AutoRestockDTO> {

	@Override
	public AutoRestockDTO apply(AutoRestock t) {
		AutoRestockDTO autoRestockDTO = new AutoRestockDTO();
		StockClientB2BDTO stockClientB2B = new StockClientB2BDTO();
		autoRestockDTO.setId(t.getId());
		autoRestockDTO.setActive(t.isActive());
		autoRestockDTO.setLimit(t.getLimit());
		autoRestockDTO.setStockClientB2B(stockClientB2B);
		return autoRestockDTO;
	}

}
