package com.brotandos.androidkit

interface OnBackPressListener {

    companion object {
        const val ACTION_BACK_PRESS_CONSUME = true
        const val ACTION_PERFORM_DEFAULT = false
    }

    /**
     * @return  `true` if backpress was consumed,
     *          `false` if default action should be performed
     */
    fun onBackPressed(): Boolean
}