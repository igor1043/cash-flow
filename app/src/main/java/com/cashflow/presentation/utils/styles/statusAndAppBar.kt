package com.cashflow.com.cashflow.presentation.utils.styles

import android.app.Activity
import android.os.Build
import android.view.View
import android.view.View.SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR
import android.view.WindowInsetsController
import android.view.WindowManager
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.cashflow.R

fun Fragment.setStatusBarDarkMode(isLightMode: Boolean) {
    activity?.let {
        ViewUtils.setStatusBarDarkMode(it, isLightMode)
    }
}

fun Fragment.setNavBarDarkMode(isLightMode: Boolean) {
    activity?.let {
        ViewUtils.setNavBarDarkMode(it, isLightMode)
    }
}

abstract class ViewUtils {

    companion object {

        @JvmStatic
        fun setStatusBarDarkMode(activity: Activity, isDarkMode: Boolean) {
            try {
                activity.window?.let {

                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                        it.insetsController!!.setSystemBarsAppearance(
                            if (isDarkMode) WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS else 0,
                            WindowInsetsController.APPEARANCE_LIGHT_STATUS_BARS
                        )

                    } else {
                        val flags = it.decorView.systemUiVisibility
                        it.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
                        it.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)

                        it.decorView.systemUiVisibility = if (isDarkMode) {
                            flags or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                        } else {
                            flags and View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR.inv()
                        }
                    }

                    it.statusBarColor = ContextCompat.getColor(
                        activity,
                        if (isDarkMode) R.color.neutral_10 else R.color.neutral_500
                    )
                }
            } catch (e: Exception) {

            }
        }

        @JvmStatic
        fun setNavBarDarkMode(activity: Activity, isDarkMode: Boolean) {
            try {
                activity.window?.let {
                    it.navigationBarColor = ContextCompat.getColor(activity, R.color.neutral_10);
                    it.decorView.systemUiVisibility = SYSTEM_UI_FLAG_LIGHT_NAVIGATION_BAR;
                }

            } catch (e: Exception) {

            }
        }
    }
}
