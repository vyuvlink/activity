package cn.com.act.common.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import static cn.com.act.config.RabbitMqConfig.QUEUE_NAME;

@Component
public class RabbitmqUtil {
    @RabbitListener(queues = QUEUE_NAME)
    public void consumeMessage(String msg) {
        System.out.println("TopicRecive1接受的消息： " + msg);
    }
}
