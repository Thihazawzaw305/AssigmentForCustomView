package com.padcmyanmar.thiha.assigmentforcustomview.components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.withStyledAttributes
import com.padcmyanmar.thiha.assigmentforcustomview.R

class RoundedProfileWithBorder(context: Context, attrs: AttributeSet) : AppCompatImageView(context, attrs) {
    //Paint object for color and styling
    private val path = Path()
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)


    private var borderColor: Int = DEFAULT_BORDER_COLOR

    //face border width pixel
    private var borderWidth = DEFAULT_BORDER_WIDTH

    //View size in Pixel
    private var size = 0
   private var  radius = size / 2f


    init {
        paint.isAntiAlias = true
               setUpAttributes(attrs)
    }


    private fun setUpAttributes(attrs: AttributeSet?) {
        context.withStyledAttributes(attrs, R.styleable.RoundedProfileWithBorder) {
            borderColor = getColor(R.styleable.RoundedProfileWithBorder_borderColor, DEFAULT_BORDER_COLOR)
            borderWidth = getDimension(R.styleable.RoundedProfileWithBorder_borderWidth, DEFAULT_BORDER_WIDTH)
            radius = getDimension(R.styleable.RoundedProfileWithBorder_radius, 10f)

        }
        }




    override fun onDraw(canvas: Canvas) {
        path.addCircle(radius, radius, radius, Path.Direction.CCW)
        canvas.clipPath(path)
        super.onDraw(canvas)
        drawFaceBackground(canvas)


    }

    private fun drawFaceBackground(canvas: Canvas) {


        paint.color = borderColor
        paint.style = Paint.Style.STROKE
        paint.strokeWidth = borderWidth
        canvas.drawCircle(radius, radius, radius - (borderWidth/2f), paint)

    }




    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        size = w.coerceAtMost(h)
    }

    companion object {
        private const val DEFAULT_BORDER_COLOR = Color.WHITE
        private const val DEFAULT_BORDER_WIDTH = 6.0F


    }


}

