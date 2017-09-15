package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.l;
import android.support.v4.app.p;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.e;
import com.google.android.gms.common.internal.w;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

public final class u
  extends Fragment
  implements DialogInterface.OnCancelListener
{
  public boolean aok;
  public int aol = -1;
  public ConnectionResult aom;
  public final Handler aon = new Handler(Looper.getMainLooper());
  final SparseArray<a> aoo = new SparseArray();
  public boolean ny;
  
  public static u a(FragmentActivity paramFragmentActivity)
  {
    w.V("Must be called from main thread of process");
    paramFragmentActivity = paramFragmentActivity.aR();
    try
    {
      u localu = (u)paramFragmentActivity.k("GmsSupportLifecycleFragment");
      if (localu != null)
      {
        paramFragmentActivity = localu;
        if (!localu.pb) {}
      }
      else
      {
        paramFragmentActivity = null;
      }
      return paramFragmentActivity;
    }
    catch (ClassCastException paramFragmentActivity)
    {
      throw new IllegalStateException("Fragment with tag GmsSupportLifecycleFragment is not a SupportLifecycleFragment", paramFragmentActivity);
    }
  }
  
  public static u b(FragmentActivity paramFragmentActivity)
  {
    u localu = a(paramFragmentActivity);
    l locall = paramFragmentActivity.aR();
    paramFragmentActivity = localu;
    if (localu == null)
    {
      paramFragmentActivity = new u();
      locall.aV().a(paramFragmentActivity, "GmsSupportLifecycleFragment").commitAllowingStateLoss();
      locall.executePendingTransactions();
    }
    return paramFragmentActivity;
  }
  
  public final void a(int paramInt, ConnectionResult paramConnectionResult)
  {
    Object localObject = (a)this.aoo.get(paramInt);
    if (localObject != null)
    {
      a locala = (a)this.aoo.get(paramInt);
      this.aoo.remove(paramInt);
      if (locala != null)
      {
        locala.aoq.b(locala);
        locala.aoq.disconnect();
      }
      localObject = ((a)localObject).aor;
      if (localObject != null) {
        ((c.c)localObject).a(paramConnectionResult);
      }
    }
    jL();
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    super.dump(paramString, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
    int i = 0;
    while (i < this.aoo.size())
    {
      paramFileDescriptor = (a)this.aoo.valueAt(i);
      paramPrintWriter.append(paramString).append("GoogleApiClient #").print(paramFileDescriptor.aop);
      paramPrintWriter.println(":");
      paramFileDescriptor.aoq.a(paramString + "  ", paramPrintWriter);
      i += 1;
    }
  }
  
  public final void jL()
  {
    this.aok = false;
    this.aol = -1;
    this.aom = null;
    int i = 0;
    while (i < this.aoo.size())
    {
      ((a)this.aoo.valueAt(i)).aoq.connect();
      i += 1;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    int i = 1;
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
    }
    for (;;)
    {
      if (paramInt1 == 0) {
        break label66;
      }
      jL();
      return;
      if (e.w(aG()) != 0) {
        break;
      }
      paramInt1 = i;
      continue;
      if (paramInt2 != -1) {
        break;
      }
      paramInt1 = i;
    }
    label66:
    a(this.aol, this.aom);
  }
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    a(this.aol, new ConnectionResult(13, null));
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (paramBundle != null)
    {
      this.aok = paramBundle.getBoolean("resolving_error", false);
      this.aol = paramBundle.getInt("failed_client_id", -1);
      if (this.aol >= 0) {
        this.aom = new ConnectionResult(paramBundle.getInt("failed_status"), (PendingIntent)paramBundle.getParcelable("failed_resolution"));
      }
    }
  }
  
  public final void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    paramBundle.putBoolean("resolving_error", this.aok);
    if (this.aol >= 0)
    {
      paramBundle.putInt("failed_client_id", this.aol);
      paramBundle.putInt("failed_status", this.aom.alZ);
      paramBundle.putParcelable("failed_resolution", this.aom.ama);
    }
  }
  
  public final void onStart()
  {
    super.onStart();
    this.ny = true;
    if (!this.aok)
    {
      int i = 0;
      while (i < this.aoo.size())
      {
        ((a)this.aoo.valueAt(i)).aoq.connect();
        i += 1;
      }
    }
  }
  
  public final void onStop()
  {
    super.onStop();
    this.ny = false;
    int i = 0;
    while (i < this.aoo.size())
    {
      ((a)this.aoo.valueAt(i)).aoq.disconnect();
      i += 1;
    }
  }
  
  private final class a
    implements c.c
  {
    public final int aop;
    public final c aoq;
    public final c.c aor;
    
    public a(int paramInt, c paramc, c.c paramc1)
    {
      this.aop = paramInt;
      this.aoq = paramc;
      this.aor = paramc1;
      paramc.a(this);
    }
    
    public final void a(ConnectionResult paramConnectionResult)
    {
      u.this.aon.post(new u.b(u.this, this.aop, paramConnectionResult));
    }
  }
  
  private final class b
    implements Runnable
  {
    private final int aot;
    private final ConnectionResult aou;
    
    public b(int paramInt, ConnectionResult paramConnectionResult)
    {
      this.aot = paramInt;
      this.aou = paramConnectionResult;
    }
    
    public final void run()
    {
      if ((!u.this.ny) || (u.this.aok)) {
        return;
      }
      u.this.aok = true;
      u.this.aol = this.aot;
      u.this.aom = this.aou;
      if (this.aou.jf()) {
        try
        {
          int i = u.this.aG().aR().aW().indexOf(u.this);
          this.aou.a(u.this.aG(), (i + 1 << 16) + 1);
          return;
        }
        catch (IntentSender.SendIntentException localSendIntentException)
        {
          u.this.jL();
          return;
        }
      }
      if (e.bP(this.aou.alZ))
      {
        e.a(this.aou.alZ, u.this.aG(), u.this, u.this);
        return;
      }
      u.this.a(this.aot, this.aou);
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/google/android/gms/common/api/u.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */