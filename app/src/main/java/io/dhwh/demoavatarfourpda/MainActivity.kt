
package io.dhwh.demoavatarfourpda

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.pm.PackageInfoCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* Connect main layout */
        setContentView(R.layout.main)

        /* Displaying tooltip for a scrolling when clicked */
        val scrollTooltip: AppCompatTextView = findViewById(R.id.scroll_tooltip) // Set object ID
        // View
        scrollTooltip.setOnClickListener {
            Toast.makeText(this, getString(R.string.scroll_tooltip_toast), Toast.LENGTH_SHORT).show()
        }

        /* Open link a source image when click */
        val exampleOriginalSource: AppCompatTextView = findViewById(R.id.example_original_source) // Set object ID
        val exampleOriginalSourceLink = "https://mr-dark-1amao.tumblr.com/post/689605799594639360/how-start-a-great-day-with-a-great" // Set link
        // Action
        exampleOriginalSource.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(exampleOriginalSourceLink)))
        }

        /* Set text about the author */
        val author: AppCompatTextView = findViewById(R.id.author) // Set object ID
        val packageInfo = packageManager.getPackageInfo(this.packageName, 0) // Getting the package info
        val appVersionName = packageInfo.versionName // Getting the app versionName
        val appVersionCode = PackageInfoCompat.getLongVersionCode(packageInfo).toInt() // Getting the app versionCode
        val authorLink = "https://github.com/ThIsLinked/DemoAvatar4PDA" // Set link
        // View
        author.text = getString(R.string.author, appVersionName, appVersionCode)
        // Action
        author.setOnClickListener {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(authorLink)))
        }
    }
}
