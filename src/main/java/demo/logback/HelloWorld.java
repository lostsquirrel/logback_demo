package demo.logback;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

/**
 * Hello world!
 *
 */
public class HelloWorld {

	@Test
	public void testLogger1() throws Exception {
		Logger logger = LoggerFactory.getLogger(HelloWorld.class);
		logger.debug("Hello world.");
	}

	@Test
	public void testLoggerInternal() throws Exception {
		Logger logger = LoggerFactory.getLogger(HelloWorld.class);
		logger.debug("Hello world.");

		// print internal state
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		StatusPrinter.print(lc);
	}
}
