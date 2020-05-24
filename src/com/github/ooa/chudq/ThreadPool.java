package com.github.ooa.chudq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @description 线程池应用
 * @author Covet
 *
 */
public class ThreadPool {
	ExecutorService threadPool = Executors.newFixedThreadPool(10);
}
