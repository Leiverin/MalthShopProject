package AdapterHome;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.malthshop.MainActivity;
import com.example.malthshop.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import InterfaceForHomeManager.OnEventShowComponentListener;
import Login.LoginActivity;
import Login.RegisterActivity;
import ModelHome.Component;
import SharePreferencesManager.SavePreferences;

public class ComponentAdapter extends RecyclerView.Adapter<ComponentAdapter.ComponentViewHolder> {
    private Context context;
    private List<Component> mListComponent;
    private OnEventShowComponentListener onEventShowComponentListener;

    public ComponentAdapter(Context context, List<Component> mListComponent, OnEventShowComponentListener onEventShowComponentListener) {
        this.context = context;
        this.mListComponent = mListComponent;
        this.onEventShowComponentListener = onEventShowComponentListener;
    }

    @NonNull
    @NotNull
    @Override
    public ComponentViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_component_product, parent, false);
        return new ComponentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ComponentViewHolder holder, int position) {
        Component component = mListComponent.get(position);
        if(component == null){
            return;
        }else{
            holder.populate(component);
            holder.cvContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onEventShowComponentListener.onShowComponent(component);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mListComponent != null ? mListComponent.size()-46 : 0;
    }

    public class ComponentViewHolder extends RecyclerView.ViewHolder {

        private CardView cvContainer;
        private ImageView imgComponent;
        private TextView tvPriceComponent;

        public ComponentViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            cvContainer = (CardView) itemView.findViewById(R.id.cv_container);
            imgComponent = (ImageView) itemView.findViewById(R.id.img_component);
            tvPriceComponent = (TextView) itemView.findViewById(R.id.tv_price_component);
        }
        public void populate(Component component){
            Glide.with(context).load(component.getComponentImage()).into(imgComponent);
            tvPriceComponent.setText((component.getPrice()/100)+"K");
        }
    }
}
