package com.jaime.easit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.viewpager.widget.PagerAdapter;

public class SliderIntroAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;
    private int currentPlayingIndex; // Keep this as gloabal variable

    public SliderIntroAdapter(Context context){

        this.context=context;
    }




    // ArraysImgs
    public int[] slide_images = {
            R.drawable.logoeasit,
            R.drawable.imgcategorias,
            R.drawable.imgbuscador,
            R.drawable.imgmenudesplegable,
            R.drawable.imgchatbot,
            R.drawable.imgtop5apps,
            R.drawable.imgappsdentrocategoria,
            R.drawable.imgbotonesacciones,
            R.drawable.imgpasos,
            R.drawable.imgletraseasit,
    };

    public String [] slide_headings = {
            "BIENVENIDO",
            "PANTALLA PRINCIPAL",
            "BUSCAR APPS",
            "MENÚ DESPLEGABLE",
            "CHATBOT DE EASIT",
            "TOP 5 APPS BY EAS!T",
            "DENTRO DE LAS CATEGORÍAS",
            "ACCIONES DE CADA APP",
            "PASOS",
            "ENJOY IT!"
    };

    public String [] slide_descs = {
            "Bienvenido a Easit, una aplicación que pone a su disposición guías de iniciación en las aplicaciones más populares y valoradas de Google Play Store.",
            "Las aplicaciones están organizadas en 6 categorías principales, donde podrá encontrar la app que desee de manera más eficiente e intuitiva.",
            "En la barra superior encontrará un símbolo de una lupa, el cuál le permitirá buscar directamente la aplicación que desea.",
            "Por otro lado en la barra superior en la parte izquierda, podrá encontrar un menú desplegable, donde podrá realizar diferentes tareas como cambiar el tema de la app de Easit.",
                    "Dentro del menú desplegable podrá interactuar con nuestro ChatBot exclusivo, el cuál le resolverá cualquier duda sobre las aplicaciones de las que disponga Easit y sobre nuestra aplicación en general.",
            "En la parte inferior de la pantalla principal, ¡podrá encontrar una lista deslizable del top 5 de las mejores aplicaciones seleccionadas especialmente por el equipo de Easit!",
            "Al pinchar en una categoría apareceran las 5 apps más populares de dicha categoría, con una pequeña descripción " +
                    "y un enlace directo a la Google Play Store para poder descargarla al instante.",
            "Una vez seleccionada la app, aparecerán las acciones más básicas y fundamentales de dicha aplicación, así podrá acceder a la que desee sin tener que ver las demás.",
            "Deslice la pantalla para ver los distintos pasos para realizar la acción que ha seleecionado previamente, tambien puede pulsar los botones inferiores.",
            "¡Hora de empezar a descubrir Easit!"
    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject( View view, Object o) {
        return view==(RelativeLayout) o;
    }


    @Override
    public Object instantiateItem( ViewGroup container, int position) {

        layoutInflater=(LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slidewizard_layout,container,false);

        ImageView slideImageView=(ImageView) view.findViewById(R.id.slideImage);
        TextView slideHeading=(TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription=(TextView) view.findViewById(R.id.slide_desc);

        slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);




        container.addView(view);


        return view;
    }

    @Override
    public void destroyItem( ViewGroup container, int position,  Object object) {
        container.removeView((RelativeLayout)object);
    }
}
