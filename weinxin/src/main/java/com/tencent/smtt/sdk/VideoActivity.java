package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer.OnErrorListener;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.VideoView;

public class VideoActivity
  extends Activity
{
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    u.gy(this);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    super.requestWindowFeature(1);
    super.getWindow().setFormat(-3);
    paramBundle = super.getIntent();
    Object localObject2;
    Object localObject1;
    if (paramBundle != null)
    {
      paramBundle = paramBundle.getBundleExtra("extraData");
      if (paramBundle != null)
      {
        paramBundle.putInt("callMode", 1);
        localObject2 = u.gy(super.getApplicationContext());
        localObject1 = paramBundle;
        if (paramBundle == null) {
          localObject1 = new Bundle();
        }
        if (!TextUtils.isEmpty(null)) {
          ((Bundle)localObject1).putString("videoUrl", null);
        }
        ((Bundle)localObject1).putInt("callMode", 1);
        localObject2 = ((u)localObject2).wUg;
        ((v)localObject2).setBackgroundColor(-16777216);
        if (((v)localObject2).wUi == null)
        {
          d.lY(true).a(((v)localObject2).getContext().getApplicationContext(), null);
          paramBundle = d.lY(true).cdI();
          if (paramBundle == null) {
            break label379;
          }
        }
      }
    }
    label379:
    for (paramBundle = paramBundle.wUo;; paramBundle = null)
    {
      if ((paramBundle != null) && (QbSdk.canLoadVideo(((v)localObject2).getContext()))) {
        ((v)localObject2).wUi = new z(paramBundle);
      }
      if ((((v)localObject2).wUi != null) && (((v)localObject2).wUh == null)) {
        ((v)localObject2).wUh = ((v)localObject2).wUi.gz(((v)localObject2).getContext().getApplicationContext());
      }
      boolean bool = false;
      if (((v)localObject2).ceK())
      {
        ((Bundle)localObject1).putInt("callMode", ((Bundle)localObject1).getInt("callMode"));
        bool = ((v)localObject2).wUi.a(((v)localObject2).wUh, (Bundle)localObject1, (FrameLayout)localObject2, null);
      }
      if (!bool)
      {
        if (((v)localObject2).wUj != null) {
          ((v)localObject2).wUj.stopPlayback();
        }
        if (((v)localObject2).wUj == null) {
          ((v)localObject2).wUj = new VideoView(((v)localObject2).getContext());
        }
        ((v)localObject2).mUrl = ((Bundle)localObject1).getString("videoUrl");
        ((v)localObject2).wUj.setVideoURI(Uri.parse(((v)localObject2).mUrl));
        ((v)localObject2).wUj.setOnErrorListener((MediaPlayer.OnErrorListener)localObject2);
        paramBundle = new Intent("com.tencent.smtt.tbs.video.PLAY");
        paramBundle.addFlags(268435456);
        localObject1 = ((v)localObject2).getContext().getApplicationContext();
        paramBundle.setPackage(((Context)localObject1).getPackageName());
        ((Context)localObject1).startActivity(paramBundle);
      }
      return;
      paramBundle = null;
      break;
    }
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    u.gy(this).k(this, 4);
  }
  
  protected void onPause()
  {
    super.onPause();
    u.gy(this).k(this, 3);
  }
  
  protected void onResume()
  {
    super.onResume();
    u.gy(this).k(this, 2);
  }
  
  protected void onStop()
  {
    super.onStop();
    u.gy(this).k(this, 1);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/smtt/sdk/VideoActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */