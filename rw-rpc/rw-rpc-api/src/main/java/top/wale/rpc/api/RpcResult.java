package top.wale.rpc.api;

import java.lang.reflect.Field;

/**
 * @author wale
 */
public class RpcResult implements Result {

    private Object resp;

    private Throwable throwable;


    @Override
    public Object getValue() {
        return resp;
    }

    @Override
    public void setValue(Object value) {
        resp = value;
    }

    @Override
    public Throwable getException() {
        return this.throwable;
    }

    @Override
    public void setException(Throwable t) {
        this.throwable = t;
    }

    @Override
    public boolean hasException() {
        return throwable != null;
    }

    @Override
    public Object recreate() throws Throwable {
        if (throwable != null) {
            // fix issue#619
            try {
                // get Throwable class
                Class clazz = throwable.getClass();
                while (!clazz.getName().equals(Throwable.class.getName())) {
                    clazz = clazz.getSuperclass();
                }
                // get stackTrace value
                Field stackTraceField = clazz.getDeclaredField("stackTrace");
                stackTraceField.setAccessible(true);
                Object stackTrace = stackTraceField.get(throwable);
                if (stackTrace == null) {
                    throwable.setStackTrace(new StackTraceElement[0]);
                }
            } catch (Exception e) {
                // ignore
            }
            throw throwable;
        }
        return resp;
    }

    public static RpcResult defaultResult(Object value, Throwable t, Invocation invocation) {
        RpcResult result = new RpcResult();
        if (t != null) {
            result.setException(t);
        } else {
            result.setValue(value);
        }
        return result;
    }
}
