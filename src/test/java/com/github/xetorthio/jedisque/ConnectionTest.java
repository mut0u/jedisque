package com.github.xetorthio.jedisque;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.Test;

import redis.clients.jedis.exceptions.JedisConnectionException;

public class ConnectionTest {
	@Test
	public void iterateOverHosts() throws URISyntaxException {
		try (Jedisque q = new Jedisque(new URI("disque://localhost:55665"),
				new URI("disque://localhost:7711"))) {
			q.info();
		}
	}

	@Test(expected = JedisConnectionException.class)
	public void throwExceptionWhenNodesAreUnavailbale()
			throws URISyntaxException {
		try (Jedisque q = new Jedisque(new URI("disque://localhost:55665"),
				new URI("disque://localhost:55666"))) {
			q.info();
		}
	}
}
