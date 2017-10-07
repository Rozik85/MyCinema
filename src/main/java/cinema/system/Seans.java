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



    @ManyToOne
    @JoinColumn(name = "movie_id", nullable = false)
    private Movie movie;

    @Column (name = "date_time")
    private LocalDateTime date_time;


    @Column (name = "nrSala", nullable = false)
    private int nrSala;

    public Seans() {

    }

    public int getSeans_id() {
        return seans_id;
    }

    public void setSeans_id(int seans_id) {
        this.seans_id = seans_id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = this.movie;
    }

    public LocalDateTime getDate_time() {
        return date_time;
    }

    public void setDate_time(LocalDateTime date_time) {
        this.date_time = date_time;
    }

    public int getNrSala() {
        return nrSala;
    }

    public void setNrSala(int nrSala) {
        this.nrSala = nrSala;
    }

    @Override
    public String toString() {
        return "Seans{" +
                "seans_id=" + seans_id +
                ", movie=" + movie +
                ", date_time=" + date_time +
                ", nrSala=" + nrSala +
                '}';
    }
}
