package com.lizza.ForkJoin;

import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * 计算1~10000的求和
 * @author lt
 * @date 2019年5月29日
 * @version v1.0
 */
public class ForkJoin_1 {

	@SuppressWarnings("serial")
	static class Sum extends RecursiveTask<Long> {
		private static final Long threshold = 10000L;
		private Long start;
		private Long end;
		public Sum(Long start, Long end){
			this.start = start;
			this.end = end;
		}
		@Override
		protected Long compute() {
			if((end-start)<threshold){
				Long sum = 0L;
				for(Long i=start; i<=end; i++){
					sum += i;
				}
	            return sum;
			} else {
				Long mid = (end+start)/2;
				Sum sum1 = new Sum(start, mid);
				Sum sum2 = new Sum(mid+1, end);
				sum1.fork();
				sum2.fork();
				return sum1.join() + sum2.join();
			}
		}
	}
	
	public static void main(String[] args) {
		Long start = 0L;
		Long end = 10000000000L;
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
