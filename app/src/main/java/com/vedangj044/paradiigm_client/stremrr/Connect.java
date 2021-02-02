package com.vedangj044.paradiigm_client.stremrr;

import android.util.Log;

import com.streamr.client.StreamrClient;
import com.streamr.client.authentication.AuthenticationMethod;
import com.streamr.client.authentication.EthereumAuthenticationMethod;
import com.streamr.client.options.EncryptionOptions;
import com.streamr.client.options.SigningOptions;
import com.streamr.client.options.StreamrClientOptions;
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
                StreamrClientOptions options = new StreamrClientOptions(new EthereumAuthenticationMethod("aa139ebaac01f9f7684565b9f52ecec0ba80cd227f6a02e68403736d00f2daa3"), SigningOptions.getDefault(), EncryptionOptions.getDefault(), "wss://hack.streamr.network/api/v1/ws", "https://hack.streamr.network/api/v1");
                StreamrClient client = new StreamrClient(options);

                
                Log.v("key", client.getSessionToken());

                Stream stream = null;
                try {
                    stream = client.getStreamByName(streamID);
                    Log.v("mess", stream.getId() + stream.getDescription());
                } catch (IOException e) {
                    e.printStackTrace();
                }


                client.publish(stream, msg);
            }
        }).start();


    }


}
