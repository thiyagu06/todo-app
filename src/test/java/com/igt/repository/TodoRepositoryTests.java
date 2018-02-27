/**
 * 
 */
package com.igt.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.igt.entity.Todo;
import com.igt.entity.TodoStatus;
import com.igt.repo.TodoRepository;

/**
 * Test class for Todo Repository.
 * 
 * @author tkamaraj
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class TodoRepositoryTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private TodoRepository todoRepository;

	private Todo firstTodo;
	private Todo secondTodo;

	@Before
	public void before() {
		this.firstTodo = new Todo("First Todo");
		this.entityManager.persist(this.firstTodo);
		this.secondTodo = new Todo("Second Todo");
		this.entityManager.persist(this.secondTodo);
	}

	@Test
	public void findAllTodos() {
		final List<Todo> todos = (List<Todo>) this.todoRepository.findAll();

		assertThat(todos.size()).isEqualTo(2);
	}

	@Test
	public void findOneTodo() {
		assertThat(this.todoRepository.findOne(this.firstTodo.getId())).isEqualTo(this.firstTodo);
	}

	@Test
	public void addNewTodo() {
		final Todo newTodo = new Todo("My New Todo");
		this.todoRepository.save(newTodo);
		final Todo newTodoFromDb = this.todoRepository.findOne(newTodo.getId());
		assertThat(newTodo).isEqualTo(newTodoFromDb);
	}

	@Test
	public void updateExistingTodo() {
		this.firstTodo.setStatus(TodoStatus.COMPLETED);
		this.todoRepository.save(this.firstTodo);
		assertThat(this.todoRepository.findOne(this.firstTodo.getId()).getStatus().equals(TodoStatus.COMPLETED));
	}

	@Test
	public void deleteTodo() {
		this.todoRepository.delete(this.firstTodo);
		assertThat(this.todoRepository.findOne(this.firstTodo.getId())).isNull();
	}

}
