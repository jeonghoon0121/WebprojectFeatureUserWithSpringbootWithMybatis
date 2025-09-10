package com.org.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

@Configuration  //스프링이 설정 클래스로 인식
@EnableWebSecurity //스프링 시큐리티 기능 활성화
public class SecurityConfig {
    @Bean   //보안필터체인설정
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(
                                        "/", "/main",
                                        "/test1",
                                        "/test2",
                                        "/test3",
                                        "/css/**",
                                        "/js/**"
                                        )
                                        .permitAll()
                        .anyRequest().authenticated()
                )
                /*위, 누구나 접근 가능함, 그외에 모든 요청은 인증된 사용자만 가능*/
                .formLogin(form -> form
                        .loginPage("/login") // 커스텀 로그인 페이지가 있다면 지정
                        .permitAll()
                )
                /*폼기반 로그인설정, 사용자정의 로그인페이지 정의, 로그인페이지는 누구나 접근가능 */
                .logout(logout -> logout.permitAll());
                /*로그아웃 기능을 활성화, 누구나 로그아웃 요청가능하게 설정*/
        return http.build();
            /*설정완료후 스프링 시큐리티에 적용 */
    }
}
