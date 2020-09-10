/**
 * 
 */
package com.ri.spring.mobile.app.users.apis.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ri.spring.mobile.app.users.apis.data.UserEntity;

/**
 * @author ripum
 *
 */
public interface UsersRepository extends JpaRepository<UserEntity, Long> {

}
