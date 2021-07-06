
package com.apirest.pasteleria.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apirest.pasteleria.entity.ERole;
import com.apirest.pasteleria.entity.Login;
import com.apirest.pasteleria.entity.Persona;
import com.apirest.pasteleria.entity.Role;
import com.apirest.pasteleria.repository.LoginRepository;
import com.apirest.pasteleria.repository.PersonaRepository;
import com.apirest.pasteleria.repository.RoleRepository;
import com.apirest.pasteleria.security.jwt.JwtUtils;
import com.apirest.pasteleria.service.dto.RoleDto;
import com.apirest.pasteleria.service.dto.UserDto;
import com.apirest.pasteleria.service.dto.request.LoginRequest;
import com.apirest.pasteleria.service.dto.request.RegisterRequest;
import com.apirest.pasteleria.service.dto.response.JwtResponse;
import com.apirest.pasteleria.service.dto.response.JwtUserResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder encoder;

    public ResponseEntity<?> resgisterUserClient(RegisterRequest register) {
        Login login = new Login();
        Persona client = new Persona(register);

        if (loginRepository.existsByUsername(register.getUsername())) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        login.setUsername(register.getUsername());
        login.setPassword(encoder.encode(register.getPassword()));

        Set<Role> roles = new HashSet<>();

        Role userRole = roleRepository.findByName(ERole.ROLE_CLIENT)
                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));

        roles.add(userRole);
        login.setRoles(roles);

        try {
            login.setPersona(personaRepository.saveAndFlush(client));
            return new ResponseEntity<>(generarJWT(loginRepository.saveAndFlush(login),
                    register.getPassword()),HttpStatus.CREATED);
        } catch (final Exception e) {
            System.out.print(e);
            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
        }

    }

    public JwtUserResponse getJwtByLogin(LoginRequest loginRequest) {
        String jwt = null;
        Set<Role> rolesList = new HashSet<>();
        Set<RoleDto> rolesDtoList = new HashSet<>();
        Login user = loginRepository.findByUsername(
                loginRequest.getUsername())
                .orElseThrow(() -> new RuntimeException("El username no existe"));
        return generarJWT(user, loginRequest.getPassword());
        /*   rolesList = user.getRoles();
        for (Role role : rolesList) {
            switch (role.getName()) {
                case ROLE_ADMIN:
                    rolesDtoList.add(new RoleDto(ERole.ROLE_ADMIN));
                    break;
                case ROLE_CLIENT:
                    rolesDtoList.add(new RoleDto(ERole.ROLE_CLIENT));
                    break;
            }
        }
        UserDto userDto = new UserDto(
                user.getUsername(),
                user.getPersona().getName(),
                user.getPersona().getEdad(),
                user.getPersona().getEmail(),
                user.getPersona().getNumero(),
                rolesDtoList);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        jwt = jwtUtils.generateJwtToken(authentication);

        return new JwtUserResponse(userDto, new JwtResponse(jwt));*/
    }

    private JwtUserResponse generarJWT(Login user, String password) {
        String jwt = null;
        Set<Role> rolesList = new HashSet<>();
        Set<RoleDto> rolesDtoList = new HashSet<>();
        rolesList = user.getRoles();
        for (Role role : rolesList) {
            switch (role.getName()) {
                case ROLE_ADMIN:
                    rolesDtoList.add(new RoleDto(ERole.ROLE_ADMIN));
                    break;
                case ROLE_CLIENT:
                    rolesDtoList.add(new RoleDto(ERole.ROLE_CLIENT));
                    break;
            }
        }
        UserDto userDto = new UserDto(
                user.getUsername(),
                user.getPersona().getName(),
                user.getPersona().getEdad(),
                user.getPersona().getEmail(),
                user.getPersona().getNumero(),
                user.getPersona().getFechaf(),
                rolesDtoList);
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.getUsername(),
                        password
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        jwt = jwtUtils.generateJwtToken(authentication);

        return new JwtUserResponse(userDto, new JwtResponse(jwt));
    }

}
