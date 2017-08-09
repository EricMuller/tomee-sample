package rest;

import test.ClientJerseyTest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by eric on 29/05/2017.
 */
@Path("test")
public class TestRest {

	@GET
	public String test() {

		// ClientJerseyTest clientJerseyTest = new ClientJerseyTest();
		// clientJerseyTest.test();

		return "test";
	}
}
