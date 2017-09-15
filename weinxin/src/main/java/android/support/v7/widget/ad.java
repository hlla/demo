package android.support.v7.widget;

import android.content.res.AssetFileDescriptor;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.InputStream;

class ad
  extends Resources
{
  private final Resources Cu;
  
  public ad(Resources paramResources)
  {
    super(paramResources.getAssets(), paramResources.getDisplayMetrics(), paramResources.getConfiguration());
    this.Cu = paramResources;
  }
  
  public XmlResourceParser getAnimation(int paramInt)
  {
    return this.Cu.getAnimation(paramInt);
  }
  
  public boolean getBoolean(int paramInt)
  {
    return this.Cu.getBoolean(paramInt);
  }
  
  public int getColor(int paramInt)
  {
    return this.Cu.getColor(paramInt);
  }
  
  public ColorStateList getColorStateList(int paramInt)
  {
    return this.Cu.getColorStateList(paramInt);
  }
  
  public Configuration getConfiguration()
  {
    return this.Cu.getConfiguration();
  }
  
  public float getDimension(int paramInt)
  {
    return this.Cu.getDimension(paramInt);
  }
  
  public int getDimensionPixelOffset(int paramInt)
  {
    return this.Cu.getDimensionPixelOffset(paramInt);
  }
  
  public int getDimensionPixelSize(int paramInt)
  {
    return this.Cu.getDimensionPixelSize(paramInt);
  }
  
  public DisplayMetrics getDisplayMetrics()
  {
    return this.Cu.getDisplayMetrics();
  }
  
  public Drawable getDrawable(int paramInt)
  {
    return this.Cu.getDrawable(paramInt);
  }
  
  public Drawable getDrawable(int paramInt, Resources.Theme paramTheme)
  {
    return this.Cu.getDrawable(paramInt, paramTheme);
  }
  
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2)
  {
    return this.Cu.getDrawableForDensity(paramInt1, paramInt2);
  }
  
  public Drawable getDrawableForDensity(int paramInt1, int paramInt2, Resources.Theme paramTheme)
  {
    return this.Cu.getDrawableForDensity(paramInt1, paramInt2, paramTheme);
  }
  
  public float getFraction(int paramInt1, int paramInt2, int paramInt3)
  {
    return this.Cu.getFraction(paramInt1, paramInt2, paramInt3);
  }
  
  public int getIdentifier(String paramString1, String paramString2, String paramString3)
  {
    return this.Cu.getIdentifier(paramString1, paramString2, paramString3);
  }
  
  public int[] getIntArray(int paramInt)
  {
    return this.Cu.getIntArray(paramInt);
  }
  
  public int getInteger(int paramInt)
  {
    return this.Cu.getInteger(paramInt);
  }
  
  public XmlResourceParser getLayout(int paramInt)
  {
    return this.Cu.getLayout(paramInt);
  }
  
  public Movie getMovie(int paramInt)
  {
    return this.Cu.getMovie(paramInt);
  }
  
  public String getQuantityString(int paramInt1, int paramInt2)
  {
    return this.Cu.getQuantityString(paramInt1, paramInt2);
  }
  
  public String getQuantityString(int paramInt1, int paramInt2, Object... paramVarArgs)
  {
    return this.Cu.getQuantityString(paramInt1, paramInt2, paramVarArgs);
  }
  
  public CharSequence getQuantityText(int paramInt1, int paramInt2)
  {
    return this.Cu.getQuantityText(paramInt1, paramInt2);
  }
  
  public String getResourceEntryName(int paramInt)
  {
    return this.Cu.getResourceEntryName(paramInt);
  }
  
  public String getResourceName(int paramInt)
  {
    return this.Cu.getResourceName(paramInt);
  }
  
  public String getResourcePackageName(int paramInt)
  {
    return this.Cu.getResourcePackageName(paramInt);
  }
  
  public String getResourceTypeName(int paramInt)
  {
    return this.Cu.getResourceTypeName(paramInt);
  }
  
  public String getString(int paramInt)
  {
    return this.Cu.getString(paramInt);
  }
  
  public String getString(int paramInt, Object... paramVarArgs)
  {
    return this.Cu.getString(paramInt, paramVarArgs);
  }
  
  public String[] getStringArray(int paramInt)
  {
    return this.Cu.getStringArray(paramInt);
  }
  
  public CharSequence getText(int paramInt)
  {
    return this.Cu.getText(paramInt);
  }
  
  public CharSequence getText(int paramInt, CharSequence paramCharSequence)
  {
    return this.Cu.getText(paramInt, paramCharSequence);
  }
  
  public CharSequence[] getTextArray(int paramInt)
  {
    return this.Cu.getTextArray(paramInt);
  }
  
  public void getValue(int paramInt, TypedValue paramTypedValue, boolean paramBoolean)
  {
    this.Cu.getValue(paramInt, paramTypedValue, paramBoolean);
  }
  
  public void getValue(String paramString, TypedValue paramTypedValue, boolean paramBoolean)
  {
    this.Cu.getValue(paramString, paramTypedValue, paramBoolean);
  }
  
  public void getValueForDensity(int paramInt1, int paramInt2, TypedValue paramTypedValue, boolean paramBoolean)
  {
    this.Cu.getValueForDensity(paramInt1, paramInt2, paramTypedValue, paramBoolean);
  }
  
  public XmlResourceParser getXml(int paramInt)
  {
    return this.Cu.getXml(paramInt);
  }
  
  public TypedArray obtainAttributes(AttributeSet paramAttributeSet, int[] paramArrayOfInt)
  {
    return this.Cu.obtainAttributes(paramAttributeSet, paramArrayOfInt);
  }
  
  public TypedArray obtainTypedArray(int paramInt)
  {
    return this.Cu.obtainTypedArray(paramInt);
  }
  
  public InputStream openRawResource(int paramInt)
  {
    return this.Cu.openRawResource(paramInt);
  }
  
  public InputStream openRawResource(int paramInt, TypedValue paramTypedValue)
  {
    return this.Cu.openRawResource(paramInt, paramTypedValue);
  }
  
  public AssetFileDescriptor openRawResourceFd(int paramInt)
  {
    return this.Cu.openRawResourceFd(paramInt);
  }
  
  public void parseBundleExtra(String paramString, AttributeSet paramAttributeSet, Bundle paramBundle)
  {
    this.Cu.parseBundleExtra(paramString, paramAttributeSet, paramBundle);
  }
  
  public void parseBundleExtras(XmlResourceParser paramXmlResourceParser, Bundle paramBundle)
  {
    this.Cu.parseBundleExtras(paramXmlResourceParser, paramBundle);
  }
  
  public void updateConfiguration(Configuration paramConfiguration, DisplayMetrics paramDisplayMetrics)
  {
    super.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    if (this.Cu != null) {
      this.Cu.updateConfiguration(paramConfiguration, paramDisplayMetrics);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/widget/ad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */