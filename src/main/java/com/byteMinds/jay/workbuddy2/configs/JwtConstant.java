package com.byteMinds.jay.workbuddy2.configs;

import org.springframework.boot.context.properties.ConfigurationProperties;



@ConfigurationProperties(prefix = "jwt")
public class JwtConstant {


    public  final  String SECRET_KEY;

    public  final  String HEADER;

    public JwtConstant(String SECRET_KEY,String HEADER)
    {
        this.SECRET_KEY= SECRET_KEY;
        this.HEADER=HEADER;

    }





}
