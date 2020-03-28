package com.qtt.bbs.common.filter;

import com.qtt.bbs.common.system.AppContext;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Project name：bbsDesign
 * Class name：AuthFilter
 * description：TODO
 * date：2020/3/12 11:29
 *
 * @author ：XC
 */
public class AuthFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {

    }
}
