package com.brotandos.androidkit

import android.os.Bundle
import android.view.View
import com.brotandos.androidkit.base.BaseActivity
import com.brotandos.androidkit.base.BaseFragment

interface MvpView

interface MvpPresenter<V : MvpView> {
    fun attach(view: V)
    fun detach()
}

abstract class BaseMvpActivity<V : MvpView, P : MvpPresenter<V>> : BaseActivity(), MvpView {

    abstract val presenter: P

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        @Suppress("UNCHECKED_CAST")
        presenter.attach(this as V)
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detach()
    }
}

abstract class BaseMvpFragment<V : MvpView, P : MvpPresenter<V>> : BaseFragment(), MvpView {

    abstract val presenter: P

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        @Suppress("UNCHECKED_CAST")
        presenter.attach(this as V)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        presenter.detach()
    }
}