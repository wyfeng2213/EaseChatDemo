package com.example.administrator.easechatdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.administrator.easechatdemo.R;
import com.hyphenate.EMCallBack;
import com.hyphenate.chat.EMClient;

public class SettingsFragment extends Fragment{
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }
    
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        
        Button logoutButton = (Button) getView().findViewById(R.id.btn_logout);
        logoutButton.setOnClickListener(new OnClickListener() {
            
            @Override
            public void onClick(View v) {
                EMClient.getInstance().logout(false, new EMCallBack() {
                    
                    @Override
                    public void onSuccess() {
                        getActivity().finish();
                        startActivity(new Intent(getActivity(), LoginActivity.class));
                    }
                    
                    @Override
                    public void onProgress(int progress, String status) {
                        
                    }
                    
                    @Override
                    public void onError(int code, String error) {
                        
                    }
                });
            }
        });
    }
}
