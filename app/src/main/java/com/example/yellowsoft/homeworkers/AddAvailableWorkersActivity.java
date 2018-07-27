package com.example.yellowsoft.homeworkers;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.io.File;
import java.util.ArrayList;

/**
 * Created by info on 17-04-2018.
 */

public class AddAvailableWorkersActivity extends Activity {
    ImageView back_btn;
    EditText name,sal,amount,experience;
    String nationality_id,religion_id;
    ArrayList<Nationality> nationalitiesfrom_api;
    ArrayList<Religions> religionsfrom_api;
    LinearLayout submit;
    EditText age,nationality_option,religion_option,amt_btn;
    NationalityAdapter nationalityAdapter;
    ReligionAdapter religionAdapter;
    LinearLayout select_nationality,nationality_popup,religion_popup,select_age,select_religion,age_popup;
    ImageView nationality_close_btn,religion_close_btn,age_close_btn;
    ListView nationality_list,religion_list,age_list;
    ImageView profile_image;
    ArrayList<Age> agefrom_api;
    AgeAdapter ageAdapter;
    String req_id,msg;
    LinearLayout male,female;
    ImageView male_checkbox,female_checkbox;
    TextView male_option,female_option;
    String type,service_charge;
    int ASK_MULTIPLE_PERMISSION_REQUEST_CODE;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_available_worker);
        Session.forceRTLIfSupported(this);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        nationalitiesfrom_api = new ArrayList<>();
        religionsfrom_api = new ArrayList<>();
        agefrom_api = new ArrayList<>();
        name = (EditText) findViewById(R.id.name);
        age = (EditText) findViewById(R.id.age);
        nationality_option = (EditText) findViewById(R.id.nationality_option);
        religion_option = (EditText) findViewById(R.id.religion_option);
        sal = (EditText) findViewById(R.id.sal);
        amount = (EditText) findViewById(R.id.amount);
        experience = (EditText) findViewById(R.id.experience);
        submit= (LinearLayout) findViewById(R.id.submit);
        profile_image = (ImageView) findViewById(R.id.profile_image);
        nationality_popup = (LinearLayout) findViewById(R.id.nationality_popup);
        religion_popup = (LinearLayout) findViewById(R.id.religion_popup);
        nationality_close_btn = (ImageView) findViewById(R.id.nationality_close_btn);
        religion_close_btn = (ImageView) findViewById(R.id.religion_close_btn);
        nationality_list = (ListView) findViewById(R.id.nationality_list);
        select_nationality = (LinearLayout) findViewById(R.id.select_nationality);
        select_religion = (LinearLayout) findViewById(R.id.select_religion);
        select_age = (LinearLayout) findViewById(R.id.select_age);
        age_popup = (LinearLayout) findViewById(R.id.age_popup);
        back_btn = (ImageView) findViewById(R.id.back_btn);
        age_close_btn = (ImageView) findViewById(R.id.age_close_btn);
        religion_list = (ListView) findViewById(R.id.religion_list);
        amt_btn = (EditText) findViewById(R.id.amt_btn);
        age_list = (ListView) findViewById(R.id.age_list);
        male_checkbox = (ImageView) findViewById(R.id.male_checkbox);
        female_checkbox = (ImageView) findViewById(R.id.female_checkbox);
        male_option = (TextView) findViewById(R.id.male_option);
        female_option = (TextView) findViewById(R.id.female_option);
        male = (LinearLayout) findViewById(R.id.male);
        female = (LinearLayout) findViewById(R.id.female);
        nationalityAdapter = new NationalityAdapter(this,nationalitiesfrom_api);
        nationality_list.setAdapter(nationalityAdapter);
        religionAdapter = new ReligionAdapter(this,religionsfrom_api);
        religion_list.setAdapter(religionAdapter);
        ageAdapter = new AgeAdapter(this,agefrom_api);
        age_list.setAdapter(ageAdapter);

        select_nationality.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nationality_popup.setVisibility(View.VISIBLE);
                Animation anim = AnimationUtils.loadAnimation(AddAvailableWorkersActivity.this, R.anim.myanim);
                nationality_popup.startAnimation(anim);
//                Dialog dialog = onNationalityChoice();
//                dialog.show();
            }
        });

        nationality_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nationality_popup.setVisibility(View.VISIBLE);
                Animation anim = AnimationUtils.loadAnimation(AddAvailableWorkersActivity.this, R.anim.myanim);
                nationality_popup.startAnimation(anim);
//                Dialog dialog = onNationalityChoice();
//                dialog.show();
            }
        });

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddAvailableWorkersActivity.this.onBackPressed();
            }
        });

        nationality_close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nationality_popup.setVisibility(View.GONE);
            }
        });

        religion_close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                religion_popup.setVisibility(View.GONE);
            }
        });

        male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (male_checkbox.isEnabled()){
                    male_checkbox.setImageResource(R.drawable.checked);
                    female_checkbox.setImageResource(R.drawable.unchecked);
                    type="0";
                }else {
                    male_checkbox.setImageResource(R.drawable.unchecked);
                }
            }
        });

        female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (female_checkbox.isEnabled()){
                    female_checkbox.setImageResource(R.drawable.checked);
                    male_checkbox.setImageResource(R.drawable.unchecked);
                    type="1";
                }else {
                    female_checkbox.setImageResource(R.drawable.unchecked);

                }
            }
        });

        select_religion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                religion_popup.setVisibility(View.VISIBLE);
                Animation anim = AnimationUtils.loadAnimation(AddAvailableWorkersActivity.this, R.anim.myanim);
                religion_popup.startAnimation(anim);
//                Dialog dialog = onReligionChoice();
//                dialog.show();
            }
        });

        religion_option.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                religion_popup.setVisibility(View.VISIBLE);
                Animation anim = AnimationUtils.loadAnimation(AddAvailableWorkersActivity.this, R.anim.myanim);
                religion_popup.startAnimation(anim);
//                Dialog dialog = onReligionChoice();
//                dialog.show();
            }
        });

        select_age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age_popup.setVisibility(View.VISIBLE);
                Animation anim = AnimationUtils.loadAnimation(AddAvailableWorkersActivity.this, R.anim.myanim);
                age_popup.startAnimation(anim);
//                Dialog dialog = onReligionChoice();
//                dialog.show();
            }
        });

        age.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age_popup.setVisibility(View.VISIBLE);
                Animation anim = AnimationUtils.loadAnimation(AddAvailableWorkersActivity.this, R.anim.myanim);
                age_popup.startAnimation(anim);
//                Dialog dialog = onReligionChoice();
//                dialog.show();
            }
        });

        age_close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                age_popup.setVisibility(View.GONE);
            }
        });

        nationality_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                nationality_popup.setVisibility(View.GONE);
                nationality_option.setText(nationalitiesfrom_api.get(i).title);
            }
        });

        religion_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                religion_popup.setVisibility(View.GONE);
                religion_option.setText(religionsfrom_api.get(i).title);
            }
        });

        age_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                age_popup.setVisibility(View.GONE);
                age.setText(agefrom_api.get(i).title);
            }
        });


        try {
            JsonParser jsonParser = new JsonParser();
            if (!Session.GetSettings(AddAvailableWorkersActivity.this).equals("-1")) {
                JsonObject parse = (JsonObject) jsonParser.parse(Session.GetSettings(AddAvailableWorkersActivity.this));
                 service_charge = parse.get("avail_amount").getAsString();
                amt_btn.setText(service_charge+" KD ");
            }
        }catch (Exception e1){
            e1.printStackTrace();
        }







        profile_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("is","coming or not");
                final CharSequence[] items = {"camera","gallery"};
                AlertDialog.Builder builder = new AlertDialog.Builder(AddAvailableWorkersActivity.this);
                builder.setTitle("select_image");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if(items[item].equals("camera")){
                            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            startActivityForResult(intent,1);

                        }else if(items[item].equals("gallery")){
                            Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                                    MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            startActivityForResult(pickPhoto,2);
                        }
                    }
                });
                AlertDialog alert = builder.create();
                alert.show();
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                add_available_workers();
            }
        });
        get_nationalities();
        get_religions();
        get_age();

    }

    String selected_image_path = "";
    protected void onActivityResult(int requestCode,int resultCode,Intent imageReturnedIntent){
        super.onActivityResult(requestCode,resultCode,imageReturnedIntent);
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    profile_image.setImageURI(selectedImage);
                    selected_image_path = getRealPathFromURI(selectedImage);
                    Log.e("image_path",selected_image_path);

                }
                break;
            case 2:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    profile_image.setImageURI(selectedImage);
                    File new_file = new File(selectedImage.getPath());
                    selected_image_path = getRealPathFromURI(selectedImage);
                    Log.e("image_path",selected_image_path);

                }
                break;
            case 3:

            if (resultCode == RESULT_OK) {
                if (imageReturnedIntent != null && imageReturnedIntent.hasExtra("message")) {
                    msg = imageReturnedIntent.getExtras().getString("message");
                    Log.e("toast", msg);
                    if (this.msg.equals("success")) {
                        Toast.makeText(this, "Payment done Successfully", Toast.LENGTH_SHORT).show();
                        update_payment_info();
                    } else if (this.msg.equals("failure")) {
                        Toast.makeText(this, "Please Try Again", Toast.LENGTH_SHORT).show();
                    }
                }
            } else if (resultCode != 0) {
            }
        }
    }

    private String getRealPathFromURI(Uri contentURI){
        String result;
        Cursor cursor = getContentResolver().query(contentURI, null, null, null, null);
        if (cursor == null) {
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }


    public void get_nationalities(){
        Ion.with(this)
                .load(Session.SERVER_URL+"nationality.php")
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        try {
                            for (int i = 0; i < result.size(); i++) {
                                Nationality nationality = new Nationality(result.get(i).getAsJsonObject(), AddAvailableWorkersActivity.this);
                                nationalitiesfrom_api.add(nationality);
                            }
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                    }
                });
    }


    public void get_religions(){
        Ion.with(this)
                .load(Session.SERVER_URL+"religions.php")
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        try {
                            for (int i = 0; i < result.size(); i++) {
                                Religions religions = new Religions(result.get(i).getAsJsonObject(), AddAvailableWorkersActivity.this);
                                religionsfrom_api.add(religions);
                            }
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                    }
                });
    }

    public void get_age(){
        Ion.with(this)
                .load(Session.SERVER_URL+"age.php")
                .asJsonArray()
                .setCallback(new FutureCallback<JsonArray>() {
                    @Override
                    public void onCompleted(Exception e, JsonArray result) {
                        try {
                            for (int i = 0; i < result.size(); i++) {
                                Age ages = new Age(result.get(i).getAsJsonObject(), AddAvailableWorkersActivity.this);
                                agefrom_api.add(ages);
                            }
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                    }
                });
    }




    public Dialog onNationalityChoice() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final CharSequence[] array = new CharSequence[nationalitiesfrom_api.size()];
        for(int i=0;i<nationalitiesfrom_api.size();i++){

            array[i] = nationalitiesfrom_api.get(i).title;
        }

        builder.setTitle("Select Nationality")
                .setSingleChoiceItems(array, 0, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        String selectedItem = array[i].toString();
                        Log.e("select",selectedItem);
                        nationality_option.setText(selectedItem);
                        nationality_id = nationalitiesfrom_api.get(i).id;


                    }
                })

                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        return builder.create();
    }

    public Dialog onReligionChoice() {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final CharSequence[] array = new CharSequence[religionsfrom_api.size()];
        for(int i=0;i<religionsfrom_api.size();i++){

            array[i] = religionsfrom_api.get(i).title;
        }

        builder.setTitle("Select Religion")
                .setSingleChoiceItems(array, 0, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        String selectedItem = array[i].toString();
                        Log.e("select",selectedItem);
                        religion_option.setText(selectedItem);
                        religion_id = religionsfrom_api.get(i).id;


                    }
                })

                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        return builder.create();
    }



    public void add_available_workers(){
        String fname_string = name.getText().toString();
        String age_string = age.getText().toString();
        String sal_string = sal.getText().toString();
        String amt_string = amount.getText().toString();
        String experience_string = experience.getText().toString();
        String nationality_string = nationality_option.getText().toString();
        String religion_string = religion_option.getText().toString();
        if (fname_string.equals("")){
            Toast.makeText(AddAvailableWorkersActivity.this,"Please Enter Name",Toast.LENGTH_SHORT).show();
            name.requestFocus();
        }else if (age_string.equals("")){
            Toast.makeText(AddAvailableWorkersActivity.this,"Please Enter Age",Toast.LENGTH_SHORT).show();
            age.requestFocus();
        }else if (nationality_string==""){
            Toast.makeText(AddAvailableWorkersActivity.this,"Please Enter Nationality",Toast.LENGTH_SHORT).show();
            nationality_option.requestFocus();
        }else if (religion_string == ""){
            Toast.makeText(AddAvailableWorkersActivity.this,"Please Enter Religion",Toast.LENGTH_SHORT).show();
            religion_option.requestFocus();
        }else if (sal_string.equals("")){
            Toast.makeText(AddAvailableWorkersActivity.this,"Please Enter Salary",Toast.LENGTH_SHORT).show();
            sal.requestFocus();
        }else if (amt_string.equals("")){
            Toast.makeText(AddAvailableWorkersActivity.this,"Please Enter Amount",Toast.LENGTH_SHORT).show();
            amount.requestFocus();
        }else if (experience_string.equals("")){
            Toast.makeText(AddAvailableWorkersActivity.this,"Please Enter Experience",Toast.LENGTH_SHORT).show();
            experience.requestFocus();
        }else {
            final KProgressHUD hud = KProgressHUD.create(this).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setLabel("Please wait").setCancellable(true).setMaxProgress(100).show();

            Ion.with(this)
                    .load(Session.SERVER_URL + "add-availworker.php")
                    .setBodyParameter("member_id", Session.GetUserId(this))
                    .setBodyParameter("name", fname_string)
                    .setBodyParameter("age", age_string)
                    .setBodyParameter("nationality", nationality_string)
                    .setBodyParameter("religion", religion_string)
                    .setBodyParameter("salary", sal_string)
                    .setBodyParameter("amount", amt_string)
                    .setBodyParameter("experience", experience_string)
                    .setBodyParameter("image",selected_image_path)
                    .asJsonObject()
                    .setCallback(new FutureCallback<JsonObject>() {
                        @Override
                        public void onCompleted(Exception e, JsonObject result) {
                            try {
                                hud.dismiss();
                                Log.e("response", result.toString());
                                if (result.get("status").getAsString().equals("Success")) {
                                    Log.e("result",result.get("id").getAsString());
                                    req_id = result.get("id").getAsString();
                                    Toast.makeText(AddAvailableWorkersActivity.this, result.get("message").getAsString(), Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(AddAvailableWorkersActivity.this, PaymentPage.class);
                                    intent.putExtra("amount", service_charge);
                                    AddAvailableWorkersActivity.this.startActivityForResult(intent, 3);
                                } else {
                                    Toast.makeText(AddAvailableWorkersActivity.this, result.get("message").getAsString(), Toast.LENGTH_SHORT).show();

                                }
                            } catch (Exception e1) {
                                e1.printStackTrace();
                            }
                        }
                    });
        }
    }

    public void update_payment_info(){
        final KProgressHUD hud = KProgressHUD.create(this).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE)
                .setLabel("Please wait").setCancellable(true).setMaxProgress(100).show();
        Ion.with(this)
                .load(Session.SERVER_URL+"update_available_payment.php")
                .setBodyParameter("member_id",Session.GetUserId(this))
                .setBodyParameter("req_id",req_id)
                .asJsonObject()
                .setCallback(new FutureCallback<JsonObject>() {
                    @Override
                    public void onCompleted(Exception e, JsonObject result) {
                        hud.dismiss();
                        AddAvailableWorkersActivity.this.onBackPressed();
                    }
                });
    }



}
