package pe.com.idat.controller;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pe.com.idat.repository.RolRepository;
import pe.com.idat.repository.UsuarioRepository;




@RestController
public class AuthController {
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	UsuarioRepository repository;
	
	@Autowired
	RolRepository repository2;
	
	@Autowired
	PasswordEncoder encoder;
	
	
	@Autowired
	JwtUtils jwtUtils;
	
	
	@PostMapping("/signin")
	public ResponseEntity<?>authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
		Authentication authentication= authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(
						loginRequest.getUsername(), loginRequest.getPassword()));
	
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails=(UserDetailsImpl) authentication.getPrincipal();
		List<String> roles=userDetails.getAuthorities().stream()
				.map(item->item.getAuthority())
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetails.getId(),
				
				
				
				roles));
		
		
		
	}
	
	
	
	

}
