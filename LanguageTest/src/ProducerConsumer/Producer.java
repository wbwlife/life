package ProducerConsumer;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Producer implements Runnable {
    private BlockingQueue<Integer> queue;
    private volatile boolean isRunning;//开关
    private static AtomicInteger atomicInteger = new AtomicInteger();
    private static final int SLEEPUNIT = 1000;

    public Producer(BlockingQueue<Integer> queue){
        this.queue = queue;
    }

    @Override
    public void run() {
        System.out.println("producer id: " + Thread.currentThread().getId()+" start");
        //执行
        try {
            int data = 0;
            while (isRunning){
                //模拟延迟
                Thread.sleep(new Random().nextInt(SLEEPUNIT));
                data = atomicInteger.incrementAndGet();
                //打印任务数据
                System.out.println("producer " + Thread.currentThread().getId() + " create data：" + data
                        + ", size：" + queue.size());
                if(!queue.offer(data, 2, TimeUnit.SECONDS)){
                    System.err.println("failed to put data: "+ data);
                }

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupted();
        }
    }

    public void stop(){
        isRunning = false;
    }
}
