package com.android.common.content;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ProjectionMap
  extends HashMap<String, String>
{
  private String[] mColumns;
  
  public static Builder builder()
  {
    return new Builder();
  }
  
  private void putColumn(String paramString1, String paramString2)
  {
    super.put(paramString1, paramString2);
  }
  
  public String[] getColumnNames()
  {
    return this.mColumns;
  }
  
  public String put(String paramString1, String paramString2)
  {
    throw new UnsupportedOperationException();
  }
  
  public void putAll(Map<? extends String, ? extends String> paramMap)
  {
    throw new UnsupportedOperationException();
  }
  
  public static class Builder
  {
    private ProjectionMap mMap = new ProjectionMap();
    
    public Builder add(String paramString)
    {
      this.mMap.putColumn(paramString, paramString);
      return this;
    }
    
    public Builder add(String paramString1, String paramString2)
    {
      this.mMap.putColumn(paramString1, paramString2 + " AS " + paramString1);
      return this;
    }
    
    public Builder addAll(ProjectionMap paramProjectionMap)
    {
      paramProjectionMap = paramProjectionMap.entrySet().iterator();
      while (paramProjectionMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramProjectionMap.next();
        this.mMap.putColumn((String)localEntry.getKey(), (String)localEntry.getValue());
      }
      return this;
    }
    
    public Builder addAll(String[] paramArrayOfString)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        add(paramArrayOfString[i]);
        i += 1;
      }
      return this;
    }
    
    public ProjectionMap build()
    {
      String[] arrayOfString = new String[this.mMap.size()];
      this.mMap.keySet().toArray(arrayOfString);
      Arrays.sort(arrayOfString);
      ProjectionMap.access$102(this.mMap, arrayOfString);
      return this.mMap;
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/common/content/ProjectionMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */