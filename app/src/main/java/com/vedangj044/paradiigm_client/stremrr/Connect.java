package com.vedangj044.paradiigm_client.stremrr;

import android.util.Log;

import com.streamr.client.StreamrClient;
import com.streamr.client.authentication.AuthenticationMethod;
import com.streamr.client.authentication.EthereumAuthenticationMethod;
import com.streamr.client.rest.Stream;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Connect {

    private static final String key = "QSTxqRH_TdOV_tzK83H12Qn8vyHxwSQqiyv_DPJCMD_w";
    private static final String streamID = "0x73e1581fa2147bebfc03c39647715be2f6f91d99/paradigm-data";


    public static void publish(Integer age, Integer gender, String question,
                                String answer, Boolean correct, Float response_time) {



        Map<String, Object> msg = new LinkedHashMap<>();
        msg.put("age", age);
        msg.put("gender", gender);
        msg.put("question", question);
        msg.put("answer", answer);
        msg.put("correct", correct);
        msg.put("response_time", response_time);

        new Thread(new Runnable() {
            @Override
            public void run() {
                StreamrClient client = new StreamrClient(new EthereumAuthenticationMethod("0b834453cfd9bfa4eac2c73b15adcbdeffb9892c23f7e52d91e8f61af779ac4b"));

                Stream stream = null;
                try {
                    stream = client.getStream(streamID);
                } catch (IOException e) {
                    e.printStackTrace();
                }


                client.publish(stream, msg);
            }
        }).start();


    }


}
