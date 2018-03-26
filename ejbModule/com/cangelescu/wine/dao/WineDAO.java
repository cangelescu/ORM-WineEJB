package com.cangelescu.wine.dao;

import javax.ejb.Stateless;

import com.cangelescu.wine.dto.WineDTO;

/**
 * Session Bean implementation class WineDAO
 */
@Stateless
public class WineDAO implements WineDAORemote {

    /**
     * Default constructor. 
     */
    public WineDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(WineDTO entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public WineDTO findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(WineDTO entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(WineDTO entity) {
		// TODO Auto-generated method stub
		
	}

}
