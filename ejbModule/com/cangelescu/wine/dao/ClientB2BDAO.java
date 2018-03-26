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

    /**
     * Default constructor. 
     */
    public ClientB2BDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(ClientB2BDTO entity) {
		ClientB2B client=new ClientB2B();
		dtoToClientB2B(entity, client);
		entityManager.persist(client);
	}

	@Override
	public ClientB2BDTO findById(int id) {
		ClientB2BDTO clientB2BDTO = new ClientB2BDTO();
		ClientB2B client= entityManager.find(ClientB2B.class, id);
	    clientB2BToDto(client, clientB2BDTO);
		return clientB2BDTO;
	}

	@Override
	public void delete(ClientB2BDTO entity) {
		ClientB2B client=new ClientB2B();
		dtoToClientB2B(entity, client);
		entityManager.remove(client);
		
	}

	@Override
	public void update(ClientB2BDTO entity) {
		ClientB2B client=new ClientB2B();
		dtoToClientB2B(entity, client);
		entityManager.merge(client);
		
	}
	
	public static void dtoToClientB2B(ClientB2BDTO clientB2BDTO, ClientB2B clientB2b) {
		
		List<StockClientB2B> stocks=new ArrayList<StockClientB2B>();
		
		clientB2b.setVisibility(clientB2BDTO.isVisibility())
		.setBusinessName(clientB2BDTO.getBusinessName())
		.setCui(clientB2BDTO.getCui())
		.setSubscribed(clientB2BDTO.isSubscribed())
		.setStocks(stocks)
		.setId(clientB2BDTO.getId())
		.setAddress(clientB2BDTO.getAddress())
		.setEmail(clientB2BDTO.getEmail())
		.setPassword(clientB2BDTO.getPassword())
		.setUsername(clientB2BDTO.getUsername());
		
		//todo stocks
	}

	public static void clientB2BToDto(ClientB2B clientB2b,ClientB2BDTO clientB2BDTO)  {
		List<StockClientB2BDTO> stocksDTO=new ArrayList<StockClientB2BDTO>();
		
		
		clientB2BDTO.setVisibility(clientB2b.isVisibility())
		.setBusinessName(clientB2b.getBusinessName())
		.setCui(clientB2b.getCui())
		.setSubscribed(clientB2b.isSubscribed())
		.setStocks(stocksDTO)
		.setId(clientB2b.getId())
		.setAddress(clientB2b.getAddress())
		.setEmail(clientB2b.getEmail())
		.setPassword(clientB2b.getPassword())
		.setUsername(clientB2b.getUsername());
		
		//todo stocks
	}

}
