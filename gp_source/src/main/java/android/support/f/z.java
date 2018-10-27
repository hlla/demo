package android.support.f;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.TimeInterpolator;
import android.os.Build.VERSION;
import android.support.v4.g.h;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class z
  implements Cloneable
{
  private static final int[] q = { 2, 1, 3, 4 };
  private static final v r = new aa();
  private static ThreadLocal z = new ThreadLocal();
  public boolean a = false;
  public ArrayList b = new ArrayList();
  public long c = -1L;
  public aq d = new aq();
  public ArrayList e;
  public ae f;
  public TimeInterpolator g = null;
  public int[] h = q;
  public al i = null;
  public v j = r;
  public ak k;
  public long l = -1L;
  public aq m = new aq();
  public ArrayList n;
  public ArrayList o = new ArrayList();
  public ArrayList p = new ArrayList();
  private ArrayList s = new ArrayList();
  private boolean t = false;
  private ArrayList u = null;
  private String v = getClass().getName();
  private int w = 0;
  private boolean x = false;
  private ArrayList y = null;
  
  private static void a(aq paramaq, View paramView, ap paramap)
  {
    paramaq.d.put(paramView, paramap);
    int i1 = paramView.getId();
    if (i1 >= 0)
    {
      if (paramaq.a.indexOfKey(i1) < 0) {
        break label185;
      }
      paramaq.a.put(i1, null);
    }
    for (;;)
    {
      paramap = android.support.v4.view.ac.v(paramView);
      if (paramap != null)
      {
        if (!paramaq.c.containsKey(paramap)) {
          break label172;
        }
        paramaq.c.put(paramap, null);
      }
      for (;;)
      {
        long l1;
        if ((paramView.getParent() instanceof ListView))
        {
          paramap = (ListView)paramView.getParent();
          if (paramap.getAdapter().hasStableIds())
          {
            l1 = paramap.getItemIdAtPosition(paramap.getPositionForView(paramView));
            if (paramaq.b.b(l1) < 0) {
              break label156;
            }
            paramView = (View)paramaq.b.a(l1, null);
            if (paramView != null)
            {
              android.support.v4.view.ac.a(paramView, false);
              paramaq.b.b(l1, null);
            }
          }
        }
        return;
        label156:
        android.support.v4.view.ac.a(paramView, true);
        paramaq.b.b(l1, paramView);
        return;
        label172:
        paramaq.c.put(paramap, paramView);
      }
      label185:
      paramaq.a.put(i1, paramView);
    }
  }
  
  private static boolean a(ap paramap1, ap paramap2, String paramString)
  {
    paramap1 = paramap1.b.get(paramString);
    paramap2 = paramap2.b.get(paramString);
    if (paramap1 != null) {}
    while (paramap2 != null)
    {
      if (paramap1 == null) {}
      while (paramap2 == null) {
        return true;
      }
      return paramap1.equals(paramap2) ^ true;
    }
    return false;
  }
  
  static android.support.v4.g.a b()
  {
    android.support.v4.g.a locala2 = (android.support.v4.g.a)z.get();
    android.support.v4.g.a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new android.support.v4.g.a();
      z.set(locala1);
    }
    return locala1;
  }
  
  private final void c(View paramView, boolean paramBoolean)
  {
    if (paramView != null)
    {
      paramView.getId();
      ap localap;
      if ((paramView.getParent() instanceof ViewGroup))
      {
        localap = new ap();
        localap.c = paramView;
        if (!paramBoolean) {
          break label126;
        }
        a(localap);
      }
      for (;;)
      {
        localap.a.add(this);
        c(localap);
        if (paramBoolean) {
          a(this.m, paramView, localap);
        }
        while ((paramView instanceof ViewGroup))
        {
          paramView = (ViewGroup)paramView;
          int i1 = 0;
          while (i1 < paramView.getChildCount())
          {
            c(paramView.getChildAt(i1), paramBoolean);
            i1 += 1;
          }
          a(this.d, paramView, localap);
        }
        label126:
        b(localap);
      }
    }
  }
  
  public Animator a(ViewGroup paramViewGroup, ap paramap1, ap paramap2)
  {
    return null;
  }
  
  public final ap a(View paramView, boolean paramBoolean)
  {
    al localal;
    for (Object localObject = this;; localObject = localal)
    {
      localal = ((z)localObject).i;
      if (localal == null) {
        break;
      }
    }
    if (!paramBoolean) {}
    for (localObject = ((z)localObject).d;; localObject = ((z)localObject).m) {
      return (ap)((aq)localObject).d.get(paramView);
    }
  }
  
  public z a(long paramLong)
  {
    this.c = paramLong;
    return this;
  }
  
  public z a(TimeInterpolator paramTimeInterpolator)
  {
    this.g = paramTimeInterpolator;
    return this;
  }
  
  public z a(af paramaf)
  {
    if (this.u == null) {
      this.u = new ArrayList();
    }
    this.u.add(paramaf);
    return this;
  }
  
  public z a(ViewGroup paramViewGroup)
  {
    return this;
  }
  
  public z a(String paramString, boolean paramBoolean)
  {
    ArrayList localArrayList2 = this.y;
    Object localObject;
    if (paramString == null) {
      localObject = localArrayList2;
    }
    for (;;)
    {
      this.y = ((ArrayList)localObject);
      return this;
      if (!paramBoolean)
      {
        localObject = localArrayList2;
        if (localArrayList2 != null)
        {
          localArrayList2.remove(paramString);
          localObject = localArrayList2;
          if (localArrayList2.isEmpty()) {
            localObject = null;
          }
        }
      }
      else
      {
        ArrayList localArrayList1 = localArrayList2;
        if (localArrayList2 == null) {
          localArrayList1 = new ArrayList();
        }
        localObject = localArrayList1;
        if (!localArrayList1.contains(paramString))
        {
          localArrayList1.add(paramString);
          localObject = localArrayList1;
        }
      }
    }
  }
  
  String a(String paramString)
  {
    int i2 = 0;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(getClass().getSimpleName());
    ((StringBuilder)localObject).append("@");
    ((StringBuilder)localObject).append(Integer.toHexString(hashCode()));
    ((StringBuilder)localObject).append(": ");
    localObject = ((StringBuilder)localObject).toString();
    paramString = (String)localObject;
    if (this.c != -1L)
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append("dur(");
      paramString.append(this.c);
      paramString.append(") ");
      paramString = paramString.toString();
    }
    localObject = paramString;
    if (this.l != -1L)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("dly(");
      ((StringBuilder)localObject).append(this.l);
      ((StringBuilder)localObject).append(") ");
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString = (String)localObject;
    if (this.g != null)
    {
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append("interp(");
      paramString.append(this.g);
      paramString.append(") ");
      paramString = paramString.toString();
    }
    int i1;
    if (this.o.size() <= 0)
    {
      localObject = paramString;
      if (this.p.size() <= 0) {}
    }
    else
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append("tgts(");
      localObject = ((StringBuilder)localObject).toString();
      paramString = (String)localObject;
      if (this.o.size() > 0)
      {
        paramString = (String)localObject;
        i1 = 0;
      }
    }
    for (;;)
    {
      if (i1 >= this.o.size())
      {
        localObject = paramString;
        if (this.p.size() > 0) {
          i1 = i2;
        }
        for (;;)
        {
          if (i1 >= this.p.size())
          {
            localObject = paramString;
            paramString = new StringBuilder();
            paramString.append((String)localObject);
            paramString.append(")");
            localObject = paramString.toString();
            return (String)localObject;
          }
          localObject = paramString;
          if (i1 > 0)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append(paramString);
            ((StringBuilder)localObject).append(", ");
            localObject = ((StringBuilder)localObject).toString();
          }
          paramString = new StringBuilder();
          paramString.append((String)localObject);
          paramString.append(this.p.get(i1));
          paramString = paramString.toString();
          i1 += 1;
        }
      }
      localObject = paramString;
      if (i1 > 0)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(", ");
        localObject = ((StringBuilder)localObject).toString();
      }
      paramString = new StringBuilder();
      paramString.append((String)localObject);
      paramString.append(this.o.get(i1));
      paramString = paramString.toString();
      i1 += 1;
    }
  }
  
  public void a(ae paramae)
  {
    this.f = paramae;
  }
  
  public void a(ak paramak)
  {
    this.k = paramak;
  }
  
  public abstract void a(ap paramap);
  
  public void a(v paramv)
  {
    if (paramv == null)
    {
      this.j = r;
      return;
    }
    this.j = paramv;
  }
  
  protected void a(ViewGroup paramViewGroup, aq paramaq1, aq paramaq2, ArrayList paramArrayList1, ArrayList paramArrayList2)
  {
    android.support.v4.g.a locala = b();
    SparseIntArray localSparseIntArray = new SparseIntArray();
    int i3 = paramArrayList1.size();
    long l1 = Long.MAX_VALUE;
    int i1 = 0;
    label117:
    label121:
    int i2;
    if (i1 < i3)
    {
      Object localObject2 = (ap)paramArrayList1.get(i1);
      Object localObject1 = (ap)paramArrayList2.get(i1);
      paramaq1 = (aq)localObject2;
      if (localObject2 != null)
      {
        paramaq1 = (aq)localObject2;
        if (!((ap)localObject2).a.contains(this)) {
          paramaq1 = null;
        }
      }
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject2 = localObject1;
        if (!((ap)localObject1).a.contains(this)) {
          localObject2 = null;
        }
      }
      long l2;
      if (paramaq1 != null) {
        if (paramaq1 == null)
        {
          localObject1 = a(paramViewGroup, paramaq1, (ap)localObject2);
          if (localObject1 == null) {
            l2 = l1;
          }
        }
      }
      for (;;)
      {
        i1 += 1;
        l1 = l2;
        break;
        if (localObject2 == null)
        {
          paramaq1 = paramaq1.c;
          localObject2 = null;
        }
        for (;;)
        {
          l2 = l1;
          if (localObject1 == null) {
            break;
          }
          Object localObject3 = this.k;
          if (localObject3 != null)
          {
            l2 = ((ak)localObject3).a();
            localSparseIntArray.put(this.s.size(), (int)l2);
            l1 = Math.min(l2, l1);
          }
          for (;;)
          {
            locala.put(localObject1, new ad(paramaq1, this.v, this, ba.a(paramViewGroup), (ap)localObject2));
            this.s.add(localObject1);
            l2 = l1;
            break;
          }
          paramaq1 = ((ap)localObject2).c;
          localObject3 = a();
          if (paramaq1 == null)
          {
            localObject2 = null;
          }
          else if (localObject3 == null)
          {
            localObject2 = null;
          }
          else
          {
            if (localObject3.length > 0)
            {
              localObject2 = new ap();
              ((ap)localObject2).c = paramaq1;
              ap localap = (ap)paramaq2.d.get(paramaq1);
              if (localap == null) {}
              for (;;)
              {
                int i4 = locala.size();
                i2 = 0;
                if (i2 < i4)
                {
                  localObject3 = (ad)locala.get((Animator)locala.b(i2));
                  if (((ad)localObject3).c == null) {}
                  while ((((ad)localObject3).d != paramaq1) || (!((ad)localObject3).a.equals(this.v)) || (!((ad)localObject3).c.equals(localObject2)))
                  {
                    i2 += 1;
                    break;
                  }
                  localObject1 = null;
                  break;
                }
                break;
                i2 = 0;
                while (i2 < localObject3.length)
                {
                  Map localMap = ((ap)localObject2).b;
                  Object localObject4 = localObject3[i2];
                  localMap.put(localObject4, localap.b.get(localObject4));
                  i2 += 1;
                }
              }
            }
            localObject2 = null;
          }
        }
        if ((localObject2 == null) || (a(paramaq1, (ap)localObject2))) {
          break label121;
        }
        l2 = l1;
        continue;
        if (localObject2 != null) {
          break label117;
        }
        l2 = l1;
      }
    }
    if (l1 != 0L)
    {
      i1 = 0;
      while (i1 < localSparseIntArray.size())
      {
        i2 = localSparseIntArray.keyAt(i1);
        paramViewGroup = (Animator)this.s.get(i2);
        paramViewGroup.setStartDelay(localSparseIntArray.valueAt(i1) - l1 + paramViewGroup.getStartDelay());
        i1 += 1;
      }
    }
  }
  
  final void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    int i3 = 0;
    a(paramBoolean);
    int i1;
    if (this.o.size() <= 0)
    {
      if (this.p.size() <= 0)
      {
        c(paramViewGroup, paramBoolean);
        return;
      }
      i1 = 0;
    }
    for (;;)
    {
      int i2 = i3;
      Object localObject;
      if (i1 < this.o.size())
      {
        localObject = paramViewGroup.findViewById(((Integer)this.o.get(i1)).intValue());
        ap localap;
        if (localObject != null)
        {
          localap = new ap();
          localap.c = ((View)localObject);
          if (!paramBoolean) {
            break label155;
          }
          a(localap);
        }
        for (;;)
        {
          localap.a.add(this);
          c(localap);
          if (paramBoolean) {
            a(this.m, (View)localObject, localap);
          }
          for (;;)
          {
            i1 += 1;
            break;
            a(this.d, (View)localObject, localap);
          }
          label155:
          b(localap);
        }
      }
      label164:
      if (i2 < this.p.size())
      {
        paramViewGroup = (View)this.p.get(i2);
        localObject = new ap();
        ((ap)localObject).c = paramViewGroup;
        if (!paramBoolean) {
          break label266;
        }
        a((ap)localObject);
      }
      for (;;)
      {
        ((ap)localObject).a.add(this);
        c((ap)localObject);
        if (paramBoolean) {
          a(this.m, paramViewGroup, (ap)localObject);
        }
        for (;;)
        {
          i2 += 1;
          break label164;
          break;
          a(this.d, paramViewGroup, (ap)localObject);
        }
        label266:
        b((ap)localObject);
      }
      i1 = 0;
    }
  }
  
  final void a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      this.d.d.clear();
      this.d.a.clear();
      this.d.b.b();
      return;
    }
    this.m.d.clear();
    this.m.a.clear();
    this.m.b.b();
  }
  
  public boolean a(ap paramap1, ap paramap2)
  {
    if (paramap1 == null) {
      return false;
    }
    if (paramap2 != null)
    {
      Object localObject = a();
      if (localObject != null)
      {
        int i2 = localObject.length;
        int i1 = 0;
        while (i1 < i2) {
          if (!a(paramap1, paramap2, localObject[i1])) {
            i1 += 1;
          } else {
            return true;
          }
        }
        return false;
      }
      localObject = paramap1.b.keySet().iterator();
      while (((Iterator)localObject).hasNext()) {
        if (a(paramap1, paramap2, (String)((Iterator)localObject).next())) {
          return true;
        }
      }
      return false;
    }
    return false;
  }
  
  final boolean a(View paramView)
  {
    int i1 = paramView.getId();
    if ((this.y == null) || (android.support.v4.view.ac.v(paramView) == null) || (!this.y.contains(android.support.v4.view.ac.v(paramView))))
    {
      if ((this.o.size() == 0) && (this.p.size() == 0)) {}
    }
    else {
      return (this.o.contains(Integer.valueOf(i1))) || (this.p.contains(paramView));
    }
    return true;
  }
  
  public String[] a()
  {
    return null;
  }
  
  final ap b(View paramView, boolean paramBoolean)
  {
    Object localObject4 = null;
    Object localObject2;
    for (Object localObject1 = this;; localObject1 = localObject2)
    {
      localObject2 = ((z)localObject1).i;
      if (localObject2 == null)
      {
        if (!paramBoolean) {}
        for (localObject2 = ((z)localObject1).e;; localObject2 = ((z)localObject1).n)
        {
          Object localObject3 = localObject4;
          int i2;
          if (localObject2 != null)
          {
            int i3 = ((ArrayList)localObject2).size();
            int i1 = 0;
            while (i1 < i3)
            {
              ap localap = (ap)((ArrayList)localObject2).get(i1);
              localObject3 = localObject4;
              if (localap == null) {
                break label105;
              }
              i2 = i1;
              if (localap.c == paramView) {
                break label95;
              }
              i1 += 1;
            }
            i2 = -1;
            label95:
            if (i2 < 0)
            {
              paramView = null;
              localObject3 = paramView;
            }
          }
          else
          {
            label105:
            return (ap)localObject3;
          }
          if (!paramBoolean) {}
          for (paramView = ((z)localObject1).n;; paramView = ((z)localObject1).e)
          {
            paramView = (ap)paramView.get(i2);
            break;
          }
        }
      }
    }
  }
  
  public z b(long paramLong)
  {
    this.l = paramLong;
    return this;
  }
  
  public z b(af paramaf)
  {
    ArrayList localArrayList = this.u;
    if (localArrayList != null)
    {
      localArrayList.remove(paramaf);
      if (this.u.size() == 0) {
        this.u = null;
      }
    }
    return this;
  }
  
  public z b(View paramView)
  {
    this.p.add(paramView);
    return this;
  }
  
  public abstract void b(ap paramap);
  
  public void b(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
  
  public z c(View paramView)
  {
    this.p.remove(paramView);
    return this;
  }
  
  protected void c()
  {
    d();
    android.support.v4.g.a locala = b();
    ArrayList localArrayList = this.s;
    int i2 = localArrayList.size();
    int i1 = 0;
    if (i1 < i2)
    {
      Animator localAnimator = (Animator)localArrayList.get(i1);
      if (!locala.containsKey(localAnimator)) {}
      for (;;)
      {
        i1 += 1;
        break;
        d();
        if (localAnimator != null)
        {
          localAnimator.addListener(new ab(this, locala));
          if (localAnimator != null)
          {
            long l1 = this.c;
            if (l1 < 0L) {}
            for (;;)
            {
              l1 = this.l;
              if (l1 < 0L) {}
              for (;;)
              {
                TimeInterpolator localTimeInterpolator = this.g;
                if (localTimeInterpolator != null) {
                  localAnimator.setInterpolator(localTimeInterpolator);
                }
                localAnimator.addListener(new ac(this));
                localAnimator.start();
                break;
                localAnimator.setStartDelay(l1);
              }
              localAnimator.setDuration(l1);
            }
          }
          e();
        }
      }
    }
    this.s.clear();
    e();
  }
  
  void c(ap paramap)
  {
    if ((this.k != null) && (!paramap.b.isEmpty()))
    {
      String[] arrayOfString = this.k.c();
      if (arrayOfString != null)
      {
        int i1 = 0;
        while (i1 < arrayOfString.length) {
          if (paramap.b.containsKey(arrayOfString[i1])) {
            i1 += 1;
          } else {
            this.k.b();
          }
        }
      }
    }
  }
  
  protected final void d()
  {
    if (this.w == 0)
    {
      ArrayList localArrayList = this.u;
      if ((localArrayList != null) && (localArrayList.size() > 0))
      {
        localArrayList = (ArrayList)this.u.clone();
        int i2 = localArrayList.size();
        int i1 = 0;
        while (i1 < i2)
        {
          ((af)localArrayList.get(i1)).c();
          i1 += 1;
        }
      }
      this.t = false;
    }
    this.w += 1;
  }
  
  public void d(View paramView)
  {
    int i3 = 0;
    if (!this.t)
    {
      android.support.v4.g.a locala = b();
      int i1 = locala.size();
      paramView = ba.a(paramView);
      i1 -= 1;
      label99:
      int i2;
      if (i1 >= 0)
      {
        Object localObject = (ad)locala.c(i1);
        if (((ad)localObject).d == null) {}
        ArrayList localArrayList;
        do
        {
          for (;;)
          {
            i1 -= 1;
            break;
            if (paramView.equals(((ad)localObject).e))
            {
              localObject = (Animator)locala.b(i1);
              if (Build.VERSION.SDK_INT < 19) {
                break label99;
              }
              ((Animator)localObject).pause();
            }
          }
          localArrayList = ((Animator)localObject).getListeners();
        } while (localArrayList == null);
        int i4 = localArrayList.size();
        i2 = 0;
        label120:
        Animator.AnimatorListener localAnimatorListener;
        if (i2 < i4)
        {
          localAnimatorListener = (Animator.AnimatorListener)localArrayList.get(i2);
          if ((localAnimatorListener instanceof a)) {
            break label152;
          }
        }
        for (;;)
        {
          i2 += 1;
          break label120;
          break;
          label152:
          ((a)localAnimatorListener).onAnimationPause((Animator)localObject);
        }
      }
      paramView = this.u;
      if ((paramView != null) && (paramView.size() > 0))
      {
        paramView = (ArrayList)this.u.clone();
        i2 = paramView.size();
        i1 = i3;
        while (i1 < i2)
        {
          ((af)paramView.get(i1)).a();
          i1 += 1;
        }
      }
      this.x = true;
    }
  }
  
  protected final void e()
  {
    this.w -= 1;
    Object localObject;
    int i1;
    if (this.w == 0)
    {
      localObject = this.u;
      if (localObject == null) {
        break label188;
      }
      if (((ArrayList)localObject).size() <= 0) {
        break label183;
      }
      localObject = (ArrayList)this.u.clone();
      int i2 = ((ArrayList)localObject).size();
      i1 = 0;
      while (i1 < i2)
      {
        ((af)((ArrayList)localObject).get(i1)).a(this);
        i1 += 1;
      }
      i1 = 0;
    }
    for (;;)
    {
      if (i1 < this.m.b.a())
      {
        localObject = (View)this.m.b.b(i1);
        if (localObject == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          android.support.v4.view.ac.a((View)localObject, false);
        }
      }
      i1 = 0;
      if (i1 < this.d.b.a())
      {
        localObject = (View)this.d.b.b(i1);
        if (localObject == null) {}
        for (;;)
        {
          i1 += 1;
          break;
          android.support.v4.view.ac.a((View)localObject, false);
        }
      }
      this.t = true;
      return;
      label183:
      i1 = 0;
      continue;
      label188:
      i1 = 0;
    }
  }
  
  public void e(View paramView)
  {
    if (this.x)
    {
      if (!this.t)
      {
        android.support.v4.g.a locala = b();
        int i1 = locala.size();
        paramView = ba.a(paramView);
        i1 -= 1;
        label103:
        int i2;
        if (i1 >= 0)
        {
          Object localObject = (ad)locala.c(i1);
          if (((ad)localObject).d == null) {}
          ArrayList localArrayList;
          do
          {
            for (;;)
            {
              i1 -= 1;
              break;
              if (paramView.equals(((ad)localObject).e))
              {
                localObject = (Animator)locala.b(i1);
                if (Build.VERSION.SDK_INT < 19) {
                  break label103;
                }
                ((Animator)localObject).resume();
              }
            }
            localArrayList = ((Animator)localObject).getListeners();
          } while (localArrayList == null);
          int i3 = localArrayList.size();
          i2 = 0;
          label124:
          Animator.AnimatorListener localAnimatorListener;
          if (i2 < i3)
          {
            localAnimatorListener = (Animator.AnimatorListener)localArrayList.get(i2);
            if ((localAnimatorListener instanceof a)) {
              break label156;
            }
          }
          for (;;)
          {
            i2 += 1;
            break label124;
            break;
            label156:
            ((a)localAnimatorListener).onAnimationResume((Animator)localObject);
          }
        }
        paramView = this.u;
        if ((paramView != null) && (paramView.size() > 0))
        {
          paramView = (ArrayList)this.u.clone();
          i2 = paramView.size();
          i1 = 0;
          while (i1 < i2)
          {
            ((af)paramView.get(i1)).b();
            i1 += 1;
          }
        }
      }
      this.x = false;
    }
  }
  
  public z f()
  {
    try
    {
      z localz = (z)super.clone();
      localz.s = new ArrayList();
      localz.m = new aq();
      localz.d = new aq();
      localz.n = null;
      localz.e = null;
      return localz;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException) {}
    return null;
  }
  
  public String toString()
  {
    return a("");
  }
}


/* Location:              /home/chengjian/CM_test/gp/apk/a.jar!/android/support/f/z.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */