package com.jwt.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
public class JwtFilter extends GenericFilterBean {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {

        final HttpServletRequest request= (HttpServletRequest) servletRequest;

        final String authorization= request.getHeader("Authorization");



        if(!StringUtils.startsWithIgnoreCase(authorization,"Bearer ")){
            throw new ServletException("401-Unauthorized");
        }

        try{

            final Claims claims = Jwts.parser()
                    .setSigningKey("123#&*zcvAWEE999")
                    .parseClaimsJws(authorization.substring(7))
                    .getBody();

            request.setAttribute("claims",claims);

        }catch(final Exception e){

            throw new ServletException("401-Unauthorize");

        }

        filterChain.doFilter(servletRequest,servletResponse);

    }
}
