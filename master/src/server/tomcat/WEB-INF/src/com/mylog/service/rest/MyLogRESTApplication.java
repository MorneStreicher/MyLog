package com.mylog.service.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.mylog.service.rest.login.Login;

@ApplicationPath("/")
public class MyLogRESTApplication
	extends Application
{
    @Override
    public Set<Class<?>> getClasses()
    {
        final Set<Class<?>> classes = new HashSet<Class<?>>();

        classes.add(Login.class);

        return classes;
    }
}
