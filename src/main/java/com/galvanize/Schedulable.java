package com.galvanize;

import java.time.LocalDateTime;

public interface Schedulable {
    public String toString();
    public String iCalendar();
    public void markComplete();
    public void markIncomplete();
    public LocalDateTime getSchedulableDate();
}
