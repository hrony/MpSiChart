
package com.seeweekend.code.charting.data;

import android.graphics.Color;

import com.seeweekend.code.charting.interfaces.datasets.IRadarDataSet;
import com.seeweekend.code.charting.utils.ColorTemplate;
import com.seeweekend.code.charting.utils.MpChartSetdate;

import java.util.ArrayList;
import java.util.List;

public class RadarDataSet extends LineRadarDataSet<Entry> implements IRadarDataSet {
    public MpChartSetdate mpChartSetdate;
    /// flag indicating whether highlight circle should be drawn or not
    protected boolean mDrawHighlightCircleEnabled = false;

    protected int mHighlightCircleFillColor = Color.WHITE;

    /// The stroke color for highlight circle.
    /// If Utils.COLOR_NONE, the color of the dataset is taken.
    protected int mHighlightCircleStrokeColor = ColorTemplate.COLOR_NONE;

    protected int mHighlightCircleStrokeAlpha = (int)(0.3 * 255);
    protected float mHighlightCircleInnerRadius = 3.0f;
    protected float mHighlightCircleOuterRadius = 4.0f;
    protected float mHighlightCircleStrokeWidth = 2.0f;

    public RadarDataSet(List<Entry> yVals, String label) {
        super(yVals, label);
    }

    /// Returns true if highlight circle should be drawn, false if not
    @Override
    public boolean isDrawHighlightCircleEnabled()
    {
        return mDrawHighlightCircleEnabled;
    }

    /// Sets whether highlight circle should be drawn or not
    @Override
    public void setDrawHighlightCircleEnabled(boolean enabled)
    {
        mDrawHighlightCircleEnabled = enabled;
    }

    @Override
    public int getHighlightCircleFillColor()
    {
        return mHighlightCircleFillColor;
    }

    public void setHighlightCircleFillColor(int color)
    {
        mHighlightCircleFillColor = color;
    }

    /// Returns the stroke color for highlight circle.
    /// If Utils.COLOR_NONE, the color of the dataset is taken.
    @Override
    public int getHighlightCircleStrokeColor()
    {
        return mHighlightCircleStrokeColor;
    }

    /// Sets the stroke color for highlight circle.
    /// Set to Utils.COLOR_NONE in order to use the color of the dataset;
    public void setHighlightCircleStrokeColor(int color)
    {
        mHighlightCircleStrokeColor = color;
    }

    @Override
    public int getHighlightCircleStrokeAlpha()
    {
        return mHighlightCircleStrokeAlpha;
    }

    public void setHighlightCircleStrokeAlpha(int alpha)
    {
        mHighlightCircleStrokeAlpha = alpha;
    }

    @Override
    public float getHighlightCircleInnerRadius()
    {
        return mHighlightCircleInnerRadius;
    }

    public void setHighlightCircleInnerRadius(float radius)
    {
        mHighlightCircleInnerRadius = radius;
    }

    @Override
    public float getHighlightCircleOuterRadius()
    {
        return mHighlightCircleOuterRadius;
    }

    public void setHighlightCircleOuterRadius(float radius)
    {
        mHighlightCircleOuterRadius = radius;
    }

    @Override
    public float getHighlightCircleStrokeWidth()
    {
        return mHighlightCircleStrokeWidth;
    }

    public void setHighlightCircleStrokeWidth(float strokeWidth)
    {
        mHighlightCircleStrokeWidth = strokeWidth;
    }

    @Override
    public DataSet<Entry> copy() {

        List<Entry> yVals = new ArrayList<Entry>();

        for (int i = 0; i < mYVals.size(); i++) {
            yVals.add(mYVals.get(i).copy());
        }

        RadarDataSet copied = new RadarDataSet(yVals, getLabel());
        copied.mColors = mColors;
        copied.mHighLightColor = mHighLightColor;

        return copied;
    }

    @Override
    public MpChartSetdate mpChartSetdate() {
        return mpChartSetdate;
    }
}
