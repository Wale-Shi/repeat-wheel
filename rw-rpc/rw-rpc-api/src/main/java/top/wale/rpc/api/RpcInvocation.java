package top.wale.rpc.api;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author wale
 */
public class RpcInvocation implements Invocation {

    private String methodName;

    private Class<?>[] parameterTypes;

    private Object[] arguments;

    private Invoker<?> invoker;

    private Class<?> returnType;

    @Override
    public String getMethodName() {
        return methodName;
    }

    @Override
    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    @Override
    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public Invoker<?> getInvoker() {
        return invoker;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public void setArguments(Object[] arguments) {
        this.arguments = arguments;
    }

    public void setInvoker(Invoker<?> invoker) {
        this.invoker = invoker;
    }

    public Class<?> getReturnType() {
        return returnType;
    }

    public void setReturnType(Class<?> returnType) {
        this.returnType = returnType;
    }


    public RpcInvocation(Method method, Object[] arguments) {
        this(method.getName(), method.getParameterTypes(), arguments, null);
        this.returnType = method.getReturnType();
    }

    public RpcInvocation(String methodName, Class<?>[] parameterTypes, Object[] arguments) {
        this(methodName, parameterTypes, arguments, null);
    }

    public RpcInvocation(String methodName, Class<?>[] parameterTypes, Object[] arguments, Invoker<?> invoker) {
        this.methodName = methodName;
        this.parameterTypes = parameterTypes == null ? new Class<?>[0] : parameterTypes;
        this.arguments = arguments == null ? new Object[0] : arguments;
        this.invoker = invoker;
    }

}
