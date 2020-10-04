package com.jmac.whatsappclone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private TabsAccessorAdapter mTabsAcessorAdapter;
//firebase
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

mViewPager=(ViewPager)findViewById(R.id.main_tabs_pager);
mTabsAcessorAdapter=new TabsAccessorAdapter(getSupportFragmentManager());
mViewPager.setAdapter(mTabsAcessorAdapter);

mTabLayout=(TabLayout)findViewById(R.id.main_tabs);
mTabLayout.setupWithViewPager(mViewPager);

    }

    @Override
    protected void onStart() {
        super.onStart();

    if(currentUser==null){
        sendUserToLoginActivity();
    }

    }

    private void sendUserToLoginActivity() {
        Intent loginIntent = new Intent(MainActivity.this,LoginActivity.class);
        startActivity(loginIntent);
    }

}
