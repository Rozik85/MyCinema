package cinema.system;


import org.apache.log4j.helpers.DateTimeDateFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="seans")
public class Seans {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seans_id;

    @Column (name= "movie_ID")
    private int movie_id;

    @Column (name = "date_time")
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "")

    public int getSeans_id() {
        return seans_id;
    }

    public void setSeans_id(int seans_id) {
        this.seans_id = seans_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    @Override
    public String toString() {
        return "Seans{" +
                "seans_id=" + seans_id +
                ", movie_id=" + movie_id +
                ", dateTime=" + dateTime +
                '}';
    }
}
