package org.apache.rocketmq.example.quickstart;

import org.apache.rocketmq.client.hook.SendMessageContext;
import org.apache.rocketmq.client.hook.SendMessageHook;

public class FillUserIdSendMessageHook implements SendMessageHook {
    @Override
    public String hookName() {
        return "FillUserId";
    }

    @Override
    public void sendMessageBefore(SendMessageContext context) {
        context.getMessage().setBuyerId("10086");

    }

    @Override
    public void sendMessageAfter(SendMessageContext context) {

    }
}
