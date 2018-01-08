package com.android.launcher2;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import com.sec.android.app.launcher.R.styleable;

public class HandleView
  extends ImageView
{
  private static final int ORIENTATION_HORIZONTAL = 1;
  private HomeView mHomeView;
  private int mOrientation = 1;
  
  public HandleView(Context paramContext)
  {
    super(paramContext);
  }
  
  public HandleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public HandleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    paramAttributeSet = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.HandleView, paramInt, 0);
    this.mOrientation = paramAttributeSet.getInt(0, 1);
    paramAttributeSet.recycle();
    setContentDescription(paramContext.getString(2131755225));
  }
  
  public View focusSearch(int paramInt)
  {
    Object localObject = super.focusSearch(paramInt);
    if (localObject == null)
    {
      localObject = this.mHomeView.getWorkspace();
      ((Workspace)localObject).dispatchUnhandledMove(null, paramInt);
      if ((this.mOrientation == 1) && (paramInt == 130)) {
        return this;
      }
      return (View)localObject;
    }
    return (View)localObject;
  }
  
  void setLauncher(HomeView paramHomeView)
  {
    this.mHomeView = paramHomeView;
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/HandleView.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */