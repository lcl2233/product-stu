package org.bomb.duapp.mq.producer0;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

public class AsyncProducer {

    private static String productGroup = "du_product";

    private static String nameSrv = "localhost:9876";

    private static String topic = "product";

    private static String tag = "tag_a";

    private static String keys = "";

    private static int sendTime = 60000;

    private static long sleepTime = 2000;

    public static void main(String[]args) throws Exception {
//        DefaultMQProducer producer = new DefaultMQProducer(productGroup);
//        producer.setNamesrvAddr(nameSrv);
//        producer.start();
//        producer.setSendMsgTimeout(sendTime);
//        producer.setRetryTimesWhenSendAsyncFailed(0);
//        sendAsyncMsg(producer);
        //producer.shutdown();
        System.out.println(638786%128);
    }

    private static void sendAsyncMsg(DefaultMQProducer producer) throws Exception {
        String common = "异步消息";
        for (int i = 0; i < 100; i++) {
            Message message = new Message(topic, tag, keys, common.getBytes(RemotingHelper.DEFAULT_CHARSET));
            producer.send(message, new SendCallback() {
                @Override
                public void onSuccess(SendResult sendResult) {
                    String msgId = sendResult.getMsgId();
                    String offsetMsgId = sendResult.getOffsetMsgId();
                    System.out.println("msgId : " + msgId + ", offsetMsgId : " + offsetMsgId);
                }

                @Override
                public void onException(Throwable e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
