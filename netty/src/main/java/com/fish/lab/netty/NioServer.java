package com.fish.lab.netty;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

public class NioServer {
    public void start() throws IOException {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.bind(new InetSocketAddress(6789));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        ServerSocketChannel serverSocketChannelB = ServerSocketChannel.open();
        serverSocketChannelB.bind(new InetSocketAddress(6790));
        serverSocketChannelB.configureBlocking(false);
        serverSocketChannelB.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("服务器启动成功");
        while (true) {
            //多路复用？
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    iterator.remove();
                    handleAccept(serverSocketChannel, selector);
                    handleAccept(serverSocketChannelB, selector);
                } else if (selectionKey.isReadable()) {
                    //nio？
                    handleRead(selectionKey);
                } else {
                    System.out.println("其他请求");
                }
            }
        }
    }

    private void handleRead(SelectionKey selectionKey) throws IOException {
        SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        StringBuilder request = new StringBuilder();
        //nio？
        while (socketChannel.read(byteBuffer) > 0) {
            byteBuffer.flip();
            request.append(StandardCharsets.UTF_8.decode(byteBuffer));
        }
        if (request.length() > 0) {
            System.out.println("服务端收到消息：" + request.toString());
        }
    }

    private void handleAccept(ServerSocketChannel serverSocketChannel, Selector selector) throws IOException {
        SocketChannel socketChannel = serverSocketChannel.accept();
        //read nio？
        socketChannel.configureBlocking(true);
        socketChannel.register(selector, SelectionKey.OP_READ);
        System.out.println("有新人进入聊天室");
        socketChannel.write(StandardCharsets.UTF_8.encode("进入聊天室，现在可以聊天了"));
    }

    public static void main(String[] args) throws IOException {
        new NioServer().start();
    }
}
