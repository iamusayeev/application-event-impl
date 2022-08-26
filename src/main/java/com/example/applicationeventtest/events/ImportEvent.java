package com.example.applicationeventtest.events;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class ImportEvent extends ApplicationEvent {

    private final String message;

    public ImportEvent(Object source, String message) {
        super(source);
        this.message = message;
    }
}
