package com.hzmsc.scada.Equipment.client;

import com.hzmsc.scada.Equipment.codec.*;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.ssl.SslContext;

/**
 * Created by wxhx1 on 2017/2/7.
 */
public class JmtisClientInitializer extends ChannelInitializer<SocketChannel> {
    private final SslContext sslCtx;

    public JmtisClientInitializer(SslContext sslCtx) {
       this.sslCtx = sslCtx;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {

        ChannelPipeline pipeline = ch.pipeline();

        if (sslCtx != null) {
            pipeline.addLast(sslCtx.newHandler(ch.alloc(), JmtisClient.HOST, JmtisClient.PORT));
        }



        pipeline.addLast(new LengthFieldBasedFrameDecoder(1024,4,4));
        pipeline.addLast(new JmtisDecoder());

        pipeline.addLast(new JmtisHeaderEncoder());
        pipeline.addLast(new JmtisBodyEncoder());
        // and then business logic.
        pipeline.addLast(new JmtisClientHandler());
    }
}
