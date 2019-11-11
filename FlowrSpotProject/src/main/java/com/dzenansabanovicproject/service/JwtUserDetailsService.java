package com.dzenansabanovicproject.service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dzenansabanovicproject.dao.UserDao;
import com.dzenansabanovicproject.model.DAOUser;
import com.dzenansabanovicproject.model.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;
	Logger logger = Logger.getLogger(JwtUserDetailsService.class.getName());
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = userDao.findByUsername(username);
		logger.warning(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				getAuthorities(user.getRoles()));

	}


	public List<GrantedAuthority> getAuthorities(Integer role) {
		List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
		if (role.intValue() == 0) {
			authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		} else if (role.intValue() == 1) {
			authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		}
		System.out.println(authList);
		return authList;
	}


	public DAOUser getUserById(int id){
		return userDao.findById(id);

	}




	
	public DAOUser save(UserDTO user) {
		DAOUser newUser = new DAOUser();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		newUser.setRoles(user.getRoles());
		return userDao.save(newUser);
	}
}