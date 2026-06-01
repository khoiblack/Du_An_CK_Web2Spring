package ntu.khoi.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "lab_rooms")
public class LabRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "room_name", nullable = false, unique = true, length = 50)
    private String roomName;

    @Column(nullable = false)
    private Integer capacity;

    @Column(length = 50)
    private String status = "AVAILABLE";

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	} 
    

    
}