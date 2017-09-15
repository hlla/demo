package com.tencent.mm.storage;

import android.database.Cursor;
import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public final class d
  extends i<c>
{
  public static final String[] gUn;
  private final e gUp;
  
  static
  {
    GMTrace.i(1581621706752L, 11784);
    gUn = new String[] { i.a(c.gTF, "ABTestItem") };
    GMTrace.o(1581621706752L, 11784);
  }
  
  public d(e parame)
  {
    super(parame, c.gTF, "ABTestItem", null);
    GMTrace.i(1580816400384L, 11778);
    this.gUp = parame;
    GMTrace.o(1580816400384L, 11778);
  }
  
  public final Map<String, c> QC(String paramString)
  {
    GMTrace.i(1581084835840L, 11780);
    if (bf.mA(paramString)) {}
    for (paramString = null; (paramString == null) || (!paramString.moveToFirst()); paramString = rawQuery(String.format("select * from %s where %s = %s", new Object[] { "ABTestItem", "business", paramString }), new String[0]))
    {
      if (paramString != null) {
        paramString.close();
      }
      paramString = new HashMap(0);
      GMTrace.o(1581084835840L, 11780);
      return paramString;
    }
    HashMap localHashMap = new HashMap();
    do
    {
      c localc = new c();
      localc.b(paramString);
      localHashMap.put(localc.field_layerId, localc);
    } while (paramString.moveToNext());
    paramString.close();
    GMTrace.o(1581084835840L, 11780);
    return localHashMap;
  }
  
  public final LinkedList<qc> bKy()
  {
    GMTrace.i(1581487489024L, 11783);
    LinkedList localLinkedList = new LinkedList();
    Cursor localCursor = Kl();
    if ((localCursor == null) || (!localCursor.moveToFirst()))
    {
      GMTrace.o(1581487489024L, 11783);
      return localLinkedList;
    }
    c localc = new c();
    for (;;)
    {
      localc.b(localCursor);
      qc localqc = new qc();
      try
      {
        localqc.trS = bf.getInt(localc.field_expId, 0);
        localqc.priority = localc.field_prioritylevel;
        localLinkedList.add(localqc);
        if (localCursor.moveToNext()) {
          continue;
        }
        localCursor.close();
        GMTrace.o(1581487489024L, 11783);
        return localLinkedList;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          v.e("MicroMsg.ABTestStorage", "expId parse failed, %s", new Object[] { localc.field_expId });
        }
      }
    }
  }
  
  public final String bKz()
  {
    GMTrace.i(1581353271296L, 11782);
    Object localObject = Kl();
    if (localObject == null)
    {
      GMTrace.o(1581353271296L, 11782);
      return "null cursor!!";
    }
    if (!((Cursor)localObject).moveToFirst())
    {
      ((Cursor)localObject).close();
      GMTrace.o(1581353271296L, 11782);
      return "cursor empty!!";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    c localc = new c();
    do
    {
      localStringBuilder.append("============\n");
      localc.b((Cursor)localObject);
      localStringBuilder.append("layerId = ").append(localc.field_layerId).append("\n");
      localStringBuilder.append("sequence = ").append(localc.field_sequence).append("\n");
      localStringBuilder.append("priorityLV = ").append(localc.field_prioritylevel).append("\n");
      localStringBuilder.append("expId = ").append(localc.field_expId).append("\n");
    } while (((Cursor)localObject).moveToNext());
    ((Cursor)localObject).close();
    localObject = localStringBuilder.toString();
    GMTrace.o(1581353271296L, 11782);
    return (String)localObject;
  }
  
  public final c dX(String paramString)
  {
    GMTrace.i(1580950618112L, 11779);
    c localc = new c();
    localc.field_layerId = paramString;
    boolean bool = super.b(localc, new String[0]);
    if ((bool) && (localc.field_endTime == 0L)) {
      localc.field_endTime = Long.MAX_VALUE;
    }
    v.i("MicroMsg.ABTestStorage", "getByLayerId, id: %s, return: %b", new Object[] { paramString, Boolean.valueOf(bool) });
    GMTrace.o(1580950618112L, 11779);
    return localc;
  }
  
  public final void i(List<c> paramList, int paramInt)
  {
    GMTrace.i(1581219053568L, 11781);
    int i = 0;
    long l = bf.Nz();
    this.gUp.delete("ABTestItem", String.format(Locale.US, "%s<>0 and %s<%d", new Object[] { "endTime", "endTime", Long.valueOf(l) }), null);
    c localc1;
    if (paramInt == 0)
    {
      localc1 = new c();
      localc1.field_prioritylevel = 1;
      b(localc1, false, new String[] { "prioritylevel" });
    }
    paramList = paramList.iterator();
    paramInt = i;
    boolean bool;
    if (paramList.hasNext())
    {
      localc1 = (c)paramList.next();
      if ((localc1 == null) || (bf.mA(localc1.field_layerId)))
      {
        v.e("MicroMsg.ABTestStorage", "saveIfNecessary, Invalid item");
        bool = false;
        label151:
        if (!bool) {
          break label453;
        }
        paramInt = 1;
      }
    }
    label453:
    for (;;)
    {
      break;
      c localc2 = new c();
      localc2.field_layerId = localc1.field_layerId;
      if (!super.b(localc2, new String[0]))
      {
        bool = super.a(localc1, false);
        v.i("MicroMsg.ABTestStorage", "Inserted: %s, Result: %b", new Object[] { localc1.field_layerId, Boolean.valueOf(bool) });
        break label151;
      }
      if (((localc1.field_sequence > localc2.field_sequence) && (localc1.field_prioritylevel == localc2.field_prioritylevel)) || (localc1.field_prioritylevel > localc2.field_prioritylevel))
      {
        bool = super.a(localc1, false, new String[0]);
        v.i("MicroMsg.ABTestStorage", "Updated: %s, Result: %b, Seq: %d, %d, PriorityLV: %d, %d", new Object[] { localc1.field_layerId, Boolean.valueOf(bool), Long.valueOf(localc2.field_sequence), Long.valueOf(localc1.field_sequence), Integer.valueOf(localc2.field_prioritylevel), Integer.valueOf(localc1.field_prioritylevel) });
        break label151;
      }
      v.i("MicroMsg.ABTestStorage", "Ignored: %s, Seq: %d, %d, PriorityLV: %d, %d", new Object[] { localc1.field_layerId, Long.valueOf(localc2.field_sequence), Long.valueOf(localc1.field_sequence), Integer.valueOf(localc2.field_prioritylevel), Integer.valueOf(localc1.field_prioritylevel) });
      bool = false;
      break label151;
      if (paramInt != 0) {
        Qq("event_updated");
      }
      GMTrace.o(1581219053568L, 11781);
      return;
    }
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/storage/d.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */