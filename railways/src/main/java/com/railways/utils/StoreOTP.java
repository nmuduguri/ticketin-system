package com.railways.utils;

public class StoreOTP {

	public String otp;
	public Long milliseconds;

	public StoreOTP() {
		super();
	}

	public StoreOTP(String otp, Long milliseconds) {
		super();
		this.otp = otp;
		this.milliseconds = milliseconds;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Long getMilliseconds() {
		return milliseconds;
	}

	public void setMilliseconds(Long milliseconds) {
		this.milliseconds = milliseconds;
	}

	@Override
	public String toString() {
		return "StoreOTP [otp=" + otp + ", milliseconds=" + milliseconds + "]";
	}

}
