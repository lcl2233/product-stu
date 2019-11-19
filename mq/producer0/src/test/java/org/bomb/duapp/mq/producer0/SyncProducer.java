package org.bomb.duapp.mq.producer0;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class SyncProducer {

    private static String productGroup = "du_product";

    private static String nameSrv = "localhost:9876";

    private static String topic = "product";

    private static String tag = "tag_a";

    private static String keys = "";

    private static int sendTime = 60000;

    private static long sleepTime = 2000;

    public static void main(String[]args) throws Exception {
        //生产者实例
        DefaultMQProducer producer = new DefaultMQProducer(productGroup);
        //指定nameServer
        producer.setNamesrvAddr(nameSrv);
        //超时时间
        producer.setSendMsgTimeout(sendTime);
        //启动实例
        producer.start();
        //发送消息
        sendMsg(producer);
        //关闭
        producer.shutdown();
    }

    private static void sendMsg(DefaultMQProducer producer) throws Exception {
        String msg = "这是测试消息";
        for (int i = 149; i < 249; i++) {
            byte[] body = (msg + i).getBytes(RemotingHelper.DEFAULT_CHARSET);
            Message message = new Message(topic, tag, keys, body);
            SendResult sendResult = producer.send(message);

            String msgId = sendResult.getMsgId();
            String offsetMsgId = sendResult.getOffsetMsgId();
            System.out.println("msgId : " + msgId + ", offsetMsgId : " + offsetMsgId);

            Thread.sleep(sleepTime);
        }
    }
}
