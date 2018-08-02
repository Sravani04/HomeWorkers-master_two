package com.example.yellowsoft.homeworkers;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Calendar;

/**
 * Created by info on 16-07-2018.
 */

public class StepTwoActivity extends Activity {
    ImageView back_btn;
    TextView previous_btn,next_btn;
    LinearLayout yes,no,yes_btn,no_btn,yes_layout,yes_working,no_working,no_layout,when_layout;
    TextView yes_option,no_option,yes_value,no_value,yes_val,no_val,yes_text,no_text;
    EditText company_name,full_name,occupation,companyname,contact,fullname2,occupation2,companyname2,contactdetails2,fullname3,occupation3,when_option,
    companyname3,contactdeatsils3,relationship;
    ImageView yes_checkbox,no_checkbox,yes_check,no_check,yes_imageview,no_imageview,yes_,no_;
    String checked,checked1,checked2,checked3;
    String fname,mname,familyname,dob,pob,nationality,expirydate,article,address,telephone,mobile,email,position,doyouworknow,whencanyoustart,expectedsal,marital_status;
    LinearLayout line1,reference_item,line2,line3;
    TextInputLayout name,relationship_layout;
    TextView reference;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_request_page2);
        back_btn = (ImageView) findViewById(R.id.back_btn);
        previous_btn = (TextView) findViewById(R.id.previous_btn);
        next_btn = (TextView) findViewById(R.id.next_btn);
        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StepTwoActivity.this.onBackPressed();
            }
        });




        yes = (LinearLayout) findViewById(R.id.yes);
        no = (LinearLayout) findViewById(R.id.no);
        yes_btn = (LinearLayout) findViewById(R.id.yes_btn);
        no_btn = (LinearLayout) findViewById(R.id.no_btn);
        yes_layout = (LinearLayout) findViewById(R.id.yes_layout);
        no_layout = (LinearLayout) findViewById(R.id.no_layout);
        yes_working = (LinearLayout) findViewById(R.id.yes_working);
        no_working = (LinearLayout) findViewById(R.id.no_working);
        yes_option = (TextView) findViewById(R.id.yes_option);
        no_option = (TextView) findViewById(R.id.no_option);
        yes_value = (TextView) findViewById(R.id.yes_value);
        no_value = (TextView) findViewById(R.id.no_value);
        yes_val = (TextView) findViewById(R.id.yes_val);
        no_val = (TextView) findViewById(R.id.no_val);
        when_option = (EditText) findViewById(R.id.when_option);
        yes_text = (TextView) findViewById(R.id.yes_text);
        no_text = (TextView) findViewById(R.id.no_text);
        yes_checkbox = (ImageView) findViewById(R.id.yes_checkbox);
        no_checkbox = (ImageView) findViewById(R.id.no_checkbox);
        yes_check = (ImageView) findViewById(R.id.yes_check);
        no_check = (ImageView) findViewById(R.id.no_check);
        yes_imageview = (ImageView) findViewById(R.id.yes_imageview);
        no_imageview = (ImageView) findViewById(R.id.no_imageview);
        when_layout = (LinearLayout) findViewById(R.id.when_layout);
        yes_ = (ImageView) findViewById(R.id.yes_);
        no_ = (ImageView) findViewById(R.id.no_);
        line1 = findViewById(R.id.line1);
        reference_item = findViewById(R.id.reference_item);
        reference = findViewById(R.id.reference);
        line2 = findViewById(R.id.line2);
        line3 = findViewById(R.id.line3);
        name = findViewById(R.id.name);
        relationship_layout = findViewById(R.id.relationship_layout);


        yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (yes_checkbox.isEnabled()){
                    yes_checkbox.setImageResource(R.drawable.checked);
                    no_checkbox.setImageResource(R.drawable.unchecked);
                    checked="1";
                    name.setVisibility(View.VISIBLE);
                    line1.setVisibility(View.VISIBLE);

                    //get_quantity();
                }else {
                    yes_checkbox.setImageResource(R.drawable.unchecked);

                }
            }
        });

        no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (no_checkbox.isEnabled()){
                    no_checkbox.setImageResource(R.drawable.checked);
                    yes_checkbox.setImageResource(R.drawable.unchecked);
                    checked="2";
                    name.setVisibility(View.GONE);
                    line1.setVisibility(View.GONE);
                    //get_quantity();
                }else {
                    no_checkbox.setImageResource(R.drawable.unchecked);

                }
            }
        });




        yes_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (yes_check.isEnabled()){
                    yes_check.setImageResource(R.drawable.checked);
                    no_check.setImageResource(R.drawable.unchecked);
                    checked1="1";
                    reference.setVisibility(View.VISIBLE);
                    reference_item.setVisibility(View.VISIBLE);
                    //get_quantity();
                }else {
                    yes_check.setImageResource(R.drawable.unchecked);
                }
            }
        });

        no_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (no_check.isEnabled()){
                    no_check.setImageResource(R.drawable.checked);
                    yes_check.setImageResource(R.drawable.unchecked);
                    checked1="2";
                    reference.setVisibility(View.GONE);
                    reference_item.setVisibility(View.GONE);
                    //get_quantity();
                }else {
                    no_check.setImageResource(R.drawable.unchecked);
                }
            }
        });



        yes_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (yes_imageview.isEnabled()){
                    yes_imageview.setImageResource(R.drawable.checked);
                    no_imageview.setImageResource(R.drawable.unchecked);
                    checked2="1";
                    line2.setVisibility(View.VISIBLE);
                    when_layout.setVisibility(View.VISIBLE);
                    //get_quantity();
                }else {
                    yes_imageview.setImageResource(R.drawable.unchecked);
                }
            }
        });



        no_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (no_imageview.isEnabled()){
                    no_imageview.setImageResource(R.drawable.checked);
                    yes_imageview.setImageResource(R.drawable.unchecked);
                    checked2="2";
                    line2.setVisibility(View.GONE);
                    when_layout.setVisibility(View.GONE);
                    //get_quantity();
                }else {
                    no_imageview.setImageResource(R.drawable.unchecked);
                }
            }
        });




        yes_working.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (yes_.isEnabled()){
                    yes_.setImageResource(R.drawable.checked);
                    no_.setImageResource(R.drawable.unchecked);
                    checked3="1";
                    line3.setVisibility(View.VISIBLE);
                    relationship_layout.setVisibility(View.VISIBLE);
                    //get_quantity();
                }else {
                    yes_.setImageResource(R.drawable.unchecked);
                }
            }
        });

        no_working.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (no_.isEnabled()){
                    no_.setImageResource(R.drawable.checked);
                    yes_.setImageResource(R.drawable.unchecked);
                    checked3="2";
                    line3.setVisibility(View.GONE);
                    relationship_layout.setVisibility(View.GONE);
                    //get_quantity();
                }else {
                    no_.setImageResource(R.drawable.unchecked);
                }
            }
        });


        fname = getIntent().getStringExtra("first_name");
        mname = getIntent().getStringExtra("middle_name");
        familyname = getIntent().getStringExtra("family_name");
        dob = getIntent().getStringExtra("date_of_birth");
        pob = getIntent().getStringExtra("place_of_birth");
        nationality = getIntent().getStringExtra("nationality");
        expirydate = getIntent().getStringExtra("expirydate");
        article = getIntent().getStringExtra("article");
        address = getIntent().getStringExtra("address");
        telephone = getIntent().getStringExtra("telephone");
        mobile = getIntent().getStringExtra("mobile");
        email = getIntent().getStringExtra("email");
        position = getIntent().getStringExtra("position_applied_for");
        doyouworknow = getIntent().getStringExtra("do_you_work_now");
        whencanyoustart = getIntent().getStringExtra("when_can_youstart");
        expectedsal = getIntent().getStringExtra("expectedsal");
        marital_status = getIntent().getStringExtra("marital_status");

        company_name = (EditText) findViewById(R.id.company_name);
        full_name = (EditText) findViewById(R.id.full_name);
        occupation = (EditText) findViewById(R.id.occupation);
        companyname = (EditText) findViewById(R.id.company_name);
        relationship = (EditText) findViewById(R.id.relationship);
        contact = (EditText) findViewById(R.id.contact);

         when_option.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 datePicker();
             }
         });

         when_layout.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view) {
                 datePicker();
             }
         });





        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StepTwoActivity.this,StepThreeActivity.class);
                intent.putExtra("fname",fname);
                intent.putExtra("mname",mname);
                intent.putExtra("familyname",familyname);
                intent.putExtra("dob",dob);
                intent.putExtra("pob",pob);
                intent.putExtra("nationality",nationality);
                intent.putExtra("expirydate",expirydate);
                intent.putExtra("article",article);
                intent.putExtra("address",address);
                intent.putExtra("telephone",telephone);
                intent.putExtra("mobile",mobile);
                intent.putExtra("email",email);
                intent.putExtra("position",position);
                intent.putExtra("doyouworknow",doyouworknow);
                intent.putExtra("whencanyoustart",whencanyoustart);
                intent.putExtra("expectedsal",expectedsal);
                intent.putExtra("marital_status",marital_status);
                intent.putExtra("company_name",company_name.getText().toString());
                intent.putExtra("fullname",full_name.getText().toString());
                intent.putExtra("occupation",occupation.getText().toString());
                intent.putExtra("companyname",companyname.getText().toString());
                intent.putExtra("contact",contact.getText().toString());
                intent.putExtra("when",when_option.getText().toString());
                intent.putExtra("relationship",relationship.getText().toString());
                intent.putExtra("employed",checked);
                intent.putExtra("current_employer",checked1);
                intent.putExtra("applied",checked2);
                intent.putExtra("relatives",checked3);

                startActivity(intent);
            }
        });

        previous_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StepTwoActivity.this.onBackPressed();
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
                        when_option.setText(date_time);
                    }
                }, mYear, mMonth, mDay);
        datePickerDialog.show();
    }
}
