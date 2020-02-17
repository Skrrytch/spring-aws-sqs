package eu.spex.sqs.receiver;

import javax.jms.JMSException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import eu.spex.sqs.messaging.QueueOfIncomingEdigas;

@Service
public class Receiver {

    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    @JmsListener(destination = QueueOfIncomingEdigas.NAME, concurrency = "2-2")
    public void receive(String message) throws JMSException {
        LOGGER.info("received message='{}'", message);
        int waitLoop = 10;
        for (int count = 1; count < waitLoop; count++) {
            try {
                Thread.sleep(2000);
                LOGGER.info("\"{}\": {} of {}", message, count, waitLoop);
            } catch (InterruptedException e) {
            }
        }
        LOGGER.info("\"{}\": done", message);
    }
}
