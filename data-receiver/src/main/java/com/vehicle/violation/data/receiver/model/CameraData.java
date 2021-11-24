package com.vehicle.violation.data.receiver.model;

import lombok.Data;

@Data
public class CameraData{
    private String vehicleNumber;
    private String owner;
    private String mfd_date;
    private String color;
    private String make;
}
