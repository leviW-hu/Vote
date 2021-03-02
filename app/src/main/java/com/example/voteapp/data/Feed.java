package com.example.voteapp.data;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class Feed {

    private String author;
    private LocalDateTime writeDate;
    private String text;

    public Feed(String author, LocalDateTime writeDate, String text) {
        this.author = author;
        this.writeDate = writeDate;
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getWriteDate() {
        return writeDate;
    }

    public void setWriteDate(LocalDateTime writeDate) {
        this.writeDate = writeDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public String timeSince(){
        LocalDateTime timePoint = LocalDateTime.now();

        if(Math.abs(ChronoUnit.MINUTES.between(timePoint, writeDate)) < 60){
            return Long.toString(Math.abs(ChronoUnit.MINUTES.between(timePoint, writeDate))) + " perce";
        }else if(Math.abs(ChronoUnit.HOURS.between(timePoint, writeDate)) < 24){
            return Long.toString(Math.abs(ChronoUnit.HOURS.between(timePoint, writeDate))) + " órája";
        }else if(Math.abs(ChronoUnit.MONTHS.between(timePoint, writeDate)) <1 ){
            return Long.toString(Math.abs(ChronoUnit.DAYS.between(timePoint, writeDate))) + " napja";
        }else if(Math.abs(ChronoUnit.MONTHS.between(timePoint, writeDate)) < 12){
            return Long.toString(Math.abs(ChronoUnit.MONTHS.between(timePoint, writeDate))) + " hónapja";
        }
        else return Long.toString(Math.abs(ChronoUnit.YEARS.between(timePoint, writeDate))) + " éve";
    }
}
