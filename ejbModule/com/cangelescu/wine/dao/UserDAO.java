package com.cangelescu.wine.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.cangelescu.wine.dto.UserDTO;
import com.cangelescu.wine.model.User;

/**
 * Session Bean implementation class UserDAO
 */
@Stateless
public class UserDAO implements UserDAORemote {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insert(UserDTO entity) {
		User user = new User();
		dtoToUser(entity, user);
		entityManager.persist(user);
	}

	@Override
	public UserDTO findById(int id) {
		UserDTO UserDTO = new UserDTO();
		User user = entityManager.find(User.class, id);
		UserToDTO(user, UserDTO);
		return UserDTO;
	}

	@Override
	public void delete(UserDTO entity) {
		User user = new User();
		dtoToUser(entity, user);
		entityManager.remove(user);
	}

	@Override
	public void update(UserDTO entity) {
		User user = new User();
		dtoToUser(entity, user);
		entityManager.merge(user);
	}

	private void dtoToUser(UserDTO userDTO, User user) {
		user.setId(userDTO.getId());
		user.setAddress(userDTO.getAddress());
		user.setEmail(userDTO.getEmail());
		user.setPassword(userDTO.getPassword());
		user.setUsername(userDTO.getUsername());
	}

	private void UserToDTO(User user, UserDTO userDTO) {
		userDTO.setId(user.getId());
		userDTO.setAddress(user.getAddress());
		userDTO.setEmail(user.getEmail());
		userDTO.setPassword(user.getPassword());
		userDTO.setUsername(user.getUsername());
	}

}
