package com.example.applicationeventtest.events;

import java.util.concurrent.ThreadLocalRandom;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ListenerTwo implements ApplicationListener<ImportEvent> {

    @Override
    public void onApplicationEvent(ImportEvent event) {
        var timeout = ThreadLocalRandom.current().nextLong(5000L, 20000L);
        System.out.println(Thread.currentThread().getName() + " " + timeout);
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("ListTWO - Done");

    }
}
