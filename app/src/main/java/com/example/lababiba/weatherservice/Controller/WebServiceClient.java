package com.example.lababiba.weatherservice.Controller;


import android.util.Log;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.SoapFault;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.net.Proxy;
import java.net.URL;
import java.util.List;
import javax.xml.namespace.QName;



/**
 * Created by lababiba on 14.04.16.
 */
public class WebServiceClient {
    private static final String MAIN_REQUEST_URL = "http://178.136.218.195:8080/web";
    private static WebServiceClient WSinstance;
    private static final String namespace = "http://Implemention.Controller/";
    private static final String methodname = "getWeather";


    public static WebServiceClient getInstance()
    {
        if(WSinstance==null) WSinstance = new WebServiceClient();
        return WSinstance;
    }

    static public void connect()
    {
        SoapObject request = new SoapObject(namespace,methodname);
        request.addProperty("","Одесса");
        SoapSerializationEnvelope envelope = getSoapSerializationEnvelope(request);

        HttpTransportSE ht = getHttpTransportSE();
        try {
            ht.call("getWeather",envelope);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }



        try {
            SoapPrimitive resultsString = (SoapPrimitive)envelope.getResponse();
            Log.e(request.toString(),resultsString.toString());

        } catch (SoapFault soapFault) {
            soapFault.printStackTrace();
        }



    }

    private static HttpTransportSE getHttpTransportSE() {
        HttpTransportSE ht = new HttpTransportSE(MAIN_REQUEST_URL,60000);
        ht.debug = true;
        ht.setXmlVersionTag("<!--?xml version=\"1.0\" encoding= \"UTF-8\" ?-->");
        return ht;

    }




    private static final SoapSerializationEnvelope getSoapSerializationEnvelope(SoapObject request) {
        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        envelope.dotNet = false;
        envelope.implicitTypes = true;
        envelope.setAddAdornments(false);
        envelope.setOutputSoapObject(request);

        return envelope;
    }

}
