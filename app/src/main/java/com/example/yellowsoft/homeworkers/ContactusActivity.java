package com.example.yellowsoft.homeworkers;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

/**
 * Created by info on 12-05-2018.
 */

public class ContactusActivity extends Activity {
    ImageView back_btn;
    EditText name,email,phone,message;
    TextView send_btn;
    TextView st_name,st_email,st_phone,st_message,email_btn,call_btn;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contactus_page);
        Session.forceRTLIfSupported(this);
        back_btn = (ImageView) findViewById(R.id.back_btn);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        message = (EditText) findViewById(R.id.message);
        send_btn = (TextView) findViewById(R.id.send_btn);
        email_btn = (TextView) findViewById(R.id.email_btn);
        call_btn = (TextView) findViewById(R.id.call_btn);
//        st_name = (TextView) findViewById(R.id.st_name);
//        st_email = (TextView) findViewById(R.id.st_email);
//        st_phone = (TextView) findViewById(R.id.st_phone);
//        st_message  = (TextView) findViewById(R.id.st_message);

//        st_name.setText(Session.GetWord(this,"Name"));
//        st_email.setText(Session.GetWord(this,"Email"));
//        st_phone.setText(Session.GetWord(this,"Phone"));
//        st_message.setText(Session.GetWord(this,"message"));
        send_btn.setText(Session.GetWord(this,"Send"));

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContactusActivity.this.onBackPressed();
            }
        });

        send_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contactusform();
            }
        });

        email_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                JsonParser jsonParser = new JsonParser();
                if(!Session.GetSettings(ContactusActivity.this).equals("-1")) {
                    JsonObject parse = (JsonObject) jsonParser.parse(Session.GetSettings(ContactusActivity.this));
                    Intent Email = new Intent(Intent.ACTION_SEND);
                    Email.setType("text/email");
                    Email.putExtra(Intent.EXTRA_EMAIL, new String[]{parse.get("email").getAsString()});
                    Email.putExtra(Intent.EXTRA_SUBJECT, "Add your Subject");
                    Email.putExtra(Intent.EXTRA_TEXT, "message");
                    startActivity(Intent.createChooser(Email, "Send Feedback:"));
                }
            }
        });

        call_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(ContactusActivity.this);
                builder.setTitle("Alert");
                builder.setMessage("Call facility is not available!!!");

                // add a button
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });

                // create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });




        }

    public void contactusform(){
        String name_string = name.getText().toString();
        String email_string = email.getText().toString();
        String phone_string = phone.getText().toString();
        String message_string = message.getText().toString();
        if (name_string.equals("")){
            Toast.makeText(ContactusActivity.this,"Please Enter Name",Toast.LENGTH_SHORT).show();
            name.requestFocus();
        }else if (email_string.equals("")){
            Toast.makeText(ContactusActivity.this,"Please Enter Email",Toast.LENGTH_SHORT).show();
            email.requestFocus();
        }else if (phone_string.equals("")){
            Toast.makeText(ContactusActivity.this,"Please Enter Mobile Number",Toast.LENGTH_SHORT).show();
            phone.requestFocus();
        }else if (message_string.equals("")){
            Toast.makeText(ContactusActivity.this,"Please Enter Message",Toast.LENGTH_SHORT).show();
            message.requestFocus();
        }else {
            final KProgressHUD hud = KProgressHUD.create(this).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setLabel("Please wait").setCancellable(true).setMaxProgress(100).show();
            Ion.with(this)
                    .load(Session.SERVER_URL + "contact-us.php")
                    .setBodyParameter("name",name_string)
                    .setBodyParameter("email",email_string)
                    .setBodyParameter("phone",phone_string)
                    .setBodyParameter("message",message_string)
                    .asJsonObject()
                    .setCallback(new FutureCallback<JsonObject>() {
                        @Override
                        public void onCompleted(Exception e, JsonObject result) {
                            try {
                                hud.dismiss();
                                if (result.get("status").getAsString().equals("Success")){
                                    Toast.makeText(ContactusActivity.this,result.get("message").getAsString(),Toast.LENGTH_SHORT);
                                }else {
                                    Toast.makeText(ContactusActivity.this,result.get("message").getAsString(),Toast.LENGTH_SHORT);
                                }
                            }catch (Exception e1){
                                e1.printStackTrace();
                            }


                        }
                    });
        }
    }
}
