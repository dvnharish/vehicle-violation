
package com.vehicle.violation.data.receiver.model;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feed implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3869585325822706186L;
	private String cameraId;
	private String cameraLocation;
	private CameraData cameraData;

}
