package com.example.yellowsoft.homeworkers;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.util.Calendar;

/**
 * Created by info on 16-07-2018.
 */

public class StepFourActivity extends Activity {
    ImageView back_btn;
    TextView previous_btn,submit_btn,from_date_option,to_date_option,from2,todate2,from3,todate3;
    EditText employer,last_position,start_sal,last_sal,employer2,lastposition2,start2,last2,employer3,lastposition3,start3,last3;
    LinearLayout from_date_layout,to_date_layout,fromdate_layout,todate_layout,fromdate_,todate_;
    String fname,mname,familyname,dob,pob,nationality,expirydate,article,address,telephone,mobile,email,position,doyouworknow,whencanyoustart,expectedsal,marital_status,
            company_name,fullname,occupation,companyname,relationship,employed,current_employer,applied,relatives,school_first,school_second,school_third,school_fourth,
    years_first,years_second,years_third,years_fourth,graduated_date_first,graduated_date_second,graduated_date_third,graduated_date_fourth,certificate_first,certificate_second,
    certificate_third,certificate_fourth,english,arabic,msoffice,typing,contact,when;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_request_page4);
        back_btn = (ImageView) findViewById(R.id.back_btn);
        previous_btn = (TextView) findViewById(R.id.previous_btn);
        submit_btn = (TextView) findViewById(R.id.submit_btn);
        from_date_option = (TextView) findViewById(R.id.from_date_option);
        to_date_option = (TextView) findViewById(R.id.to_date_option);
        from2 = (TextView) findViewById(R.id.from2);
        todate2 = (TextView) findViewById(R.id.todate2);
        from3 = (TextView) findViewById(R.id.from3);
        todate3 = (TextView) findViewById(R.id.todate3);
        employer = (EditText) findViewById(R.id.employer);
        last_position = (EditText) findViewById(R.id.last_position);
        start_sal = (EditText) findViewById(R.id.start_sal);
        last_sal = (EditText) findViewById(R.id.last_sal);
        employer2 = (EditText) findViewById(R.id.employer2);
        lastposition2 = (EditText) findViewById(R.id.lastposition2);
        start2 = (EditText) findViewById(R.id.start2);
        last2 = (EditText) findViewById(R.id.last2);
        employer3 = (EditText) findViewById(R.id.employer3);
        lastposition3 = (EditText) findViewById(R.id.lastposition3);
        start3 = (EditText) findViewById(R.id.start3);
        last3 = (EditText) findViewById(R.id.last3);
        from_date_layout = (LinearLayout) findViewById(R.id.from_date_layout);
        to_date_layout = (LinearLayout) findViewById(R.id.to_date_layout);
        fromdate_layout = (LinearLayout) findViewById(R.id.fromdate_layout);
        todate_layout = (LinearLayout) findViewById(R.id.todate_layout);
        fromdate_ = (LinearLayout) findViewById(R.id.fromdate_);
        todate_ = (LinearLayout) findViewById(R.id.todate_);

        fname = getIntent().getStringExtra("fname");
        mname = getIntent().getStringExtra("mname");
        familyname = getIntent().getStringExtra("familyname");
        dob = getIntent().getStringExtra("dob");
        pob = getIntent().getStringExtra("pob");
        nationality = getIntent().getStringExtra("nationality");
        expirydate = getIntent().getStringExtra("expirydate");
        article = getIntent().getStringExtra("article");
        address = getIntent().getStringExtra("address");
        telephone = getIntent().getStringExtra("telephone");
        mobile = getIntent().getStringExtra("mobile");
        email = getIntent().getStringExtra("email");
        position = getIntent().getStringExtra("position");
        doyouworknow = getIntent().getStringExtra("doyouworknow");
        whencanyoustart = getIntent().getStringExtra("whencanyoustart");
        expectedsal = getIntent().getStringExtra("expectedsal");
        marital_status = getIntent().getStringExtra("marital_status");
        company_name = getIntent().getStringExtra("company_name");
        fullname = getIntent().getStringExtra("fullname");
        occupation = getIntent().getStringExtra("occupation");
        companyname = getIntent().getStringExtra("companyname");
        relationship =  getIntent().getStringExtra("relationship");
        employed = getIntent().getStringExtra("employed");
        current_employer = getIntent().getStringExtra("current_employer");
        applied = getIntent().getStringExtra("applied");
        relatives = getIntent().getStringExtra("relatives");
        contact = getIntent().getStringExtra("contact");
        when= getIntent().getStringExtra("when");
        school_first= getIntent().getStringExtra("schoolname");
        years_first = getIntent().getStringExtra("years");
        graduated_date_first = getIntent().getStringExtra("graduateddate");
        certificate_first= getIntent().getStringExtra("certificatenumber");
        school_second = getIntent().getStringExtra("schoolname2");
        years_second = getIntent().getStringExtra("years2");
        graduated_date_second = getIntent().getStringExtra("date");
        certificate_second =getIntent().getStringExtra("certificatenumber2");
        school_third = getIntent().getStringExtra("schoolname3");
        years_third = getIntent().getStringExtra("years3");
        graduated_date_third = getIntent().getStringExtra("date3");
        certificate_third = getIntent().getStringExtra("certificatenumber3");
        school_fourth = getIntent().getStringExtra("schoolname4");
        years_fourth = getIntent().getStringExtra("years4");
        graduated_date_fourth = getIntent().getStringExtra("date4");
        certificate_fourth = getIntent().getStringExtra("certificatenumber4");
        english = getIntent().getStringExtra("excellent_option");
        arabic = getIntent().getStringExtra("arabiclevel_option");
        msoffice = getIntent().getStringExtra("msofficelevel_option");
        typing = getIntent().getStringExtra("typing_option");

        from_date_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker();
            }
        });

        to_date_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker2();
            }

        });

        fromdate_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker3();
            }
        });

        todate_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker4();
            }
        });

        fromdate_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker5();
            }
        });

        todate_.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePicker6();
            }
        });



        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StepFourActivity.this.onBackPressed();
            }
        });
        previous_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StepFourActivity.this.onBackPressed();
            }
        });

        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              post_employee();
            }
        });
    }


    private void datePicker(){
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        String date_time = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        from_date_option.setText(date_time);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void datePicker2(){
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        String date_time = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        to_date_option.setText(date_time);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void datePicker3(){
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        String date_time = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        from2.setText(date_time);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void datePicker4(){
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        String date_time = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        todate2.setText(date_time);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void datePicker5(){
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        String date_time = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        from3.setText(date_time);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    private void datePicker6(){
        final Calendar c = Calendar.getInstance();
        int mYear = c.get(Calendar.YEAR);
        int mMonth = c.get(Calendar.MONTH);
        int mDay = c.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                        String date_time = dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                        todate3.setText(date_time);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }

    public void post_employee(){


        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("member_id", Session.GetUserId(this));
        jsonObject.addProperty("first_name",fname);
        jsonObject.addProperty("middle_name",mname);
        jsonObject.addProperty("family_name",familyname );
        jsonObject.addProperty("date_of_birth", dob);
        jsonObject.addProperty("place_of_birth", pob);
        jsonObject.addProperty("nationality", nationality);
        jsonObject.addProperty("residence_expiredate", expirydate);
        jsonObject.addProperty("article_number", article);
        jsonObject.addProperty("address",address);
        jsonObject.addProperty("telephone",telephone);
        jsonObject.addProperty("mobile",mobile);
        jsonObject.addProperty("email",email);
        jsonObject.addProperty("position_applied_for",position);
        jsonObject.addProperty("do_you_work_now",doyouworknow);
        jsonObject.addProperty("when_can_youstart",whencanyoustart);
        jsonObject.addProperty("expected_salary",expectedsal);
        jsonObject.addProperty("marital_status",marital_status);
        jsonObject.addProperty("are-you_employed",employed);
        jsonObject.addProperty("companyName",company_name);
        jsonObject.addProperty("maywe_contact_yourcurrent_employer",current_employer);
        jsonObject.addProperty("fullname_first",fullname);
        jsonObject.addProperty("occupation_first",occupation);
        jsonObject.addProperty("company_first",companyname);
        jsonObject.addProperty("contactdetails_first",contact);
        jsonObject.addProperty("applied_before",applied);
        jsonObject.addProperty("when",when);
        jsonObject.addProperty("relatives_incompany",relatives);
        jsonObject.addProperty("name_relationship",relationship);
        jsonObject.addProperty("school_first",school_first);
        jsonObject.addProperty("years_first",years_first);
        jsonObject.addProperty("graduated_date_first",graduated_date_first);
        jsonObject.addProperty("certificate_first",certificate_first);
        jsonObject.addProperty("school_second",school_second);
        jsonObject.addProperty("years_second",years_second);
        jsonObject.addProperty("graduated_date_second",graduated_date_second);
        jsonObject.addProperty("certificate_second",certificate_second);
        jsonObject.addProperty("school_third",school_third);
        jsonObject.addProperty("years_third",years_third);
        jsonObject.addProperty("graduated_date_third",graduated_date_third);
        jsonObject.addProperty("certificate_third",certificate_third);
        jsonObject.addProperty("school_fourth",school_fourth);
        jsonObject.addProperty("years_fourth",years_fourth);
        jsonObject.addProperty("graduated_date_fourth",graduated_date_fourth);
        jsonObject.addProperty("certificate_fourth",certificate_fourth);
        jsonObject.addProperty("english",english);
        jsonObject.addProperty("arabic",arabic);
        jsonObject.addProperty("msoffice",msoffice);
        jsonObject.addProperty("typing",typing);
        //JsonArray jsonArray = jsonObject.get("employer").getAsJsonArray();
//        for (int i = 0; i < jsonArray.size(); i++) {
//            JsonObject jsonObject2 = new JsonObject();
//            jsonObject2.addProperty("employer", employer.getText().toString());
//            jsonObject2.addProperty("start_sal", start_sal.getText().toString());
//            jsonObject2.addProperty("to",to_date_option.getText().toString());
//            jsonObject2.addProperty("last-position",last_position.getText().toString());
//            jsonObject2.addProperty("last_sal",last_sal.getText().toString());
//            jsonObject2.addProperty("from",from_date_option.getText().toString());
//            jsonArray.add(jsonObject2);
//            Log.e("employee", jsonArray.toString());
//        }
//        jsonObject.add("employee", jsonArray);


        Log.e("reeeee", jsonObject.toString());


        if (fname.equals("")){
            Toast.makeText(StepFourActivity.this,"Please Enter FirstName",Toast.LENGTH_SHORT).show();
        }else if (mname.equals("")){
            Toast.makeText(StepFourActivity.this,"Please Enter MiddleName",Toast.LENGTH_SHORT).show();
        }else if (fname.equals("")){
            Toast.makeText(StepFourActivity.this,"Please Enter FamilyName",Toast.LENGTH_SHORT).show();
        }else if (dob.equals("")){
            Toast.makeText(StepFourActivity.this,"Please Enter Date Of Birth",Toast.LENGTH_SHORT).show();
        }else if (pob.equals("")){
            Toast.makeText(StepFourActivity.this,"Please Enter Place Of Birth",Toast.LENGTH_SHORT).show();
        }else if (nationality.equals("")){
            Toast.makeText(StepFourActivity.this,"Please Enter Nationality",Toast.LENGTH_SHORT).show();
        }else if (expirydate.equals("")){
            Toast.makeText(StepFourActivity.this,"Please Enter Residency Expire Date",Toast.LENGTH_SHORT).show();
        }else if (article.equals("")){
            Toast.makeText(StepFourActivity.this,"Please Enter Article Number",Toast.LENGTH_SHORT).show();
        }else if (address.equals("")){
            Toast.makeText(StepFourActivity.this,"Please Enter Address",Toast.LENGTH_SHORT).show();
        }else if (telephone.equals("")){
            Toast.makeText(StepFourActivity.this,"Please Enter Telephone",Toast.LENGTH_SHORT).show();
        }else if (mobile.equals("")){
            Toast.makeText(StepFourActivity.this,"Please Enter Mobile Number",Toast.LENGTH_SHORT).show();
        }else if (email.equals("")){
            Toast.makeText(StepFourActivity.this,"Please Enter Email",Toast.LENGTH_SHORT).show();
        }else if (position.equals("")){
            Toast.makeText(StepFourActivity.this,"Please Enter Selected Post",Toast.LENGTH_SHORT).show();
        }else if (whencanyoustart.equals("")){
            Toast.makeText(StepFourActivity.this,"Please Enter When can you start",Toast.LENGTH_SHORT).show();
        }else if (expectedsal.equals("")){
            Toast.makeText(StepFourActivity.this,"Please Enter Expected  Salary",Toast.LENGTH_SHORT).show();
        }else if (marital_status.equals("")){
            Toast.makeText(StepFourActivity.this,"Please Enter Marital Status",Toast.LENGTH_SHORT).show();
        }else if (employed.equals("")){
            Toast.makeText(StepFourActivity.this,"Please Enter Are you employed?",Toast.LENGTH_SHORT).show();
        }else if (company_name.equals("")){
            Toast.makeText(StepFourActivity.this,"Please Enter Company Name",Toast.LENGTH_SHORT).show();
        }else if (current_employer.equals("")){
            Toast.makeText(StepFourActivity.this,"Please Enter Current Employer?",Toast.LENGTH_SHORT).show();
        }else if (fullname.equals("")){
            Toast.makeText(StepFourActivity.this,"Please Enter Full Name",Toast.LENGTH_SHORT).show();
        }else if (occupation.equals("")) {
            Toast.makeText(StepFourActivity.this, "Please Enter Occupation", Toast.LENGTH_SHORT).show();
        }else if (companyname.equals("")){
            Toast.makeText(StepFourActivity.this, "Please Enter Company Name", Toast.LENGTH_SHORT).show();
        }else if (contact.equals("")){
            Toast.makeText(StepFourActivity.this, "Please Enter Contact Details", Toast.LENGTH_SHORT).show();
        }else if (applied.equals("")){
            Toast.makeText(StepFourActivity.this, "Please Enter Applied ", Toast.LENGTH_SHORT).show();
        }else if (when.equals("")){
            Toast.makeText(StepFourActivity.this, "Please Enter When", Toast.LENGTH_SHORT).show();
        }else if (relatives.equals("")){
            Toast.makeText(StepFourActivity.this, "Please Enter Relatives working in this company", Toast.LENGTH_SHORT).show();
        }else if (relationship.equals("")){
            Toast.makeText(StepFourActivity.this, "Please Enter Name and Relationship", Toast.LENGTH_SHORT).show();
        }else {


            Ion.with(this)
                    .load(Session.SERVER_URL + "add-employee.php")
                    .setBodyParameter("member_id", Session.GetUserId(this))
                    .setBodyParameter("content", jsonObject.toString())
                    .asJsonObject()
                    .setCallback(new FutureCallback<JsonObject>() {
                        @Override
                        public void onCompleted(Exception e, JsonObject result) {
                            if (result.get("status").getAsString().equals("Success")) {
                                Log.e("result", result.toString());
                                Log.e("corporate_id", result.get("corporate_id").getAsString());
                                Log.e("result", result.get("message").getAsString());
                                Toast.makeText(StepFourActivity.this, result.get("message").getAsString(), Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(StepFourActivity.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                                return;
                            }
                            Toast.makeText(StepFourActivity.this, result.get("message").getAsString(), Toast.LENGTH_SHORT).show();
                        }
                    });
        }
    }



}
