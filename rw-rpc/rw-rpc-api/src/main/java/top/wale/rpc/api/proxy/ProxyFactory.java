package top.wale.rpc.api.proxy;

import top.wale.rpc.api.Invoker;
import top.wale.rpc.api.RpcException;

/**
 * @author wale
 */
public interface ProxyFactory {
    /**
     * create proxy.
     *
     * @param invoker
     * @return proxy
     */
    <T> T getProxy(Invoker<T> invoker) throws RpcException;
}
