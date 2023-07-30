package com.lizza.Pipe;

import java.io.IOException;
import java.io.PipedReader;
import java.io.PipedWriter;
import java.util.Scanner;

/**
 * 使用管道输入/输出流进行线程之间的通信
 * @author lt
 * @date 2019年5月18日
 * @version v1.0
 */
@SuppressWarnings("all")
public class PipedTest_1 {

	public static void main(String[] args) throws IOException {
		PipedReader reader = new PipedReader();
		PipedWriter writer = new PipedWriter();
		reader.connect(writer);
		Thread t1 = new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.print("请输入信息：");
				Scanner scanner = new Scanner(System.in);
				while(scanner.hasNext()){
					try {
						writer.write(scanner.next());
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}, "线程1");
		Thread t2 = new Thread(new Runnable(){
			@Override
			public void run() {
				try {
					int len = 0;
					while((len=reader.read())!=-1){
						System.out.print((char)len);
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}, "线程2");
		t1.start();
		t2.start();
	}
}
