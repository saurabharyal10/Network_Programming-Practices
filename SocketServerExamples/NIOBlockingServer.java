package SocketServerExamples;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class NIOBlockingServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		final ServerSocketChannel serverSocket = ServerSocketChannel.open();
		
		serverSocket.bind(new InetSocketAddress(8080));
		
		while(true) {
			final SocketChannel socket = serverSocket.accept();
			handle(socket);
		}
	}
	
	private static void handle(final SocketChannel socket) {
		final ByteBuffer byteBuffer = ByteBuffer.allocateDirect(80);
		
		try {
			int data;
			while((data = socket.read(byteBuffer))!=-1) {
				byteBuffer.flip();
				
				invertCase(byteBuffer);
				
				while (byteBuffer.hasRemaining()) {
					socket.write(byteBuffer);
					
				}
				byteBuffer.compact();
				}
			}catch(IOException e) {
				throw new UncheckedIOException(e);
			}
		}
		
		private static void invertCase(final ByteBuffer bytebuffer) {
			for(int x= 0; x< bytebuffer.limit(); x++) {
				bytebuffer.put(x, (byte) invertCase(bytebuffer.get(x)));
			}
		}
		private static int invertCase(final int data) {
			return Character.isLetter(data)?
					
					Character.isUpperCase(data)
						?Character.toLowerCase(data)
						:Character.toUpperCase(data):
							
					data;
		}
}
