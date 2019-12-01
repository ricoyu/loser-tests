package com.loserico.threadpool;

public interface RejectedExecutionHandler {
	
	void rejectedExecution(Runnable r, ThreadPoolExecutor executor);
}
