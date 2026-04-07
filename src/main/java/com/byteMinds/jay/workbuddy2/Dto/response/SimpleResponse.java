package com.byteMinds.jay.workbuddy2.Dto.response;

public class AuthResponse {
    private  String message;
    private  String jwt;

    public  AuthResponse(String message, String jwt)
    {
      this.message= message;
      this.jwt= jwt;
    }
   public  AuthResponse()
   {

   }


    public void setMessage(String message) {
        this.message = message;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getMessage() {
        return message;
    }

    public String getJwt() {
        return jwt;
    }
}
