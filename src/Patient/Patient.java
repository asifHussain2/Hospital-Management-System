/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Patient;

import java.util.Date;

public class Patient {
    private int id;
    private String name;
    private int age;
    private String disease;
    private String address;
    private int RoomNo;
    private Date dateadmitted;

    public Patient(int id, String name, int age, String disease, String address, int RoomNo, Date dateadmitted) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.disease = disease;
        this.address = address;
        this.RoomNo = RoomNo;
        this.dateadmitted = dateadmitted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getRoomNo() {
        return RoomNo;
    }

    public void setRoomNo(int RoomNo) {
        this.RoomNo = RoomNo;
    }

    public Date getDateadmitted() {
        return dateadmitted;
    }

    public void setDateadmitted(Date dateadmitted) {
        this.dateadmitted = dateadmitted;
    }
    
    
}
