package com.cangelescu.wine.dao;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cangelescu.wine.dto.ClientB2CDTO;
import com.cangelescu.wine.dto.ClientOrderDTO;
import com.cangelescu.wine.dto.OrderItemDTO;
import com.example.finalprojectejb.model.ClientB2C;
import com.example.finalprojectejb.model.ClientOrder;
import com.example.finalprojectejb.model.OrderItem;

/**
 * Session Bean implementation class ClientOrderDAO
 */
@Stateless
public class ClientOrderDAO implements ClientOrderDAORemote {
	
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public ClientOrderDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(ClientOrderDTO entity) {
		ClientOrder order=new ClientOrder();
		dtoToClientOrder(entity, order);
		entityManager.persist(order);
		
	}

	@Override
	public ClientOrderDTO findById(int id) {
		ClientOrderDTO clientOrderDTO = new ClientOrderDTO();
		ClientOrder order= entityManager.find(ClientOrder.class, id);
	    clientOrderToDto(order, clientOrderDTO);
		return clientOrderDTO;
	}

	@Override
	public void delete(ClientOrderDTO entity) {
		ClientOrder order=new ClientOrder();
		dtoToClientOrder(entity, order);
		entityManager.remove(order);
		
	}

	@Override
	public void update(ClientOrderDTO entity) {
		ClientOrder order=new ClientOrder();
		dtoToClientOrder(entity, order);
		entityManager.merge(order);
		
	}
	
    public static void dtoToClientOrder(ClientOrderDTO clientOrderDTO, ClientOrder clientOrder) {
	
	    List<OrderItem> orderItems=new ArrayList<OrderItem>();
		
		ClientB2C clientB2C=new ClientB2C();
		ClientB2CDAO.dtoToClientB2C(clientOrderDTO.getClientB2C(), clientB2C);
		
		clientOrder.setId(clientOrderDTO.getId())
		.setDate(clientOrderDTO.getDate())
		.setOrderNumber(clientOrderDTO.getOrderNumber())
		.setClientB2C(clientB2C)
		.setOrderItems(orderItems);
		
		//todo order items
	}

	public static void clientOrderToDto( ClientOrder clientOrder,ClientOrderDTO clientOrderDTO)  {
          List<OrderItemDTO> orderItems=new ArrayList<OrderItemDTO>();
		
		ClientB2CDTO clientB2CDTO=new ClientB2CDTO();
		ClientB2CDAO.clientB2CToDto(clientOrder.getClientB2C(), clientB2CDTO);
		
		clientOrderDTO.setId(clientOrder.getId())
		.setDate(clientOrder.getDate())
		.setOrderNumber(clientOrder.getOrderNumber())
		.setClientB2C(clientB2CDTO)
		.setOrderItems(orderItems);
		
		//todo order items
	}

}
