package com.lizza.ForkJoin;

import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 计算1~10000的求和，JDK 1.8中的fork/join
 * @author lt
 * @date 2019年5月29日
 * @version v1.0
 */
public class ForkJoin_2 {
	static class Sum extends RecursiveTask<Long> {

		private static final long serialVersionUID = -5659973761218653810L;

		Long start;
		Long end;
		
		public Sum(Long start, Long end){
			this.start = start;
			this.end = end;
		}
		
		@Override
		protected Long compute() {
			Long sum = 0L;
			if(end-start<1000){
				for(Long i=start; i<end; i++){
					sum += i;
				}
			} else {
				Long middle = (end-start)/2;
				Sum sum1 = new Sum(start, middle);
				Sum sum2 = new Sum(middle+1, end);
				//任务拆分执行
				sum1.fork();
				sum2.fork();
				//执行结果合并
				sum = sum1.join()+sum2.join();
			}
			return sum;
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Runtime.getRuntime().availableProcessors());
		Long start = 0L;
		Long end = 100000000L;
		Long t1 = System.currentTimeMillis();
        Long sum1 = LongStream.rangeClosed(start, end).parallel().sum();
		System.out.println("ForkJoin计算结果为："+sum1+"，耗时为："+(System.currentTimeMillis()-t1)+"ms");
		Long t2 = System.currentTimeMillis();
		Long sum2 = 0L;
		for(Long i=start; i<=end; i++){
			sum2 += i;
		}
		System.out.println("普通计算结果为："+sum2+"，耗时为："+(System.currentTimeMillis()-t2)+"ms");
	}
}
