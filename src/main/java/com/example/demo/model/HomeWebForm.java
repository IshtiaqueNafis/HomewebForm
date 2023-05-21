package com.example.demo.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@RequiredArgsConstructor
public class HomeWebForm {

    @NotBlank(message = "SSID can not be empty")
    private String SSID;
    @NotBlank(message = "password can not blank")
    private String password;
    @NotBlank(message = "password can not blank")
    private String confirmPassword;


    private LocalDateTime DT = LocalDateTime.now();

    private int WDF1From = 7;
    private int WDF1To = 9;

    private int WDF2From = 17;
    private int WDF2To = 19;


    private int WEF1From = 0;
    private int WEF1To = 0;

    private int WEF2From = 0;
    private int WEF2To = 0;

    private int circuitBreakerA;
    private int circuitBreakerB;


    private int PR;
    private int CT;

    private String zone;

    private int TZ;
    private int DST;
//
//
//    private int SensedPanelRating;
//    private int SensorCTRating;
//
//    private int circuitBreakerA;
//    private int circuitBreakerB;


}
