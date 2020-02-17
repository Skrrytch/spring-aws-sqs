package eu.spex.sqs.messaging;

import org.springframework.stereotype.Component;

/**
 *  aws
 *    --endpoint-url http://localhost:9324
 *    sqs create-queue
 *    --attributes FifoQueue=true
 *    --attributes ContentBasedDeduplication=true
 *    --queue-name msg-edigas-in.fifo
 */
@Component
public class EdigasInQueue implements QueueDef {

    @Override
    public String getName() {
        // return "http://localhost:9324/queue/msg-edigas-in";
        return "msg-edigas-in.fifo";
    }
}
