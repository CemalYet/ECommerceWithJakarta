package ejb;

import jakarta.inject.Inject;
import jakarta.interceptor.AroundConstruct;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.InvocationContext;

import java.util.logging.Logger;


public class CartInterceptor {

    private final Logger logger = Logger.getLogger(CartInterceptor.class.getName());


    @AroundConstruct
    private void init(InvocationContext ic) throws Exception {
        logger.fine("Entering constructor");
        System.out.println("Entering constructor");
        try {
            ic.proceed();
        } finally {
            logger.fine("Exiting constructor");
            System.out.println("Exiting constructor");
        }
    }

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
