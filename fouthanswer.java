package javaassignment;

import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class fouthanswer {
    public static void main(String[] args) {
        // Create and start multiple threads
        System.out.println("Creating and starting multiple threads...");
        for (int i = 1; i <= 5; i++) {
            Thread thread = new MyThread("Thread " + i);
            thread.start();
        }

        // Synchronize threads to avoid race conditions
        System.out.println("\nSynchronizing threads to avoid race conditions...");
        Counter counter = new Counter();
        for (int i = 1; i <= 10; i++) {
            Thread syncThread = new SynchronizedThread(counter);
            syncThread.start();
        }

        // Use wait() and notify() to implement thread communication
        System.out.println("\nUsing wait() and notify() for thread communication...");
        Message message = new Message();
        Thread producer = new Producer(message);
        Thread consumer = new Consumer(message);
        producer.start();
        consumer.start();

        // Use sleep() to pause threads for a specified duration
        System.out.println("\nUsing sleep() to pause threads...");
        Thread sleeper = new Sleeper();
        sleeper.start();

        try {
            sleeper.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted while waiting for sleeper thread.");
        }

        // Demonstrate thread interruption and thread termination
        System.out.println("\nDemonstrating thread interruption and termination...");
        Thread interruptible = new InterruptibleThread();
        interruptible.start();
        interruptible.interrupt();

        // Use Executors and Callable to perform parallel computation and get results
        System.out.println("\nUsing Executors and Callable for parallel computation...");
        ExecutorService executor = Executors.newFixedThreadPool(3);
        Future<Integer> future1 = executor.submit(new MyCallable(1, 10));
        Future<Integer> future2 = executor.submit(new MyCallable(11, 20));
        Future<Integer> future3 = executor.submit(new MyCallable(21, 30));

        try {
            int result1 = future1.get();
            int result2 = future2.get();
            int result3 = future3.get();
            System.out.println("Results from Callable tasks:");
            System.out.println("Task 1 result: " + result1);
            System.out.println("Task 2 result: " + result2);
            System.out.println("Task 3 result: " + result3);
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Error getting result from Callable: " + e.getMessage());
        }

        executor.shutdown();
    }
}

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread: " + Thread.currentThread().getName() + " is running.");
    }
}

// Synchronized thread
class SynchronizedThread extends Thread {
    private static Counter counter = new Counter();

    public SynchronizedThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        counter.increment();
    }
}

// Counter class for synchronization
class Counter {
    private int count = 0;

    public synchronized void increment() {
        count++;
        System.out.println("Counter: " + count);
    }
}

// Message class for thread communication
class Message {
    private String content;
    private boolean empty = true;

    public synchronized String read() {
        while (empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted while waiting for message.");
            }
        }
        empty = true;
        notifyAll();
        return content;
    }

    public synchronized void write(String content) {
        while (!empty) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println("Interrupted while waiting to write message.");
            }
        }
        empty = false;
        this.content = content;
        notifyAll();
    }
}

// Producer thread for thread communication
class Producer extends Thread {
    private Message message;

    public Producer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages = {"Message 1", "Message 2", "Message 3"};
        for (String msg : messages) {
            message.write(msg);
            System.out.println("Produced: " + msg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Producer thread interrupted.");
            }
        }
    }
}

// Consumer thread for thread communication
class Consumer extends Thread {
    private Message message;

    public Consumer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            String msg = message.read();
            System.out.println("Consumed: " + msg);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Consumer thread interrupted.");
            }
        }
    }
}

// Sleeper thread using sleep()
class Sleeper extends Thread {
    @Override
    public void run() {
        for (int i = 5; i >= 1; i--) {
            System.out.println("Sleeping for " + i + " seconds...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Sleeper thread interrupted.");
            }
        }
    }
}

// Interruptible thread for interruption and termination
class InterruptibleThread extends Thread {
    @Override
    public void run() {
        while (!Thread.interrupted()) {
            System.out.println("Running interruptible thread...");
        }
        System.out.println("Interruptible thread terminated.");
    }
}

// Callable class for parallel computation
class MyCallable implements Callable<Integer> {
    private int start;
    private int end;

    public MyCallable(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = start; i <= end; i++) {
            sum += i;
        }
        return sum;
    }
}
