package com.appointment.entity;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "doctors")
public class Doctor {
	
	@Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message="name should not be blank")
	@Column(nullable = false)
	private String name;
	
	@NotBlank(message="hospital name should not be blank")
	@Column(nullable = false)
	private String hopitalName;
	
	@NotBlank(message="speciality should not be blank")
	@Column(nullable = false)
	private String speciality;
	
	@NotBlank(message="daily time should not be blank")
	@Column(name = "dailytime", nullable = false)
	private String dailyTime;
	
	
	public Doctor() {
		super();
		
	}

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
	
	 public String getHospitalName() {
	        return hopitalName;
	    }

	    public void setHospitalName(String hospitalName) {
	        this.hopitalName = hospitalName;
	    }

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getDailyTime() {
		return dailyTime;
	}

	public void setDailyTime(String dailyTime) {
		this.dailyTime = dailyTime;
	}

	public Doctor(Long id, @NotBlank(message = "name should not be blank") String name,
			@NotBlank(message = "hospital name should not be blank") String hopitalName,
			@NotBlank(message = "speciality should not be blank") String speciality,
			@NotBlank(message = "daily time should not be blank") String dailyTime) {
		super();
		this.id = id;
		this.name = name;
		this.hopitalName = hopitalName;
		this.speciality = speciality;
		this.dailyTime = dailyTime;
	}

	
	
	

}
