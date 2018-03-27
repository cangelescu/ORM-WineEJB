package com.cangelescu.wine.convertor;

import java.util.ArrayList;
import java.util.List;

import com.cangelescu.wine.dto.StockSupplierDTO;
import com.cangelescu.wine.dto.WineDTO;
import com.cangelescu.wine.model.Wine;
import com.cangelescu.wine.util.SuperConverter;

public class WineToDTOConvertor implements SuperConverter<Wine, WineDTO> {

	@Override
	public WineDTO apply(Wine t) {
		WineDTO wineDto = new WineDTO();
		List<StockSupplierDTO> stockSupplierDTO = new ArrayList<>();
		wineDto.setId(t.getId());
		wineDto.setDescription(t.getDescription());
		wineDto.setName(t.getName());
		wineDto.setType(t.getType());
		wineDto.setSoi(t.getSoi());
		wineDto.setStockSupplier(stockSupplierDTO);
		return wineDto;
	}

}
