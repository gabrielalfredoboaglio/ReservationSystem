package com.transporteboaglio.TB.service;

public interface RecaptchaService {

    boolean validateRecaptcha(String captchaResponse);
}
