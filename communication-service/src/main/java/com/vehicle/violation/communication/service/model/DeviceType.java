package com.vehicle.violation.communication.service.model;

public enum DeviceType {

	MOBILE("MOBILE"), TRANSCEIVER("TRANSCEIVER"), MIC("MIC");

	public final String label;

	private DeviceType(String label) {
		this.label = label;
	}
}
