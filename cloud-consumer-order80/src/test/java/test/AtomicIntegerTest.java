package test;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerTest {
    /*

     */
    @Test
    public void testAtomic() {
        AtomicInteger integer = new AtomicInteger(7);
        integer.getAndIncrement();
        System.out.println(integer.get());
    }
    /*
       测试interger最大值
    */
    @Test
    public void testMaxInteger(){
        System.out.println(Integer.MAX_VALUE);
    }
}
