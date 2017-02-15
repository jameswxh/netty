package com.hzmsc.scada.Equipment.server;

import com.hzmsc.scada.Equipment.codec.*;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.ssl.SslContext;



/**
 * Created by wxhx1 on 2017/2/7.
 */
public class EquipmentServerInitializer extends ChannelInitializer<SocketChannel>{
    private final SslContext sslCtx;

    public EquipmentServerInitializer(SslContext sslCtx) {
        this.sslCtx = sslCtx;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        if (sslCtx != null) {
            pipeline.addLast(sslCtx.newHandler(ch.alloc()));
        }


        pipeline.addLast(new LengthFieldBasedFrameDecoder(1024,4,4));
        pipeline.addLast(new HeaderEncoder());
        //pipeline.addLast(new LengthFieldPrepender(4,false));
        /*pipeline.addLast(new EquipmentMsgDecoder());
        pipeline.addLast(new EquipmentMsgEncoder());
*/
        pipeline.addLast(new SimpleDecoder());
        pipeline.addLast(new SimpleEncoder());

        pipeline.addLast(new EquipmentServerHandler());

    }
}
