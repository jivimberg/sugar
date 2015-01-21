package me.jivimberg.android.sugartestapp;

import android.app.ListActivity;
import android.os.Bundle;

import com.orm.query.Select;

import java.util.List;

import me.jivimberg.android.sugartestapp.model.Contact;


public class MainActivity extends ListActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Contact> contacts = Select.from(Contact.class).list();

    }


}
