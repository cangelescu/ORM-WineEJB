package com.cangelescu.wine.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cangelescuwine.dto.ClientB2CDTO;
import com.cangelescuwine.dto.ClientOrderDTO;
import com.example.finalprojectejb.model.ClientB2C;
import com.example.finalprojectejb.model.ClientOrder;


/**
 * Session Bean implementation class ClientB2CDAO
 */
@Stateless
public class ClientB2CDAO implements ClientB2CDAORemote {
	
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public ClientB2CDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(ClientB2CDTO entity) {
		ClientB2C client=new ClientB2C();
		dtoToClientB2C(entity, client);
		entityManager.persist(client);
		
	}

	@Override
	public ClientB2CDTO findById(int id) {
		ClientB2CDTO clientB2CDTO = new ClientB2CDTO();
		ClientB2C client= entityManager.find(ClientB2C.class, id);
	    clientB2CToDto(client, clientB2CDTO);
		return clientB2CDTO;
	}

	@Override
	public void delete(ClientB2CDTO entity) {
		ClientB2C client=new ClientB2C();
		dtoToClientB2C(entity, client);
		entityManager.remove(client);
	}

	@Override
	public void update(ClientB2CDTO entity) {
		ClientB2C client=new ClientB2C();
		dtoToClientB2C(entity, client);
		entityManager.merge(client);
	}
	
	public static void dtoToClientB2C(ClientB2CDTO clientB2CDTO, ClientB2C clientB2c) {
		
		List<ClientOrder> orders=new ArrayList<ClientOrder>();
		
		clientB2c.setCnp(clientB2CDTO.getCnp())
		.setFirstName(clientB2CDTO.getFirstName())
		.setLastName(clientB2CDTO.getLastName())
		.setRegisterDate(clientB2CDTO.getRegisterDate())
		.setOrders(orders)
		.setId(clientB2CDTO.getId())
		.setAddress(clientB2CDTO.getAddress())
		.setEmail(clientB2CDTO.getEmail())
		.setPassword(clientB2CDTO.getPassword())
		.setUsername(clientB2CDTO.getUsername());
		
		//todo orders
	}

	public static void clientB2CToDto(ClientB2C clientB2c,ClientB2CDTO clientB2CDTO)  {
		List<ClientOrderDTO> orders=new ArrayList<ClientOrderDTO>();
		
		
		clientB2CDTO.setCnp(clientB2c.getCnp())
		.setFirstName(clientB2c.getFirstName())
		.setLastName(clientB2c.getLastName())
		.setRegisterDate(clientB2c.getRegisterDate())
		.setOrders(orders)
		.setId(clientB2c.getId())
		.setAddress(clientB2c.getAddress())
		.setEmail(clientB2c.getEmail())
		.setPassword(clientB2c.getPassword())
		.setUsername(clientB2c.getUsername());
		
		//todo orders
	}

}
