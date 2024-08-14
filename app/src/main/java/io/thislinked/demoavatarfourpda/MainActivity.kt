//
package io.thislinked.demoavatarfourpda

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.pm.PackageInfoCompat
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        /* Connect main layout */
        setContentView(R.layout.main)

        /* Displaying tooltip for a scrolling when clicked */
        val scrollTooltip: AppCompatTextView = findViewById(R.id.scroll_tooltip) // Set object ID
        // View
        scrollTooltip.setOnClickListener {
            val scrollTooltipToast =
                Toast.makeText(this, getString(R.string.scroll_tooltip_toast), Toast.LENGTH_SHORT)
            scrollTooltipToast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0)
            scrollTooltipToast.show()
        }

        /* Open link a source image when click */
        val exampleOriginalSource: MaterialButton =
            findViewById(R.id.example_original_source) // Set object ID
        // Action
        exampleOriginalSource.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://mr-dark-1amao.tumblr.com/post/689605799594639360/how-start-a-great-day-with-a-great")
                )
            )
        }

        /* Set text about the author */
        val author: AppCompatTextView = findViewById(R.id.author) // Set object ID
        val packageInfo =
            packageManager.getPackageInfo(this.packageName, 0) // Getting the package info
        val appVersionName = packageInfo.versionName // Getting the app versionName
        val appVersionCode =
            PackageInfoCompat.getLongVersionCode(packageInfo).toInt() // Getting the app versionCode
        // View
        author.text = getString(R.string.author, appVersionName, appVersionCode)
        // Action
        author.setOnClickListener {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://github.com/ThIsLinked/DemoAvatar4PDA")
                )
            )
        }

    }

}
