package org.apache.rocketmq.example.quickstart;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.hook.CheckForbiddenContext;
import org.apache.rocketmq.client.hook.CheckForbiddenHook;

public class CustomCheckForbiddenHook implements CheckForbiddenHook {

    @Override
    public String hookName() {
        return "CustomCheck";
    }

    @Override
    public void checkForbidden(final CheckForbiddenContext context) throws MQClientException {
        // 在这里添加你的检查逻辑
        // 根据context中的信息判断是否允许当前操作
        // 如果不允许，则抛出MQClientException异常


        String topic = context.getMessage().getTopic();

        if (!"TopicTest".equalsIgnoreCase(topic)) {
            throw new MQClientException("The IP is not allowed to send messages", null);
        }
    }

}
