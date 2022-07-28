package com.galvanize;

import java.time.Duration;
import java.time.LocalDateTime;

public class Event extends ICalendarItem implements Schedulable {

    private final String title;
    private final LocalDateTime startsAt;
    private final Duration duration;

    public Event(String title, LocalDateTime startsAt, Duration duration) {
        this.title = title;
        this.startsAt = startsAt;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String getTextToDisplay() {
        return getTitle();
    }

    @Override
    public LocalDateTime getSchedulableDate() {
        return startsAt;
    }

    public Duration getDuration() {
        return duration;
    }

    public LocalDateTime getEndsAt() {
        return startsAt.plus(getDuration());
    }


    @Override
    public String iCalendar() {
        if (title == null) return "";

        return new StringBuilder()
                .append("BEGIN:VEVENT\n")
                .append(String.format("DTSTART:%s\n", getSchedulableDate()))
                .append(String.format("DTEND:%s\n", getEndsAt()))
                .append(String.format("UID:%s@example.com\n", getUuid()))
                .append(String.format("DESCRIPTION:%s\n", getTextToDisplay()))
                .append("END:VEVENT\n")
                .toString();
    }

    @Override
    public String toString() {
        return String.format(
                "%s at %s (ends at %s)",
                getTitle(),
                getSchedulableDate().format(DATE_FORMATTER),
                getEndsAt().format(DATE_FORMATTER)
        );
    }
}
