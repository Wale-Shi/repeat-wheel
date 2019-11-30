package top.wale.rw.im.server.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * Function:
 *
 * @author wale
 * @date 2019/11/29
 */
public class IMServerHandler extends SimpleChannelInboundHandler<IMMessageProto.Message> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, IMMessageProto.Message msg) throws Exception {
        System.out.println(msg.getContent());

    }

//    @Override
//    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
//        System.out.println(msg);
//    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
    }
}
