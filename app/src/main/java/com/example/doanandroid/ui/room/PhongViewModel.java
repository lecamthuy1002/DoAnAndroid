package com.example.doanandroid.ui.room;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class PhongViewModel  extends ViewModel {
    private final MutableLiveData<String> mEditText;
    private final MutableLiveData<String> mText5;
    private final MutableLiveData<String> mCardView;
    public PhongViewModel() {
        mEditText = new MutableLiveData<>();
        mEditText.setValue("Search here");
        mText5 = new MutableLiveData<>();
        mText5.setValue("Single Room");
        mCardView = new MutableLiveData<>();
        mCardView.setValue("This is room fragment");
    }

    public LiveData<String> getText2() {
        return mEditText;
    }
    public LiveData<String> getText5() {
        return mText5;
    }
    public LiveData<String> getText3() {
        return mCardView;
    }
    /*public LiveData<String> getText4() {
        return mCardView1;
    }*/

}
