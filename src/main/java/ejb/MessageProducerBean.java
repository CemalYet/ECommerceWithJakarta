package ejb;

import jakarta.annotation.Resource;
import jakarta.jms.*;

@jakarta.ejb.Stateless(name = "MessageProducerEJB")
public class MessageProducerBean {
    @Resource(lookup = "jms/Order")
    private ConnectionFactory factory;
    @Resource(lookup = "jmsDAdemo/orderdest")
    private Queue queueName;
    public MessageProducerBean() {
    }

    public void sendJMSMessageToOrderDest(String messageData){
        Connection connection;
        Session session;
        try{

            connection= factory.createConnection();
            session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
            TextMessage tm=session.createTextMessage();
            tm.setText(messageData);
            MessageProducer messageProducer=session.createProducer(queueName);
            messageProducer.send(tm);


        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
