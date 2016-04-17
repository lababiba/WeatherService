package com.example.lababiba.weatherservice.Interfaces;

/**
 * Created by lababiba on 14.04.16.
 */
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
// говорим, что веб-сервис будет использоваться для вызова методов
@SOAPBinding(style = SOAPBinding.Style.RPC)

public interface IWebService {

    // говорим, что этот метод можно вызывать удаленно


    @WebMethod
    public String[] getWeather(String city);

    @WebMethod
    public String[] getCites();
}
