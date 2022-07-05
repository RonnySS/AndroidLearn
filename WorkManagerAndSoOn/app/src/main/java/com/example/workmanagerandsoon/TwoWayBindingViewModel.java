package com.example.workmanagerandsoon;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class TwoWayBindingViewModel extends BaseObservable {
    private LoginModel loginModel;
    public TwoWayBindingViewModel(){
        loginModel = new LoginModel();
        loginModel.username = "Michael";
    }
    @Bindable
    public String getUsername(){
        return loginModel.username;
    }

    public void setUserName(String userName){
        if (userName != null && !userName.equals(loginModel.username)){
            loginModel.username = userName;
        }

    }
}
