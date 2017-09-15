package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.z;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.a.a.f;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;

public final class b
  extends i
  implements DialogInterface
{
  private a Gn = new a(getContext(), this, getWindow());
  
  public b(Context paramContext, int paramInt)
  {
    super(paramContext, c(paramContext, paramInt));
  }
  
  static int c(Context paramContext, int paramInt)
  {
    if (paramInt >= 16777216) {
      return paramInt;
    }
    TypedValue localTypedValue = new TypedValue();
    paramContext.getTheme().resolveAttribute(android.support.v7.a.a.a.alertDialogTheme, localTypedValue, true);
    return localTypedValue.resourceId;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a locala = this.Gn;
    int i;
    Object localObject4;
    Object localObject3;
    Object localObject2;
    Object localObject1;
    label108:
    label114:
    label225:
    label360:
    label411:
    label460:
    label509:
    label515:
    label574:
    label591:
    int k;
    label607:
    int j;
    if ((locala.FD != 0) && (locala.FI == 1))
    {
      i = locala.FD;
      locala.Fd.setContentView(i);
      paramBundle = locala.Fe.findViewById(a.f.Kf);
      localObject4 = paramBundle.findViewById(a.f.Kx);
      localObject3 = paramBundle.findViewById(a.f.JX);
      localObject2 = paramBundle.findViewById(a.f.JW);
      localObject1 = (ViewGroup)paramBundle.findViewById(a.f.JY);
      if (locala.mView == null) {
        break label834;
      }
      paramBundle = locala.mView;
      if (paramBundle == null) {
        break label870;
      }
      i = 1;
      if ((i == 0) || (!a.aI(paramBundle))) {
        locala.Fe.setFlags(131072, 131072);
      }
      if (i == 0) {
        break label875;
      }
      Object localObject5 = (FrameLayout)locala.Fe.findViewById(a.f.custom);
      ((FrameLayout)localObject5).addView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
      if (locala.Fm) {
        ((FrameLayout)localObject5).setPadding(locala.Fi, locala.Fj, locala.Fk, locala.Fl);
      }
      if (locala.Fg != null) {
        ((LinearLayout.LayoutParams)((ViewGroup)localObject1).getLayoutParams()).weight = 0.0F;
      }
      paramBundle = ((ViewGroup)localObject1).findViewById(a.f.Kx);
      View localView = ((ViewGroup)localObject1).findViewById(a.f.JX);
      localObject5 = ((ViewGroup)localObject1).findViewById(a.f.JW);
      paramBundle = a.b(paramBundle, (View)localObject4);
      localObject3 = a.b(localView, (View)localObject3);
      localObject2 = a.b((View)localObject5, (View)localObject2);
      locala.Fw = ((NestedScrollView)locala.Fe.findViewById(a.f.Ki));
      locala.Fw.setFocusable(false);
      locala.Fw.setNestedScrollingEnabled(false);
      locala.jq = ((TextView)((ViewGroup)localObject3).findViewById(16908299));
      if (locala.jq != null)
      {
        if (locala.Ff == null) {
          break label885;
        }
        locala.jq.setText(locala.Ff);
      }
      i = 0;
      locala.Fn = ((Button)((ViewGroup)localObject2).findViewById(16908313));
      locala.Fn.setOnClickListener(locala.FJ);
      if (!TextUtils.isEmpty(locala.Fo)) {
        break label979;
      }
      locala.Fn.setVisibility(8);
      locala.Fq = ((Button)((ViewGroup)localObject2).findViewById(16908314));
      locala.Fq.setOnClickListener(locala.FJ);
      if (!TextUtils.isEmpty(locala.Fr)) {
        break label1006;
      }
      locala.Fq.setVisibility(8);
      locala.Ft = ((Button)((ViewGroup)localObject2).findViewById(16908315));
      locala.Ft.setOnClickListener(locala.FJ);
      if (!TextUtils.isEmpty(locala.Fu)) {
        break label1035;
      }
      locala.Ft.setVisibility(8);
      if (i == 0) {
        break label1064;
      }
      i = 1;
      if (i == 0) {
        ((ViewGroup)localObject2).setVisibility(8);
      }
      if (locala.Fz == null) {
        break label1069;
      }
      localObject4 = new ViewGroup.LayoutParams(-1, -2);
      paramBundle.addView(locala.Fz, 0, (ViewGroup.LayoutParams)localObject4);
      locala.Fe.findViewById(a.f.Kw).setVisibility(8);
      if ((localObject1 == null) || (((ViewGroup)localObject1).getVisibility() == 8)) {
        break label1278;
      }
      i = 1;
      if ((paramBundle == null) || (paramBundle.getVisibility() == 8)) {
        break label1283;
      }
      k = 1;
      if ((localObject2 == null) || (((ViewGroup)localObject2).getVisibility() == 8)) {
        break label1289;
      }
      j = 1;
      label624:
      if ((j == 0) && (localObject3 != null))
      {
        paramBundle = ((ViewGroup)localObject3).findViewById(a.f.Kv);
        if (paramBundle != null) {
          paramBundle.setVisibility(0);
        }
      }
      if ((k != 0) && (locala.Fw != null)) {
        locala.Fw.setClipToPadding(true);
      }
      if (i == 0)
      {
        if (locala.Fg == null) {
          break label1294;
        }
        paramBundle = locala.Fg;
        label691:
        if (paramBundle != null)
        {
          if (k == 0) {
            break label1303;
          }
          i = 1;
          label702:
          if (j == 0) {
            break label1308;
          }
          j = 2;
          label708:
          i |= j;
          localObject1 = locala.Fe.findViewById(a.f.Kh);
          localObject2 = locala.Fe.findViewById(a.f.Kg);
          if (Build.VERSION.SDK_INT < 23) {
            break label1313;
          }
          z.c(paramBundle, i, 3);
          if (localObject1 != null) {
            ((ViewGroup)localObject3).removeView((View)localObject1);
          }
          if (localObject2 != null) {
            ((ViewGroup)localObject3).removeView((View)localObject2);
          }
        }
      }
    }
    for (;;)
    {
      paramBundle = locala.Fg;
      if ((paramBundle != null) && (locala.FA != null))
      {
        paramBundle.setAdapter(locala.FA);
        i = locala.FB;
        if (i >= 0)
        {
          paramBundle.setItemChecked(i, true);
          paramBundle.setSelection(i);
        }
      }
      return;
      i = locala.FC;
      break;
      label834:
      if (locala.Fh != 0)
      {
        paramBundle = LayoutInflater.from(locala.mContext).inflate(locala.Fh, (ViewGroup)localObject1, false);
        break label108;
      }
      paramBundle = null;
      break label108;
      label870:
      i = 0;
      break label114;
      label875:
      ((ViewGroup)localObject1).setVisibility(8);
      break label225;
      label885:
      locala.jq.setVisibility(8);
      locala.Fw.removeView(locala.jq);
      if (locala.Fg != null)
      {
        localObject4 = (ViewGroup)locala.Fw.getParent();
        i = ((ViewGroup)localObject4).indexOfChild(locala.Fw);
        ((ViewGroup)localObject4).removeViewAt(i);
        ((ViewGroup)localObject4).addView(locala.Fg, i, new ViewGroup.LayoutParams(-1, -1));
        break label360;
      }
      ((ViewGroup)localObject3).setVisibility(8);
      break label360;
      label979:
      locala.Fn.setText(locala.Fo);
      locala.Fn.setVisibility(0);
      i = 1;
      break label411;
      label1006:
      locala.Fq.setText(locala.Fr);
      locala.Fq.setVisibility(0);
      i |= 0x2;
      break label460;
      label1035:
      locala.Ft.setText(locala.Fu);
      locala.Ft.setVisibility(0);
      i |= 0x4;
      break label509;
      label1064:
      i = 0;
      break label515;
      label1069:
      locala.kI = ((ImageView)locala.Fe.findViewById(16908294));
      if (!TextUtils.isEmpty(locala.uI)) {
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          locala.Fy = ((TextView)locala.Fe.findViewById(a.f.JV));
          locala.Fy.setText(locala.uI);
          if (locala.Fx != 0)
          {
            locala.kI.setImageResource(locala.Fx);
            break;
            i = 0;
            continue;
          }
          if (locala.jQ != null)
          {
            locala.kI.setImageDrawable(locala.jQ);
            break;
          }
          locala.Fy.setPadding(locala.kI.getPaddingLeft(), locala.kI.getPaddingTop(), locala.kI.getPaddingRight(), locala.kI.getPaddingBottom());
          locala.kI.setVisibility(8);
          break;
        }
      }
      locala.Fe.findViewById(a.f.Kw).setVisibility(8);
      locala.kI.setVisibility(8);
      paramBundle.setVisibility(8);
      break label574;
      label1278:
      i = 0;
      break label591;
      label1283:
      k = 0;
      break label607;
      label1289:
      j = 0;
      break label624;
      label1294:
      paramBundle = locala.Fw;
      break label691;
      label1303:
      i = 0;
      break label702;
      label1308:
      j = 0;
      break label708;
      label1313:
      paramBundle = (Bundle)localObject1;
      if (localObject1 != null)
      {
        paramBundle = (Bundle)localObject1;
        if ((i & 0x1) == 0)
        {
          ((ViewGroup)localObject3).removeView((View)localObject1);
          paramBundle = null;
        }
      }
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if ((i & 0x2) == 0)
        {
          ((ViewGroup)localObject3).removeView((View)localObject2);
          localObject1 = null;
        }
      }
      if ((paramBundle != null) || (localObject1 != null)) {
        if (locala.Ff != null)
        {
          locala.Fw.Dm = new a.2(locala, paramBundle, (View)localObject1);
          locala.Fw.post(new a.3(locala, paramBundle, (View)localObject1));
        }
        else if (locala.Fg != null)
        {
          locala.Fg.setOnScrollListener(new a.4(locala, paramBundle, (View)localObject1));
          locala.Fg.post(new a.5(locala, paramBundle, (View)localObject1));
        }
        else
        {
          if (paramBundle != null) {
            ((ViewGroup)localObject3).removeView(paramBundle);
          }
          if (localObject1 != null) {
            ((ViewGroup)localObject3).removeView((View)localObject1);
          }
        }
      }
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    a locala = this.Gn;
    if ((locala.Fw != null) && (locala.Fw.executeKeyEvent(paramKeyEvent))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    a locala = this.Gn;
    if ((locala.Fw != null) && (locala.Fw.executeKeyEvent(paramKeyEvent))) {}
    for (int i = 1; i != 0; i = 0) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.Gn.setTitle(paramCharSequence);
  }
  
  public static final class a
  {
    public final a.a Go;
    public int oH;
    
    public a(Context paramContext)
    {
      this(paramContext, b.c(paramContext, 0));
    }
    
    private a(Context paramContext, int paramInt)
    {
      this.Go = new a.a(new ContextThemeWrapper(paramContext, b.c(paramContext, paramInt)));
      this.oH = paramInt;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v7/app/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */