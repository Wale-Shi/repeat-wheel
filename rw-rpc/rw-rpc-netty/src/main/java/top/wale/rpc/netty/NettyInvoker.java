package top.wale.rpc.netty;

import top.wale.rpc.api.Invocation;
import top.wale.rpc.api.Invoker;
import top.wale.rpc.api.Result;
import top.wale.rpc.api.RpcException;

/**
 * @author wale
 */
public class NettyInvoker<T> implements Invoker<T>  {
    @Override
    public Class<T> getInterface() {
        return null;
    }

    @Override
    public Result invoke(Invocation invocation) throws RpcException {
        return null;
    }
}
