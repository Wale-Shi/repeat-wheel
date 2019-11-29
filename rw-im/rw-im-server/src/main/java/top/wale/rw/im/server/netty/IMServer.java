package top.wale.rw.im.server.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * @author wale
 */
@Component
@PropertySource("net.properties")
public class IMServer {
    private static Logger logger = LoggerFactory.getLogger(IMServer.class);
    @Value("${im.server.port}")
    private Integer port;

    private EventLoopGroup boss = new NioEventLoopGroup();
    private EventLoopGroup worker = new NioEventLoopGroup();
    @PostConstruct
    public void run() throws InterruptedException {
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(boss, worker)
                .channel(NioServerSocketChannel.class)
                .localAddress(new InetSocketAddress(port))
                .option(ChannelOption.SO_KEEPALIVE, true)
                .childHandler(new IMServerInitializer());
        ChannelFuture future = bootstrap.bind().sync();
        if (future.isSuccess()) {
            logger.info("启动聊天服务端成功！");
        }
    }

    @PreDestroy
    public void close(){
        boss.shutdownGracefully();
        worker.shutdownGracefully();
    }
}
