package workflow.workflow.service;

import workflow.workflow.pojo.LoginRequest;
import workflow.workflow.pojo.RegisterRequest;
import workflow.workflow.pojo.AuthResponse;
import workflow.workflow.entity.Role;
import workflow.workflow.entity.User;
import workflow.workflow.repository.UserRepository;
import workflow.workflow.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class AuthService {

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder;
	private final JwtService jwtService;
	private final AuthenticationManager authenticationManager;

	public AuthResponse register(RegisterRequest request) {
		if (userRepository.existsByEmail(request.getEmail())) {
			throw new RuntimeException("Email already registered");
		}

		Role role = "ADMIN".equalsIgnoreCase(request.getRole()) ? Role.ADMIN : Role.USER;
		User user = User.builder().name(request.getName()).email(request.getEmail())
				.password(passwordEncoder.encode(request.getPassword())).role(role).createdAt(LocalDateTime.now())
				.build();

		userRepository.save(user);

		String token = jwtService.generateToken(user.getEmail(), user.getRole().name());

		return AuthResponse.builder().token(token).email(user.getEmail()).role(user.getRole()).name(user.getName())
				.build();
	}

	public AuthResponse login(LoginRequest request) {
		authenticationManager
				.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));

		User user = userRepository.findByEmail(request.getEmail())
				.orElseThrow(() -> new RuntimeException("Invalid credentials"));

		String token = jwtService.generateToken(user.getEmail(), user.getRole().name());

		return AuthResponse.builder().token(token).email(user.getEmail()).role(user.getRole()).name(user.getName())
				.build();
	}
}
