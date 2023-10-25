/*
    Source code: https://developer.alexanderklimov.ru/android/views/verticaltextview.php
 */

package io.dhwh.demoavatarfourpda

import android.content.Context
import android.graphics.Canvas
import android.text.TextPaint
import android.util.AttributeSet
import android.view.Gravity
import androidx.appcompat.widget.AppCompatTextView


class VerticalTextView(context: Context?, attrs: AttributeSet?) :
    AppCompatTextView(context!!, attrs) {

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(measuredHeight, measuredWidth)
    }

    override fun onDraw(canvas: Canvas) {
        var textPaint: TextPaint = paint
        textPaint.color = currentTextColor
        textPaint.drawableState = drawableState
        canvas.save()
        canvas.translate(width.toFloat(), 0f)
        canvas.rotate(90f)
        layout.draw(canvas)
        canvas.restore()
    }
}
