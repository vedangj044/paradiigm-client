package com.vedangj044.paradiigm_client.stremrr;

import com.streamr.client.StreamrClient;
import com.streamr.client.authentication.EthereumAuthenticationMethod;
import com.streamr.client.rest.Stream;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class Connect {

    private static final String key = "QSTxqRH_TdOV_tzK83H12Qn8vyHxwSQqiyv_DPJCMD_w";
    private static final String streamID = "0x73e1581fa2147bebfc03c39647715be2f6f91d99/paradigm-data";
    private static final StreamrClient client = new StreamrClient(new EthereumAuthenticationMethod(key));

    private static void publish(Integer age, Integer gender, String question,
                                String answer, Boolean correct, Float response_time) {

        Stream stream = null;
        try {
            stream = client.getStream(streamID);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Object> msg = new LinkedHashMap<>();
        msg.put("age", age);
        msg.put("gender", gender);
        msg.put("question", question);
        msg.put("answer", answer);
        msg.put("correct", correct);
        msg.put("response_time", response_time);

        client.publish(stream, msg);

    }


}
