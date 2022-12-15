package io.optimogroup.xracoon.xracoonnotification.service;

import io.optimogroup.xracoon.xracoonnotification.utils.Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public String getCurrentUserId() {
        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        Jwt token = jwtAuthenticationToken.getToken();
        String userId = token.getClaim("user_id");
        if (Utils.stringIsEmpty(userId)) {
            log.error("Invalid User_id provided!");
            throw new AccessDeniedException("Invalid User_id provided!");
        }
        return userId;
    }
}
