package com.cangelescu.wine.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cangelescu.wine.dto.ClientB2BDTO;
import com.cangelescu.wine.dto.StockClientB2BDTO;
import com.cangelescu.wine.model.ClientB2B;
import com.cangelescu.wine.model.StockClientB2B;

/**
 * Session Bean implementation class ClientB2BDAO
 */
@Stateless
public class ClientB2BDAO implements ClientB2BDAORemote {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insert(ClientB2BDTO entity) {
		ClientB2B client = new ClientB2B();
		dtoToClientB2B(entity, client);
		entityManager.persist(client);
	}

	@Override
	public ClientB2BDTO findById(int id) {
		ClientB2BDTO clientB2BDTO = new ClientB2BDTO();
		ClientB2B client = entityManager.find(ClientB2B.class, id);
		clientB2BToDto(client, clientB2BDTO);
		return clientB2BDTO;
	}

	@Override
	public void delete(ClientB2BDTO entity) {
		ClientB2B client = new ClientB2B();
		dtoToClientB2B(entity, client);
		entityManager.remove(client);

	}

	@Override
	public void update(ClientB2BDTO entity) {
		ClientB2B client = new ClientB2B();
		dtoToClientB2B(entity, client);
		entityManager.merge(client);

	}

	public static void dtoToClientB2B(ClientB2BDTO clientB2BDTO, ClientB2B clientB2b) {

		List<StockClientB2B> stocks = new ArrayList<StockClientB2B>();

		clientB2b.setVisibility(clientB2BDTO.isVisibility());
		clientB2b.setCompanyName(clientB2BDTO.getCompanyName());
		clientB2b.setCui(clientB2BDTO.getCui());
		clientB2b.setSubscribed(clientB2BDTO.isSubscribed());
		clientB2b.setStockClientB2B(stocks);
		clientB2b.setId(clientB2BDTO.getId());
		clientB2b.setAddress(clientB2BDTO.getAddress());
		clientB2b.setEmail(clientB2BDTO.getEmail());
		clientB2b.setPassword(clientB2BDTO.getPassword());
		clientB2b.setUsername(clientB2BDTO.getUsername());

	}

	public static void clientB2BToDto(ClientB2B clientB2b, ClientB2BDTO clientB2BDTO) {
		List<StockClientB2BDTO> stocksDTO = new ArrayList<StockClientB2BDTO>();

		clientB2BDTO.setVisibility(clientB2b.isVisibility());
		clientB2BDTO.setCompanyName(clientB2b.getCompanyName());
		clientB2BDTO.setCui(clientB2b.getCui());
		clientB2BDTO.setSubscribed(clientB2b.isSubscribed());
		clientB2BDTO.setStockClientB2B(stocksDTO);
		clientB2BDTO.setId(clientB2b.getId());
		clientB2BDTO.setAddress(clientB2b.getAddress());
		clientB2BDTO.setEmail(clientB2b.getEmail());
		clientB2BDTO.setPassword(clientB2b.getPassword());
		clientB2BDTO.setUsername(clientB2b.getUsername());

	}

}
