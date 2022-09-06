package com.taskplanner.users.dto;

import java.util.Date;

/**
 * @author Laura Garcia
 */
public class TokenDto {

    private String token;

    private Date expirationDate;

    public TokenDto(String token, Date expirationDate) {
        this.token = token;
        this.expirationDate = expirationDate;
    }

    public String getToken() {
        return token;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }
}
