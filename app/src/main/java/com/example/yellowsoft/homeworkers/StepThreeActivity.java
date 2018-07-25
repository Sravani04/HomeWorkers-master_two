package com.example.yellowsoft.homeworkers;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by info on 16-07-2018.
 */

public class StepThreeActivity extends Activity {
    ImageView back_btn;
    TextView previous_btn,next_btn,excellent_option,arabiclevel_option,msofficelevel_option,typing_option;
    EditText schoolname,years,graduateddate,certificatenumber,schoolname2,years2,date,certificatenumber2,schoolname3,years3,date3,certificatenumber3,
    schoolname4,years4,date4,certificatenumber4;
    LinearLayout excellent_popup,arabiclevel_popup,mslevel_popup,typing_popup,excellent_layout,msoffice_layout,arabic_layout,typing_layout;
    ImageView excellent_close_btn,arabic_close_btn,other_close_btn,mslevel_close_btn,typing_close_btn;
    ListView excellent_list,arabic_list,other_list,mslevel_list,typing_list;
    ArrayList<String> titles;
    String fname,mname,familyname,dob,pob,nationality,expirydate,article,address,telephone,mobile,email,position,doyouworknow,whencanyoustart,expectedsal,marital_status,
    company_name,fullname,occupation,companyname,relationship,employed,current_employer,applied,relatives;

    EnglishLevelAdapter englishLevelAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_request_page3);
        titles = new ArrayList<>();
        titles.add("Excellent");
        titles.add("Good");
        titles.add("Fair");



        excellent_close_btn = (ImageView) findViewById(R.id.excellent_close_btn);
        arabic_close_btn = (ImageView) findViewById(R.id.arabic_close_btn);
        mslevel_close_btn = (ImageView) findViewById(R.id.mslevel_close_btn);
        typing_close_btn = (ImageView) findViewById(R.id.typing_close_btn);
        excellent_list = (ListView) findViewById(R.id.excellent_list);
        arabic_list = (ListView) findViewById(R.id.arabic_list);
        mslevel_list = (ListView) findViewById(R.id.mslevel_list);
        typing_list = (ListView) findViewById(R.id.typing_list);
        back_btn = (ImageView) findViewById(R.id.back_btn);
        previous_btn = (TextView) findViewById(R.id.previous_btn);
        next_btn = (TextView) findViewById(R.id.next_btn);
        excellent_option = (TextView) findViewById(R.id.excellent_option);
        arabiclevel_option = (TextView) findViewById(R.id.arabiclevel_option);
        msofficelevel_option = (TextView) findViewById(R.id.msofficelevel_option);
        typing_option = (TextView) findViewById(R.id.typing_option);
        schoolname = (EditText) findViewById(R.id.schoolname);
        years = (EditText) findViewById(R.id.years);
        graduateddate = (EditText) findViewById(R.id.graduateddate);
        certificatenumber = (EditText) findViewById(R.id.certificatenumber);
        schoolname2 = (EditText) findViewById(R.id.schoolname2);
        years2 = (EditText) findViewById(R.id.years2);
        date = (EditText) findViewById(R.id.date);
        certificatenumber2 = (EditText) findViewById(R.id.certificatenumber2);
        schoolname3 = (EditText) findViewById(R.id.schoolname3);
        years3 = (EditText) findViewById(R.id.years3);
        date3 = (EditText) findViewById(R.id.date3);
        certificatenumber3 = (EditText) findViewById(R.id.certificatenumber3);
        schoolname4 = (EditText) findViewById(R.id.schoolname4);
        years4 = (EditText) findViewById(R.id.years4);
        date4 = (EditText) findViewById(R.id.date4);
        certificatenumber4 = (EditText) findViewById(R.id.certificatenumber4);
        excellent_popup = (LinearLayout) findViewById(R.id.excellent_popup);
        arabiclevel_popup = (LinearLayout) findViewById(R.id.arabiclevel_popup);
        mslevel_popup = (LinearLayout) findViewById(R.id.mslevel_popup);
        typing_popup = (LinearLayout) findViewById(R.id.typing_popup);
        excellent_layout = (LinearLayout) findViewById(R.id.excellent_layout);
        arabic_layout = (LinearLayout) findViewById(R.id.arabic_layout);
        msoffice_layout = (LinearLayout) findViewById(R.id.msoffice_layout);
        typing_layout = (LinearLayout) findViewById(R.id.typing_layout);


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


        englishLevelAdapter = new EnglishLevelAdapter(this,titles);
        excellent_list.setAdapter(englishLevelAdapter);

        //englishLevelAdapter = new EnglishLevelAdapter(this,titles);
        //other_list.setAdapter(englishLevelAdapter);

        englishLevelAdapter = new EnglishLevelAdapter(this,titles);
        arabic_list.setAdapter(englishLevelAdapter);

        englishLevelAdapter = new EnglishLevelAdapter(this,titles);
        mslevel_list.setAdapter(englishLevelAdapter);

        englishLevelAdapter = new EnglishLevelAdapter(this,titles);
        typing_list.setAdapter(englishLevelAdapter);

        excellent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                excellent_popup.setVisibility(View.VISIBLE);
            }
        });

        excellent_close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                excellent_popup.setVisibility(View.GONE);
            }
        });

        excellent_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                excellent_popup.setVisibility(View.GONE);
                excellent_option.setText(titles.get(i));
            }
        });


        arabic_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arabiclevel_popup.setVisibility(View.VISIBLE);
            }
        });

        arabic_close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arabiclevel_popup.setVisibility(View.GONE);
            }
        });

        arabic_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                arabiclevel_popup.setVisibility(View.GONE);
                arabiclevel_option.setText(titles.get(i));
            }
        });


        msoffice_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mslevel_popup.setVisibility(View.VISIBLE);
            }
        });

        mslevel_close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mslevel_popup.setVisibility(View.GONE);
            }
        });

        mslevel_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                mslevel_popup.setVisibility(View.GONE);
                msofficelevel_option.setText(titles.get(i));
            }
        });

        typing_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                typing_popup.setVisibility(View.VISIBLE);
            }
        });

        typing_close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                typing_popup.setVisibility(View.GONE);
            }
        });

        typing_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                typing_popup.setVisibility(View.GONE);
                typing_option.setText(titles.get(i));
            }
        });



        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StepThreeActivity.this.onBackPressed();
            }
        });

        previous_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StepThreeActivity.this.onBackPressed();
            }
        });

        next_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(StepThreeActivity.this,StepFourActivity.class);
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
                intent.putExtra("company_name",company_name);
                intent.putExtra("fullname",fullname);
                intent.putExtra("occupation",occupation);
                intent.putExtra("companyname",companyname);
                intent.putExtra("relationship",relationship);
                intent.putExtra("employed",employed);
                intent.putExtra("current_employer",current_employer);
                intent.putExtra("applied",applied);
                intent.putExtra("relatives",relatives);
                intent.putExtra("school_first",schoolname.getText().toString());
                intent.putExtra("years_first",years.getText().toString());
                intent.putExtra("graduated_date_first",graduateddate.getText().toString());
                intent.putExtra("certificate_first",certificatenumber.getText().toString());
                intent.putExtra("school_second",schoolname2.getText().toString());
                intent.putExtra("years_second",years2.getText().toString());
                intent.putExtra("graduated_date_second",date.getText().toString());
                intent.putExtra("certificate_second",certificatenumber2.getText().toString());
                intent.putExtra("school_third",schoolname3.getText().toString());
                intent.putExtra("years_third",years3.getText().toString());
                intent.putExtra("graduated_date_third",date3.getText().toString());
                intent.putExtra("certificate_third",certificatenumber3.getText().toString());
                intent.putExtra("school_fourth",schoolname4.getText().toString());
                intent.putExtra("years_fourth",years4.getText().toString());
                intent.putExtra("graduated_date_fourth",date4.getText().toString());
                intent.putExtra("certificate_fourth",certificatenumber4.getText().toString());
                intent.putExtra("english",excellent_option.getText().toString());
                intent.putExtra("arabic",arabiclevel_option.getText().toString());
                intent.putExtra("msoffice",msofficelevel_option.getText().toString());
                intent.putExtra("typing",typing_option.getText().toString());
                startActivity(intent);
            }
        });
    }
}