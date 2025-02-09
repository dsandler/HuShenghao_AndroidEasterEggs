package com.dede.android_eggs.views.widget

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.RemoteViews
import androidx.core.app.PendingIntentCompat
import com.dede.android_eggs.R
import com.dede.android_eggs.main.EasterEggsActivity

/**
 * Easter Eggs Analog clock widget.
 */
class AnalogClockAppWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray,
    ) {
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onAppWidgetOptionsChanged(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetId: Int,
        newOptions: Bundle?,
    ) {
        super.onAppWidgetOptionsChanged(context, appWidgetManager, appWidgetId, newOptions)
        updateAppWidget(context, appWidgetManager, appWidgetId)
    }

}

private fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int,
) {
    val views = RemoteViews(context.packageName, R.layout.widget_easter_egg_analog_clock)
    val intent = PendingIntentCompat.getActivity(
        context,
        0,
        Intent(context, EasterEggsActivity::class.java),
        PendingIntent.FLAG_UPDATE_CURRENT,
        false
    )
    views.setOnClickPendingIntent(R.id.analog_clock, intent)
    appWidgetManager.updateAppWidget(appWidgetId, views)
}