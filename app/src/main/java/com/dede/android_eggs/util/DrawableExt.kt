package com.dede.android_eggs.util

import android.content.Context
import android.graphics.Shader
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.annotation.AttrRes
import androidx.annotation.DrawableRes
import androidx.core.graphics.drawable.toBitmap
import com.dede.basic.requireDrawable


fun createRepeatWavyDrawable(
    context: Context,
    @DrawableRes wavyRes: Int,
    @AttrRes tintAttr: Int = com.google.android.material.R.attr.colorSecondary
): Drawable {
    val bitmap = context.requireDrawable(wavyRes).toBitmap()
    return BitmapDrawable(context.resources, bitmap).apply {
        tileModeX = Shader.TileMode.REPEAT
        setTint(context.resolveColor(tintAttr))
    }
}