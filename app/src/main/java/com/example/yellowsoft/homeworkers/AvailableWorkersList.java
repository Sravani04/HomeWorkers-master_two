package com.example.yellowsoft.homeworkers;

import android.content.Context;

import com.google.gson.JsonNull;
import com.google.gson.JsonObject;

import java.io.Serializable;

/**
 * Created by info on 18-07-2018.
 */

public class AvailableWorkersList implements Serializable {
    public String id,applicant_id,name,name_ar,age_id,age_title,age_title_ar,nationality_id,nationality_title,nationality_title_ar,email,phone,religion_id,religion_title,religion_title_ar,salary,amount,
            part_amount,experience,experience_ar,exp_date,status,date;
    public AvailableWorkersList(JsonObject jsonObject, Context context){
        id = jsonObject.get("id").getAsString();
        applicant_id = jsonObject.get("applicant_id").getAsString();
        name = jsonObject.get("name").getAsString();
        name_ar = jsonObject.get("name_ar").getAsString();
        age_id = jsonObject.get("age").getAsJsonObject().get("id") != JsonNull.INSTANCE ? age_id = jsonObject.get("age").getAsJsonObject().get("id").getAsString() : null;
        age_title = jsonObject.get("age").getAsJsonObject().get("title") != JsonNull.INSTANCE ? age_title = jsonObject.get("age").getAsJsonObject().get("title").getAsString() : null;
        age_title_ar = jsonObject.get("age").getAsJsonObject().get("id") != JsonNull.INSTANCE ? age_title_ar = jsonObject.get("age").getAsJsonObject().get("title_ar").getAsString() : null;
        nationality_id = jsonObject.get("nationality").getAsJsonObject().get("id") != JsonNull.INSTANCE ? nationality_id = jsonObject.get("nationality").getAsJsonObject().get("id").getAsString() : null;
        nationality_id = jsonObject.get("nationality").getAsJsonObject().get("title") != JsonNull.INSTANCE ? nationality_title = jsonObject.get("nationality").getAsJsonObject().get("title").getAsString() : null;
        nationality_title_ar = jsonObject.get("nationality").getAsJsonObject().get("title_ar") != JsonNull.INSTANCE ? nationality_title_ar = jsonObject.get("nationality").getAsJsonObject().get("title_ar").getAsString() : null;
        email = jsonObject.get("email").getAsString();
        phone = jsonObject.get("phone").getAsString();
        nationality_id = jsonObject.get("nationality").getAsJsonObject().get("id") != JsonNull.INSTANCE ? nationality_id = jsonObject.get("nationality").getAsJsonObject().get("id").getAsString() : null;
        nationality_id = jsonObject.get("nationality").getAsJsonObject().get("title") != JsonNull.INSTANCE ? nationality_title = jsonObject.get("nationality").getAsJsonObject().get("title").getAsString() : null;
        nationality_title_ar = jsonObject.get("nationality").getAsJsonObject().get("title_ar") != JsonNull.INSTANCE ? religion_title_ar = jsonObject.get("nationality").getAsJsonObject().get("title_ar").getAsString() : null;
        salary = jsonObject.get("salary").getAsString();
        amount = jsonObject.get("amount").getAsString();
        part_amount = jsonObject.get("part_amount").getAsString();
        experience = jsonObject.get("experience").getAsString();
        experience_ar = jsonObject.get("experience_ar").getAsString();
        exp_date = jsonObject.get("exp_date").getAsString();
        status = jsonObject.get("status").getAsString();
        date = jsonObject.get("date").getAsString();
    }
}
