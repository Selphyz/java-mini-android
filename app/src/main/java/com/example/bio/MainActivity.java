package com.example.bio;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button myButton = findViewById(R.id.myButton);
        myButton.setOnClickListener(this::showInfo);
    }

    private void showInfo(View view) {
        final CoordinatorLayout coordinatorLayout = findViewById(R.id.milayout);
        String mensaje = "Este es un mensaje largo que puede extenderse. Voy a contar mi vida y hacer un poco de relleno " +
                "porque quiero testear que esto pueda alargarse hasta casi el infinito o que almenos sea muy largo";
        Snackbar snackbar = Snackbar.make(coordinatorLayout, mensaje, Snackbar.LENGTH_INDEFINITE);
        View snackbarView = snackbar.getView();
        ViewCompat.setBackground(snackbarView, getRoundRectShape(48));
        ViewGroup.LayoutParams params = snackbarView.getLayoutParams();
        if (params instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginParams = (ViewGroup.MarginLayoutParams) params;
            marginParams.setMargins(10, 0, 10, 10); // Establece el margen en píxeles
        }
        TextView textView = snackbarView.findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextSize(20);
        textView.setMaxLines(6); // Establece el número máximo de líneas para mostrar
        textView.setEllipsize(null); // Permite que el texto se extienda a más líneas
        snackbar.show();
        snackbarView.setOnClickListener(v -> snackbar.dismiss());
    }

    private Drawable getRoundRectShape(int cornerRadius) {
        GradientDrawable shape = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.RED, Color.BLUE});
        shape.setShape(GradientDrawable.RECTANGLE);
        shape.setCornerRadius(cornerRadius);
//        shape.setColor(Color.GREEN); // Cambia el color de fondo según tus preferencias
        return shape;
    }
}