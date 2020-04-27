package com.jeeweb.conference.gestionconference.security;

public class SecurityConstants {
    public static final String HEADER_NAME = "Authorization";
    public static final String HEADER_PREFIX = "Bearer ";
    public static final long EXPIRATION = 10*24*3600*1000; // 10 jours
    public static final String SECRET = "conference@spring.com";
}
