package io.apsteer.model;

import lombok.Data;

@Data
public class RecaptchaResponse {

	private boolean success;
    private String challenge_ts;
    private String hostname;
}
