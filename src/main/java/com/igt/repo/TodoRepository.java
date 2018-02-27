/**
 * 
 */
package com.igt.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.igt.entity.Todo;

/**
 * Repository interface all CRUD operation of todo entity
 * 
 * @author Thiyagu
 *
 */
@Repository	
public interface TodoRepository extends JpaRepository<Todo, String> {

}
