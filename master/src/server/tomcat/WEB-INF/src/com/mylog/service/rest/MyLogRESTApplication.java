package com.mylog.service.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.xml.bind.JAXBContext;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;
import org.glassfish.jersey.moxy.json.MoxyJsonFeature;

import com.mylog.service.rest.login.Login;
import com.mylog.service.rest.login.LoginResult;

@ApplicationPath("/")
public class MyLogRESTApplication
	extends Application
{
	public MyLogRESTApplication()
	{
		// Nothing to do here
	}

    @Override
    public Set<Class<?>> getClasses()
    {
        final Set<Class<?>> classes = new HashSet<Class<?>>();

        classes.add(Login.class);

        return classes;
    }
}
