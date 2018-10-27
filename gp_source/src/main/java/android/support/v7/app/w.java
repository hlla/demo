package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnKeyListener;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public final class w
{
  public final p a;
  private final int b;
  
  public w(Context paramContext)
  {
    this(paramContext, v.a(paramContext, 0));
  }
  
  public w(Context paramContext, int paramInt)
  {
    this.a = new p(new ContextThemeWrapper(paramContext, v.a(paramContext, paramInt)));
    this.b = paramInt;
  }
  
  public final v a()
  {
    v localv = new v(this.a.e, this.b);
    p localp = this.a;
    AlertController localAlertController = localv.a;
    Object localObject1 = localp.f;
    int i;
    if (localObject1 == null)
    {
      localObject1 = localp.x;
      if (localObject1 != null) {
        localAlertController.a((CharSequence)localObject1);
      }
      localObject1 = localp.g;
      if (localObject1 == null)
      {
        i = localp.h;
        if (i != 0) {}
      }
    }
    for (;;)
    {
      localObject1 = localp.m;
      if (localObject1 == null) {}
      Object localObject2;
      for (;;)
      {
        localObject1 = localp.w;
        if (localObject1 != null) {
          localAlertController.a(-1, (CharSequence)localObject1, localp.v);
        }
        localObject1 = localp.o;
        if (localObject1 != null) {
          localAlertController.a(-2, (CharSequence)localObject1, localp.n);
        }
        localObject1 = localp.q;
        if (localObject1 != null) {
          localAlertController.a(-3, (CharSequence)localObject1, localp.p);
        }
        if ((localp.l == null) && (localp.a == null))
        {
          localObject1 = localp.y;
          if (localObject1 == null) {}
          for (;;)
          {
            localv.setCancelable(this.a.b);
            if (this.a.b) {
              localv.setCanceledOnTouchOutside(true);
            }
            localv.setOnCancelListener(this.a.r);
            localv.setOnDismissListener(null);
            localObject1 = this.a.u;
            if (localObject1 != null) {
              localv.setOnKeyListener((DialogInterface.OnKeyListener)localObject1);
            }
            return localv;
            localAlertController.J = ((View)localObject1);
          }
        }
        localObject2 = (AlertController.RecycleListView)localp.i.inflate(localAlertController.z, null);
        if (localp.j)
        {
          localObject1 = new q(localp, localp.e, localAlertController.D, localp.l, (AlertController.RecycleListView)localObject2);
          localAlertController.a = ((ListAdapter)localObject1);
          localAlertController.q = localp.c;
          if (localp.t != null) {
            ((AlertController.RecycleListView)localObject2).setOnItemClickListener(new r(localp, localAlertController));
          }
          for (;;)
          {
            if (localp.k) {
              ((AlertController.RecycleListView)localObject2).setChoiceMode(1);
            }
            for (;;)
            {
              localAlertController.A = ((ListView)localObject2);
              break;
              if (localp.j) {
                ((AlertController.RecycleListView)localObject2).setChoiceMode(2);
              }
            }
            if (localp.s != null) {
              ((AlertController.RecycleListView)localObject2).setOnItemClickListener(new s(localp, (AlertController.RecycleListView)localObject2, localAlertController));
            }
          }
        }
        if (localp.k) {}
        for (i = localAlertController.G;; i = localAlertController.y)
        {
          localObject1 = localp.a;
          if (localObject1 == null)
          {
            localObject1 = new u(localp.e, i, localp.l);
            break;
          }
          break;
        }
        localAlertController.B = ((CharSequence)localObject1);
        localObject2 = localAlertController.C;
        if (localObject2 != null) {
          ((TextView)localObject2).setText((CharSequence)localObject1);
        }
      }
      localAlertController.v = null;
      localAlertController.w = i;
      localObject1 = localAlertController.x;
      if (localObject1 != null) {
        if (i != 0)
        {
          ((ImageView)localObject1).setVisibility(0);
          localAlertController.x.setImageResource(localAlertController.w);
        }
        else
        {
          ((ImageView)localObject1).setVisibility(8);
          continue;
          localAlertController.v = ((Drawable)localObject1);
          localAlertController.w = 0;
          localObject2 = localAlertController.x;
          if (localObject2 == null) {
            break;
          }
          if (localObject1 != null)
          {
            ((ImageView)localObject2).setVisibility(0);
            localAlertController.x.setImageDrawable((Drawable)localObject1);
            break;
          }
          ((ImageView)localObject2).setVisibility(8);
          break;
          localAlertController.s = ((View)localObject1);
        }
      }
    }
  }
  
  public final w a(Drawable paramDrawable)
  {
    this.a.g = paramDrawable;
    return this;
  }
  
  public final w a(View paramView)
  {
    this.a.f = paramView;
    return this;
  }
  
  public final w a(CharSequence paramCharSequence)
  {
    this.a.x = paramCharSequence;
    return this;
  }
  
  public final w a(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    p localp = this.a;
    localp.w = paramCharSequence;
    localp.v = paramOnClickListener;
    return this;
  }
  
  public final w a(CharSequence[] paramArrayOfCharSequence, int paramInt, DialogInterface.OnClickListener paramOnClickListener)
  {
    p localp = this.a;
    localp.l = paramArrayOfCharSequence;
    localp.t = paramOnClickListener;
    localp.c = paramInt;
    localp.k = true;
    return this;
  }
  
  public final w a(CharSequence[] paramArrayOfCharSequence, boolean[] paramArrayOfBoolean, DialogInterface.OnMultiChoiceClickListener paramOnMultiChoiceClickListener)
  {
    p localp = this.a;
    localp.l = paramArrayOfCharSequence;
    localp.s = paramOnMultiChoiceClickListener;
    localp.d = paramArrayOfBoolean;
    localp.j = true;
    return this;
  }
  
  public final w b(View paramView)
  {
    this.a.y = paramView;
    return this;
  }
  
  public final w b(CharSequence paramCharSequence)
  {
    this.a.m = paramCharSequence;
    return this;
  }
  
  public final w b(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    p localp = this.a;
    localp.o = paramCharSequence;
    localp.n = paramOnClickListener;
    return this;
  }
  
  public final w c(CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    p localp = this.a;
    localp.q = paramCharSequence;
    localp.p = paramOnClickListener;
    return this;
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/w.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */