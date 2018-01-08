package com.android.launcher2;

import java.lang.reflect.Field;

public class ShadowStyleable
{
  public static int[] FrameLayout_Layout;
  public static int FrameLayout_Layout_layout_gravity;
  public static int[] LinearLayout;
  public static int[] LinearLayout_Layout;
  public static int LinearLayout_Layout_layout_gravity;
  public static int LinearLayout_Layout_layout_height;
  public static int LinearLayout_Layout_layout_weight;
  public static int LinearLayout_Layout_layout_width;
  public static int LinearLayout_baselineAligned;
  public static int LinearLayout_baselineAlignedChildIndex;
  public static int LinearLayout_divider;
  public static int LinearLayout_dividerPadding;
  public static int LinearLayout_gravity;
  public static int LinearLayout_measureWithLargestChild;
  public static int LinearLayout_orientation;
  public static int LinearLayout_showDividers;
  public static int[] TextView;
  public static int TextView_drawablePadding;
  public static int TextView_ellipsize;
  public static int TextView_gravity;
  public static int TextView_lines;
  public static int TextView_scrollHorizontally;
  public static int TextView_singleLine;
  public static int TextView_textSize;
  public static int[] View;
  public static int[] ViewGroup_Layout;
  public static int ViewGroup_Layout_layout_height;
  public static int ViewGroup_Layout_layout_width;
  public static int[] ViewGroup_MarginLayout;
  public static int ViewGroup_MarginLayout_layout_height;
  public static int ViewGroup_MarginLayout_layout_margin;
  public static int ViewGroup_MarginLayout_layout_marginBottom;
  public static int ViewGroup_MarginLayout_layout_marginLeft;
  public static int ViewGroup_MarginLayout_layout_marginRight;
  public static int ViewGroup_MarginLayout_layout_marginTop;
  public static int ViewGroup_MarginLayout_layout_width;
  public static int View_alpha;
  public static int View_background;
  public static int View_clickable;
  public static int View_longClickable;
  public static int View_minHeight;
  public static int View_minWidth;
  public static int View_padding;
  public static int View_paddingBottom;
  public static int View_paddingLeft;
  public static int View_paddingRight;
  public static int View_paddingTop;
  public static int View_rotation;
  public static int View_rotationX;
  public static int View_rotationY;
  public static int View_scaleX;
  public static int View_scaleY;
  public static int View_transformPivotX;
  public static int View_transformPivotY;
  public static int View_translationX;
  public static int View_translationY;
  
  public static void init()
  {
    Class localClass = Reflection.getClass("android.R$styleable");
    try
    {
      View = (int[])Reflection.getFieldValue(localClass, Reflection.getField(localClass, "View", true));
      View_alpha = Reflection.getField(localClass, "View_alpha", true).getInt(localClass);
      View_background = Reflection.getField(localClass, "View_background", true).getInt(localClass);
      View_clickable = Reflection.getField(localClass, "View_clickable", true).getInt(localClass);
      View_longClickable = Reflection.getField(localClass, "View_longClickable", true).getInt(localClass);
      View_minHeight = Reflection.getField(localClass, "View_minHeight", true).getInt(localClass);
      View_minWidth = Reflection.getField(localClass, "View_minWidth", true).getInt(localClass);
      View_padding = Reflection.getField(localClass, "View_padding", true).getInt(localClass);
      View_paddingBottom = Reflection.getField(localClass, "View_paddingBottom", true).getInt(localClass);
      View_paddingLeft = Reflection.getField(localClass, "View_paddingLeft", true).getInt(localClass);
      View_paddingRight = Reflection.getField(localClass, "View_paddingRight", true).getInt(localClass);
      View_paddingTop = Reflection.getField(localClass, "View_paddingTop", true).getInt(localClass);
      View_rotation = Reflection.getField(localClass, "View_rotation", true).getInt(localClass);
      View_rotationX = Reflection.getField(localClass, "View_rotationX", true).getInt(localClass);
      View_rotationY = Reflection.getField(localClass, "View_rotationY", true).getInt(localClass);
      View_scaleX = Reflection.getField(localClass, "View_scaleX", true).getInt(localClass);
      View_scaleY = Reflection.getField(localClass, "View_scaleY", true).getInt(localClass);
      View_transformPivotX = Reflection.getField(localClass, "View_transformPivotX", true).getInt(localClass);
      View_transformPivotY = Reflection.getField(localClass, "View_transformPivotY", true).getInt(localClass);
      View_translationX = Reflection.getField(localClass, "View_translationX", true).getInt(localClass);
      View_translationY = Reflection.getField(localClass, "View_translationY", true).getInt(localClass);
      TextView = (int[])Reflection.getFieldValue(localClass, Reflection.getField(localClass, "TextView", true));
      TextView_drawablePadding = Reflection.getField(localClass, "TextView_drawablePadding", true).getInt(localClass);
      TextView_ellipsize = Reflection.getField(localClass, "TextView_ellipsize", true).getInt(localClass);
      TextView_gravity = Reflection.getField(localClass, "TextView_gravity", true).getInt(localClass);
      TextView_lines = Reflection.getField(localClass, "TextView_lines", true).getInt(localClass);
      TextView_scrollHorizontally = Reflection.getField(localClass, "TextView_scrollHorizontally", true).getInt(localClass);
      TextView_singleLine = Reflection.getField(localClass, "TextView_singleLine", true).getInt(localClass);
      TextView_textSize = Reflection.getField(localClass, "TextView_textSize", true).getInt(localClass);
      FrameLayout_Layout = (int[])Reflection.getFieldValue(localClass, Reflection.getField(localClass, "FrameLayout_Layout", true));
      TextView_drawablePadding = Reflection.getField(localClass, "TextView_drawablePadding", true).getInt(localClass);
      LinearLayout = (int[])Reflection.getFieldValue(localClass, Reflection.getField(localClass, "LinearLayout", true));
      LinearLayout_baselineAligned = Reflection.getField(localClass, "LinearLayout_baselineAligned", true).getInt(localClass);
      LinearLayout_baselineAlignedChildIndex = Reflection.getField(localClass, "LinearLayout_baselineAlignedChildIndex", true).getInt(localClass);
      LinearLayout_divider = Reflection.getField(localClass, "LinearLayout_divider", true).getInt(localClass);
      LinearLayout_dividerPadding = Reflection.getField(localClass, "LinearLayout_dividerPadding", true).getInt(localClass);
      LinearLayout_gravity = Reflection.getField(localClass, "LinearLayout_gravity", true).getInt(localClass);
      LinearLayout_measureWithLargestChild = Reflection.getField(localClass, "LinearLayout_measureWithLargestChild", true).getInt(localClass);
      LinearLayout_orientation = Reflection.getField(localClass, "LinearLayout_orientation", true).getInt(localClass);
      LinearLayout_showDividers = Reflection.getField(localClass, "LinearLayout_showDividers", true).getInt(localClass);
      LinearLayout_Layout = (int[])Reflection.getFieldValue(localClass, Reflection.getField(localClass, "LinearLayout_Layout", true));
      LinearLayout_Layout_layout_gravity = Reflection.getField(localClass, "LinearLayout_Layout_layout_gravity", true).getInt(localClass);
      LinearLayout_Layout_layout_height = Reflection.getField(localClass, "LinearLayout_Layout_layout_height", true).getInt(localClass);
      LinearLayout_Layout_layout_weight = Reflection.getField(localClass, "LinearLayout_Layout_layout_weight", true).getInt(localClass);
      LinearLayout_Layout_layout_width = Reflection.getField(localClass, "LinearLayout_Layout_layout_width", true).getInt(localClass);
      ViewGroup_Layout = (int[])Reflection.getFieldValue(localClass, Reflection.getField(localClass, "ViewGroup_Layout", true));
      ViewGroup_Layout_layout_height = Reflection.getField(localClass, "ViewGroup_Layout_layout_height", true).getInt(localClass);
      ViewGroup_Layout_layout_width = Reflection.getField(localClass, "ViewGroup_Layout_layout_width", true).getInt(localClass);
      ViewGroup_MarginLayout = (int[])Reflection.getFieldValue(localClass, Reflection.getField(localClass, "ViewGroup_MarginLayout", true));
      ViewGroup_MarginLayout_layout_height = Reflection.getField(localClass, "ViewGroup_MarginLayout_layout_height", true).getInt(localClass);
      ViewGroup_MarginLayout_layout_margin = Reflection.getField(localClass, "ViewGroup_MarginLayout_layout_margin", true).getInt(localClass);
      ViewGroup_MarginLayout_layout_marginBottom = Reflection.getField(localClass, "ViewGroup_MarginLayout_layout_marginBottom", true).getInt(localClass);
      ViewGroup_MarginLayout_layout_marginLeft = Reflection.getField(localClass, "ViewGroup_MarginLayout_layout_marginLeft", true).getInt(localClass);
      ViewGroup_MarginLayout_layout_marginRight = Reflection.getField(localClass, "ViewGroup_MarginLayout_layout_marginRight", true).getInt(localClass);
      ViewGroup_MarginLayout_layout_marginTop = Reflection.getField(localClass, "ViewGroup_MarginLayout_layout_marginTop", true).getInt(localClass);
      ViewGroup_MarginLayout_layout_width = Reflection.getField(localClass, "ViewGroup_MarginLayout_layout_width", true).getInt(localClass);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
    }
  }
}


/* Location:              /home/chengjian/CM/phone_launcher/samsung_launcher/apk/1.jar!/com/android/launcher2/ShadowStyleable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */