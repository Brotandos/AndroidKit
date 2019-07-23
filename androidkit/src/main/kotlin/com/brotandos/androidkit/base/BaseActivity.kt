package com.brotandos.androidkit.base

import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.brotandos.androidkit.OnBackPressListener
import com.brotandos.androidkit.R

abstract class BaseActivity : AppCompatActivity() {

    fun replaceFragment(
        fragment: Fragment,
        @IdRes containerId: Int = R.id.content,
        addToBackStack: Boolean = true
    ) {
        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(R.anim.nav_enter, R.anim.nav_exit, R.anim.nav_pop_enter, R.anim.nav_pop_exit)
            .replace(containerId, fragment)
            .apply { if (addToBackStack) addToBackStack(fragment.javaClass.simpleName) }
            .commit()
    }

    override fun onBackPressed() {
        val listener = supportFragmentManager.fragments.lastOrNull() as? OnBackPressListener
        val backPressAction = listener?.onBackPressed() ?: OnBackPressListener.ACTION_PERFORM_DEFAULT
        if (backPressAction == OnBackPressListener.ACTION_BACK_PRESS_CONSUME) return
        if (supportFragmentManager.backStackEntryCount == 1) finish() else super.onBackPressed()
    }

    protected fun clearBackStack() =
        supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
}