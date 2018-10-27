package android.support.constraint;

import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public final class b
{
  private static final int[] b = { 0, 4, 8 };
  private static SparseIntArray c;
  public HashMap a = new HashMap();
  
  static
  {
    SparseIntArray localSparseIntArray = new SparseIntArray();
    c = localSparseIntArray;
    localSparseIntArray.append(d.aJ, 25);
    c.append(d.aK, 26);
    c.append(d.aM, 29);
    c.append(d.aN, 30);
    c.append(d.aS, 36);
    c.append(d.aR, 35);
    c.append(d.av, 4);
    c.append(d.au, 3);
    c.append(d.as, 1);
    c.append(d.aZ, 6);
    c.append(d.ba, 7);
    c.append(d.az, 17);
    c.append(d.aA, 18);
    c.append(d.aB, 19);
    c.append(d.ah, 27);
    c.append(d.aO, 32);
    c.append(d.aP, 33);
    c.append(d.ay, 10);
    c.append(d.ax, 9);
    c.append(d.bc, 13);
    c.append(d.bf, 16);
    c.append(d.bd, 14);
    c.append(58, 11);
    c.append(d.be, 15);
    c.append(d.bb, 12);
    c.append(d.aV, 40);
    c.append(d.aH, 39);
    c.append(d.aG, 41);
    c.append(d.aU, 42);
    c.append(d.aF, 20);
    c.append(d.aT, 37);
    c.append(d.aw, 5);
    c.append(d.aI, 60);
    c.append(d.aQ, 60);
    c.append(d.aL, 60);
    c.append(d.at, 60);
    c.append(d.ar, 60);
    c.append(d.ac, 24);
    c.append(d.ad, 28);
    c.append(d.ae, 31);
    c.append(d.ab, 8);
    c.append(d.af, 34);
    c.append(d.aa, 2);
    c.append(d.ag, 23);
    c.append(d.Z, 21);
    c.append(d.aq, 22);
    c.append(d.W, 43);
    c.append(d.X, 44);
    c.append(d.ai, 45);
    c.append(17, 46);
    c.append(d.aj, 47);
    c.append(d.ak, 48);
    c.append(d.al, 49);
    c.append(d.am, 50);
    c.append(d.an, 51);
    c.append(d.ao, 52);
    c.append(d.ap, 53);
    c.append(d.aW, 54);
    c.append(d.aC, 55);
    c.append(d.aX, 56);
    c.append(d.aD, 57);
    c.append(d.aY, 58);
    c.append(d.aE, 59);
    c.append(d.Y, 38);
  }
  
  private static int a(TypedArray paramTypedArray, int paramInt1, int paramInt2)
  {
    int i = paramTypedArray.getResourceId(paramInt1, paramInt2);
    paramInt2 = i;
    if (i == -1) {
      paramInt2 = paramTypedArray.getInt(paramInt1, -1);
    }
    return paramInt2;
  }
  
  static void a(c paramc, TypedArray paramTypedArray)
  {
    int j = paramTypedArray.getIndexCount();
    int i = 0;
    if (i < j)
    {
      int k = paramTypedArray.getIndex(i);
      StringBuilder localStringBuilder;
      switch (c.get(k))
      {
      case 54: 
      case 55: 
      case 56: 
      case 57: 
      case 58: 
      case 59: 
      default: 
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("Unknown attribute 0x");
        localStringBuilder.append(Integer.toHexString(k));
        localStringBuilder.append("   ");
        localStringBuilder.append(c.get(k));
        Log.w("ConstraintSet", localStringBuilder.toString());
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("unused attribute 0x");
        localStringBuilder.append(Integer.toHexString(k));
        localStringBuilder.append("   ");
        localStringBuilder.append(c.get(k));
        Log.w("ConstraintSet", localStringBuilder.toString());
        continue;
        paramc.ab = paramTypedArray.getFloat(k, paramc.ab);
        continue;
        paramc.aa = paramTypedArray.getFloat(k, paramc.aa);
        continue;
        paramc.Z = paramTypedArray.getFloat(k, paramc.Z);
        continue;
        paramc.Y = paramTypedArray.getFloat(k, paramc.Y);
        continue;
        paramc.X = paramTypedArray.getFloat(k, paramc.X);
        continue;
        paramc.Q = paramTypedArray.getFloat(k, paramc.Q);
        continue;
        paramc.P = paramTypedArray.getFloat(k, paramc.P);
        continue;
        paramc.O = paramTypedArray.getFloat(k, paramc.O);
        continue;
        paramc.N = paramTypedArray.getFloat(k, paramc.N);
        continue;
        paramc.b = true;
        paramc.j = paramTypedArray.getFloat(k, paramc.j);
        continue;
        paramc.a = paramTypedArray.getFloat(k, paramc.a);
        continue;
        paramc.ad = paramTypedArray.getInt(k, paramc.ad);
        continue;
        paramc.A = paramTypedArray.getInt(k, paramc.A);
        continue;
        paramc.ae = paramTypedArray.getFloat(k, paramc.ae);
        continue;
        paramc.B = paramTypedArray.getFloat(k, paramc.B);
        continue;
        paramc.H = paramTypedArray.getResourceId(k, paramc.H);
        continue;
        paramc.ac = paramTypedArray.getFloat(k, paramc.ac);
        continue;
        paramc.W = a(paramTypedArray, k, paramc.W);
        continue;
        paramc.V = a(paramTypedArray, k, paramc.V);
        continue;
        paramc.U = paramTypedArray.getDimensionPixelSize(k, paramc.U);
        continue;
        paramc.T = a(paramTypedArray, k, paramc.T);
        continue;
        paramc.S = a(paramTypedArray, k, paramc.S);
        continue;
        paramc.R = paramTypedArray.getDimensionPixelSize(k, paramc.R);
        continue;
        paramc.M = a(paramTypedArray, k, paramc.M);
        continue;
        paramc.L = a(paramTypedArray, k, paramc.L);
        continue;
        paramc.K = paramTypedArray.getDimensionPixelSize(k, paramc.K);
        continue;
        paramc.J = paramTypedArray.getInt(k, paramc.J);
        continue;
        paramc.E = a(paramTypedArray, k, paramc.E);
        continue;
        paramc.D = a(paramTypedArray, k, paramc.D);
        continue;
        paramc.C = paramTypedArray.getDimensionPixelSize(k, paramc.C);
        continue;
        paramc.I = paramTypedArray.getLayoutDimension(k, paramc.I);
        continue;
        paramc.af = paramTypedArray.getInt(k, paramc.af);
        paramc.af = b[paramc.af];
        continue;
        paramc.F = paramTypedArray.getLayoutDimension(k, paramc.F);
        continue;
        paramc.z = paramTypedArray.getFloat(k, paramc.z);
        continue;
        paramc.v = paramTypedArray.getFloat(k, paramc.v);
        continue;
        paramc.u = paramTypedArray.getDimensionPixelOffset(k, paramc.u);
        continue;
        paramc.t = paramTypedArray.getDimensionPixelOffset(k, paramc.t);
        continue;
        paramc.s = paramTypedArray.getDimensionPixelSize(k, paramc.s);
        continue;
        paramc.r = paramTypedArray.getDimensionPixelSize(k, paramc.r);
        continue;
        paramc.q = paramTypedArray.getDimensionPixelSize(k, paramc.q);
        continue;
        paramc.p = paramTypedArray.getDimensionPixelSize(k, paramc.p);
        continue;
        paramc.o = paramTypedArray.getDimensionPixelSize(k, paramc.o);
        continue;
        paramc.n = paramTypedArray.getDimensionPixelSize(k, paramc.n);
        continue;
        paramc.m = a(paramTypedArray, k, paramc.m);
        continue;
        paramc.f = a(paramTypedArray, k, paramc.l);
        continue;
        paramc.k = paramTypedArray.getDimensionPixelSize(k, paramc.k);
        continue;
        paramc.i = paramTypedArray.getDimensionPixelOffset(k, paramc.i);
        continue;
        paramc.h = paramTypedArray.getDimensionPixelOffset(k, paramc.h);
        continue;
        paramc.g = paramTypedArray.getString(k);
        continue;
        paramc.f = a(paramTypedArray, k, paramc.f);
        continue;
        paramc.e = a(paramTypedArray, k, paramc.e);
        continue;
        paramc.d = paramTypedArray.getDimensionPixelSize(k, paramc.d);
        continue;
        paramc.c = a(paramTypedArray, k, paramc.c);
      }
    }
  }
  
  public final void a(ConstraintLayout paramConstraintLayout)
  {
    int j = paramConstraintLayout.getChildCount();
    Object localObject1 = new HashSet(this.a.keySet());
    int i = 0;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    if (i < j)
    {
      localObject2 = paramConstraintLayout.getChildAt(i);
      int k = ((View)localObject2).getId();
      localObject3 = this.a;
      localObject4 = Integer.valueOf(k);
      if (((HashMap)localObject3).containsKey(localObject4))
      {
        ((HashSet)localObject1).remove(localObject4);
        localObject3 = (c)this.a.get(localObject4);
        localObject4 = (a)((View)localObject2).getLayoutParams();
        ((c)localObject3).a((a)localObject4);
        ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject4);
        ((View)localObject2).setVisibility(((c)localObject3).af);
        if (Build.VERSION.SDK_INT >= 17)
        {
          ((View)localObject2).setAlpha(((c)localObject3).a);
          ((View)localObject2).setRotationX(((c)localObject3).N);
          ((View)localObject2).setRotationY(((c)localObject3).O);
          ((View)localObject2).setScaleX(((c)localObject3).P);
          ((View)localObject2).setScaleY(((c)localObject3).Q);
          ((View)localObject2).setPivotX(((c)localObject3).X);
          ((View)localObject2).setPivotY(((c)localObject3).Y);
          ((View)localObject2).setTranslationX(((c)localObject3).Z);
          ((View)localObject2).setTranslationY(((c)localObject3).aa);
          if (Build.VERSION.SDK_INT >= 21) {
            break label234;
          }
        }
      }
      for (;;)
      {
        i += 1;
        break;
        label234:
        ((View)localObject2).setTranslationZ(((c)localObject3).ab);
        if (((c)localObject3).b) {
          ((View)localObject2).setElevation(((c)localObject3).j);
        }
      }
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject4 = (Integer)((Iterator)localObject1).next();
      localObject2 = (c)this.a.get(localObject4);
      if (((c)localObject2).G)
      {
        localObject3 = new Guideline(paramConstraintLayout.getContext());
        ((Guideline)localObject3).setId(((Integer)localObject4).intValue());
        localObject4 = ConstraintLayout.a();
        ((c)localObject2).a((a)localObject4);
        paramConstraintLayout.addView((View)localObject3, (ViewGroup.LayoutParams)localObject4);
      }
    }
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/constraint/b.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */