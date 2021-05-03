package ejb;

import jakarta.ejb.ActivationConfigProperty;
import jakarta.ejb.MessageDriven;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;
import jakarta.jms.TextMessage;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

@MessageDriven(name = "OrderMessageEJB",mappedName = "jmsDAdemo/orderdest", activationConfig = {
        @ActivationConfigProperty(  propertyName = "acknowledgeMode",
                                    propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(  propertyName = "destinationType",
                                    propertyValue = "jakarta.jms.Queue")
        })
public class OrderMessageBean implements MessageListener {
    public OrderMessageBean() {
    }

    @Override
    public void onMessage(Message message) {

        try{
            TextMessage msg = (TextMessage) message;
            System.out.println(msg.getText()+" -----> IS LOGGED IN "+new Date());
        } catch (JMSException e) {
            Logger.getLogger(OrderMessageBean.class.getName()).log(Level.SEVERE,null,e);
        }

    }
}
