package com.example.vaksys_49.all_apps;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void process(View view)
    {
        Intent intent=null,chooser=null;
        if(view.getId()==R.id.map)
        {
            intent =new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("geo:19.076,72.8777"));
            chooser=intent.createChooser(intent,"Maps");
            startActivity(chooser);
        }
        if(view.getId()==R.id.market)
        {
            intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse("market://details?id=arjuntoshniwal.androidtutorials.advanced"));
            chooser=intent.createChooser(intent,"Market");
            startActivity(chooser);
        }
        if(view.getId()==R.id.sendemail)
        {
            intent =new Intent(Intent.ACTION_SEND);
            intent.setData(Uri.parse("mailto:"));
            String[] to={"dvinfosys0@gmail.com","dvbhuva6@gmail.com"};
            intent.putExtra(Intent.EXTRA_EMAIL,to);
            intent.putExtra(Intent.EXTRA_SUBJECT,"hi, this was send email");
            intent.putExtra(Intent.EXTRA_TEXT,"hey, whats up ,how are doing? this is my frist message my frist apps create");
            intent.setType("message/rfc822");
            chooser=intent.createChooser(intent,"E-mail send");
            startActivity(chooser);
        }
        if(view.getId()==R.id.sendimage)
        {
            Uri imageuri=Uri.parse("android.resource://com.example.vaksys_php_9.apps/drawable/"+R.drawable.one);
            intent=new Intent(intent.ACTION_SEND);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM,imageuri);
            intent.putExtra(Intent.EXTRA_TEXT,"hey i have Attached Image");
            chooser=intent.createChooser(intent,"Send Image");
            startActivity(chooser);
        }
        if(view.getId()==R.id.sendimages)
        {
            File pictures= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
            String[] listofpictures=pictures.list();
            Uri uri=null;

            ArrayList<Uri> arrayList=new ArrayList<Uri>();

            for(String picture: listofpictures)
            {
                uri=Uri.parse("Files://"+pictures.toString()+"/"+picture);
                arrayList.add(uri);
            }
            intent =new Intent(Intent.ACTION_SEND_MULTIPLE);
            intent.setType("image/*");
            intent.putExtra(Intent.EXTRA_STREAM,arrayList);
            chooser=Intent.createChooser(intent,"Send Multiple Images");
            startActivity(intent);
        }
        if(view.getId()==R.id.facebook)
        {
            intent=new Intent(Intent.ACTION_SEND);
            intent.setType("text/plain");
            String uriSrting;
            uriSrting="https://facebook.com/";
            intent.putExtra(Intent.EXTRA_TEXT,uriSrting);
            intent.setPackage("com.facebook.katana");
            chooser=Intent.createChooser(intent,"Facebook");
            startActivity(chooser);
        }
    }
}
