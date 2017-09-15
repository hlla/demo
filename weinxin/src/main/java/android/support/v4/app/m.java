package android.support.v4.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.support.v4.e.c;
import android.support.v4.view.z;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.ScaleAnimation;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class m
  extends l
  implements android.support.v4.view.k
{
  static boolean DEBUG;
  static final Interpolator qD = new DecelerateInterpolator(2.5F);
  static final Interpolator qE = new DecelerateInterpolator(1.5F);
  static final Interpolator qF = new AccelerateInterpolator(2.5F);
  static final Interpolator qG = new AccelerateInterpolator(1.5F);
  static final boolean qf;
  static Field qu;
  k ph;
  Bundle qA = null;
  SparseArray<Parcelable> qB = null;
  Runnable qC = new Runnable()
  {
    public final void run()
    {
      m.this.execPendingActions();
    }
  };
  ArrayList<Runnable> qg;
  Runnable[] qh;
  boolean qi;
  ArrayList<Fragment> qj;
  ArrayList<Fragment> qk;
  ArrayList<Integer> ql;
  ArrayList<d> qm;
  ArrayList<Fragment> qn;
  ArrayList<d> qo;
  ArrayList<Integer> qp;
  ArrayList<Object> qq;
  int qr = 0;
  i qs;
  Fragment qt;
  boolean qv;
  boolean qw;
  boolean qx;
  String qy;
  boolean qz;
  
  static
  {
    boolean bool = false;
    DEBUG = false;
    if (Build.VERSION.SDK_INT >= 11) {
      bool = true;
    }
    qf = bool;
    qu = null;
  }
  
  public static int H(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 4097: 
      return 8194;
    case 8194: 
      return 4097;
    }
    return 4099;
  }
  
  private static Animation a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AnimationSet localAnimationSet = new AnimationSet(false);
    Object localObject = new ScaleAnimation(paramFloat1, paramFloat2, paramFloat1, paramFloat2, 1, 0.5F, 1, 0.5F);
    ((ScaleAnimation)localObject).setInterpolator(qD);
    ((ScaleAnimation)localObject).setDuration(220L);
    localAnimationSet.addAnimation((Animation)localObject);
    localObject = new AlphaAnimation(paramFloat3, paramFloat4);
    ((AlphaAnimation)localObject).setInterpolator(qE);
    ((AlphaAnimation)localObject).setDuration(220L);
    localAnimationSet.addAnimation((Animation)localObject);
    return localAnimationSet;
  }
  
  private Animation a(Fragment paramFragment, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    int i = paramFragment.pt;
    Fragment.aL();
    if (paramFragment.pt != 0)
    {
      paramFragment = AnimationUtils.loadAnimation(this.ph.mContext, paramFragment.pt);
      if (paramFragment != null) {
        return paramFragment;
      }
    }
    if (paramInt1 == 0) {
      return null;
    }
    i = -1;
    switch (paramInt1)
    {
    default: 
      paramInt1 = i;
    }
    while (paramInt1 < 0)
    {
      return null;
      if (paramBoolean)
      {
        paramInt1 = 1;
      }
      else
      {
        paramInt1 = 2;
        continue;
        if (paramBoolean)
        {
          paramInt1 = 3;
        }
        else
        {
          paramInt1 = 4;
          continue;
          if (paramBoolean) {
            paramInt1 = 5;
          } else {
            paramInt1 = 6;
          }
        }
      }
    }
    switch (paramInt1)
    {
    default: 
      paramInt1 = paramInt2;
      if (paramInt2 == 0)
      {
        paramInt1 = paramInt2;
        if (this.ph.onHasWindowAnimations()) {
          paramInt1 = this.ph.onGetWindowAnimations();
        }
      }
      if (paramInt1 == 0) {
        return null;
      }
      break;
    case 1: 
      return a(1.125F, 1.0F, 0.0F, 1.0F);
    case 2: 
      return a(1.0F, 0.975F, 1.0F, 0.0F);
    case 3: 
      return a(0.975F, 1.0F, 0.0F, 1.0F);
    case 4: 
      return a(1.0F, 1.075F, 1.0F, 0.0F);
    case 5: 
      return f(0.0F, 1.0F);
    case 6: 
      return f(1.0F, 0.0F);
    }
    return null;
  }
  
  /* Error */
  private void a(int paramInt, d paramd)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 198	android/support/v4/app/m:qo	Ljava/util/ArrayList;
    //   6: ifnonnull +14 -> 20
    //   9: aload_0
    //   10: new 200	java/util/ArrayList
    //   13: dup
    //   14: invokespecial 201	java/util/ArrayList:<init>	()V
    //   17: putfield 198	android/support/v4/app/m:qo	Ljava/util/ArrayList;
    //   20: aload_0
    //   21: getfield 198	android/support/v4/app/m:qo	Ljava/util/ArrayList;
    //   24: invokevirtual 204	java/util/ArrayList:size	()I
    //   27: istore 4
    //   29: iload 4
    //   31: istore_3
    //   32: iload_1
    //   33: iload 4
    //   35: if_icmpge +45 -> 80
    //   38: getstatic 77	android/support/v4/app/m:DEBUG	Z
    //   41: ifeq +26 -> 67
    //   44: new 206	java/lang/StringBuilder
    //   47: dup
    //   48: ldc -48
    //   50: invokespecial 211	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   53: iload_1
    //   54: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   57: ldc -39
    //   59: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   62: aload_2
    //   63: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_0
    //   68: getfield 198	android/support/v4/app/m:qo	Ljava/util/ArrayList;
    //   71: iload_1
    //   72: aload_2
    //   73: invokevirtual 227	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   76: pop
    //   77: aload_0
    //   78: monitorexit
    //   79: return
    //   80: iload_3
    //   81: iload_1
    //   82: if_icmpge +55 -> 137
    //   85: aload_0
    //   86: getfield 198	android/support/v4/app/m:qo	Ljava/util/ArrayList;
    //   89: aconst_null
    //   90: invokevirtual 231	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   93: pop
    //   94: aload_0
    //   95: getfield 233	android/support/v4/app/m:qp	Ljava/util/ArrayList;
    //   98: ifnonnull +14 -> 112
    //   101: aload_0
    //   102: new 200	java/util/ArrayList
    //   105: dup
    //   106: invokespecial 201	java/util/ArrayList:<init>	()V
    //   109: putfield 233	android/support/v4/app/m:qp	Ljava/util/ArrayList;
    //   112: getstatic 77	android/support/v4/app/m:DEBUG	Z
    //   115: ifeq +3 -> 118
    //   118: aload_0
    //   119: getfield 233	android/support/v4/app/m:qp	Ljava/util/ArrayList;
    //   122: iload_3
    //   123: invokestatic 239	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   126: invokevirtual 231	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   129: pop
    //   130: iload_3
    //   131: iconst_1
    //   132: iadd
    //   133: istore_3
    //   134: goto -54 -> 80
    //   137: getstatic 77	android/support/v4/app/m:DEBUG	Z
    //   140: ifeq +26 -> 166
    //   143: new 206	java/lang/StringBuilder
    //   146: dup
    //   147: ldc -15
    //   149: invokespecial 211	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   152: iload_1
    //   153: invokevirtual 215	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   156: ldc -13
    //   158: invokevirtual 220	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: aload_2
    //   162: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   165: pop
    //   166: aload_0
    //   167: getfield 198	android/support/v4/app/m:qo	Ljava/util/ArrayList;
    //   170: aload_2
    //   171: invokevirtual 231	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   174: pop
    //   175: goto -98 -> 77
    //   178: astore_2
    //   179: aload_0
    //   180: monitorexit
    //   181: aload_2
    //   182: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	m
    //   0	183	1	paramInt	int
    //   0	183	2	paramd	d
    //   31	103	3	i	int
    //   27	9	4	j	int
    // Exception table:
    //   from	to	target	type
    //   2	20	178	finally
    //   20	29	178	finally
    //   38	67	178	finally
    //   67	77	178	finally
    //   77	79	178	finally
    //   85	112	178	finally
    //   112	118	178	finally
    //   118	130	178	finally
    //   137	166	178	finally
    //   166	175	178	finally
    //   179	181	178	finally
  }
  
  private void a(RuntimeException paramRuntimeException)
  {
    paramRuntimeException.getMessage();
    PrintWriter localPrintWriter = new PrintWriter(new android.support.v4.e.d("FragmentManager"));
    if (this.ph != null) {}
    try
    {
      this.ph.a("  ", localPrintWriter, new String[0]);
      for (;;)
      {
        throw paramRuntimeException;
        try
        {
          dump("  ", null, localPrintWriter, new String[0]);
        }
        catch (Exception localException1) {}
      }
    }
    catch (Exception localException2)
    {
      for (;;) {}
    }
  }
  
  static boolean a(View paramView, Animation paramAnimation)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if (Build.VERSION.SDK_INT >= 19)
    {
      bool1 = bool2;
      if (z.I(paramView) == 0)
      {
        bool1 = bool2;
        if (z.ad(paramView))
        {
          if (!(paramAnimation instanceof AlphaAnimation)) {
            break label54;
          }
          i = 1;
        }
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i != 0) {
        bool1 = true;
      }
      return bool1;
      label54:
      if ((paramAnimation instanceof AnimationSet))
      {
        paramView = ((AnimationSet)paramAnimation).getAnimations();
        i = 0;
        for (;;)
        {
          if (i >= paramView.size()) {
            break label106;
          }
          if ((paramView.get(i) instanceof AlphaAnimation))
          {
            i = 1;
            break;
          }
          i += 1;
        }
      }
      label106:
      i = 0;
    }
  }
  
  private void aY()
  {
    if (this.qw) {
      throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
    }
    if (this.qy != null) {
      throw new IllegalStateException("Can not perform this action inside of " + this.qy);
    }
  }
  
  private static void b(View paramView, Animation paramAnimation)
  {
    if ((paramView == null) || (paramAnimation == null)) {}
    while (!a(paramView, paramAnimation)) {
      return;
    }
    try
    {
      if (qu == null)
      {
        localObject1 = Animation.class.getDeclaredField("mListener");
        qu = (Field)localObject1;
        ((Field)localObject1).setAccessible(true);
      }
      localObject1 = (Animation.AnimationListener)qu.get(paramAnimation);
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2 = null;
      }
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      for (;;)
      {
        Object localObject3 = null;
      }
    }
    paramAnimation.setAnimationListener(new a(paramView, paramAnimation, (Animation.AnimationListener)localObject1));
  }
  
  private static Animation f(float paramFloat1, float paramFloat2)
  {
    AlphaAnimation localAlphaAnimation = new AlphaAnimation(paramFloat1, paramFloat2);
    localAlphaAnimation.setInterpolator(qE);
    localAlphaAnimation.setDuration(220L);
    return localAlphaAnimation;
  }
  
  private void g(Fragment paramFragment)
  {
    a(paramFragment, this.qr, 0, 0, false);
  }
  
  private void i(Fragment paramFragment)
  {
    if (paramFragment.pv == null) {
      return;
    }
    if (this.qB == null) {
      this.qB = new SparseArray();
    }
    for (;;)
    {
      paramFragment.pv.saveHierarchyState(this.qB);
      if (this.qB.size() <= 0) {
        break;
      }
      paramFragment.oU = this.qB;
      this.qB = null;
      return;
      this.qB.clear();
    }
  }
  
  private Bundle j(Fragment paramFragment)
  {
    if (this.qA == null) {
      this.qA = new Bundle();
    }
    paramFragment.d(this.qA);
    Object localObject2;
    if (!this.qA.isEmpty())
    {
      localObject2 = this.qA;
      this.qA = null;
    }
    for (;;)
    {
      if (paramFragment.mView != null) {
        i(paramFragment);
      }
      Object localObject1 = localObject2;
      if (paramFragment.oU != null)
      {
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = new Bundle();
        }
        ((Bundle)localObject1).putSparseParcelableArray("android:view_state", paramFragment.oU);
      }
      localObject2 = localObject1;
      if (!paramFragment.px)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new Bundle();
        }
        ((Bundle)localObject2).putBoolean("android:user_visible_hint", paramFragment.px);
      }
      return (Bundle)localObject2;
      localObject2 = null;
    }
  }
  
  public final Fragment E(int paramInt)
  {
    int i;
    Object localObject;
    if (this.qk != null)
    {
      i = this.qk.size() - 1;
      while (i >= 0)
      {
        localObject = (Fragment)this.qk.get(i);
        if ((localObject != null) && (((Fragment)localObject).pk == paramInt)) {
          return (Fragment)localObject;
        }
        i -= 1;
      }
    }
    if (this.qj != null)
    {
      i = this.qj.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label112;
        }
        Fragment localFragment = (Fragment)this.qj.get(i);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (localFragment.pk == paramInt) {
            break;
          }
        }
        i -= 1;
      }
    }
    label112:
    return null;
  }
  
  public final void F(final int paramInt)
  {
    if (paramInt < 0) {
      throw new IllegalArgumentException("Bad id: " + paramInt);
    }
    a(new Runnable()
    {
      public final void run()
      {
        m localm = m.this;
        k localk = m.this.ph;
        localm.h(paramInt, this.qI);
      }
    }, false);
  }
  
  final void G(int paramInt)
  {
    a(paramInt, 0, 0, false);
  }
  
  public final int a(d paramd)
  {
    try
    {
      if ((this.qp == null) || (this.qp.size() <= 0))
      {
        if (this.qo == null) {
          this.qo = new ArrayList();
        }
        i = this.qo.size();
        if (DEBUG) {
          new StringBuilder("Setting back stack index ").append(i).append(" to ").append(paramd);
        }
        this.qo.add(paramd);
        return i;
      }
      int i = ((Integer)this.qp.remove(this.qp.size() - 1)).intValue();
      if (DEBUG) {
        new StringBuilder("Adding back stack index ").append(i).append(" with ").append(paramd);
      }
      this.qo.set(i, paramd);
      return i;
    }
    finally {}
  }
  
  final void a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    if ((this.ph == null) && (paramInt1 != 0)) {
      throw new IllegalStateException("No host");
    }
    if ((!paramBoolean) && (this.qr == paramInt1)) {}
    do
    {
      return;
      this.qr = paramInt1;
    } while (this.qj == null);
    int i = 0;
    boolean bool = false;
    label54:
    if (i < this.qj.size())
    {
      Fragment localFragment = (Fragment)this.qj.get(i);
      if (localFragment == null) {
        break label169;
      }
      a(localFragment, paramInt1, paramInt2, paramInt3, false);
      if (localFragment.py == null) {
        break label169;
      }
      bool |= localFragment.py.bc();
    }
    label169:
    for (;;)
    {
      i += 1;
      break label54;
      if (!bool) {
        aX();
      }
      if ((!this.qv) || (this.ph == null) || (this.qr != 5)) {
        break;
      }
      this.ph.aT();
      this.qv = false;
      return;
    }
  }
  
  public final void a(Bundle paramBundle, String paramString, Fragment paramFragment)
  {
    if (paramFragment.mIndex < 0) {
      a(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    paramBundle.putInt(paramString, paramFragment.mIndex);
  }
  
  public final void a(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      new StringBuilder("remove: ").append(paramFragment).append(" nesting=").append(paramFragment.pf);
    }
    if (paramFragment.pf > 0)
    {
      i = 1;
      if (i != 0) {
        break label134;
      }
      i = 1;
      label52:
      if ((!paramFragment.pn) || (i != 0))
      {
        if (this.qk != null) {
          this.qk.remove(paramFragment);
        }
        if ((paramFragment.pq) && (paramFragment.pr)) {
          this.qv = true;
        }
        paramFragment.pa = false;
        paramFragment.pb = true;
        if (i == 0) {
          break label140;
        }
      }
    }
    label134:
    label140:
    for (int i = 0;; i = 1)
    {
      a(paramFragment, i, paramInt1, paramInt2, false);
      return;
      i = 0;
      break;
      i = 0;
      break label52;
    }
  }
  
  final void a(final Fragment paramFragment, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    int i;
    if (paramFragment.pa)
    {
      i = paramInt1;
      if (!paramFragment.pn) {}
    }
    else
    {
      i = paramInt1;
      if (paramInt1 > 1) {
        i = 1;
      }
    }
    int j = i;
    if (paramFragment.pb)
    {
      j = i;
      if (i > paramFragment.mState) {
        j = paramFragment.mState;
      }
    }
    paramInt1 = j;
    if (paramFragment.pw)
    {
      paramInt1 = j;
      if (paramFragment.mState < 4)
      {
        paramInt1 = j;
        if (j > 3) {
          paramInt1 = 3;
        }
      }
    }
    int k;
    label725:
    Object localObject2;
    if (paramFragment.mState < paramInt1)
    {
      if ((paramFragment.pc) && (!paramFragment.pd)) {}
      do
      {
        return;
        if (paramFragment.oR != null)
        {
          paramFragment.oR = null;
          a(paramFragment, paramFragment.oS, 0, 0, true);
        }
        i = paramInt1;
        k = paramInt1;
        j = paramInt1;
        switch (paramFragment.mState)
        {
        default: 
          i = paramInt1;
        }
      } while (paramFragment.mState == i);
      new StringBuilder("moveToState: Fragment state for ").append(paramFragment).append(" not updated inline; expected state ").append(i).append(" found ").append(paramFragment.mState);
      paramFragment.mState = i;
      return;
      if (DEBUG) {
        new StringBuilder("moveto CREATED: ").append(paramFragment);
      }
      j = paramInt1;
      if (paramFragment.oT != null)
      {
        paramFragment.oT.setClassLoader(this.ph.mContext.getClassLoader());
        paramFragment.oU = paramFragment.oT.getSparseParcelableArray("android:view_state");
        paramFragment.oX = c(paramFragment.oT, "android:target_state");
        if (paramFragment.oX != null) {
          paramFragment.oZ = paramFragment.oT.getInt("android:target_req_state", 0);
        }
        paramFragment.px = paramFragment.oT.getBoolean("android:user_visible_hint", true);
        j = paramInt1;
        if (!paramFragment.px)
        {
          paramFragment.pw = true;
          j = paramInt1;
          if (paramInt1 > 3) {
            j = 3;
          }
        }
      }
      paramFragment.ph = this.ph;
      paramFragment.pj = this.qt;
      if (this.qt != null) {}
      for (localObject1 = this.qt.pi;; localObject1 = this.ph.pg)
      {
        paramFragment.pg = ((m)localObject1);
        paramFragment.ps = false;
        paramFragment.onAttach(this.ph.mContext);
        if (paramFragment.ps) {
          break;
        }
        throw new al("Fragment " + paramFragment + " did not call through to super.onAttach()");
      }
      localObject1 = paramFragment.pj;
      if (!paramFragment.pp)
      {
        localObject1 = paramFragment.oT;
        if (paramFragment.pi != null) {
          paramFragment.pi.qw = false;
        }
        paramFragment.mState = 1;
        paramFragment.ps = false;
        paramFragment.onCreate((Bundle)localObject1);
        if (!paramFragment.ps) {
          throw new al("Fragment " + paramFragment + " did not call through to super.onCreate()");
        }
        if (localObject1 != null)
        {
          localObject1 = ((Bundle)localObject1).getParcelable("android:support:fragments");
          if (localObject1 != null)
          {
            if (paramFragment.pi == null) {
              paramFragment.aN();
            }
            paramFragment.pi.restoreAllState((Parcelable)localObject1, null);
            paramFragment.pi.dispatchCreate();
          }
        }
      }
      paramFragment.pp = false;
      i = j;
      if (paramFragment.pc)
      {
        paramFragment.mView = paramFragment.a(paramFragment.c(paramFragment.oT), null, paramFragment.oT);
        if (paramFragment.mView == null) {
          break label1101;
        }
        paramFragment.pv = paramFragment.mView;
        if (Build.VERSION.SDK_INT >= 11)
        {
          z.ac(paramFragment.mView);
          if (paramFragment.pm) {
            paramFragment.mView.setVisibility(8);
          }
          localObject1 = paramFragment.mView;
          localObject1 = paramFragment.oT;
          paramFragment.aM();
          i = j;
        }
      }
      else
      {
        k = i;
        if (i <= 1) {
          break label1242;
        }
        if (DEBUG) {
          new StringBuilder("moveto ACTIVITY_CREATED: ").append(paramFragment);
        }
        if (!paramFragment.pc)
        {
          if (paramFragment.pl == 0) {
            break label2494;
          }
          localObject2 = (ViewGroup)this.qs.onFindViewById(paramFragment.pl);
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = localObject2;
            if (!paramFragment.pe) {
              a(new IllegalArgumentException("No view found for id 0x" + Integer.toHexString(paramFragment.pl) + " (" + paramFragment.getResources().getResourceName(paramFragment.pl) + ") for fragment " + paramFragment));
            }
          }
        }
      }
    }
    label932:
    label1101:
    label1135:
    label1242:
    label1586:
    label2107:
    label2488:
    label2494:
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      paramFragment.pu = ((ViewGroup)localObject1);
      paramFragment.mView = paramFragment.a(paramFragment.c(paramFragment.oT), (ViewGroup)localObject1, paramFragment.oT);
      if (paramFragment.mView != null)
      {
        paramFragment.pv = paramFragment.mView;
        if (Build.VERSION.SDK_INT >= 11)
        {
          z.ac(paramFragment.mView);
          if (localObject1 != null)
          {
            localObject2 = a(paramFragment, paramInt2, true, paramInt3);
            if (localObject2 != null)
            {
              b(paramFragment.mView, (Animation)localObject2);
              paramFragment.mView.startAnimation((Animation)localObject2);
            }
            ((ViewGroup)localObject1).addView(paramFragment.mView);
          }
          if (paramFragment.pm) {
            paramFragment.mView.setVisibility(8);
          }
          localObject1 = paramFragment.mView;
          localObject1 = paramFragment.oT;
          paramFragment.aM();
        }
      }
      for (;;)
      {
        localObject1 = paramFragment.oT;
        if (paramFragment.pi != null) {
          paramFragment.pi.qw = false;
        }
        paramFragment.mState = 2;
        paramFragment.ps = false;
        paramFragment.onActivityCreated((Bundle)localObject1);
        if (paramFragment.ps) {
          break label1135;
        }
        throw new al("Fragment " + paramFragment + " did not call through to super.onActivityCreated()");
        paramFragment.mView = v.z(paramFragment.mView);
        break;
        paramFragment.pv = null;
        i = j;
        break label725;
        paramFragment.mView = v.z(paramFragment.mView);
        break label932;
        paramFragment.pv = null;
      }
      if (paramFragment.pi != null) {
        paramFragment.pi.dispatchActivityCreated();
      }
      if (paramFragment.mView != null)
      {
        localObject1 = paramFragment.oT;
        if (paramFragment.oU != null)
        {
          paramFragment.pv.restoreHierarchyState(paramFragment.oU);
          paramFragment.oU = null;
        }
        paramFragment.ps = false;
        paramFragment.ps = true;
        if (!paramFragment.ps) {
          throw new al("Fragment " + paramFragment + " did not call through to super.onViewStateRestored()");
        }
      }
      paramFragment.oT = null;
      k = i;
      j = k;
      if (k > 3)
      {
        if (DEBUG) {
          new StringBuilder("moveto STARTED: ").append(paramFragment);
        }
        if (paramFragment.pi != null)
        {
          paramFragment.pi.qw = false;
          paramFragment.pi.execPendingActions();
        }
        paramFragment.mState = 4;
        paramFragment.ps = false;
        paramFragment.onStart();
        if (!paramFragment.ps) {
          throw new al("Fragment " + paramFragment + " did not call through to super.onStart()");
        }
        if (paramFragment.pi != null) {
          paramFragment.pi.dispatchStart();
        }
        j = k;
        if (paramFragment.py != null)
        {
          paramFragment.py.bh();
          j = k;
        }
      }
      i = j;
      if (j <= 4) {
        break;
      }
      if (DEBUG) {
        new StringBuilder("moveto RESUMED: ").append(paramFragment);
      }
      if (paramFragment.pi != null)
      {
        paramFragment.pi.qw = false;
        paramFragment.pi.execPendingActions();
      }
      paramFragment.mState = 5;
      paramFragment.ps = false;
      paramFragment.onResume();
      if (!paramFragment.ps) {
        throw new al("Fragment " + paramFragment + " did not call through to super.onResume()");
      }
      if (paramFragment.pi != null)
      {
        paramFragment.pi.dispatchResume();
        paramFragment.pi.execPendingActions();
      }
      paramFragment.oT = null;
      paramFragment.oU = null;
      i = j;
      break;
      i = paramInt1;
      if (paramFragment.mState <= paramInt1) {
        break;
      }
      switch (paramFragment.mState)
      {
      default: 
        i = paramInt1;
        break;
      case 1: 
      case 5: 
      case 4: 
      case 3: 
      case 2: 
        do
        {
          i = paramInt1;
          if (paramInt1 > 0) {
            break;
          }
          if ((this.qx) && (paramFragment.oR != null))
          {
            localObject1 = paramFragment.oR;
            paramFragment.oR = null;
            ((View)localObject1).clearAnimation();
          }
          if (paramFragment.oR == null) {
            break label2107;
          }
          paramFragment.oS = paramInt1;
          i = 1;
          break;
          if (paramInt1 < 5)
          {
            if (DEBUG) {
              new StringBuilder("movefrom RESUMED: ").append(paramFragment);
            }
            if (paramFragment.pi != null) {
              paramFragment.pi.G(4);
            }
            paramFragment.mState = 4;
            paramFragment.ps = false;
            paramFragment.onPause();
            if (!paramFragment.ps) {
              throw new al("Fragment " + paramFragment + " did not call through to super.onPause()");
            }
          }
          if (paramInt1 < 4)
          {
            if (DEBUG) {
              new StringBuilder("movefrom STARTED: ").append(paramFragment);
            }
            if (paramFragment.pi != null) {
              paramFragment.pi.dispatchStop();
            }
            paramFragment.mState = 3;
            paramFragment.ps = false;
            paramFragment.onStop();
            if (!paramFragment.ps) {
              throw new al("Fragment " + paramFragment + " did not call through to super.onStop()");
            }
          }
          if (paramInt1 < 3)
          {
            if (DEBUG) {
              new StringBuilder("movefrom STOPPED: ").append(paramFragment);
            }
            paramFragment.aO();
          }
        } while (paramInt1 >= 2);
        if (DEBUG) {
          new StringBuilder("movefrom ACTIVITY_CREATED: ").append(paramFragment);
        }
        if ((paramFragment.mView != null) && (this.ph.aS()) && (paramFragment.oU == null)) {
          i(paramFragment);
        }
        if (paramFragment.pi != null) {
          paramFragment.pi.G(1);
        }
        paramFragment.mState = 1;
        paramFragment.ps = false;
        paramFragment.onDestroyView();
        if (!paramFragment.ps) {
          throw new al("Fragment " + paramFragment + " did not call through to super.onDestroyView()");
        }
        if (paramFragment.py != null) {
          paramFragment.py.bg();
        }
        if ((paramFragment.mView != null) && (paramFragment.pu != null)) {
          if ((this.qr <= 0) || (this.qx)) {
            break label2488;
          }
        }
        for (localObject1 = a(paramFragment, paramInt2, false, paramInt3);; localObject1 = null)
        {
          if (localObject1 != null)
          {
            paramFragment.oR = paramFragment.mView;
            paramFragment.oS = paramInt1;
            ((Animation)localObject1).setAnimationListener(new a(paramFragment.mView, (Animation)localObject1)
            {
              public final void onAnimationEnd(Animation paramAnonymousAnimation)
              {
                super.onAnimationEnd(paramAnonymousAnimation);
                if (paramFragment.oR != null)
                {
                  paramFragment.oR = null;
                  m.this.a(paramFragment, paramFragment.oS, 0, 0, false);
                }
              }
            });
            paramFragment.mView.startAnimation((Animation)localObject1);
          }
          paramFragment.pu.removeView(paramFragment.mView);
          paramFragment.pu = null;
          paramFragment.mView = null;
          paramFragment.pv = null;
          break label1586;
          if (DEBUG) {
            new StringBuilder("movefrom CREATED: ").append(paramFragment);
          }
          if (!paramFragment.pp)
          {
            if (paramFragment.pi != null) {
              paramFragment.pi.dispatchDestroy();
            }
            paramFragment.mState = 0;
            paramFragment.ps = false;
            paramFragment.onDestroy();
            if (!paramFragment.ps) {
              throw new al("Fragment " + paramFragment + " did not call through to super.onDestroy()");
            }
          }
          else
          {
            paramFragment.mState = 0;
          }
          paramFragment.ps = false;
          paramFragment.onDetach();
          if (!paramFragment.ps) {
            throw new al("Fragment " + paramFragment + " did not call through to super.onDetach()");
          }
          i = paramInt1;
          if (paramBoolean) {
            break;
          }
          if (!paramFragment.pp)
          {
            i = paramInt1;
            if (paramFragment.mIndex < 0) {
              break;
            }
            if (DEBUG) {
              new StringBuilder("Freeing fragment index ").append(paramFragment);
            }
            this.qj.set(paramFragment.mIndex, null);
            if (this.ql == null) {
              this.ql = new ArrayList();
            }
            this.ql.add(Integer.valueOf(paramFragment.mIndex));
            this.ph.j(paramFragment.oV);
            paramFragment.mIndex = -1;
            paramFragment.oV = null;
            paramFragment.pa = false;
            paramFragment.pb = false;
            paramFragment.pc = false;
            paramFragment.pd = false;
            paramFragment.pe = false;
            paramFragment.pf = 0;
            paramFragment.pg = null;
            paramFragment.pi = null;
            paramFragment.ph = null;
            paramFragment.pk = 0;
            paramFragment.pl = 0;
            paramFragment.mTag = null;
            paramFragment.pm = false;
            paramFragment.pn = false;
            paramFragment.pp = false;
            paramFragment.py = null;
            paramFragment.pz = false;
            paramFragment.pA = false;
            i = paramInt1;
            break;
          }
          paramFragment.ph = null;
          paramFragment.pj = null;
          paramFragment.pg = null;
          paramFragment.pi = null;
          i = paramInt1;
          break;
        }
      }
    }
  }
  
  public final void a(Fragment paramFragment, boolean paramBoolean)
  {
    if (this.qk == null) {
      this.qk = new ArrayList();
    }
    if (DEBUG) {
      new StringBuilder("add: ").append(paramFragment);
    }
    h(paramFragment);
    if (!paramFragment.pn)
    {
      if (this.qk.contains(paramFragment)) {
        throw new IllegalStateException("Fragment already added: " + paramFragment);
      }
      this.qk.add(paramFragment);
      paramFragment.pa = true;
      paramFragment.pb = false;
      if ((paramFragment.pq) && (paramFragment.pr)) {
        this.qv = true;
      }
      if (paramBoolean) {
        g(paramFragment);
      }
    }
  }
  
  public final void a(k paramk, i parami, Fragment paramFragment)
  {
    if (this.ph != null) {
      throw new IllegalStateException("Already attached");
    }
    this.ph = paramk;
    this.qs = parami;
    this.qt = paramFragment;
  }
  
  public final void a(Runnable paramRunnable, boolean paramBoolean)
  {
    if (!paramBoolean) {
      aY();
    }
    try
    {
      if ((this.qx) || (this.ph == null)) {
        throw new IllegalStateException("Activity has been destroyed");
      }
    }
    finally
    {
      throw paramRunnable;
      if (this.qg == null) {
        this.qg = new ArrayList();
      }
      this.qg.add(paramRunnable);
      if (this.qg.size() == 1) {
        this.ph.mHandler.removeCallbacks(this.qC);
      }
    }
  }
  
  public final p aV()
  {
    return new d(this);
  }
  
  public final List<Fragment> aW()
  {
    return this.qj;
  }
  
  final void aX()
  {
    if (this.qj == null) {}
    for (;;)
    {
      return;
      int i = 0;
      while (i < this.qj.size())
      {
        Fragment localFragment = (Fragment)this.qj.get(i);
        if (localFragment != null) {
          f(localFragment);
        }
        i += 1;
      }
    }
  }
  
  final void aZ()
  {
    if (this.qq != null)
    {
      int i = 0;
      while (i < this.qq.size())
      {
        this.qq.get(i);
        i += 1;
      }
    }
  }
  
  public final void b(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      new StringBuilder("hide: ").append(paramFragment);
    }
    if (!paramFragment.pm)
    {
      paramFragment.pm = true;
      if (paramFragment.mView != null)
      {
        Animation localAnimation = a(paramFragment, paramInt1, false, paramInt2);
        if (localAnimation != null)
        {
          b(paramFragment.mView, localAnimation);
          paramFragment.mView.startAnimation(localAnimation);
        }
        paramFragment.mView.setVisibility(8);
      }
      if ((paramFragment.pa) && (paramFragment.pq) && (paramFragment.pr)) {
        this.qv = true;
      }
      paramFragment.onHiddenChanged(true);
    }
  }
  
  public final Fragment c(Bundle paramBundle, String paramString)
  {
    int i = paramBundle.getInt(paramString, -1);
    if (i == -1) {
      paramBundle = null;
    }
    Fragment localFragment;
    do
    {
      return paramBundle;
      if (i >= this.qj.size()) {
        a(new IllegalStateException("Fragment no longer exists for key " + paramString + ": index " + i));
      }
      localFragment = (Fragment)this.qj.get(i);
      paramBundle = localFragment;
    } while (localFragment != null);
    a(new IllegalStateException("Fragment no longer exists for key " + paramString + ": index " + i));
    return localFragment;
  }
  
  public final void c(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      new StringBuilder("show: ").append(paramFragment);
    }
    if (paramFragment.pm)
    {
      paramFragment.pm = false;
      if (paramFragment.mView != null)
      {
        Animation localAnimation = a(paramFragment, paramInt1, true, paramInt2);
        if (localAnimation != null)
        {
          b(paramFragment.mView, localAnimation);
          paramFragment.mView.startAnimation(localAnimation);
        }
        paramFragment.mView.setVisibility(0);
      }
      if ((paramFragment.pa) && (paramFragment.pq) && (paramFragment.pr)) {
        this.qv = true;
      }
      paramFragment.onHiddenChanged(false);
    }
  }
  
  public final void d(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      new StringBuilder("detach: ").append(paramFragment);
    }
    if (!paramFragment.pn)
    {
      paramFragment.pn = true;
      if (paramFragment.pa)
      {
        if (this.qk != null)
        {
          if (DEBUG) {
            new StringBuilder("remove from detach: ").append(paramFragment);
          }
          this.qk.remove(paramFragment);
        }
        if ((paramFragment.pq) && (paramFragment.pr)) {
          this.qv = true;
        }
        paramFragment.pa = false;
        a(paramFragment, 1, paramInt1, paramInt2, false);
      }
    }
  }
  
  public final void dispatchActivityCreated()
  {
    this.qw = false;
    G(2);
  }
  
  public final void dispatchConfigurationChanged(Configuration paramConfiguration)
  {
    if (this.qk != null)
    {
      int i = 0;
      while (i < this.qk.size())
      {
        Fragment localFragment = (Fragment)this.qk.get(i);
        if (localFragment != null)
        {
          localFragment.onConfigurationChanged(paramConfiguration);
          if (localFragment.pi != null) {
            localFragment.pi.dispatchConfigurationChanged(paramConfiguration);
          }
        }
        i += 1;
      }
    }
  }
  
  public final boolean dispatchContextItemSelected(MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    if (this.qk != null) {
      j = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      Fragment localFragment;
      int i;
      if (j < this.qk.size())
      {
        localFragment = (Fragment)this.qk.get(j);
        if (localFragment == null) {
          break label108;
        }
        if (localFragment.pm) {
          break label103;
        }
        if (!localFragment.onContextItemSelected(paramMenuItem)) {
          break label78;
        }
        i = 1;
      }
      while (i != 0)
      {
        bool1 = true;
        return bool1;
        label78:
        if ((localFragment.pi != null) && (localFragment.pi.dispatchContextItemSelected(paramMenuItem))) {
          i = 1;
        } else {
          label103:
          i = 0;
        }
      }
      label108:
      j += 1;
    }
  }
  
  public final void dispatchCreate()
  {
    this.qw = false;
    G(1);
  }
  
  public final boolean dispatchCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    int m = 0;
    Object localObject2 = null;
    Object localObject1 = null;
    int k;
    boolean bool2;
    boolean bool3;
    Fragment localFragment;
    int i;
    if (this.qk != null)
    {
      k = 0;
      bool2 = false;
      localObject2 = localObject1;
      bool3 = bool2;
      if (k >= this.qk.size()) {
        break label169;
      }
      localFragment = (Fragment)this.qk.get(k);
      if (localFragment == null) {
        break label235;
      }
      if (localFragment.pm) {
        break label243;
      }
      if ((!localFragment.pq) || (!localFragment.pr)) {
        break label238;
      }
      localFragment.onCreateOptionsMenu(paramMenu, paramMenuInflater);
      i = 1;
      label94:
      int j = i;
      if (localFragment.pi == null) {}
    }
    label169:
    label235:
    label238:
    label243:
    for (boolean bool1 = i | localFragment.pi.dispatchCreateOptionsMenu(paramMenu, paramMenuInflater);; bool1 = false)
    {
      if (bool1)
      {
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = new ArrayList();
        }
        ((ArrayList)localObject2).add(localFragment);
        bool2 = true;
        localObject1 = localObject2;
      }
      for (;;)
      {
        k += 1;
        break;
        bool3 = false;
        if (this.qn != null)
        {
          i = m;
          while (i < this.qn.size())
          {
            paramMenu = (Fragment)this.qn.get(i);
            if ((localObject2 == null) || (!((ArrayList)localObject2).contains(paramMenu))) {
              Fragment.onDestroyOptionsMenu();
            }
            i += 1;
          }
        }
        this.qn = ((ArrayList)localObject2);
        return bool3;
      }
      i = 0;
      break label94;
    }
  }
  
  public final void dispatchDestroy()
  {
    this.qx = true;
    execPendingActions();
    G(0);
    this.ph = null;
    this.qs = null;
    this.qt = null;
  }
  
  public final void dispatchLowMemory()
  {
    if (this.qk != null)
    {
      int i = 0;
      while (i < this.qk.size())
      {
        Fragment localFragment = (Fragment)this.qk.get(i);
        if (localFragment != null)
        {
          localFragment.onLowMemory();
          if (localFragment.pi != null) {
            localFragment.pi.dispatchLowMemory();
          }
        }
        i += 1;
      }
    }
  }
  
  public final boolean dispatchOptionsItemSelected(MenuItem paramMenuItem)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int j;
    if (this.qk != null) {
      j = 0;
    }
    for (;;)
    {
      bool1 = bool2;
      Fragment localFragment;
      int i;
      if (j < this.qk.size())
      {
        localFragment = (Fragment)this.qk.get(j);
        if (localFragment == null) {
          break label124;
        }
        if (localFragment.pm) {
          break label119;
        }
        if ((!localFragment.pq) || (!localFragment.pr) || (!localFragment.onOptionsItemSelected(paramMenuItem))) {
          break label94;
        }
        i = 1;
      }
      while (i != 0)
      {
        bool1 = true;
        return bool1;
        label94:
        if ((localFragment.pi != null) && (localFragment.pi.dispatchOptionsItemSelected(paramMenuItem))) {
          i = 1;
        } else {
          label119:
          i = 0;
        }
      }
      label124:
      j += 1;
    }
  }
  
  public final void dispatchOptionsMenuClosed(Menu paramMenu)
  {
    if (this.qk != null)
    {
      int i = 0;
      while (i < this.qk.size())
      {
        Fragment localFragment = (Fragment)this.qk.get(i);
        if ((localFragment != null) && (!localFragment.pm) && (localFragment.pi != null)) {
          localFragment.pi.dispatchOptionsMenuClosed(paramMenu);
        }
        i += 1;
      }
    }
  }
  
  public final boolean dispatchPrepareOptionsMenu(Menu paramMenu)
  {
    int i;
    boolean bool3;
    boolean bool4;
    Fragment localFragment;
    boolean bool1;
    if (this.qk != null)
    {
      i = 0;
      bool3 = false;
      bool4 = bool3;
      if (i >= this.qk.size()) {
        break label133;
      }
      localFragment = (Fragment)this.qk.get(i);
      bool4 = bool3;
      if (localFragment != null)
      {
        if (localFragment.pm) {
          break label141;
        }
        if ((!localFragment.pq) || (!localFragment.pr)) {
          break label136;
        }
        localFragment.onPrepareOptionsMenu(paramMenu);
        bool1 = true;
        label84:
        bool2 = bool1;
        if (localFragment.pi == null) {}
      }
    }
    label133:
    label136:
    label141:
    for (boolean bool2 = bool1 | localFragment.pi.dispatchPrepareOptionsMenu(paramMenu);; bool2 = false)
    {
      bool4 = bool3;
      if (bool2) {
        bool4 = true;
      }
      i += 1;
      bool3 = bool4;
      break;
      bool4 = false;
      return bool4;
      bool1 = false;
      break label84;
    }
  }
  
  public final void dispatchResume()
  {
    this.qw = false;
    G(5);
  }
  
  public final void dispatchStart()
  {
    this.qw = false;
    G(4);
  }
  
  public final void dispatchStop()
  {
    this.qw = true;
    G(3);
  }
  
  public final void dump(String paramString, FileDescriptor paramFileDescriptor, PrintWriter paramPrintWriter, String[] paramArrayOfString)
  {
    int j = 0;
    String str = paramString + "    ";
    int k;
    int i;
    if (this.qj != null)
    {
      k = this.qj.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("Active Fragments in ");
        paramPrintWriter.print(Integer.toHexString(System.identityHashCode(this)));
        paramPrintWriter.println(":");
        i = 0;
        while (i < k)
        {
          Fragment localFragment = (Fragment)this.qj.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(localFragment);
          if (localFragment != null) {
            localFragment.dump(str, paramFileDescriptor, paramPrintWriter, paramArrayOfString);
          }
          i += 1;
        }
      }
    }
    if (this.qk != null)
    {
      k = this.qk.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Added Fragments:");
        i = 0;
        while (i < k)
        {
          paramFileDescriptor = (Fragment)this.qk.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          i += 1;
        }
      }
    }
    if (this.qn != null)
    {
      k = this.qn.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Fragments Created Menus:");
        i = 0;
        while (i < k)
        {
          paramFileDescriptor = (Fragment)this.qn.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          i += 1;
        }
      }
    }
    if (this.qm != null)
    {
      k = this.qm.size();
      if (k > 0)
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.println("Back Stack:");
        i = 0;
        while (i < k)
        {
          paramFileDescriptor = (d)this.qm.get(i);
          paramPrintWriter.print(paramString);
          paramPrintWriter.print("  #");
          paramPrintWriter.print(i);
          paramPrintWriter.print(": ");
          paramPrintWriter.println(paramFileDescriptor.toString());
          paramFileDescriptor.a(str, paramPrintWriter);
          i += 1;
        }
      }
    }
    try
    {
      if (this.qo != null)
      {
        k = this.qo.size();
        if (k > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Back Stack Indices:");
          i = 0;
          while (i < k)
          {
            paramFileDescriptor = (d)this.qo.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i += 1;
          }
        }
      }
      if ((this.qp != null) && (this.qp.size() > 0))
      {
        paramPrintWriter.print(paramString);
        paramPrintWriter.print("mAvailBackStackIndices: ");
        paramPrintWriter.println(Arrays.toString(this.qp.toArray()));
      }
      if (this.qg != null)
      {
        k = this.qg.size();
        if (k > 0)
        {
          paramPrintWriter.print(paramString);
          paramPrintWriter.println("Pending Actions:");
          i = j;
          while (i < k)
          {
            paramFileDescriptor = (Runnable)this.qg.get(i);
            paramPrintWriter.print(paramString);
            paramPrintWriter.print("  #");
            paramPrintWriter.print(i);
            paramPrintWriter.print(": ");
            paramPrintWriter.println(paramFileDescriptor);
            i += 1;
          }
        }
      }
      paramPrintWriter.print(paramString);
    }
    finally {}
    paramPrintWriter.println("FragmentManager misc state:");
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mHost=");
    paramPrintWriter.println(this.ph);
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mContainer=");
    paramPrintWriter.println(this.qs);
    if (this.qt != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mParent=");
      paramPrintWriter.println(this.qt);
    }
    paramPrintWriter.print(paramString);
    paramPrintWriter.print("  mCurState=");
    paramPrintWriter.print(this.qr);
    paramPrintWriter.print(" mStateSaved=");
    paramPrintWriter.print(this.qw);
    paramPrintWriter.print(" mDestroyed=");
    paramPrintWriter.println(this.qx);
    if (this.qv)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNeedMenuInvalidate=");
      paramPrintWriter.println(this.qv);
    }
    if (this.qy != null)
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mNoTransactionsBecause=");
      paramPrintWriter.println(this.qy);
    }
    if ((this.ql != null) && (this.ql.size() > 0))
    {
      paramPrintWriter.print(paramString);
      paramPrintWriter.print("  mAvailIndices: ");
      paramPrintWriter.println(Arrays.toString(this.ql.toArray()));
    }
  }
  
  public final Fragment.SavedState e(Fragment paramFragment)
  {
    Object localObject2 = null;
    if (paramFragment.mIndex < 0) {
      a(new IllegalStateException("Fragment " + paramFragment + " is not currently in the FragmentManager"));
    }
    Object localObject1 = localObject2;
    if (paramFragment.mState > 0)
    {
      paramFragment = j(paramFragment);
      localObject1 = localObject2;
      if (paramFragment != null) {
        localObject1 = new Fragment.SavedState(paramFragment);
      }
    }
    return (Fragment.SavedState)localObject1;
  }
  
  public final void e(Fragment paramFragment, int paramInt1, int paramInt2)
  {
    if (DEBUG) {
      new StringBuilder("attach: ").append(paramFragment);
    }
    if (paramFragment.pn)
    {
      paramFragment.pn = false;
      if (!paramFragment.pa)
      {
        if (this.qk == null) {
          this.qk = new ArrayList();
        }
        if (this.qk.contains(paramFragment)) {
          throw new IllegalStateException("Fragment already added: " + paramFragment);
        }
        if (DEBUG) {
          new StringBuilder("add from attach: ").append(paramFragment);
        }
        this.qk.add(paramFragment);
        paramFragment.pa = true;
        if ((paramFragment.pq) && (paramFragment.pr)) {
          this.qv = true;
        }
        a(paramFragment, this.qr, paramInt1, paramInt2, false);
      }
    }
  }
  
  public final boolean execPendingActions()
  {
    if (this.qi) {
      throw new IllegalStateException("Recursive entry to executePendingTransactions");
    }
    if (Looper.myLooper() != this.ph.mHandler.getLooper()) {
      throw new IllegalStateException("Must be called from main thread of process");
    }
    boolean bool = false;
    label255:
    label268:
    label270:
    for (;;)
    {
      int j;
      try
      {
        if ((this.qg == null) || (this.qg.size() == 0))
        {
          if (!this.qz) {
            break label268;
          }
          i = 0;
          k = 0;
          if (k >= this.qj.size()) {
            break label255;
          }
          Fragment localFragment = (Fragment)this.qj.get(k);
          if ((localFragment == null) || (localFragment.py == null)) {
            break label270;
          }
          i |= localFragment.py.bc();
          k += 1;
          continue;
        }
        int k = this.qg.size();
        if ((this.qh == null) || (this.qh.length < k)) {
          this.qh = new Runnable[k];
        }
        this.qg.toArray(this.qh);
        this.qg.clear();
        this.ph.mHandler.removeCallbacks(this.qC);
        this.qi = true;
        int i = 0;
        if (i < k)
        {
          this.qh[i].run();
          this.qh[i] = null;
          i += 1;
          continue;
        }
        this.qi = false;
      }
      finally {}
      bool = true;
      break;
      if (j == 0)
      {
        this.qz = false;
        aX();
      }
      return bool;
    }
  }
  
  public final boolean executePendingTransactions()
  {
    return execPendingActions();
  }
  
  public final void f(Fragment paramFragment)
  {
    if (paramFragment.pw)
    {
      if (this.qi) {
        this.qz = true;
      }
    }
    else {
      return;
    }
    paramFragment.pw = false;
    a(paramFragment, this.qr, 0, 0, false);
  }
  
  final void h(Fragment paramFragment)
  {
    if (paramFragment.mIndex >= 0) {}
    for (;;)
    {
      return;
      if ((this.ql == null) || (this.ql.size() <= 0))
      {
        if (this.qj == null) {
          this.qj = new ArrayList();
        }
        paramFragment.c(this.qj.size(), this.qt);
        this.qj.add(paramFragment);
      }
      while (DEBUG)
      {
        new StringBuilder("Allocated fragment index ").append(paramFragment);
        return;
        paramFragment.c(((Integer)this.ql.remove(this.ql.size() - 1)).intValue(), this.qt);
        this.qj.set(paramFragment.mIndex, paramFragment);
      }
    }
  }
  
  final boolean h(int paramInt1, int paramInt2)
  {
    if (this.qm == null) {}
    int i;
    do
    {
      int j;
      do
      {
        do
        {
          return false;
          if ((paramInt1 >= 0) || ((paramInt2 & 0x1) != 0)) {
            break;
          }
          paramInt1 = this.qm.size() - 1;
        } while (paramInt1 < 0);
        localObject1 = (d)this.qm.remove(paramInt1);
        localObject2 = new SparseArray();
        localSparseArray1 = new SparseArray();
        ((d)localObject1).b((SparseArray)localObject2, localSparseArray1);
        ((d)localObject1).a(true, null, (SparseArray)localObject2, localSparseArray1);
        aZ();
        return true;
        i = -1;
        if (paramInt1 < 0) {
          break;
        }
        j = this.qm.size() - 1;
        while (j >= 0)
        {
          localObject1 = (d)this.qm.get(j);
          if ((paramInt1 >= 0) && (paramInt1 == ((d)localObject1).mIndex)) {
            break;
          }
          j -= 1;
        }
      } while (j < 0);
      i = j;
      if ((paramInt2 & 0x1) != 0)
      {
        paramInt2 = j - 1;
        for (;;)
        {
          i = paramInt2;
          if (paramInt2 < 0) {
            break;
          }
          localObject1 = (d)this.qm.get(paramInt2);
          i = paramInt2;
          if (paramInt1 < 0) {
            break;
          }
          i = paramInt2;
          if (paramInt1 != ((d)localObject1).mIndex) {
            break;
          }
          paramInt2 -= 1;
        }
      }
    } while (i == this.qm.size() - 1);
    Object localObject2 = new ArrayList();
    paramInt1 = this.qm.size() - 1;
    while (paramInt1 > i)
    {
      ((ArrayList)localObject2).add(this.qm.remove(paramInt1));
      paramInt1 -= 1;
    }
    paramInt2 = ((ArrayList)localObject2).size() - 1;
    SparseArray localSparseArray1 = new SparseArray();
    SparseArray localSparseArray2 = new SparseArray();
    paramInt1 = 0;
    while (paramInt1 <= paramInt2)
    {
      ((d)((ArrayList)localObject2).get(paramInt1)).b(localSparseArray1, localSparseArray2);
      paramInt1 += 1;
    }
    Object localObject1 = null;
    paramInt1 = 0;
    label330:
    d locald;
    if (paramInt1 <= paramInt2)
    {
      if (DEBUG) {
        new StringBuilder("Popping back stack state: ").append(((ArrayList)localObject2).get(paramInt1));
      }
      locald = (d)((ArrayList)localObject2).get(paramInt1);
      if (paramInt1 != paramInt2) {
        break label402;
      }
    }
    label402:
    for (boolean bool = true;; bool = false)
    {
      localObject1 = locald.a(bool, (d.b)localObject1, localSparseArray1, localSparseArray2);
      paramInt1 += 1;
      break label330;
      break;
    }
  }
  
  public final Fragment i(String paramString)
  {
    if ((this.qj != null) && (paramString != null))
    {
      int i = this.qj.size() - 1;
      while (i >= 0)
      {
        Fragment localFragment = (Fragment)this.qj.get(i);
        if (localFragment != null)
        {
          if (paramString.equals(localFragment.oV)) {}
          while (localFragment != null)
          {
            return localFragment;
            if (localFragment.pi != null) {
              localFragment = localFragment.pi.i(paramString);
            } else {
              localFragment = null;
            }
          }
        }
        i -= 1;
      }
    }
    return null;
  }
  
  public final boolean isDestroyed()
  {
    return this.qx;
  }
  
  public final Fragment k(String paramString)
  {
    int i;
    Object localObject;
    if ((this.qk != null) && (paramString != null))
    {
      i = this.qk.size() - 1;
      while (i >= 0)
      {
        localObject = (Fragment)this.qk.get(i);
        if ((localObject != null) && (paramString.equals(((Fragment)localObject).mTag))) {
          return (Fragment)localObject;
        }
        i -= 1;
      }
    }
    if ((this.qj != null) && (paramString != null))
    {
      i = this.qj.size() - 1;
      for (;;)
      {
        if (i < 0) {
          break label126;
        }
        Fragment localFragment = (Fragment)this.qj.get(i);
        if (localFragment != null)
        {
          localObject = localFragment;
          if (paramString.equals(localFragment.mTag)) {
            break;
          }
        }
        i -= 1;
      }
    }
    label126:
    return null;
  }
  
  public final View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (!"fragment".equals(paramString)) {
      return null;
    }
    String str1 = paramAttributeSet.getAttributeValue(null, "class");
    paramString = paramContext.obtainStyledAttributes(paramAttributeSet, b.qN);
    if (str1 == null) {
      str1 = paramString.getString(0);
    }
    for (;;)
    {
      int k = paramString.getResourceId(1, -1);
      String str2 = paramString.getString(2);
      paramString.recycle();
      if (!Fragment.c(this.ph.mContext, str1)) {
        return null;
      }
      if (paramView != null) {}
      for (int i = paramView.getId(); (i == -1) && (k == -1) && (str2 == null); i = 0) {
        throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Must specify unique android:id, android:tag, or have a parent with an id for " + str1);
      }
      int j;
      if (k != -1)
      {
        paramString = E(k);
        paramView = paramString;
        if (paramString == null)
        {
          paramView = paramString;
          if (str2 != null) {
            paramView = k(str2);
          }
        }
        paramString = paramView;
        if (paramView == null)
        {
          paramString = paramView;
          if (i != -1) {
            paramString = E(i);
          }
        }
        if (DEBUG) {
          new StringBuilder("onCreateView: id=0x").append(Integer.toHexString(k)).append(" fname=").append(str1).append(" existing=").append(paramString);
        }
        if (paramString != null) {
          break label405;
        }
        paramView = Fragment.b(paramContext, str1);
        paramView.pc = true;
        if (k == 0) {
          break label398;
        }
        j = k;
        label280:
        paramView.pk = j;
        paramView.pl = i;
        paramView.mTag = str2;
        paramView.pd = true;
        paramView.pg = this;
        paramView.ph = this.ph;
        paramString = paramView.oT;
        paramView.aK();
        a(paramView, true);
        label331:
        if ((this.qr > 0) || (!paramView.pc)) {
          break label524;
        }
        a(paramView, 1, 0, 0, false);
      }
      for (;;)
      {
        if (paramView.mView != null) {
          break label532;
        }
        throw new IllegalStateException("Fragment " + str1 + " did not create a view.");
        paramString = null;
        break;
        label398:
        j = i;
        break label280;
        label405:
        if (paramString.pd) {
          throw new IllegalArgumentException(paramAttributeSet.getPositionDescription() + ": Duplicate id 0x" + Integer.toHexString(k) + ", tag " + str2 + ", or parent id 0x" + Integer.toHexString(i) + " with another fragment for " + str1);
        }
        paramString.pd = true;
        paramString.ph = this.ph;
        if (!paramString.pp)
        {
          paramView = paramString.oT;
          paramString.aK();
        }
        paramView = paramString;
        break label331;
        label524:
        g(paramView);
      }
      label532:
      if (k != 0) {
        paramView.mView.setId(k);
      }
      if (paramView.mView.getTag() == null) {
        paramView.mView.setTag(str2);
      }
      return paramView.mView;
    }
  }
  
  public final void popBackStack()
  {
    a(new Runnable()
    {
      public final void run()
      {
        m localm = m.this;
        k localk = m.this.ph;
        localm.h(-1, 0);
      }
    }, false);
  }
  
  public final boolean popBackStackImmediate()
  {
    aY();
    execPendingActions();
    return h(-1, 0);
  }
  
  final void restoreAllState(Parcelable paramParcelable, List<Fragment> paramList)
  {
    if (paramParcelable == null) {}
    for (;;)
    {
      return;
      paramParcelable = (FragmentManagerState)paramParcelable;
      if (paramParcelable.qO != null)
      {
        Object localObject1;
        Object localObject2;
        if (paramList != null)
        {
          i = 0;
          while (i < paramList.size())
          {
            localObject1 = (Fragment)paramList.get(i);
            if (DEBUG) {
              new StringBuilder("restoreAllState: re-attaching retained ").append(localObject1);
            }
            localObject2 = paramParcelable.qO[localObject1.mIndex];
            ((FragmentState)localObject2).qV = ((Fragment)localObject1);
            ((Fragment)localObject1).oU = null;
            ((Fragment)localObject1).pf = 0;
            ((Fragment)localObject1).pd = false;
            ((Fragment)localObject1).pa = false;
            ((Fragment)localObject1).oX = null;
            if (((FragmentState)localObject2).oT != null)
            {
              ((FragmentState)localObject2).oT.setClassLoader(this.ph.mContext.getClassLoader());
              ((Fragment)localObject1).oU = ((FragmentState)localObject2).oT.getSparseParcelableArray("android:view_state");
              ((Fragment)localObject1).oT = ((FragmentState)localObject2).oT;
            }
            i += 1;
          }
        }
        this.qj = new ArrayList(paramParcelable.qO.length);
        if (this.ql != null) {
          this.ql.clear();
        }
        int i = 0;
        if (i < paramParcelable.qO.length)
        {
          localObject1 = paramParcelable.qO[i];
          if (localObject1 != null)
          {
            localObject2 = this.ph;
            Fragment localFragment = this.qt;
            if (((FragmentState)localObject1).qV == null)
            {
              Context localContext = ((k)localObject2).mContext;
              if (((FragmentState)localObject1).oW != null) {
                ((FragmentState)localObject1).oW.setClassLoader(localContext.getClassLoader());
              }
              ((FragmentState)localObject1).qV = Fragment.a(localContext, ((FragmentState)localObject1).qU, ((FragmentState)localObject1).oW);
              if (((FragmentState)localObject1).oT != null)
              {
                ((FragmentState)localObject1).oT.setClassLoader(localContext.getClassLoader());
                ((FragmentState)localObject1).qV.oT = ((FragmentState)localObject1).oT;
              }
              ((FragmentState)localObject1).qV.c(((FragmentState)localObject1).mIndex, localFragment);
              ((FragmentState)localObject1).qV.pc = ((FragmentState)localObject1).pc;
              ((FragmentState)localObject1).qV.pe = true;
              ((FragmentState)localObject1).qV.pk = ((FragmentState)localObject1).pk;
              ((FragmentState)localObject1).qV.pl = ((FragmentState)localObject1).pl;
              ((FragmentState)localObject1).qV.mTag = ((FragmentState)localObject1).mTag;
              ((FragmentState)localObject1).qV.po = ((FragmentState)localObject1).po;
              ((FragmentState)localObject1).qV.pn = ((FragmentState)localObject1).pn;
              ((FragmentState)localObject1).qV.pg = ((k)localObject2).pg;
              if (DEBUG) {
                new StringBuilder("Instantiated fragment ").append(((FragmentState)localObject1).qV);
              }
            }
            localObject2 = ((FragmentState)localObject1).qV;
            if (DEBUG) {
              new StringBuilder("restoreAllState: active #").append(i).append(": ").append(localObject2);
            }
            this.qj.add(localObject2);
            ((FragmentState)localObject1).qV = null;
          }
          for (;;)
          {
            i += 1;
            break;
            this.qj.add(null);
            if (this.ql == null) {
              this.ql = new ArrayList();
            }
            if (DEBUG) {}
            this.ql.add(Integer.valueOf(i));
          }
        }
        if (paramList != null)
        {
          i = 0;
          if (i < paramList.size())
          {
            localObject1 = (Fragment)paramList.get(i);
            if (((Fragment)localObject1).oY >= 0) {
              if (((Fragment)localObject1).oY >= this.qj.size()) {
                break label659;
              }
            }
            for (((Fragment)localObject1).oX = ((Fragment)this.qj.get(((Fragment)localObject1).oY));; ((Fragment)localObject1).oX = null)
            {
              i += 1;
              break;
              label659:
              new StringBuilder("Re-attaching retained fragment ").append(localObject1).append(" target no longer exists: ").append(((Fragment)localObject1).oY);
            }
          }
        }
        if (paramParcelable.qP != null)
        {
          this.qk = new ArrayList(paramParcelable.qP.length);
          i = 0;
          while (i < paramParcelable.qP.length)
          {
            paramList = (Fragment)this.qj.get(paramParcelable.qP[i]);
            if (paramList == null) {
              a(new IllegalStateException("No instantiated fragment for index #" + paramParcelable.qP[i]));
            }
            paramList.pa = true;
            if (DEBUG) {
              new StringBuilder("restoreAllState: added #").append(i).append(": ").append(paramList);
            }
            if (this.qk.contains(paramList)) {
              throw new IllegalStateException("Already added!");
            }
            this.qk.add(paramList);
            i += 1;
          }
        }
        this.qk = null;
        if (paramParcelable.qQ == null) {
          break;
        }
        this.qm = new ArrayList(paramParcelable.qQ.length);
        i = 0;
        while (i < paramParcelable.qQ.length)
        {
          paramList = paramParcelable.qQ[i].a(this);
          if (DEBUG)
          {
            new StringBuilder("restoreAllState: back stack #").append(i).append(" (index ").append(paramList.mIndex).append("): ").append(paramList);
            paramList.a("  ", new PrintWriter(new android.support.v4.e.d("FragmentManager")), false);
          }
          this.qm.add(paramList);
          if (paramList.mIndex >= 0) {
            a(paramList.mIndex, paramList);
          }
          i += 1;
        }
      }
    }
    this.qm = null;
  }
  
  final Parcelable saveAllState()
  {
    Object localObject3 = null;
    execPendingActions();
    if (qf) {
      this.qw = true;
    }
    if ((this.qj == null) || (this.qj.size() <= 0)) {
      return null;
    }
    int k = this.qj.size();
    FragmentState[] arrayOfFragmentState = new FragmentState[k];
    int j = 0;
    int i = 0;
    label56:
    Object localObject1;
    Object localObject2;
    if (j < k)
    {
      localObject1 = (Fragment)this.qj.get(j);
      if (localObject1 == null) {
        break label659;
      }
      if (((Fragment)localObject1).mIndex < 0) {
        a(new IllegalStateException("Failure saving state: active " + localObject1 + " has cleared index: " + ((Fragment)localObject1).mIndex));
      }
      localObject2 = new FragmentState((Fragment)localObject1);
      arrayOfFragmentState[j] = localObject2;
      if ((((Fragment)localObject1).mState > 0) && (((FragmentState)localObject2).oT == null))
      {
        ((FragmentState)localObject2).oT = j((Fragment)localObject1);
        if (((Fragment)localObject1).oX != null)
        {
          if (((Fragment)localObject1).oX.mIndex < 0) {
            a(new IllegalStateException("Failure saving state: " + localObject1 + " has target not in fragment manager: " + ((Fragment)localObject1).oX));
          }
          if (((FragmentState)localObject2).oT == null) {
            ((FragmentState)localObject2).oT = new Bundle();
          }
          a(((FragmentState)localObject2).oT, "android:target_state", ((Fragment)localObject1).oX);
          if (((Fragment)localObject1).oZ != 0) {
            ((FragmentState)localObject2).oT.putInt("android:target_req_state", ((Fragment)localObject1).oZ);
          }
        }
        label297:
        if (DEBUG) {
          new StringBuilder("Saved state of ").append(localObject1).append(": ").append(((FragmentState)localObject2).oT);
        }
        i = 1;
      }
    }
    label659:
    for (;;)
    {
      j += 1;
      break label56;
      ((FragmentState)localObject2).oT = ((Fragment)localObject1).oT;
      break label297;
      if (i == 0) {
        break;
      }
      if (this.qk != null)
      {
        j = this.qk.size();
        if (j > 0)
        {
          localObject2 = new int[j];
          i = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (i >= j) {
              break;
            }
            localObject2[i] = ((Fragment)this.qk.get(i)).mIndex;
            if (localObject2[i] < 0) {
              a(new IllegalStateException("Failure saving state: active " + this.qk.get(i) + " has cleared index: " + localObject2[i]));
            }
            if (DEBUG) {
              new StringBuilder("saveAllState: adding fragment #").append(i).append(": ").append(this.qk.get(i));
            }
            i += 1;
          }
        }
      }
      localObject1 = null;
      localObject2 = localObject3;
      if (this.qm != null)
      {
        j = this.qm.size();
        localObject2 = localObject3;
        if (j > 0)
        {
          localObject3 = new BackStackState[j];
          i = 0;
          for (;;)
          {
            localObject2 = localObject3;
            if (i >= j) {
              break;
            }
            localObject3[i] = new BackStackState((d)this.qm.get(i));
            if (DEBUG) {
              new StringBuilder("saveAllState: adding back stack #").append(i).append(": ").append(this.qm.get(i));
            }
            i += 1;
          }
        }
      }
      localObject3 = new FragmentManagerState();
      ((FragmentManagerState)localObject3).qO = arrayOfFragmentState;
      ((FragmentManagerState)localObject3).qP = ((int[])localObject1);
      ((FragmentManagerState)localObject3).qQ = ((BackStackState[])localObject2);
      return (Parcelable)localObject3;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(128);
    localStringBuilder.append("FragmentManager{");
    localStringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
    localStringBuilder.append(" in ");
    if (this.qt != null) {
      c.a(this.qt, localStringBuilder);
    }
    for (;;)
    {
      localStringBuilder.append("}}");
      return localStringBuilder.toString();
      c.a(this.ph, localStringBuilder);
    }
  }
  
  static class a
    implements Animation.AnimationListener
  {
    public View mView = null;
    private Animation.AnimationListener qK = null;
    private boolean qL = false;
    
    public a(View paramView, Animation paramAnimation)
    {
      if ((paramView == null) || (paramAnimation == null)) {
        return;
      }
      this.mView = paramView;
    }
    
    public a(View paramView, Animation paramAnimation, Animation.AnimationListener paramAnimationListener)
    {
      if ((paramView == null) || (paramAnimation == null)) {
        return;
      }
      this.qK = paramAnimationListener;
      this.mView = paramView;
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      if ((this.mView != null) && (this.qL)) {
        this.mView.post(new Runnable()
        {
          public final void run()
          {
            z.a(m.a.this.mView, 0, null);
          }
        });
      }
      if (this.qK != null) {
        this.qK.onAnimationEnd(paramAnimation);
      }
    }
    
    public void onAnimationRepeat(Animation paramAnimation)
    {
      if (this.qK != null) {
        this.qK.onAnimationRepeat(paramAnimation);
      }
    }
    
    public void onAnimationStart(Animation paramAnimation)
    {
      if (this.mView != null)
      {
        this.qL = m.a(this.mView, paramAnimation);
        if (this.qL) {
          this.mView.post(new Runnable()
          {
            public final void run()
            {
              z.a(m.a.this.mView, 2, null);
            }
          });
        }
      }
      if (this.qK != null) {
        this.qK.onAnimationStart(paramAnimation);
      }
    }
  }
  
  static final class b
  {
    public static final int[] qN = { 16842755, 16842960, 16842961 };
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/android/support/v4/app/m.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */