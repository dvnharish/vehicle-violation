package com.vehicle.violation.traffic.governance.service.model;

public enum DeviceType {

	MOBILE("MOBILE"), TRANSCEIVER("WALKI"), MIC("MIC");

	public final String label;

	private DeviceType(String label) {
		this.label = label;
	}
}
