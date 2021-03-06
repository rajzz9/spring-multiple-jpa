/*
 * Copyright 2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.developinjava.sample.multipledatasource.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerRepository {

	private static final String SELECT_SQL = "select NAME from CUSTOMER where ID=?"; 
	@Autowired
	@Qualifier("customerJdbcTemplate")
	JdbcTemplate customerJdbcTemplate;
	
	public String getCustomerName(int id) {
		String name = customerJdbcTemplate.queryForObject(SELECT_SQL, new Object[] {id}, String.class);
		
		return name;
	}
}
