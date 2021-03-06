package com.hackathon.remotebase.challengeswvl.utils

import android.content.Context
import android.view.ViewOutlineProvider
import androidx.appcompat.widget.AppCompatImageView
import com.hackathon.remotebase.challengeswvl.R
import dagger.hilt.android.qualifiers.ApplicationContext

class CircleImageView(
    @ApplicationContext context: Context
) : AppCompatImageView(context) {

    init {
        //the outline (view edges) of the view should be derived    from the background
        outlineProvider = ViewOutlineProvider.BACKGROUND
        //cut the view to match the view to the outline of the background
        clipToOutline = true
        //use the following background to calculate the outline
        setBackgroundResource(R.drawable.bg_circle)

        //fill in the whole image view, crop if needed while keeping the center
        scaleType = ScaleType.CENTER_CROP
    }
}