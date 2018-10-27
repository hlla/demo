package android.support.v4.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;

public class j
  extends Fragment
  implements DialogInterface.OnCancelListener, DialogInterface.OnDismissListener
{
  public Dialog a;
  private int aa = -1;
  private boolean ab = true;
  private boolean ac;
  private boolean ad;
  private boolean ae;
  public boolean b = true;
  public int c = 0;
  public int d = 0;
  
  public void a(Context paramContext)
  {
    super.a(paramContext);
    if (!this.ad) {
      this.ac = false;
    }
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    if (this.m == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.b = bool;
      if (paramBundle != null)
      {
        this.c = paramBundle.getInt("android:style", 0);
        this.d = paramBundle.getInt("android:theme", 0);
        this.ab = paramBundle.getBoolean("android:cancelable", true);
        this.b = paramBundle.getBoolean("android:showsDialog", this.b);
        this.aa = paramBundle.getInt("android:backStackId", -1);
      }
      return;
    }
  }
  
  public final void a(v paramv, String paramString)
  {
    this.ac = false;
    this.ad = true;
    paramv = paramv.a();
    paramv.a(this, paramString);
    paramv.a();
  }
  
  public final void a(boolean paramBoolean)
  {
    Object localObject;
    int i;
    if (!this.ac)
    {
      this.ac = true;
      this.ad = false;
      localObject = this.a;
      if (localObject != null) {
        ((Dialog)localObject).dismiss();
      }
      this.ae = true;
      i = this.aa;
      if (i >= 0) {
        break label74;
      }
      localObject = this.q.a();
      ((at)localObject).a(this);
      if (paramBoolean) {
        ((at)localObject).b();
      }
    }
    else
    {
      return;
    }
    ((at)localObject).a();
    return;
    label74:
    this.q.b(i);
    this.aa = -1;
  }
  
  public final LayoutInflater a_(Bundle paramBundle)
  {
    if (!this.b) {
      return super.a_(paramBundle);
    }
    this.a = c(paramBundle);
    paramBundle = this.a;
    if (paramBundle != null)
    {
      switch (this.c)
      {
      }
      for (;;)
      {
        return (LayoutInflater)this.a.getContext().getSystemService("layout_inflater");
        paramBundle.getWindow().addFlags(24);
        paramBundle.requestWindowFeature(1);
      }
    }
    return (LayoutInflater)this.v.b.getSystemService("layout_inflater");
  }
  
  public void au_()
  {
    super.au_();
    if ((!this.ad) && (!this.ac)) {
      this.ac = true;
    }
  }
  
  public void av_()
  {
    super.av_();
    Dialog localDialog = this.a;
    if (localDialog != null)
    {
      this.ae = false;
      localDialog.show();
    }
  }
  
  public final void b(boolean paramBoolean)
  {
    this.ab = paramBoolean;
    Dialog localDialog = this.a;
    if (localDialog != null) {
      localDialog.setCancelable(paramBoolean);
    }
  }
  
  public Dialog c(Bundle paramBundle)
  {
    return new Dialog(j(), this.d);
  }
  
  public void d(Bundle paramBundle)
  {
    super.d(paramBundle);
    if (this.b)
    {
      Object localObject = this.U;
      if (localObject != null)
      {
        if (((View)localObject).getParent() != null) {
          throw new IllegalStateException("DialogFragment can not be attached to a container view");
        }
        this.a.setContentView((View)localObject);
      }
      localObject = j();
      if (localObject != null) {
        this.a.setOwnerActivity((Activity)localObject);
      }
      this.a.setCancelable(this.ab);
      this.a.setOnCancelListener(this);
      this.a.setOnDismissListener(this);
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getBundle("android:savedDialogState");
        if (paramBundle != null) {
          this.a.onRestoreInstanceState(paramBundle);
        }
      }
    }
  }
  
  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    Object localObject = this.a;
    if (localObject != null)
    {
      localObject = ((Dialog)localObject).onSaveInstanceState();
      if (localObject != null) {
        paramBundle.putBundle("android:savedDialogState", (Bundle)localObject);
      }
    }
    int i = this.c;
    if (i != 0) {
      paramBundle.putInt("android:style", i);
    }
    i = this.d;
    if (i != 0) {
      paramBundle.putInt("android:theme", i);
    }
    boolean bool = this.ab;
    if (!bool) {
      paramBundle.putBoolean("android:cancelable", bool);
    }
    bool = this.b;
    if (!bool) {
      paramBundle.putBoolean("android:showsDialog", bool);
    }
    i = this.aa;
    if (i != -1) {
      paramBundle.putInt("android:backStackId", i);
    }
  }
  
  public final void f()
  {
    super.f();
    Dialog localDialog = this.a;
    if (localDialog != null)
    {
      this.ae = true;
      localDialog.dismiss();
      this.a = null;
    }
  }
  
  public final void o_()
  {
    super.o_();
    Dialog localDialog = this.a;
    if (localDialog != null) {
      localDialog.hide();
    }
  }
  
  public void onCancel(DialogInterface paramDialogInterface) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (!this.ae) {
      a(true);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v4/app/j.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */