package io.optimogroup.xracoon.xracoonnotification.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Override
    public String getCurrentUserId() {
//        JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
//        Jwt token = jwtAuthenticationToken.getToken();
//        String userId = token.getClaim("user_id");
//        if (Utils.stringIsEmpty(userId)) {
//            log.error("Invalid User_id provided!");
//            throw new AccessDeniedException("Invalid User_id provided!");
//        }
        return "userId";
    }
}
