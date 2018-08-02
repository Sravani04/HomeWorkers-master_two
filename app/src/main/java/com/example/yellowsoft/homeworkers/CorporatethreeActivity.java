package com.example.yellowsoft.homeworkers;

import android.Manifest;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.eminayar.panter.DialogType;
import com.eminayar.panter.PanterDialog;
import com.eminayar.panter.interfaces.OnSingleCallbackConfirmListener;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kaopiz.kprogresshud.KProgressHUD;
import com.koushikdutta.async.future.FutureCallback;
import com.koushikdutta.ion.Ion;

import java.io.File;

/**
 * Created by info on 16-07-2018.
 */

public class CorporatethreeActivity extends Activity {
    ImageView back_btn,trade_image,signatory_image,civil_image;
    LinearLayout trade_layout,signatory_layout,civil_layout;
    TextView submit_btn;
    String category_option,worker_option,salary,benefits,company_name,number,address,contact_person;
    Integer REQUEST_CAMERA = 1, SELECT_FILE = 0;
    int ASK_MULTIPLE_PERMISSION_REQUEST_CODE;
    EditText email,phone,addr;
    private static final int MY_CAMERA_REQUEST_CODE = 100;
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.corporateform_request_page_3);
        back_btn = (ImageView) findViewById(R.id.back_btn);
        trade_image = (ImageView) findViewById(R.id.trade_image);
        signatory_image = (ImageView) findViewById(R.id.signatory_image);
        civil_image = (ImageView) findViewById(R.id.civil_image);
        trade_layout = (LinearLayout) findViewById(R.id.trade_layout);
        signatory_layout = (LinearLayout) findViewById(R.id.signatory_layout);
        civil_layout = (LinearLayout) findViewById(R.id.civil_layout);
        submit_btn = (TextView) findViewById(R.id.submit_btn);
        email = (EditText) findViewById(R.id.email);
        phone = (EditText) findViewById(R.id.phone);
        addr = (EditText) findViewById(R.id.address);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CorporatethreeActivity.this.onBackPressed();
            }
        });

        category_option = getIntent().getStringExtra("category_option");
        worker_option = getIntent().getStringExtra("worker_option");
        salary = getIntent().getStringExtra("salary");
        benefits = getIntent().getStringExtra("benefits");
        company_name = getIntent().getStringExtra("company_name");
        number = getIntent().getStringExtra("number");
        address = getIntent().getStringExtra("address");
        contact_person = getIntent().getStringExtra("contact_person");

        trade_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("is","coming or not");
                pick_image();
            }
        });

        trade_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final CharSequence[] items = {"camera","gallery"};
               pick_image();
            }
        });

        signatory_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  pick_image1();
            }
        });

        signatory_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pick_image1();
            }
        });


        civil_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    pick_image2();
            }
        });

        civil_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pick_image2();
            }
        });


        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                submit();
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void pick_image() {
        if (checkSelfPermission(Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA},
                    MY_CAMERA_REQUEST_CODE);
        }
        final CharSequence[] items = {"camera","gallery"};
        AlertDialog.Builder builder = new AlertDialog.Builder(CorporatethreeActivity.this);
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


    public void pick_image1() {
        if (checkSelfPermission(Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA},
                    MY_CAMERA_REQUEST_CODE);
        }
        final CharSequence[] items = {"camera","gallery"};
        AlertDialog.Builder builder = new AlertDialog.Builder(CorporatethreeActivity.this);
        builder.setTitle("select_image");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if(items[item].equals("camera")){
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent,3);

                }else if(items[item].equals("gallery")){
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto,4);
                }
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }

    public void pick_image2() {
        if (checkSelfPermission(Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.CAMERA},
                    MY_CAMERA_REQUEST_CODE);
        }
        final CharSequence[] items = {"camera","gallery"};
        AlertDialog.Builder builder = new AlertDialog.Builder(CorporatethreeActivity.this);
        builder.setTitle("select_image");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if(items[item].equals("camera")){
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    startActivityForResult(intent,5);

                }else if(items[item].equals("gallery")){
                    Intent pickPhoto = new Intent(Intent.ACTION_PICK,
                            MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    startActivityForResult(pickPhoto,6);
                }
            }
        });
        AlertDialog alert = builder.create();
        alert.show();

    }

    String selected_image_path = "";
    String selected_image_path1 ="";
    String selected_image_path2 ="";
    protected void onActivityResult(int requestCode,int resultCode,Intent imageReturnedIntent){
        super.onActivityResult(requestCode,resultCode,imageReturnedIntent);
        switch (requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    Bitmap photo = (Bitmap) imageReturnedIntent.getExtras().get("data");
                    trade_image.setImageBitmap(photo);
//                    Uri selectedImage = imageReturnedIntent.getData();
//                    trade_image.setImageURI(selectedImage);
//                    selected_image_path = getRealPathFromURI(selectedImage);
//                    Log.e("image_path",selected_image_path);

                }
                break;
            case 2:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    trade_image.setImageURI(selectedImage);
                    File new_file = new File(selectedImage.getPath());
                    selected_image_path = getRealPathFromURI(selectedImage);
                    Log.e("image_path",selected_image_path);

                }
                break;

            case 3:
                Bitmap photo1 = (Bitmap) imageReturnedIntent.getExtras().get("data");
                signatory_image.setImageBitmap(photo1);
//                if (resultCode == RESULT_OK){
//                    Uri selectedImage = imageReturnedIntent.getData();
//                    signatory_image.setImageURI(selectedImage);
//                    selected_image_path1 = getRealPathFromURI(selectedImage);
//                    Log.e("image_path",selected_image_path1);
//
//                }
                break;
            case 4:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    signatory_image.setImageURI(selectedImage);
                    File new_file = new File(selectedImage.getPath());
                    selected_image_path1 = getRealPathFromURI(selectedImage);
                    Log.e("image_path",selected_image_path1);

                }
                break;

            case 5:
                Bitmap photo2 = (Bitmap) imageReturnedIntent.getExtras().get("data");
                civil_image.setImageBitmap(photo2);
//                if (resultCode == RESULT_OK){
//                    Uri selectedImage = imageReturnedIntent.getData();
//                    civil_image.setImageURI(selectedImage);
//                    selected_image_path2 = getRealPathFromURI(selectedImage);
//                    Log.e("image_path",selected_image_path2);
//
//                }
                break;
            case 6:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = imageReturnedIntent.getData();
                    civil_image.setImageURI(selectedImage);
                    File new_file = new File(selectedImage.getPath());
                    selected_image_path2 = getRealPathFromURI(selectedImage);
                    Log.e("image_path",selected_image_path2);

                }
                break;
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


    public void submit(){
        final KProgressHUD hud = KProgressHUD.create(this).setStyle(KProgressHUD.Style.SPIN_INDETERMINATE).setLabel("Please wait").setCancellable(true).setMaxProgress(100).show();
         JsonObject jsonObject = new JsonObject();
         jsonObject.addProperty("member_id", Session.GetUserId(this));
         jsonObject.addProperty("company_name", company_name);
         jsonObject.addProperty("phone_number", number);
         jsonObject.addProperty("address", address);
         jsonObject.addProperty("contact_person", contact_person);
         jsonObject.addProperty("selected_categories", category_option);
         jsonObject.addProperty("number_of_workers", worker_option);
         jsonObject.addProperty("salary", salary);
         jsonObject.addProperty("other_benefits", benefits);
         jsonObject.addProperty("email_address",email.getText().toString());
         jsonObject.addProperty("contact_number",phone.getText().toString());
         jsonObject.addProperty("company_address",addr.getText().toString());
         jsonObject.addProperty("image1",selected_image_path);
         jsonObject.addProperty("image2",selected_image_path);
         jsonObject.addProperty("image3",selected_image_path);
         Log.e("reeeee", jsonObject.toString());

         if (company_name.equals("")){
             Toast.makeText(CorporatethreeActivity.this,"Enter Company Name",Toast.LENGTH_SHORT).show();
         }else if (number.equals("")){
             Toast.makeText(CorporatethreeActivity.this,"Enter Phone Number",Toast.LENGTH_SHORT).show();
         }else if (address.equals("")){
             Toast.makeText(CorporatethreeActivity.this,"Enter Address",Toast.LENGTH_SHORT).show();
         }else if (contact_person.equals("")){
             Toast.makeText(CorporatethreeActivity.this,"Enter Contact Person",Toast.LENGTH_SHORT).show();
         }else if (category_option.equals("")){
             Toast.makeText(CorporatethreeActivity.this,"Select Categories",Toast.LENGTH_SHORT).show();
         }else if (worker_option.equals("")){
             Toast.makeText(CorporatethreeActivity.this,"Select Workers",Toast.LENGTH_SHORT).show();
         }else if (salary.equals("")){
             Toast.makeText(CorporatethreeActivity.this,"Enter Salary",Toast.LENGTH_SHORT).show();
         }else if (benefits.equals("")){
             Toast.makeText(CorporatethreeActivity.this,"Enter Other Benefits",Toast.LENGTH_SHORT).show();
         }else if (email.equals("")){
             Toast.makeText(CorporatethreeActivity.this,"Enter EmailAddress",Toast.LENGTH_SHORT).show();
         }else if (phone.equals("")){
             Toast.makeText(CorporatethreeActivity.this,"Enter Contact Number",Toast.LENGTH_SHORT).show();
         }else if (addr.equals("")){
             Toast.makeText(CorporatethreeActivity.this,"Enter Company Address",Toast.LENGTH_SHORT).show();
         }else {

             Ion.with((Context) this).load(Session.SERVER_URL + "add-corporate.php")
                     .setBodyParameter("member_id", Session.GetUserId(this))
                     .setBodyParameter("content", jsonObject.toString()).asJsonObject().setCallback(new FutureCallback<JsonObject>() {
                 public void onCompleted(Exception e, JsonObject result) {
                     hud.dismiss();
                     try {
                         if (result.get("status").getAsString().equals("Success")) {
                             Log.e("result", result.toString());
                             Log.e("corporate_id", result.get("corporate_id").getAsString());
                             Log.e("result", result.get("message").getAsString());
                             Toast.makeText(CorporatethreeActivity.this, result.get("message").getAsString(), Toast.LENGTH_SHORT).show();
                             Intent intent = new Intent(CorporatethreeActivity.this, MainActivity.class);
                             startActivity(intent);
                             finish();
                             return;
                         }
                         Toast.makeText(CorporatethreeActivity.this, result.get("message").getAsString(), Toast.LENGTH_SHORT).show();
                     } catch (Exception e1) {
                         e1.printStackTrace();
                     }
                 }
             });
         }
    }


}
