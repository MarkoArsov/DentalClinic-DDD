package mk.ukim.finki.emt.appointmentscheduler.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import java.time.LocalDateTime;

@Embeddable
@Getter
public class DateTimeRange implements ValueObject {

    private LocalDateTime startTime;

    private LocalDateTime endTime;

    public DateTimeRange() {
        this.startTime = null;
        this.endTime= null;
    }

    public DateTimeRange(LocalDateTime startTime) {
        this.startTime = startTime;
        this.endTime = startTime;
    }

    public void addTime(){
        if (!this.startTime.isBefore(this.endTime)) return;
        this.endTime = this.endTime.plusMinutes(30);
    }

    public void removeTime(){
        if (!this.startTime.isBefore(this.endTime)) return;
        this.endTime = this.endTime.minusMinutes(30);
    }

    public boolean overlaps(DateTimeRange range){
        return this.startTime.isBefore(range.endTime) && this.endTime.isAfter(range.startTime);
    }
}
