package dev.ben.Homemanager.config.jwt;

import java.util.Date;

public record TokenPayload(Long id, Date lastConnection, boolean isAdmin) { }