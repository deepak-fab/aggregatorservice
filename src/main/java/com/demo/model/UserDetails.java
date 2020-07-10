package com.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDetails {

	private long id;

	/** The name. */
	private String name;

	/** The age. */
	private int age;

	/** The email. */
	private String email;
}
