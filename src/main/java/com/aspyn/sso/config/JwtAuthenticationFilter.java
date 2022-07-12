//package com.aspyn.sso.config;
//
//import org.springframework.security.core.Authentication;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//    private final JwtAuthenticationProvider jwtAuthenticationProvider;
//
//    public JwtAuthenticationFilter(JwtAuthenticationProvider provider){
//        jwtAuthenticationProvider = provider;
//    }
//
//    @Override
//    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//        String token = jwtAuthenticationProvider.resolveToken(request);
//
//        if(jwtAuthenticationProvider.validateToken(token)){
//            Authentication authentication = jwtAuthenticationProvider.getAuthentication(token)
//        }
//
//    }
//}