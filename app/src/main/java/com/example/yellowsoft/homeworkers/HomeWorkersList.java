package com.example.yellowsoft.homeworkers;

import android.content.Context;

import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

import java.io.Serializable;

/**
 * Created by info on 14-07-2018.
 */

public class HomeWorkersList implements Serializable {
    public String id,type,age_id,age_title,age_title_ar,exp_kuwait,phone,status,nationality_id,nationality_title,nationality_title_ar,service_id,service_title,
    service_title_ar,religion_id,religion_title,religion_title_ar,date;
    public HomeWorkersList(JsonObject jsonObject, Context context){
        id =  jsonObject.get("id").getAsString();
        type = jsonObject.get("type").getAsString();
        age_id = jsonObject.get("age").getAsJsonObject().get("id") != JsonNull.INSTANCE ? age_id = jsonObject.get("age").getAsJsonObject().get("id").getAsString() : null;
        age_title = jsonObject.get("age").getAsJsonObject().get("title") != JsonNull.INSTANCE ? age_title = jsonObject.get("age").getAsJsonObject().get("title").getAsString() : null;
        age_title_ar = jsonObject.get("age").getAsJsonObject().get("id") != JsonNull.INSTANCE ? age_title_ar = jsonObject.get("age").getAsJsonObject().get("title_ar").getAsString() : null;
        exp_kuwait = jsonObject.get("exp_kuwait").getAsString();
        phone = jsonObject.get("phone").getAsString();
        status = jsonObject.get("status").getAsString();
        date = jsonObject.get("date").getAsString();
        nationality_id = jsonObject.get("nationality").getAsJsonObject().get("id") != JsonNull.INSTANCE ? nationality_id = jsonObject.get("nationality").getAsJsonObject().get("id").getAsString() : null;
        nationality_id = jsonObject.get("nationality").getAsJsonObject().get("title") != JsonNull.INSTANCE ? nationality_title = jsonObject.get("nationality").getAsJsonObject().get("title").getAsString() : null;
        nationality_title_ar = jsonObject.get("nationality").getAsJsonObject().get("title_ar") != JsonNull.INSTANCE ? nationality_title_ar = jsonObject.get("nationality").getAsJsonObject().get("title_ar").getAsString() : null;
        service_id = jsonObject.get("service").getAsJsonObject().get("id") != JsonNull.INSTANCE ? service_id = jsonObject.get("service").getAsJsonObject().get("id").getAsString() : null;
        service_title = jsonObject.get("service").getAsJsonObject().get("title") != JsonNull.INSTANCE ? service_title = jsonObject.get("service").getAsJsonObject().get("title").getAsString() : null;
        service_title_ar = jsonObject.get("service").getAsJsonObject().get("title_ar") != JsonNull.INSTANCE ? service_title_ar = jsonObject.get("service").getAsJsonObject().get("title_ar").getAsString() : null;
        religion_id = jsonObject.get("religion").getAsJsonObject().get("id") != JsonNull.INSTANCE ? religion_id = jsonObject.get("religion").getAsJsonObject().get("id").getAsString() : null;
        religion_title = jsonObject.get("religion").getAsJsonObject().get("title") != JsonNull.INSTANCE ? religion_title = jsonObject.get("religion").getAsJsonObject().get("title").getAsString() : null;
        religion_title_ar = jsonObject.get("religion").getAsJsonObject().get("title_ar") != JsonNull.INSTANCE ? religion_title_ar = jsonObject.get("religion").getAsJsonObject().get("title_ar").getAsString() : null;


    }
}
