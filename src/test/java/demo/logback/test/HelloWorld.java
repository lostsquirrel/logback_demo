package demo.logback.test;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hello world!
 *
 */
public class HelloWorld {
	Logger logger = LoggerFactory.getLogger(HelloWorld.class);

	@Test
	public void testLogger1() throws Exception {
		logger.debug("Hello world.");
	}
	
	@Test
	public void err() throws Exception {
		logger.error("Hello ERR.");
	}
	
	@Test
	public void warn() throws Exception {
		logger.warn("Hello Warnning");
	}
}
