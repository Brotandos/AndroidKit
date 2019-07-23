package com.brotandos.androidkit.base

import androidx.annotation.CallSuper
import com.brotandos.androidkit.MvpPresenter
import com.brotandos.androidkit.MvpView

abstract class BasePresenter<V : MvpView> : BaseViewModel(), MvpPresenter<V> {

    protected var view: V? = null
        private set

    @CallSuper
    override fun attach(view: V) {
        this.view = view
    }

    @CallSuper
    override fun detach() {
        view = null
    }
}