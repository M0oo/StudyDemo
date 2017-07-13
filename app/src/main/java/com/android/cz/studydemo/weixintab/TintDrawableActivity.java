package com.android.cz.studydemo.weixintab;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.android.cz.studydemo.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TintDrawableActivity extends AppCompatActivity {

    @BindView(R.id.edit_text)
    public EditText editText;
    @BindView(R.id.edit_text2)
    public EditText edit_text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tint_drawable);
        ButterKnife.bind(this);

        Drawable d = tintDrawable(editText.getBackground(),
                getResources().getColorStateList(R.color.edittext_tint_colors));
        editText.setBackground(d);
        edit_text2.setBackground(d);
    }

    public static Drawable tintDrawable(Drawable drawable, ColorStateList colors) {
        final Drawable wrappedDrawable = DrawableCompat.wrap(drawable);
        DrawableCompat.setTintList(wrappedDrawable, colors);
        return wrappedDrawable;
    }
}
