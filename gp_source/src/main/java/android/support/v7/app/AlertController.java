package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.a.a;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public final class AlertController
{
  public ListView A;
  public CharSequence B;
  public TextView C;
  public int D;
  public NestedScrollView E;
  public boolean F;
  public int G;
  public CharSequence H;
  public TextView I;
  public View J;
  public final Window K;
  public ListAdapter a;
  public int b;
  public final View.OnClickListener c = new k(this);
  public final int d;
  public Button e;
  public Drawable f;
  public Message g;
  public CharSequence h;
  public Button i;
  public Drawable j;
  public Message k;
  public CharSequence l;
  public Button m;
  public Drawable n;
  public Message o;
  public CharSequence p;
  public int q = -1;
  public final Context r;
  public View s;
  public final at t;
  public Handler u;
  public Drawable v;
  public int w = 0;
  public ImageView x;
  public int y;
  public int z;
  
  public AlertController(Context paramContext, at paramat, Window paramWindow)
  {
    this.r = paramContext;
    this.t = paramat;
    this.K = paramWindow;
    this.u = new t(paramat);
    paramContext = paramContext.obtainStyledAttributes(null, a.D, 2130968624, 0);
    this.b = paramContext.getResourceId(a.E, 0);
    paramContext.getResourceId(a.G, 0);
    this.z = paramContext.getResourceId(a.I, 0);
    this.D = paramContext.getResourceId(a.J, 0);
    this.G = paramContext.getResourceId(a.L, 0);
    this.y = paramContext.getResourceId(a.H, 0);
    this.F = paramContext.getBoolean(a.K, true);
    this.d = paramContext.getDimensionPixelSize(a.F, 0);
    paramContext.recycle();
    paramat.a().c(1);
  }
  
  static ViewGroup a(View paramView1, View paramView2)
  {
    if (paramView1 == null)
    {
      if ((paramView2 instanceof ViewStub)) {}
      for (paramView1 = ((ViewStub)paramView2).inflate();; paramView1 = paramView2) {
        return (ViewGroup)paramView1;
      }
    }
    if (paramView2 != null)
    {
      ViewParent localViewParent = paramView2.getParent();
      if ((localViewParent instanceof ViewGroup)) {
        ((ViewGroup)localViewParent).removeView(paramView2);
      }
    }
    if ((paramView1 instanceof ViewStub)) {
      paramView1 = ((ViewStub)paramView1).inflate();
    }
    for (;;)
    {
      return (ViewGroup)paramView1;
    }
  }
  
  static void a(View paramView1, View paramView2, View paramView3)
  {
    int i2 = 4;
    if (paramView2 != null) {
      if (paramView1.canScrollVertically(-1)) {
        break label48;
      }
    }
    label43:
    label48:
    for (int i1 = 4;; i1 = 0)
    {
      paramView2.setVisibility(i1);
      if (paramView3 != null) {
        if (paramView1.canScrollVertically(1)) {
          break label43;
        }
      }
      for (i1 = i2;; i1 = 0)
      {
        paramView3.setVisibility(i1);
        return;
      }
    }
  }
  
  static void a(Button paramButton)
  {
    LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)paramButton.getLayoutParams();
    localLayoutParams.gravity = 1;
    localLayoutParams.weight = 0.5F;
    paramButton.setLayoutParams(localLayoutParams);
  }
  
  static boolean a(View paramView)
  {
    if (!paramView.onCheckIsTextEditor())
    {
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int i1 = paramView.getChildCount();
        int i2;
        do
        {
          if (i1 <= 0) {
            break;
          }
          i2 = i1 - 1;
          i1 = i2;
        } while (!a(paramView.getChildAt(i2)));
      }
    }
    else
    {
      return true;
      return false;
    }
    return false;
  }
  
  public final void a(int paramInt, CharSequence paramCharSequence, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener != null) {}
    for (paramOnClickListener = this.u.obtainMessage(paramInt, paramOnClickListener);; paramOnClickListener = null)
    {
      switch (paramInt)
      {
      default: 
        throw new IllegalArgumentException("Button does not exist");
      case -1: 
        this.p = paramCharSequence;
        this.o = paramOnClickListener;
        this.n = null;
        return;
      case -2: 
        this.h = paramCharSequence;
        this.g = paramOnClickListener;
        this.f = null;
        return;
      }
      this.l = paramCharSequence;
      this.k = paramOnClickListener;
      this.j = null;
      return;
    }
  }
  
  public final void a(CharSequence paramCharSequence)
  {
    this.H = paramCharSequence;
    TextView localTextView = this.I;
    if (localTextView != null) {
      localTextView.setText(paramCharSequence);
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/AlertController.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */