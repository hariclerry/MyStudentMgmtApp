package edu.miu.cs.cs425.mystudentmgmtapp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Classroom {
    @Id
    @GeneratedValue
    private Long classroomId;
    private String buildingName;
    private String roomNumber;

    public Classroom(String buildingName, String roomNumber) {
        this.buildingName = buildingName;
        this.roomNumber   = roomNumber;
    }

    public Classroom() {

    }

    @Override
    public String toString() {
        return "Classroom{" +
               "classroomId=" + classroomId +
               ", buildingName='" + buildingName + '\'' +
               ", roomNumber='" + roomNumber + '\'' +
               '}';
    }

}
