package com.shishir.onlinenoticeboard.ui.comment;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class CommentViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public CommentViewModel() {
        mText = new MutableLiveData<>();
        //mText.setValue("This is Comment Fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}