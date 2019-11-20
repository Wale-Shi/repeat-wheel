package top.wale.rpc.api;

import java.util.Map;

/**
 * @author wale
 */
public interface Invocation {
    /**
     * get method name.
     *
     * @return method name.
     * @serial
     */
    String getMethodName();

    /**
     * get parameter types.
     *
     * @return parameter types.
     * @serial
     */
    Class<?>[] getParameterTypes();

    /**
     * get arguments.
     *
     * @return arguments.
     * @serial
     */
    Object[] getArguments();


    /**
     * get the invoker in current context.
     *
     * @return invoker.
     * @transient
     */
    Invoker<?> getInvoker();
}
