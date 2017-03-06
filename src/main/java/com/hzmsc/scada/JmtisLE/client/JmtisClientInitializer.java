package com.hzmsc.scada.JmtisLE.client;

import com.hzmsc.scada.JmtisLE.codec.JmtisBodyEncoder;
import com.hzmsc.scada.JmtisLE.codec.JmtisDecoder;
import com.hzmsc.scada.JmtisLE.codec.JmtisHeaderEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.ssl.SslContext;

import java.nio.ByteOrder;

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



        pipeline.addLast(new LengthFieldBasedFrameDecoder(ByteOrder.LITTLE_ENDIAN, 1024,4,4,0,0,true));
        pipeline.addLast(new JmtisDecoder());

        pipeline.addLast(new JmtisHeaderEncoder());
        pipeline.addLast(new JmtisBodyEncoder());
        // and then business logic.
        pipeline.addLast(new JmtisClientHandler());
    }
}
