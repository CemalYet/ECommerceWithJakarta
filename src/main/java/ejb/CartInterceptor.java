package ejb;

import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

import java.util.logging.Logger;


public class CartInterceptor {

    private final Logger logger = Logger.getLogger(CartInterceptor.class.getName());

    @AroundInvoke
    public Object logMethod(InvocationContext ic) throws Exception {
        logger.entering(ic.getTarget().toString(), ic.getMethod().getName());
        System.out.println("Entering Target " + ic.getTarget().toString() + "Method " + ic.getMethod().getName());
        try {
            return ic.proceed();
        } finally {
             logger.exiting(ic.getTarget().toString(), ic.getMethod().getName());
            System.out.println("Exiting  Target " + ic.getTarget().toString() + "Method " + ic.getMethod().getName());
        }
    }
}
