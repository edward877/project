package com.ulstu.project;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "records")
public class RecordDto  implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private int time;

    // сложность
    private String difficulty;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}
