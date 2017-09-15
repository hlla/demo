package android.support.v4.app;

import android.app.RemoteInput;
import android.content.ClipData;
import android.content.ClipData.Item;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;

public final class ag
  extends ai.a
{
  private static final b tf;
  public static final ai.a.a tg;
  private final Bundle mExtras;
  private final String tb;
  private final CharSequence tc;
  private final CharSequence[] td;
  private final boolean te;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 20) {
      tf = new c();
    }
    for (;;)
    {
      tg = new ai.a.a() {};
      return;
      if (Build.VERSION.SDK_INT >= 16) {
        tf = new e();
      } else {
        tf = new d();
      }
    }
  }
  
  public ag(String paramString, CharSequence paramCharSequence, CharSequence[] paramArrayOfCharSequence, boolean paramBoolean, Bundle paramBundle)
  {
    this.tb = paramString;
    this.tc = paramCharSequence;
    this.td = paramArrayOfCharSequence;
    this.te = paramBoolean;
    this.mExtras = paramBundle;
  }
  
  public static Bundle getResultsFromIntent(Intent paramIntent)
  {
    return tf.getResultsFromIntent(paramIntent);
  }
  
  public final boolean getAllowFreeFormInput()
  {
    return this.te;
  }
  
  public final CharSequence[] getChoices()
  {
    return this.td;
  }
  
  public final Bundle getExtras()
  {
    return this.mExtras;
  }
  
  public final CharSequence getLabel()
  {
    return this.tc;
  }
  
  public final String getResultKey()
  {
    return this.tb;
  }
  
  public static final class a
  {
    public Bundle mExtras = new Bundle();
    public final String tb;
    public CharSequence tc;
    public CharSequence[] td;
    public boolean te = true;
    
    public a(String paramString)
    {
      this.tb = paramString;
    }
  }
  
  static abstract interface b
  {
    public abstract Bundle getResultsFromIntent(Intent paramIntent);
  }
  
  static final class c
    implements ag.b
  {
    public final Bundle getResultsFromIntent(Intent paramIntent)
    {
      return RemoteInput.getResultsFromIntent(paramIntent);
    }
  }
  
  static final class d
    implements ag.b
  {
    public final Bundle getResultsFromIntent(Intent paramIntent)
    {
      return null;
    }
  }
  
  static final class e
    implements ag.b
  {
    public final Bundle getResultsFromIntent(Intent paramIntent)
    {
      paramIntent = paramIntent.getClipData();
      if (paramIntent != null)
      {
        ClipDescription localClipDescription = paramIntent.getDescription();
        if ((localClipDescription.hasMimeType("text/vnd.android.intent")) && (localClipDescription.getLabel().equals("android.remoteinput.results"))) {
          return (Bundle)paramIntent.getItemAt(0).getIntent().getExtras().getParcelable("android.remoteinput.resultsData");
        }
      }
      return null;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/app/ag.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */