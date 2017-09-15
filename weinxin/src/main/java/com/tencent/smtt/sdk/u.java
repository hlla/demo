package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.os.Build.VERSION;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.MediaController;
import android.widget.VideoView;

final class u
{
  private static u wUf = null;
  Context ty;
  v wUg = null;
  
  private u(Context paramContext)
  {
    this.ty = paramContext.getApplicationContext();
    this.wUg = new v(this.ty);
  }
  
  public static u gy(Context paramContext)
  {
    try
    {
      if (wUf == null) {
        wUf = new u(paramContext);
      }
      paramContext = wUf;
      return paramContext;
    }
    finally {}
  }
  
  final void k(Activity paramActivity, int paramInt)
  {
    v localv = this.wUg;
    if ((paramInt == 3) && (!localv.ceK()) && (localv.wUj != null)) {
      localv.wUj.pause();
    }
    if (paramInt == 4)
    {
      localv.mContext = null;
      if ((!localv.ceK()) && (localv.wUj != null))
      {
        localv.wUj.stopPlayback();
        localv.wUj = null;
      }
    }
    if ((paramInt == 2) && (!localv.ceK()))
    {
      localv.mContext = paramActivity;
      if ((!localv.ceK()) && (localv.wUj != null))
      {
        if (localv.wUj.getParent() == null)
        {
          Object localObject = paramActivity.getWindow();
          FrameLayout localFrameLayout = (FrameLayout)((Window)localObject).getDecorView();
          ((Window)localObject).addFlags(1024);
          ((Window)localObject).addFlags(128);
          localFrameLayout.setBackgroundColor(-16777216);
          localObject = new MediaController(paramActivity);
          ((MediaController)localObject).setMediaPlayer(localv.wUj);
          localv.wUj.setMediaController((MediaController)localObject);
          localObject = new FrameLayout.LayoutParams(-1, -1);
          ((FrameLayout.LayoutParams)localObject).gravity = 17;
          localFrameLayout.addView(localv.wUj, (ViewGroup.LayoutParams)localObject);
        }
        if (Build.VERSION.SDK_INT >= 8) {
          localv.wUj.start();
        }
      }
    }
    if (localv.ceK()) {
      localv.wUi.a(localv.wUh, paramActivity, paramInt);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */