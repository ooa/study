package com.github.ooa.chudq.mqtest;

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

    //ActiveMq ��Ĭ���û���
    private static final String USERNAME = ActiveMQConnection.DEFAULT_USER;
    //ActiveMq ��Ĭ�ϵ�¼����
    private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
    //ActiveMQ �����ӵ�ַ
    private static final String ACITVEMQ_URL = ActiveMQConnection.DEFAULT_ACITVEMQ_URL;
    
    AtomicInteger count = new AtomicInteger(0);
    
    //���ӹ���
    ConnectionFactory connectionFactory;
    //���Ӷ���
    Connection connection;
    //�������
    Session session;
    
    ThreadLocal<MessageProducer> threadLocal = new ThreadLocal<>();
    
	public void init(){
		LOGGER.info("Product init");
		try {
			//����һ�����ӹ���
	        connectionFactory = new ActiveMQConnectionFactory(USERNAME, PASSWORD, ACITVEMQ_URL);
	        //�ӹ����д���һ������
	        connection = connectionFactory.createConnection();
	        //��������
	        connection.start();
	        //����һ����������ͨ������������������ļ���
	        session = connection.createSession(true, Session.SESSION_TRANSACTED);
		} catch (JMSException e) {
			LOGGER.error("", e);
		}
	}
	
	public void sendMessage(String disname){
		try{
            //����һ����Ϣ����
            Queue queue = session.createQueue(disname);
            //��Ϣ������
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
                //����һ����Ϣ
                TextMessage msg;
                msg = session.createTextMessage(Thread.currentThread().getName() + "==Productor:��������������������,count:" + num);
                LOGGER.info("msg:{} + {}", msg, num);
                //������Ϣ
                messageProducer.send(msg);
                //�ύ����
                session.commit();
            }
        }catch (JMSException e){
            LOGGER.error("", e);
        }catch (InterruptedException e){
            LOGGER.error("", e);
        }
	}
}
