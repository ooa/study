package com.github.ooa.chudq.mq;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Producer {
	private static final Logger LOGGER = LoggerFactory.getLogger(Producer.class);

    //ActiveMq 的默认用户名
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //ActiveMq 的默认登录密码
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //ActiveMQ 的链接地址
    private static final String ACITVEMQ_URL = ActiveMQConnection.DEFAULT_ACITVEMQ_URL;
    
    AtomicInteger count = new AtomicInteger(0);
    
    //链接工厂
    ConnectionFactory connectionFactory;
    //链接对象
    Connection connection;
    //事务管理
    Session session;
    
    ThreadLocal<MessageProducer> threadLocal = new ThreadLocal<>();
    
	public void init(){
		LOGGER.info("Product init");
		try {
			//创建一个链接工厂
	        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, ACITVEMQ_URL);
	        //从工厂中创建一个链接
	        connection = connectionFactory.createConnection();
	        //开启链接
	        connection.start();
	        //创建一个事务（这里通过参数可以设置事务的级别）
	        session = connection.createSession(true, Session.SESSION_TRANSACTED);
		} catch (JMSException e) {
			LOGGER.error("", e);
		}
	}
	
	public void sendMessage(String disname){
		try{
			//创建一个消息队列
            Queue queue = session.createQueue(disname);
            //消息生产者
            MessageProducer messageProducer = null;
            if (threadLocal.get() != null){
                messageProducer = threadLocal.get();
            }else{
                messageProducer = session.createProducer(queue);
                threadLocal.set(messageProducer);
            }
            
            while (true){
                Thread.sleep(1000);
                int num = count.getAndIncrement();
                //创建一条消息
                TextMessage msg;
                msg = session.createTextMessage(Thread.currentThread().getName() + "==Productor:我现在正在生产东西！,count:" + num);
                LOGGER.info("msg:{} + {}", msg, num);
                //发送消息
                messageProducer.send(msg);
                //提交事务
                session.commit();
                System.out.println(num);
            }
        }catch (JMSException e){
            LOGGER.error("", e);
        }catch (InterruptedException e){
            LOGGER.error("", e);
        }
	}
	
	public static void main(String[] args) {
		Producer producer = new Producer();
		producer.init();
		producer.sendMessage("My-Queue");
	}
}
