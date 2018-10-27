package android.support.v7.preference;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.j;
import android.support.v4.app.o;
import android.support.v7.app.w;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public abstract class r
  extends j
  implements DialogInterface.OnClickListener
{
  private BitmapDrawable aa;
  private int ab;
  private CharSequence ac;
  private CharSequence ad;
  private CharSequence ae;
  private CharSequence af;
  private DialogPreference ag;
  private int ah;
  
  protected boolean R()
  {
    return false;
  }
  
  public final DialogPreference S()
  {
    if (this.ag == null)
    {
      String str = this.g.getString("key");
      this.ag = ((DialogPreference)((e)this.Q).a(str));
    }
    return this.ag;
  }
  
  public void a(Bundle paramBundle)
  {
    super.a(paramBundle);
    Object localObject1 = this.Q;
    if (!(localObject1 instanceof e)) {
      throw new IllegalStateException("Target fragment must implement TargetFragment interface");
    }
    localObject1 = (e)localObject1;
    Object localObject2 = this.g.getString("key");
    if (paramBundle == null)
    {
      this.ag = ((DialogPreference)((e)localObject1).a((CharSequence)localObject2));
      paramBundle = this.ag;
      this.ad = paramBundle.d;
      this.af = paramBundle.f;
      this.ae = paramBundle.e;
      this.ac = paramBundle.c;
      this.ab = paramBundle.b;
      paramBundle = paramBundle.a;
      if ((paramBundle == null) || ((paramBundle instanceof BitmapDrawable))) {
        this.aa = ((BitmapDrawable)paramBundle);
      }
    }
    do
    {
      return;
      localObject1 = Bitmap.createBitmap(paramBundle.getIntrinsicWidth(), paramBundle.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
      localObject2 = new Canvas((Bitmap)localObject1);
      paramBundle.setBounds(0, 0, ((Canvas)localObject2).getWidth(), ((Canvas)localObject2).getHeight());
      paramBundle.draw((Canvas)localObject2);
      this.aa = new BitmapDrawable(k(), (Bitmap)localObject1);
      return;
      this.ad = paramBundle.getCharSequence("PreferenceDialogFragment.title");
      this.af = paramBundle.getCharSequence("PreferenceDialogFragment.positiveText");
      this.ae = paramBundle.getCharSequence("PreferenceDialogFragment.negativeText");
      this.ac = paramBundle.getCharSequence("PreferenceDialogFragment.message");
      this.ab = paramBundle.getInt("PreferenceDialogFragment.layout", 0);
      paramBundle = (Bitmap)paramBundle.getParcelable("PreferenceDialogFragment.icon");
    } while (paramBundle == null);
    this.aa = new BitmapDrawable(k(), paramBundle);
  }
  
  protected void a(w paramw) {}
  
  protected void b(View paramView)
  {
    paramView = paramView.findViewById(16908299);
    int i;
    if (paramView != null)
    {
      CharSequence localCharSequence = this.ac;
      if (TextUtils.isEmpty(localCharSequence)) {
        break label59;
      }
      if (!(paramView instanceof TextView)) {
        break label54;
      }
      ((TextView)paramView).setText(localCharSequence);
      i = 0;
    }
    for (;;)
    {
      if (paramView.getVisibility() != i) {
        paramView.setVisibility(i);
      }
      return;
      label54:
      i = 0;
      continue;
      label59:
      i = 8;
    }
  }
  
  public final Dialog c(Bundle paramBundle)
  {
    paramBundle = null;
    o localo = j();
    this.ah = -2;
    w localw = new w(localo).a(this.ad).a(this.aa).a(this.af, this).b(this.ae, this);
    int i = this.ab;
    if (i != 0) {
      paramBundle = LayoutInflater.from(localo).inflate(i, null);
    }
    if (paramBundle != null)
    {
      b(paramBundle);
      localw.b(paramBundle);
    }
    for (;;)
    {
      a(localw);
      paramBundle = localw.a();
      if (R()) {
        paramBundle.getWindow().setSoftInputMode(5);
      }
      return paramBundle;
      localw.b(this.ac);
    }
  }
  
  public void e(Bundle paramBundle)
  {
    super.e(paramBundle);
    paramBundle.putCharSequence("PreferenceDialogFragment.title", this.ad);
    paramBundle.putCharSequence("PreferenceDialogFragment.positiveText", this.af);
    paramBundle.putCharSequence("PreferenceDialogFragment.negativeText", this.ae);
    paramBundle.putCharSequence("PreferenceDialogFragment.message", this.ac);
    paramBundle.putInt("PreferenceDialogFragment.layout", this.ab);
    BitmapDrawable localBitmapDrawable = this.aa;
    if (localBitmapDrawable != null) {
      paramBundle.putParcelable("PreferenceDialogFragment.icon", localBitmapDrawable.getBitmap());
    }
  }
  
  public abstract void e(boolean paramBoolean);
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.ah = paramInt;
  }
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    super.onDismiss(paramDialogInterface);
    if (this.ah == -1) {}
    for (boolean bool = true;; bool = false)
    {
      e(bool);
      return;
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/preference/r.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */