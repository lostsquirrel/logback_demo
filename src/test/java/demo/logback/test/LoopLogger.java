package demo.logback.test;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoopLogger {

	private static final Logger log = LoggerFactory.getLogger(LoopLogger.class);
	
	static Random random = new Random();
	
	public static void main(String[] args) throws Exception {
		manyLog();
	}
	
	public static void manyLog() throws Exception {
		Timer timer = new Timer();
		timer.schedule(new TimerTask(){
			
			@Override
			public void run() {
				log.error("gen: {}", random.nextInt());
			}
			
		}, 100, 1000);
	}
}
