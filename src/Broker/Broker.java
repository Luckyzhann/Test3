package Broker;

import java.util.concurrent.ArrayBlockingQueue;

public class Broker {
    private final static int MAX_SIZE=3;
    private static ArrayBlockingQueue<String> messageQueue=new ArrayBlockingQueue<>(MAX_SIZE);

    public  static void produce(String msg) {
        if(messageQueue.offer(msg)){
            System.out.println("成功向消息处理中心投递消息："+msg+"，当前暂存消息数量是："+messageQueue.size());
        }
        else{
            System.out.println("消息处理中心暂存消息达到最大负荷，不能继续放入信息！");
        }
        System.out.println("=======================");
    }
    public  static String consume() {
        String msg=messageQueue.poll();
        if(msg!=null){
            System.out.println("已消费消息："+msg+"，当前暂存消息数量是："+messageQueue.size());
        }
        else{
            System.out.println("消息处理中心没消息！");
        }
        System.out.println("=======================");
        return msg;
    }
}
