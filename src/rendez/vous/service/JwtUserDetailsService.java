package rendez.vous.service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import rendez.vous.entity.User;
//import rendez.vous.repository.UserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService
{
	//@Autowired
	//private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
//		Optional<User> user = userRepository.findById(username);
//		if (user == null) 
//		{
//			throw new UsernameNotFoundException("User not found with username: " + username);
//		}
//		return new org.springframework.security.core.userdetails.User(user.get().getUsername(), user.get().getPassword(), getAuthority(user.get()));
		return null;
	}
	
	private Set<SimpleGrantedAuthority> getAuthority(User user) 
	{
		Set<SimpleGrantedAuthority> authorities = new HashSet<>();
		user.getAuthorities().forEach(role -> {
			//authorities.add(new SimpleGrantedAuthority(role.getName()));
			authorities.add(new SimpleGrantedAuthority(role.getAuthority()));
		});
		return authorities;
		//return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
	}
	public User save(User user) 
	{
		User newUser = new User();
		newUser.setUsername(user.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
		//return userRepository.save(newUser);
		return null;
	}
}