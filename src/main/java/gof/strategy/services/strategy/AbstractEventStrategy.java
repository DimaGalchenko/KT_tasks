package gof.strategy.services.strategy;

import gof.strategy.domain.ScheduledEvent;
import gof.strategy.domain.Status;

public abstract class AbstractEventStrategy implements EventStrategy {

    public ScheduledEvent process(ScheduledEvent event) {
        if (event.getStatus() == Status.FAILED && event.getVersion() > 10) {
            event.setStatus(Status.TERMINATED);
        } else {
            event.setStatus(Status.ONGOING);
        }
        saveEvent(event);
        return event;
    }

    protected abstract void saveEvent(ScheduledEvent event);
}