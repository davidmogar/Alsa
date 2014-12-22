package com.davidmogar.alsa.web.listeners;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ActiveSessionsListener implements HttpSessionListener {

    private static int activeSessions;

    public static int getActiveSessions() {
        return activeSessions;
    }

    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        activeSessions++;
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        activeSessions--;
    }

}
