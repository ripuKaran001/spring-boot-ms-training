/**
 * 
 */
package com.ri.spring.mobile.app.users.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ri.spring.mobile.app.users.apis.data.UserEntity;

/**
 * @author ripum
 *
 */
public interface UsersRepository extends JpaRepository<UserEntity, Long> {

	@Query("Select ue from UserEntity ue where ue.userId= ?1")
	public UserEntity getUserByUserId(String userId);

}
