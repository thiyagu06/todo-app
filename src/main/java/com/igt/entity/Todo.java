/**
 * 
 */
package com.igt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/**
 * The todo Entity
 * 
 * @author Thiyagu
 *
 */
@Entity(name = "todos")
@Data
@ToString
@JsonPropertyOrder({ "id", "name", "status" })
@RequiredArgsConstructor
@NoArgsConstructor
public class Todo implements Serializable {

	/**
	 * Default Serialization Id
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The unique ID of todo
	 */
	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	/**
	 * The description of todo item
	 */
	@NotBlank(message="todo description should not be empty")
	@JsonProperty("description")
	@Size(max = 140,message="maximum 140 characters only allowed")
	@Column(length = 140)
	@NonNull
	private String description;

	/**
	 * The property to decide todo is done or not
	 */
	@JsonProperty("status")
	@Enumerated(EnumType.STRING)
	private TodoStatus status = TodoStatus.PENDING;
}
