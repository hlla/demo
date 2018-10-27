package android.support.v7.app;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.view.ac;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.dk;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public final class v
  extends at
  implements DialogInterface
{
  public final AlertController a = new AlertController(getContext(), this, getWindow());
  
  protected v(Context paramContext, int paramInt)
  {
    super(paramContext, a(paramContext, paramInt));
  }
  
  static int a(Context paramContext, int paramInt)
  {
    int i = paramInt;
    if (paramInt >>> 24 <= 0)
    {
      TypedValue localTypedValue = new TypedValue();
      paramContext.getTheme().resolveAttribute(2130968625, localTypedValue, true);
      i = localTypedValue.resourceId;
    }
    return i;
  }
  
  public final Button a(int paramInt)
  {
    AlertController localAlertController = this.a;
    switch (paramInt)
    {
    default: 
      return null;
    case -1: 
      return localAlertController.m;
    case -2: 
      return localAlertController.e;
    }
    return localAlertController.i;
  }
  
  protected final void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    AlertController localAlertController = this.a;
    int i = localAlertController.b;
    localAlertController.t.setContentView(i);
    paramBundle = localAlertController.K.findViewById(2131428739);
    Object localObject4 = paramBundle.findViewById(2131429537);
    Object localObject3 = paramBundle.findViewById(2131427741);
    Object localObject2 = paramBundle.findViewById(2131427576);
    Object localObject1 = (ViewGroup)paramBundle.findViewById(2131427813);
    paramBundle = localAlertController.J;
    if (paramBundle == null) {
      paramBundle = null;
    }
    for (;;)
    {
      if (paramBundle == null) {}
      for (;;)
      {
        localAlertController.K.setFlags(131072, 131072);
        label681:
        label1048:
        label1068:
        label1524:
        do
        {
          if (paramBundle != null)
          {
            ((FrameLayout)localAlertController.K.findViewById(2131427812)).addView(paramBundle, new ViewGroup.LayoutParams(-1, -1));
            if (localAlertController.A != null) {
              ((dk)((ViewGroup)localObject1).getLayoutParams()).h = 0.0F;
            }
          }
          for (;;)
          {
            paramBundle = ((ViewGroup)localObject1).findViewById(2131429537);
            View localView = ((ViewGroup)localObject1).findViewById(2131427741);
            Object localObject5 = ((ViewGroup)localObject1).findViewById(2131427576);
            paramBundle = AlertController.a(paramBundle, (View)localObject4);
            localObject3 = AlertController.a(localView, (View)localObject3);
            localObject2 = AlertController.a((View)localObject5, (View)localObject2);
            localAlertController.E = ((NestedScrollView)localAlertController.K.findViewById(2131429142));
            localAlertController.E.setFocusable(false);
            localAlertController.E.setNestedScrollingEnabled(false);
            localAlertController.C = ((TextView)((ViewGroup)localObject3).findViewById(16908299));
            localObject4 = localAlertController.C;
            if (localObject4 != null)
            {
              localObject5 = localAlertController.B;
              if (localObject5 == null) {
                break label1524;
              }
              ((TextView)localObject4).setText((CharSequence)localObject5);
            }
            for (;;)
            {
              localAlertController.m = ((Button)((ViewGroup)localObject2).findViewById(16908313));
              localAlertController.m.setOnClickListener(localAlertController.c);
              if (TextUtils.isEmpty(localAlertController.p)) {
                localAlertController.m.setVisibility(8);
              }
              for (i = 0;; i = 1)
              {
                localAlertController.e = ((Button)((ViewGroup)localObject2).findViewById(16908314));
                localAlertController.e.setOnClickListener(localAlertController.c);
                if (TextUtils.isEmpty(localAlertController.h)) {
                  localAlertController.e.setVisibility(8);
                }
                for (;;)
                {
                  localAlertController.i = ((Button)((ViewGroup)localObject2).findViewById(16908315));
                  localAlertController.i.setOnClickListener(localAlertController.c);
                  if (TextUtils.isEmpty(localAlertController.l)) {
                    localAlertController.i.setVisibility(8);
                  }
                  for (;;)
                  {
                    localObject4 = localAlertController.r;
                    localObject5 = new TypedValue();
                    ((Context)localObject4).getTheme().resolveAttribute(2130968623, (TypedValue)localObject5, true);
                    if (((TypedValue)localObject5).data == 0) {}
                    for (;;)
                    {
                      if (i != 0) {}
                      for (;;)
                      {
                        if (localAlertController.s != null)
                        {
                          localObject4 = new ViewGroup.LayoutParams(-1, -2);
                          paramBundle.addView(localAlertController.s, 0, (ViewGroup.LayoutParams)localObject4);
                          localAlertController.K.findViewById(2131429514).setVisibility(8);
                        }
                        for (;;)
                        {
                          if (localObject1 != null) {
                            if (((ViewGroup)localObject1).getVisibility() != 8) {
                              i = 1;
                            }
                          }
                          for (;;)
                          {
                            int j;
                            if (paramBundle != null) {
                              if (paramBundle.getVisibility() != 8) {
                                j = 1;
                              }
                            }
                            for (;;)
                            {
                              int k;
                              if (localObject2 != null) {
                                if (((ViewGroup)localObject2).getVisibility() != 8) {
                                  k = 1;
                                }
                              }
                              for (;;)
                              {
                                if (k != 0) {}
                                for (;;)
                                {
                                  if (j != 0)
                                  {
                                    localObject1 = localAlertController.E;
                                    if (localObject1 != null) {
                                      ((NestedScrollView)localObject1).setClipToPadding(true);
                                    }
                                    if ((localAlertController.B != null) || (localAlertController.A != null))
                                    {
                                      paramBundle = paramBundle.findViewById(2131429480);
                                      if (paramBundle != null) {}
                                    }
                                  }
                                  for (;;)
                                  {
                                    paramBundle = localAlertController.A;
                                    if ((paramBundle instanceof AlertController.RecycleListView))
                                    {
                                      paramBundle = (AlertController.RecycleListView)paramBundle;
                                      if (k != 0) {
                                        break label1068;
                                      }
                                    }
                                    for (;;)
                                    {
                                      int i1 = paramBundle.getPaddingLeft();
                                      int m;
                                      int n;
                                      if (j == 0)
                                      {
                                        m = paramBundle.b;
                                        int i2 = paramBundle.getPaddingRight();
                                        if (k == 0)
                                        {
                                          n = paramBundle.a;
                                          paramBundle.setPadding(i1, m, i2, n);
                                        }
                                      }
                                      do
                                      {
                                        if (i != 0) {}
                                        for (;;)
                                        {
                                          paramBundle = localAlertController.A;
                                          if (paramBundle != null)
                                          {
                                            localObject1 = localAlertController.a;
                                            if (localObject1 != null)
                                            {
                                              paramBundle.setAdapter((ListAdapter)localObject1);
                                              i = localAlertController.q;
                                              if (i >= 0)
                                              {
                                                paramBundle.setItemChecked(i, true);
                                                paramBundle.setSelection(i);
                                              }
                                            }
                                          }
                                          return;
                                          paramBundle = localAlertController.A;
                                          if (paramBundle == null) {
                                            paramBundle = localAlertController.E;
                                          }
                                          for (;;)
                                          {
                                            if (paramBundle == null) {
                                              break label1048;
                                            }
                                            if (k == 0) {}
                                            for (i = 0;; i = 2)
                                            {
                                              i = j | i;
                                              localObject1 = localAlertController.K.findViewById(2131429141);
                                              localObject2 = localAlertController.K.findViewById(2131429140);
                                              if (Build.VERSION.SDK_INT >= 23)
                                              {
                                                ac.g(paramBundle, i);
                                                if (localObject1 != null) {
                                                  ((ViewGroup)localObject3).removeView((View)localObject1);
                                                }
                                                if (localObject2 == null) {
                                                  break;
                                                }
                                                ((ViewGroup)localObject3).removeView((View)localObject2);
                                                break;
                                              }
                                              if (localObject1 != null) {
                                                if ((i & 0x1) == 0)
                                                {
                                                  ((ViewGroup)localObject3).removeView((View)localObject1);
                                                  paramBundle = null;
                                                }
                                              }
                                              for (;;)
                                              {
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
                                                if (paramBundle != null) {}
                                                for (;;)
                                                {
                                                  if (localAlertController.B != null)
                                                  {
                                                    localAlertController.E.setOnScrollChangeListener(new l(paramBundle, (View)localObject1));
                                                    localAlertController.E.post(new m(localAlertController, paramBundle, (View)localObject1));
                                                    break;
                                                  }
                                                  localObject2 = localAlertController.A;
                                                  if (localObject2 != null)
                                                  {
                                                    ((ListView)localObject2).setOnScrollListener(new n(paramBundle, (View)localObject1));
                                                    localAlertController.A.post(new o(localAlertController, paramBundle, (View)localObject1));
                                                    break;
                                                  }
                                                  if (paramBundle != null) {
                                                    ((ViewGroup)localObject3).removeView(paramBundle);
                                                  }
                                                  if (localObject1 == null) {
                                                    break;
                                                  }
                                                  ((ViewGroup)localObject3).removeView((View)localObject1);
                                                  break;
                                                  if (localObject1 == null) {
                                                    break;
                                                  }
                                                }
                                                paramBundle = (Bundle)localObject1;
                                                continue;
                                                paramBundle = (Bundle)localObject1;
                                              }
                                            }
                                          }
                                        }
                                        n = paramBundle.getPaddingBottom();
                                        break label681;
                                        m = paramBundle.getPaddingTop();
                                        break;
                                      } while (j != 0);
                                    }
                                    paramBundle.setVisibility(0);
                                    continue;
                                    paramBundle = null;
                                    break;
                                    if (localObject3 != null)
                                    {
                                      paramBundle = ((ViewGroup)localObject3).findViewById(2131429447);
                                      if (paramBundle != null) {
                                        paramBundle.setVisibility(0);
                                      }
                                    }
                                  }
                                  if (localObject3 != null)
                                  {
                                    localObject1 = ((ViewGroup)localObject3).findViewById(2131429446);
                                    if (localObject1 != null) {
                                      ((View)localObject1).setVisibility(0);
                                    }
                                  }
                                }
                                k = 0;
                                continue;
                                k = 0;
                              }
                              j = 0;
                              continue;
                              j = 0;
                            }
                            i = 0;
                            continue;
                            i = 0;
                          }
                          localAlertController.x = ((ImageView)localAlertController.K.findViewById(16908294));
                          if (((TextUtils.isEmpty(localAlertController.H) ^ true)) && (localAlertController.F))
                          {
                            localAlertController.I = ((TextView)localAlertController.K.findViewById(2131427436));
                            localAlertController.I.setText(localAlertController.H);
                            i = localAlertController.w;
                            if (i != 0)
                            {
                              localAlertController.x.setImageResource(i);
                            }
                            else
                            {
                              localObject4 = localAlertController.v;
                              if (localObject4 != null)
                              {
                                localAlertController.x.setImageDrawable((Drawable)localObject4);
                              }
                              else
                              {
                                localAlertController.I.setPadding(localAlertController.x.getPaddingLeft(), localAlertController.x.getPaddingTop(), localAlertController.x.getPaddingRight(), localAlertController.x.getPaddingBottom());
                                localAlertController.x.setVisibility(8);
                              }
                            }
                          }
                          else
                          {
                            localAlertController.K.findViewById(2131429514).setVisibility(8);
                            localAlertController.x.setVisibility(8);
                            paramBundle.setVisibility(8);
                          }
                        }
                        ((ViewGroup)localObject2).setVisibility(8);
                      }
                      if (i == 1) {
                        AlertController.a(localAlertController.m);
                      } else if (i == 2) {
                        AlertController.a(localAlertController.e);
                      } else if (i == 4) {
                        AlertController.a(localAlertController.i);
                      }
                    }
                    localAlertController.i.setText(localAlertController.l);
                    localAlertController.i.setVisibility(0);
                    i |= 0x4;
                  }
                  localAlertController.e.setText(localAlertController.h);
                  localAlertController.e.setVisibility(0);
                  i |= 0x2;
                }
                localAlertController.m.setText(localAlertController.p);
                localAlertController.m.setVisibility(0);
              }
              ((TextView)localObject4).setVisibility(8);
              localAlertController.E.removeView(localAlertController.C);
              if (localAlertController.A != null)
              {
                localObject4 = (ViewGroup)localAlertController.E.getParent();
                i = ((ViewGroup)localObject4).indexOfChild(localAlertController.E);
                ((ViewGroup)localObject4).removeViewAt(i);
                ((ViewGroup)localObject4).addView(localAlertController.A, i, new ViewGroup.LayoutParams(-1, -1));
              }
              else
              {
                ((ViewGroup)localObject3).setVisibility(8);
              }
            }
            ((ViewGroup)localObject1).setVisibility(8);
          }
        } while (AlertController.a(paramBundle));
      }
    }
  }
  
  public final boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    NestedScrollView localNestedScrollView = this.a.E;
    if ((localNestedScrollView != null) && (localNestedScrollView.a(paramKeyEvent))) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public final boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    NestedScrollView localNestedScrollView = this.a.E;
    if ((localNestedScrollView != null) && (localNestedScrollView.a(paramKeyEvent))) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
  
  public final void setTitle(CharSequence paramCharSequence)
  {
    super.setTitle(paramCharSequence);
    this.a.a(paramCharSequence);
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/v7/app/v.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */