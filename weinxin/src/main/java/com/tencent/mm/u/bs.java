package com.tencent.mm.u;

import com.tencent.gmtrace.GMTrace;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.au;
import com.tencent.mm.y.d;
import com.tencent.mm.y.d.a;
import com.tencent.mm.y.d.b;
import java.io.ByteArrayInputStream;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public final class bs
  implements d
{
  public bs()
  {
    GMTrace.i(600624332800L, 4475);
    GMTrace.o(600624332800L, 4475);
  }
  
  public final d.b b(d.a parama)
  {
    GMTrace.i(600758550528L, 4476);
    parama = parama.hsc;
    if ((parama == null) || (parama.tdz == null))
    {
      v.f("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension failed, invalid cmdAM");
      GMTrace.o(600758550528L, 4476);
      return null;
    }
    v.i("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension start");
    parama = com.tencent.mm.platformtools.n.a(parama.tdz);
    Object localObject = DocumentBuilderFactory.newInstance();
    for (;;)
    {
      int i;
      try
      {
        parama = ((DocumentBuilderFactory)localObject).newDocumentBuilder().parse(new InputSource(new ByteArrayInputStream(parama.getBytes("utf-8"))));
        parama.normalize();
        parama = parama.getDocumentElement().getElementsByTagName("updatepackage");
        if ((parama != null) && (parama.getLength() == 1))
        {
          parama = parama.item(0).getChildNodes();
          int j = parama.getLength();
          i = 0;
          if (i < j)
          {
            localObject = parama.item(i);
            if ((localObject == null) || (((Node)localObject).getNodeName() == null) || (!((Node)localObject).getNodeName().equals("pack"))) {
              break label306;
            }
            localObject = ((Node)localObject).getAttributes();
            if (localObject == null) {
              break label306;
            }
            localObject = ((NamedNodeMap)localObject).getNamedItem("type");
            if (localObject == null) {
              break label306;
            }
            localObject = new com.tencent.mm.ap.k(bf.getInt(((Node)localObject).getNodeValue(), 0));
            h.vH().gXs.a((com.tencent.mm.y.k)localObject, 0);
            break label306;
          }
        }
        v.i("MicroMsg.UpdatePackageMsgExtension", "[oneliang]UpdatePackageMsgExtension end");
        GMTrace.o(600758550528L, 4476);
        return null;
      }
      catch (Exception parama)
      {
        v.e("MicroMsg.UpdatePackageMsgExtension", "exception:%s", new Object[] { bf.g(parama) });
        GMTrace.o(600758550528L, 4476);
        return null;
      }
      label306:
      i += 1;
    }
  }
  
  public final void h(au paramau)
  {
    GMTrace.i(600892768256L, 4477);
    GMTrace.o(600892768256L, 4477);
  }
}


/* Location:              /home/chengjian/weinxin/weinxin_1100/classes.jar!/com/tencent/mm/u/bs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */