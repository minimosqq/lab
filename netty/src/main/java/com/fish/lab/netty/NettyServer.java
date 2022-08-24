package com.fish.lab.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.DefaultEventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import java.nio.charset.StandardCharsets;


public class NettyServer {
    public static void main(String[] args) {

        final DefaultEventLoopGroup defaultEventLoopGroup = new DefaultEventLoopGroup();

        new ServerBootstrap()
                .group(new NioEventLoopGroup())
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringDecoder());
                        ch.pipeline().addLast(defaultEventLoopGroup, "handler-1",new ChannelInboundHandlerAdapter(){
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                System.out.println("ok");
                                ByteBuf buf = (ByteBuf) msg;
                                System.out.println(buf.toString(StandardCharsets.UTF_8));
//                                ctx.fireChannelRead(msg);
                            }
                        });
                    }
                })
                .bind(8080);
    }
}
