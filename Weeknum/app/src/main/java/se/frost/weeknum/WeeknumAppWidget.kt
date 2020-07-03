package se.frost.weeknum

import android.app.PendingIntent
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.widget.RemoteViews
import se.frost.weeknum.util.WeekFormatter
import java.util.*

/**
 * Implementation of App Widget functionality.
 */
class WeeknumAppWidget : AppWidgetProvider() {
    override fun onUpdate(context: Context, appWidgetManager: AppWidgetManager, appWidgetIds: IntArray) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }
}

internal fun updateAppWidget(context: Context, appWidgetManager: AppWidgetManager, appWidgetId: Int) {
    val widgetText = WeekFormatter.weekTitle(Date())
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.weeknum_app_widget)
    views.setOnClickPendingIntent(R.id.appwidget_root,
            PendingIntent.getActivity(context, 0, Intent(context, MainActivity::class.java), 0))
    views.setTextViewText(R.id.appwidget_text, widgetText)

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}