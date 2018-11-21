package com.four.my;

import com.four.km.IUtil;

/**
 * В пакете com.km создайте интерфейс IUtil, содержащий три метода.
 * В другом пакете com.my pеализуйте этот интерфейс в классе MyUtil.
 */
public class First implements IUtil {
    public static void main(String[] args) {
        First f = new First();
        f.size();
        f.write();
        f.read();
    }

    @Override
    public int size() {
        System.out.println("SIZE");
        return 0;
    }

    @Override
    public String read() {
        System.out.println("READ");
        return null;
    }

    @Override
    public void write() {
        System.out.println("WRITE");

    }
}
