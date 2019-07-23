package com.brotandos.androidkit.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import com.brotandos.androidkit.R

abstract class BaseFragment : Fragment() {

    abstract val layoutId: Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View =
        inflater.inflate(layoutId, container, false)

    fun replaceFragment(
        fragment: Fragment,
        @IdRes containerId: Int = R.id.content,
        addToBackStack: Boolean = true
    ) {
        activity?.supportFragmentManager
            ?.beginTransaction()
            ?.setCustomAnimations(R.anim.nav_enter, R.anim.nav_exit, R.anim.nav_pop_enter, R.anim.nav_pop_exit)
            ?.replace(containerId, fragment)
            ?.apply { if (addToBackStack) addToBackStack(fragment::class.java.simpleName) }
            ?.commitAllowingStateLoss()
    }
}