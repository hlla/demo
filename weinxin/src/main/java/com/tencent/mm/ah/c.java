package com.tencent.mm.ah;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.y.e;
import com.tencent.mm.y.f;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class c
  implements e, f
{
  List<b> hEt;
  private HashSet<b> hEu;
  b hEv;
  private j hEw;
  public boolean hEx;
  
  public c()
  {
    GMTrace.i(3536234479616L, 26347);
    this.hEv = null;
    this.hEw = null;
    this.hEx = false;
    this.hEt = new LinkedList();
    this.hEu = new HashSet();
    h.vH().gXs.a(109, this);
    GMTrace.o(3536234479616L, 26347);
  }
  
  private boolean a(b paramb)
  {
    GMTrace.i(3537039785984L, 26353);
    if ((paramb == null) || (paramb.hEC.size() > 0))
    {
      GMTrace.o(3537039785984L, 26353);
      return false;
    }
    boolean bool = b(paramb);
    GMTrace.o(3537039785984L, 26353);
    return bool;
  }
  
  private static void c(b paramb)
  {
    GMTrace.i(3537442439168L, 26356);
    if (paramb == null)
    {
      v.e("ModelImage.DownloadImgService", "task is null");
      GMTrace.o(3537442439168L, 26356);
      return;
    }
    if (paramb.hEC == null)
    {
      v.e("ModelImage.DownloadImgService", "task callback list is null");
      GMTrace.o(3537442439168L, 26356);
      return;
    }
    Iterator localIterator = paramb.hEC.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.hEE != null) {
        localc.hEE.a(paramb.hEy, paramb.hEz, paramb.hEA, paramb.hEB, localc.hEF);
      }
    }
    GMTrace.o(3537442439168L, 26356);
  }
  
  private void fL(int paramInt)
  {
    GMTrace.i(3537979310080L, 26360);
    if ((this.hEv != null) || (this.hEt.size() <= 0) || (true == this.hEx))
    {
      GMTrace.o(3537979310080L, 26360);
      return;
    }
    this.hEv = ((b)this.hEt.get(0));
    this.hEt.remove(0);
    this.hEw = new j(this.hEv.hEy, this.hEv.hEz, this.hEv.hEA, this, paramInt);
    this.hEw.hGj = this.hEv.hEB;
    v.i("ModelImage.DownloadImgService", "do scene, (" + this.hEv.hEy + ", " + this.hEv.hEz + ", " + this.hEv.hEA + ")");
    h.vH().gXs.a(this.hEw, 0);
    GMTrace.o(3537979310080L, 26360);
  }
  
  public final void Gx()
  {
    GMTrace.i(3537576656896L, 26357);
    this.hEx = false;
    fL(-1);
    GMTrace.o(3537576656896L, 26357);
  }
  
  public final int a(long paramLong1, long paramLong2, int paramInt1, Object paramObject, int paramInt2, a parama, int paramInt3)
  {
    GMTrace.i(3536502915072L, 26349);
    if (parama == null)
    {
      v.e("ModelImage.DownloadImgService", "listener is null");
      GMTrace.o(3536502915072L, 26349);
      return -1;
    }
    b localb = new b(paramLong1, paramLong2, paramInt1);
    localb.hEB = paramInt2;
    if (this.hEu.contains(localb))
    {
      v.e("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] add failed, task already done");
      GMTrace.o(3536502915072L, 26349);
      return -2;
    }
    if ((this.hEv != null) && (localb.equals(this.hEv)))
    {
      if (this.hEv.a(parama, paramObject))
      {
        GMTrace.o(3536502915072L, 26349);
        return 0;
      }
      GMTrace.o(3536502915072L, 26349);
      return -3;
    }
    paramInt2 = this.hEt.indexOf(localb);
    if ((paramInt2 >= 0) && (paramInt2 < this.hEt.size()))
    {
      if (((b)this.hEt.get(paramInt2)).a(parama, paramObject))
      {
        GMTrace.o(3536502915072L, 26349);
        return 0;
      }
      GMTrace.o(3536502915072L, 26349);
      return -4;
    }
    v.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] no found task, create a new task(" + paramLong1 + " " + paramLong2 + " " + paramInt1 + ")");
    localb.a(parama, paramObject);
    this.hEt.add(localb);
    fL(paramInt3);
    GMTrace.o(3536502915072L, 26349);
    return 0;
  }
  
  public final void a(int paramInt1, int paramInt2, k paramk)
  {
    GMTrace.i(3537845092352L, 26359);
    if (this.hEw != paramk)
    {
      v.d("ModelImage.DownloadImgService", "scene changed");
      GMTrace.o(3537845092352L, 26359);
      return;
    }
    Iterator localIterator = this.hEv.hEC.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.hEE != null) {
        localc.hEE.a(this.hEv.hEy, this.hEv.hEz, this.hEv.hEA, this.hEv.hEB, localc.hEF, paramInt1, paramInt2, paramk);
      }
    }
    GMTrace.o(3537845092352L, 26359);
  }
  
  public final void a(int paramInt1, int paramInt2, String paramString, k paramk)
  {
    GMTrace.i(3537710874624L, 26358);
    if (this.hEw != paramk)
    {
      v.d("ModelImage.DownloadImgService", "scene changed");
      GMTrace.o(3537710874624L, 26358);
      return;
    }
    this.hEu.add(new b(this.hEv.hEy, this.hEv.hEz, this.hEv.hEA));
    v.i("ModelImage.DownloadImgService", "scene end, (" + this.hEv.hEy + ", " + this.hEv.hEz + ", " + this.hEv.hEA + ")");
    Iterator localIterator = this.hEv.hEC.iterator();
    while (localIterator.hasNext())
    {
      c localc = (c)localIterator.next();
      if (localc.hEE != null) {
        localc.hEE.a(this.hEv.hEy, this.hEv.hEz, this.hEv.hEA, this.hEv.hEB, localc.hEF, paramInt1, paramInt2, paramString, paramk);
      }
    }
    this.hEv = null;
    this.hEw = null;
    fL(-1);
    GMTrace.o(3537710874624L, 26358);
  }
  
  public final void a(a parama)
  {
    GMTrace.i(3536905568256L, 26352);
    if (parama == null)
    {
      v.e("ModelImage.DownloadImgService", "listener is null");
      GMTrace.o(3536905568256L, 26352);
      return;
    }
    v.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] cancel all tasks of listener");
    this.hEx = true;
    if (this.hEv != null)
    {
      this.hEv.b(parama);
      a(this.hEv);
    }
    Object localObject1 = new LinkedList();
    Object localObject2 = this.hEt.iterator();
    while (((Iterator)localObject2).hasNext()) {
      ((List)localObject1).add((b)((Iterator)localObject2).next());
    }
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (b)((Iterator)localObject1).next();
      ((b)localObject2).b(parama);
      a((b)localObject2);
    }
    Gx();
    GMTrace.o(3536905568256L, 26352);
  }
  
  public final boolean a(long paramLong1, long paramLong2, int paramInt)
  {
    GMTrace.i(3536637132800L, 26350);
    b localb = new b(paramLong1, paramLong2, paramInt);
    if ((this.hEv != null) && (this.hEv.equals(localb)))
    {
      GMTrace.o(3536637132800L, 26350);
      return true;
    }
    if (this.hEt.indexOf(localb) >= 0)
    {
      GMTrace.o(3536637132800L, 26350);
      return true;
    }
    GMTrace.o(3536637132800L, 26350);
    return false;
  }
  
  public final boolean a(long paramLong1, long paramLong2, int paramInt1, Object paramObject, int paramInt2, a parama)
  {
    GMTrace.i(3536368697344L, 26348);
    if (a(paramLong1, paramLong2, paramInt1, paramObject, paramInt2, parama, -1) >= 0)
    {
      GMTrace.o(3536368697344L, 26348);
      return true;
    }
    GMTrace.o(3536368697344L, 26348);
    return false;
  }
  
  public final boolean a(long paramLong1, long paramLong2, a parama)
  {
    GMTrace.i(3536771350528L, 26351);
    if (parama == null)
    {
      v.e("ModelImage.DownloadImgService", "listener is null");
      GMTrace.o(3536771350528L, 26351);
      return false;
    }
    b localb2 = new b(paramLong1, paramLong2, 1);
    b localb1 = null;
    if ((this.hEv != null) && (this.hEv.equals(localb2))) {
      localb1 = this.hEv;
    }
    while (localb1 != null)
    {
      localb1.b(parama);
      a(localb1);
      v.i("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] task has been canceled, (" + paramLong1 + ", " + paramLong2 + ", 1)");
      GMTrace.o(3536771350528L, 26351);
      return true;
      int i = this.hEt.indexOf(localb2);
      if (-1 != i) {
        localb1 = (b)this.hEt.get(i);
      }
    }
    v.e("ModelImage.DownloadImgService", "[" + parama.hashCode() + "] task no found, (" + paramLong1 + ", " + paramLong2 + ", 1)");
    GMTrace.o(3536771350528L, 26351);
    return false;
  }
  
  final boolean b(b paramb)
  {
    GMTrace.i(3537308221440L, 26355);
    if (paramb == null)
    {
      v.e("ModelImage.DownloadImgService", "task is null");
      GMTrace.o(3537308221440L, 26355);
      return false;
    }
    v.i("ModelImage.DownloadImgService", "cancel scene, (" + paramb.hEy + ", " + paramb.hEz + ", " + paramb.hEA + ")");
    if ((this.hEv != null) && (this.hEv.equals(paramb)))
    {
      h.vH().gXs.c(this.hEw);
      this.hEw = null;
      c(this.hEv);
      this.hEv = null;
      fL(-1);
      GMTrace.o(3537308221440L, 26355);
      return true;
    }
    if (this.hEt.contains(paramb))
    {
      int i = this.hEt.indexOf(paramb);
      paramb = (b)this.hEt.get(i);
      if (paramb != null)
      {
        this.hEt.remove(paramb);
        c(paramb);
      }
      GMTrace.o(3537308221440L, 26355);
      return true;
    }
    GMTrace.o(3537308221440L, 26355);
    return false;
  }
  
  public final boolean e(long paramLong1, long paramLong2)
  {
    GMTrace.i(3537174003712L, 26354);
    boolean bool = b(new b(paramLong1, paramLong2, 1));
    GMTrace.o(3537174003712L, 26354);
    return bool;
  }
  
  public static abstract interface a
  {
    public abstract void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject);
    
    public abstract void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, k paramk);
    
    public abstract void a(long paramLong1, long paramLong2, int paramInt1, int paramInt2, Object paramObject, int paramInt3, int paramInt4, String paramString, k paramk);
  }
  
  private static final class b
  {
    public int hEA;
    public int hEB;
    public List<c.c> hEC;
    private int hED;
    public long hEy;
    public long hEz;
    
    public b(long paramLong1, long paramLong2, int paramInt)
    {
      GMTrace.i(3538381963264L, 26363);
      this.hED = 0;
      this.hEy = paramLong1;
      this.hEz = paramLong2;
      this.hEA = paramInt;
      this.hEB = 0;
      GMTrace.o(3538381963264L, 26363);
    }
    
    public final boolean a(c.a parama, Object paramObject)
    {
      GMTrace.i(3538516180992L, 26364);
      if (this.hEC == null) {
        this.hEC = new LinkedList();
      }
      parama = new c.c(parama, paramObject);
      if (this.hEC.contains(parama))
      {
        v.d("ModelImage.DownloadImgService.Task", "task item already exists");
        GMTrace.o(3538516180992L, 26364);
        return false;
      }
      this.hEC.add(parama);
      GMTrace.o(3538516180992L, 26364);
      return true;
    }
    
    public final boolean b(c.a parama)
    {
      GMTrace.i(3538650398720L, 26365);
      parama = new c.c(parama, null);
      if (this.hEC.contains(parama))
      {
        this.hEC.remove(parama);
        GMTrace.o(3538650398720L, 26365);
        return true;
      }
      GMTrace.o(3538650398720L, 26365);
      return false;
    }
    
    public final boolean equals(Object paramObject)
    {
      GMTrace.i(3538784616448L, 26366);
      if ((paramObject == null) || (!(paramObject instanceof b)))
      {
        GMTrace.o(3538784616448L, 26366);
        return false;
      }
      paramObject = (b)paramObject;
      if ((((b)paramObject).hEy == this.hEy) && (((b)paramObject).hEz == this.hEz) && (((b)paramObject).hEA == this.hEA))
      {
        GMTrace.o(3538784616448L, 26366);
        return true;
      }
      GMTrace.o(3538784616448L, 26366);
      return false;
    }
    
    public final int hashCode()
    {
      GMTrace.i(3538918834176L, 26367);
      if (this.hED == 0) {
        this.hED = (this.hEy + "_" + this.hEz + "_" + this.hEA).hashCode();
      }
      int i = this.hED;
      GMTrace.o(3538918834176L, 26367);
      return i;
    }
  }
  
  private static final class c
  {
    public c.a hEE;
    public Object hEF;
    
    public c(c.a parama, Object paramObject)
    {
      GMTrace.i(3508451409920L, 26140);
      this.hEE = parama;
      this.hEF = paramObject;
      GMTrace.o(3508451409920L, 26140);
    }
    
    public final boolean equals(Object paramObject)
    {
      GMTrace.i(3508585627648L, 26141);
      if ((paramObject == null) || (!(paramObject instanceof c)))
      {
        GMTrace.o(3508585627648L, 26141);
        return false;
      }
      paramObject = (c)paramObject;
      if (this.hEE == ((c)paramObject).hEE)
      {
        GMTrace.o(3508585627648L, 26141);
        return true;
      }
      GMTrace.o(3508585627648L, 26141);
      return false;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/ah/c.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */