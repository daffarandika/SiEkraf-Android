package org.app.siekraf.core.utils

import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.text.ParseException
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.OffsetDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale


@RequiresApi(Build.VERSION_CODES.O)
fun String.formatDateString(): String {
    return try {
        val instant = Instant.parse(this)
        val zonedDateTime = instant.atZone(ZoneId.systemDefault())
        val outputFormatter = DateTimeFormatter.ofPattern("dd MMMM yyyy", Locale.getDefault())
        outputFormatter.format(zonedDateTime)
    } catch (e: Exception) {
        Log.e("parsing error cuk", "formatDateString: ${e.message}", )
        this
    }
}
