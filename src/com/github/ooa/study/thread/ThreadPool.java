package com.github.ooa.chudq.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import com.github.ooa.chudq.MyTask;

/**
 * @description 线程池应用
 * @author Covet
 * 1、用ThreadPoolExecutor自定义线程池，看线程是的用途，如果任务量不大，可以用无界队列，如果任务量非常大，要用有界队列，防止OOM 
 * 2、如果任务量很大，还要求每个任务都处理成功，要对提交的任务进行阻塞提交，重写拒绝机制，改为阻塞提交。保证不抛弃一个任务 
 * 3、最大线程数一般设为2N+1最好，N是CPU核数 
 * 4、核心线程数，看应用，如果是任务，一天跑一次，设置为0，合适，因为跑完就停掉了，如果是常用线程池，看任务量，是保留一个核心还是几个核心线程数 
 * 5、如果要获取任务执行结果，用CompletionService，但是注意，获取任务的结果的要重新开一个线程获取，如果在主线程获取，就要等任务都提交后才获取，就会阻塞大量任务结果，队列过大OOM，所以最好异步开个线程获取结果

 * Executors类提供了4种不同的线程池：newCachedThreadPool, newFixedThreadPool, newScheduledThreadPool, newSingleThreadExecutor
 * 1、newCachedThreadPool：用来创建一个可以无限扩大的线程池，适用于负载较轻的场景，执行短期异步任务。（可以使得任务快速得到执行，因为任务时间执行短，可以很快结束，也不会造成cpu过度切换）
 * 2、newFixedThreadPool：创建一个固定大小的线程池，因为采用无界的阻塞队列，所以实际线程数量永远不会变化，适用于负载较重的场景，对当前线程数量进行限制。（保证线程数可控，不会造成线程过多，导致系统负载更为严重）
 * 3、newSingleThreadExecutor：创建一个单线程的线程池，适用于需要保证顺序执行各个任务。
 * 4、newScheduledThreadPool：适用于执行延时或者周期性任务
 *
 * 1.当线程池小于corePoolSize时，新提交任务将创建一个新线程执行任务，即使此时线程池中存在空闲线程。 
 * 2.当线程池达到corePoolSize时，新提交任务将被放入workQueue中，等待线程池中任务调度执行 
 * 3.当workQueue已满，且maximumPoolSize>corePoolSize时，新提交任务会创建新线程执行任务 
 * 4.当提交任务数超过maximumPoolSize时，新提交任务由RejectedExecutionHandler处理 
 * 5.当线程池中超过corePoolSize线程，空闲时间达到keepAliveTime时，关闭空闲线程 
 * 6.当设置allowCoreThreadTimeOut(true)时，线程池中corePoolSize线程空闲时间达到keepAliveTime也将关闭
 */
public class ThreadPool {
	/**
	 * 1、corePoolSize（线程池基本大小）：当向线程池提交一个任务时，若线程池已创建的线程数小于corePoolSize，即便此时存在空闲线程，也会通过创建一个新线程来执行该任务，直到已创建的线程数大于或等于corePoolSize时，（除了利用提交新任务来创建和启动线程（按需构造），也可以通过 prestartCoreThread() 或 prestartAllCoreThreads() 方法来提前启动线程池中的基本线程。）
	 * 2、maximumPoolSize（线程池最大大小）：线程池所允许的最大线程个数。当队列满了，且已创建的线程数小于maximumPoolSize，则线程池会创建新的线程来执行任务。另外，对于无界队列，可忽略该参数。
     * 3、keepAliveTime（线程存活保持时间）当线程池中线程数大于核心线程数时，线程的空闲时间如果超过线程存活时间，那么这个线程就会被销毁，直到线程池中的线程数小于等于核心线程数。
     * 4、workQueue（任务队列）：用于传输和保存等待执行任务的阻塞队列。
     * 5、threadFactory（线程工厂）：用于创建新线程。threadFactory创建的线程也是采用new Thread()方式，threadFactory创建的线程名都具有统一的风格：pool-m-thread-n（m为线程池的编号，n为线程池内的线程编号）。
	 * 6、handler（线程饱和策略）：当线程池和队列都满了，再加入线程会执行此策略。 
	 */
	ThreadPoolExecutor pool;
	
	/**
	 * 参数、状态变化、Execute方法、关闭
	 */
	public void init(){
		pool = new ThreadPoolExecutor(9, 50, 60L, null, null, null, null);
	}
	
	public static void main(String[] args) {
		ExecutorService es = Executors.newFixedThreadPool(10);
		for(int i=0;i<50;i++){
			Thread t = new Thread(new MyTask());
			es.execute(t);
		}
	}

}
