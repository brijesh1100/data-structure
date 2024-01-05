package com.mt;
import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher  extends Thread{
	
	private final int index;
	private final Lock leftFork;
	private final Lock rightFork;
	
	public Philosopher (Lock leftLock, Lock rightLock, int index) {
		this.leftFork = leftLock;
		this.rightFork = rightLock;
		this.index = index;
	}
	private void pickupFork() {
		this.leftFork.lock();
		this.rightFork.lock();
		System.out.println("Philospher "+ index + " Pickedup the fork");
	}
	
	private void putDownFork() {
		this.leftFork.unlock();
		this.rightFork.unlock();
		System.out.println("Philospher "+ index + " PutDown the fork");
	}
	
	private void eat() {
		try {
			sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Philospher "+ index + " is Eating");
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000; i++) {
			pickupFork();
			eat();
			putDownFork();
		}
	}
	
	public static void main(String[] args) {
		int numPhilosophers = 5;
		Lock[] numberOfForks = new ReentrantLock[numPhilosophers];
		Philosopher[] philosophers = new Philosopher[numPhilosophers];
		
		for (int i = 0; i < numPhilosophers; i++) {
			numberOfForks[i] = new ReentrantLock();
		}
		
		for (int i = 0; i < numPhilosophers; i++) {
			philosophers[i] = new Philosopher(numberOfForks[i], numberOfForks[(i+1)%numPhilosophers], i);
		}
		
		for (Philosopher philosopher : philosophers) {
			philosopher.start();
		}
		try {
            for (Philosopher philosopher : philosophers) {
                philosopher.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}

}
