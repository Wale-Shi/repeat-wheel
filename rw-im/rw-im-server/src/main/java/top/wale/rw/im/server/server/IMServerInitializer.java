package top.wale.rw.im.server.server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.timeout.IdleStateHandler;

/**
 * Function:
 *
 * @author wale
 * @date 2019/11/29
 */
public class IMServerInitializer extends ChannelInitializer<Channel> {
    private final IMServerHandler imServerHandler = new IMServerHandler();

    @Override
    protected void initChannel(Channel ch) throws Exception {
        ch.pipeline()
                .addLast(new IdleStateHandler(10, 0, 0))
//                .addLast(new StringDecoder())
//                .addLast(new StringEncoder())
                .addLast(new ProtobufDecoder(IMMessageProto.Message.getDefaultInstance()))
                .addLast(new ProtobufEncoder())
                .addLast(new ProtobufEncoder())
                .addLast(imServerHandler)
        ;
    }
}
