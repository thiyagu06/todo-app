/**
 * 
 */
package com.igt.entity;

/**
 * constant for TodoStatus
 * 
 * @author Thiyagu
 *
 */
public enum TodoStatus {

	PENDING("p"), COMPLETED("C");

	private String todoStatus;

	TodoStatus(String s) {
		this.todoStatus = s;
	}

	public String getValue() {
		return this.todoStatus;
	}

}
