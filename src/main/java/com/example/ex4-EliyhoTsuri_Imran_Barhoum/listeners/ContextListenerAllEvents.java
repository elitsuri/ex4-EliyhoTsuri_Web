package com.example.ex4.listeners;

import org.springframework.context.event.*;
import org.springframework.stereotype.Component;

@Component
public class ContextListenerAllEvents
{
    @EventListener
    public void handleContextRefreshed(ContextRefreshedEvent event)
    {
        System.out.print(">>>> 1 >>> ContextRefreshedEvent event fired (class ContextListenerAllEvents)");
        System.out.println(event);
    }
    @EventListener
    public void handleContextStarted(ContextStartedEvent event)
    {
        System.out.print(">>>> 2 >>> ContextStartedEvent event fired (class ContextListenerAllEvents) ");
        System.out.println(event);
    }
    @EventListener
    public void handleContextStopped(ContextStoppedEvent event)
    {
        System.out.print(">>>> 3 >>> ContextStoppedEvent event fired (class ContextListenerAllEvents)");
        System.out.println(event);
    }
    @EventListener
    public void handleContextClosed(ContextClosedEvent event)
    {
        System.out.print(">>>> 4 >>> ContextClosedEvent event fired (class ContextListenerAllEvents)");
        System.out.println(event);
    }
}