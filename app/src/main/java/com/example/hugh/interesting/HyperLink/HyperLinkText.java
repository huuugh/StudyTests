package com.example.hugh.interesting.HyperLink;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

/**
 * Created by Hugh on 2019/3/8.
 *
 */

public abstract class HyperLinkText extends ClickableSpan {
    private Context context;

      public HyperLinkText(Context context) {
         this.context = context;
      }

      @Override
      public void updateDrawState(TextPaint ds) {
         super.updateDrawState(ds);
         //设置文本的颜色
         ds.setColor(Color.parseColor("#4690EF"));
         //超链接形式的下划线，false 表示不显示下划线，true表示显示下划线
         ds.setUnderlineText(false);
      }

      @Override
      public abstract void onClick(View widget);
}
