package org.bomb.duapp.mq.producer0;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.remoting.common.RemotingHelper;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;

public class Consumer {

    private static String consumerGroup = "du_consumer";

    private static String nameSrv = "localhost:9876";

    private static String topic = "product";

    public static void main(String[]args) throws MQClientException {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr(nameSrv);
        consumer.subscribe(topic,"*");

        consumer.registerMessageListener((MessageListenerConcurrently) (msgs, context) -> {
            if (CollectionUtils.isEmpty(msgs)) return ConsumeConcurrentlyStatus.RECONSUME_LATER;

            String threadName = Thread.currentThread().getName();
            for (MessageExt ext : msgs) {
                String msgId = ext.getMsgId();
                String body = "";
                try {
                    body = new String(ext.getBody(), RemotingHelper.DEFAULT_CHARSET);
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                if (StringUtils.isEmpty(body)) continue;

                System.out.println(threadName + " receive [msgId: " + msgId + ", body: "+ body + "]");
            }

            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        });

        consumer.start();

        System.out.printf("Consumer Started.%n");
    }
}
