package com.android.launcher2.mainmenu;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class TitleBarButton
  extends LinearLayout
{
  public TitleBarButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public TitleBarButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public TitleBarButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    super.setEnabled(paramBoolean);
    if (paramBoolean) {}
    for (float f = 1.0F;; f = 0.5F)
    {
      setAlpha(f);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/mainmenu/TitleBarButton.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */