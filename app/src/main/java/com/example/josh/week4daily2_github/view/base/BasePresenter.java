package com.example.josh.week4daily2_github.view.base;

public interface BasePresenter<V extends BaseView> {

    void onAttach(V view);
    void onDetach();
}
