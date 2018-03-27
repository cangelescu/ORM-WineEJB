package com.cangelescu.wine.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cangelescu.wine.dto.ClientB2CDTO;
import com.cangelescu.wine.dto.OrderDTO;
import com.cangelescu.wine.model.ClientB2C;
import com.cangelescu.wine.model.Order;

/**
 * Session Bean implementation class ClientB2CDAO
 */
@Stateless
public class ClientB2CDAO implements ClientB2CDAORemote {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insert(ClientB2CDTO entity) {
		ClientB2C client = new ClientB2C();
		dtoToClientB2C(entity, client);
		entityManager.persist(client);

	}

	@Override
	public ClientB2CDTO findById(int id) {
		ClientB2CDTO clientB2CDTO = new ClientB2CDTO();
		ClientB2C client = entityManager.find(ClientB2C.class, id);
		clientB2CToDto(client, clientB2CDTO);
		return clientB2CDTO;
	}

	@Override
	public void delete(ClientB2CDTO entity) {
		ClientB2C client = new ClientB2C();
		dtoToClientB2C(entity, client);
		entityManager.remove(client);
	}

	@Override
	public void update(ClientB2CDTO entity) {
		ClientB2C client = new ClientB2C();
		dtoToClientB2C(entity, client);
		entityManager.merge(client);
	}

	public static void dtoToClientB2C(ClientB2CDTO clientB2CDTO, ClientB2C clientB2c) {
		List<Order> orders = new ArrayList<>();
		clientB2c.setCnp(clientB2CDTO.getCnp());
		clientB2c.setFirstName(clientB2CDTO.getFirstName());
		clientB2c.setLastName(clientB2CDTO.getLastName());
		clientB2c.setRegisterDate(clientB2CDTO.getRegisterDate());
		clientB2c.setOrders(orders);
		clientB2c.setId(clientB2CDTO.getId());
		clientB2c.setAddress(clientB2CDTO.getAddress());
		clientB2c.setEmail(clientB2CDTO.getEmail());
		clientB2c.setPassword(clientB2CDTO.getPassword());
		clientB2c.setUsername(clientB2CDTO.getUsername());

	}

	public static void clientB2CToDto(ClientB2C clientB2c, ClientB2CDTO clientB2CDTO) {
		List<OrderDTO> orders = new ArrayList<>();
		clientB2CDTO.setCnp(clientB2c.getCnp());
		clientB2CDTO.setFirstName(clientB2c.getFirstName());
		clientB2CDTO.setLastName(clientB2c.getLastName());
		clientB2CDTO.setRegisterDate(clientB2c.getRegisterDate());
		clientB2CDTO.setOrders(orders);
		clientB2CDTO.setId(clientB2c.getId());
		clientB2CDTO.setAddress(clientB2c.getAddress());
		clientB2CDTO.setEmail(clientB2c.getEmail());
		clientB2CDTO.setPassword(clientB2c.getPassword());
		clientB2CDTO.setUsername(clientB2c.getUsername());
	}

}
