package com.kshare.dao.jdbctemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.kshare.entity.User;

@Repository
public class UserDaoJdbcTemplateRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Transactional
	public User addUser(User user) {
		String sqljInsertUser = "insert into user (id, name, role) values (?,?,?)";
		jdbcTemplate.update(sqljInsertUser, new Object[] {1,
				 user.getName(),user.getRole()
		});
		
		return user;
	}
	
	@SuppressWarnings("rawtypes")
	public User getUserById(int id) {
		String SELECT_USER_BY_ID = "select * from user where id = ?";
		@SuppressWarnings("unchecked")
		User user = (User)jdbcTemplate.queryForObject(SELECT_USER_BY_ID, new Object[] {id}, new RowMapper() {
			@Override
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setRole(rs.getString("role"));
				return user;
			}
		});
		
		return user;
	}
	
	public List<User> getAllUsers() {
		String GET_ALL_USER_SQL = "select * from user";
		List<User> userList = (List<User>)jdbcTemplate.query(GET_ALL_USER_SQL, new ResultSetExtractor<List<User>>() {
			@Override
			public List<User> extractData(ResultSet rs) throws SQLException, DataAccessException {
				List<User> users = new ArrayList<User>();
				User user = null;
				
				while(rs.next()) {
					user = new User();
					user.setRole(rs.getString("role"));
					user.setName(rs.getString("name"));
					users.add(user);
				}
				return users;
			}
		});
		return userList;
	}
	public void updateUser(User user) {
		String UDPATE_USER = "update user set name =? , role = ? where id = ?";
		jdbcTemplate.update(UDPATE_USER, new Object[] {user.getName(), user.getRole(),user.getId()});
	}
	
	public void deleteUserById(int id) {
		String DELETE_USER_SQL = "delete user where id = ?";
		jdbcTemplate.update(DELETE_USER_SQL, new Object[] {id});
	}
		
}
