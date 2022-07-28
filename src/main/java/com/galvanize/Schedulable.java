package com.galvanize;

import java.time.LocalDateTime;

public interface Schedulable {
    public String toString();
    public String iCalendar();
    public LocalDateTime getSchedulableDate();
}
