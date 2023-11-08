package com.transporteboaglio.TB.service;

import com.transporteboaglio.TB.dto.UserDTO;
import org.keycloak.representations.idm.UserRepresentation;

import java.util.List;

public interface KeycloakService {

    List<UserRepresentation> findAllUsers();
    List<UserRepresentation> searchUsersByUsername(String username);

    String createUser ( UserDTO userDTO );
    void deleteUser( String userid );
    void updateUser( String userid, UserDTO userDTO );
}
