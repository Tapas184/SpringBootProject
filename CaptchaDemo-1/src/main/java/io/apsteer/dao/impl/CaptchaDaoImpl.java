package io.apsteer.dao.impl;

import java.nio.file.attribute.UserPrincipalNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import io.apsteer.dao.IDaoService;
import io.apsteer.model.UserAccount;

@Repository
public class CaptchaDaoImpl implements IDaoService {

	private static final String UPDATE_QUERY = "UPDATE USER_TABLE SET accountstatus=1 where userUuid=?";

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public int updateAccount(UserAccount acc) throws IllegalAccessException {

		try {
			Object[] param = { acc.getUserUuid() };

			int update = jdbcTemplate.update(UPDATE_QUERY, param);
			if (update == 0) {
				throw new UserPrincipalNotFoundException("User Not exist");
			}
		} catch (Exception e) {
			throw new IllegalAccessException("Problem in update user Account");

		}
		return 1;
	}

}
