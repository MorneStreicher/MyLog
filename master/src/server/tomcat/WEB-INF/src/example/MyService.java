package example;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService
public class MyService
{
	@WebMethod
	public String hello(String param)
	{
		return param + ", World";
	}
}
