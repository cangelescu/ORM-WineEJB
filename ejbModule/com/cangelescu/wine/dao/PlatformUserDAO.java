package com.cangelescu.wine.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cangelescuwine.dto.UserDTO;
import com.example.finalprojectejb.model.PlatformUser;

/**
 * Session Bean implementation class PlatformUserDAO
 */
@Stateless
public class PlatformUserDAO implements UserDAORemote {
	
	@PersistenceContext
	private EntityManager entityManager;

    /**
     * Default constructor. 
     */
    public PlatformUserDAO() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void insert(UserDTO entity) {
		PlatformUser user=new PlatformUser();
		dtoToPlatformUser(entity, user);
		entityManager.persist(user);

	}

	@Override
	public UserDTO findById(int id) {
		UserDTO platformUserDTO = new UserDTO();
		PlatformUser user=entityManager.find(PlatformUser.class, id);
	    platformUserToDTO(user, platformUserDTO);
		return platformUserDTO;
}

	@Override
	public void delete(UserDTO entity) {
		PlatformUser user=new PlatformUser();
		dtoToPlatformUser(entity, user);
		entityManager.remove(user);
		
	}

	@Override
	public void update(UserDTO entity) {
		PlatformUser user=new PlatformUser();
		dtoToPlatformUser(entity, user);
		entityManager.merge(user);
		
	}

	
	private void dtoToPlatformUser(UserDTO platformUserDTO, PlatformUser platformUser) {
		platformUser.setId(platformUserDTO.getId())
		.setAddress(platformUserDTO.getAddress())
		.setEmail(platformUserDTO.getEmail())
		.setPassword(platformUserDTO.getPassword())
		.setUsername(platformUserDTO.getUsername());
	}

	private void platformUserToDTO( PlatformUser platformUser,UserDTO platformUserDTO) {
		platformUserDTO.setId(platformUser.getId())
		.setAddress(platformUser.getAddress())
		.setEmail(platformUser.getEmail())
		.setPassword(platformUser.getPassword())
		.setUsername(platformUser.getUsername());
	}


}
