package eu.spex.sqs.messaging;

import org.springframework.stereotype.Component;

@Component
public class QueueOfIncomingEdigas implements Queue {

    public static final String NAME = "msg-edigas-in.fifo";

    @Override
    public String getName() {
        return NAME;
    }
}
