package AdapterPhone;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.malthshop.R;
import com.squareup.picasso.Picasso;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import InterfaceForPhoneManager.OnEventClickElectronicComponent;
import ModelPhone.Electronic;
import SharePreferencesManager.SavePreferences;

public class RecyclerViewElectronicAdapter extends RecyclerView.Adapter<RecyclerViewElectronicAdapter.ElectronicViewHolder> {
    private Context context;
    private List<Electronic> list;
    private OnEventClickElectronicComponent onEventClickElectronicComponent;

    public RecyclerViewElectronicAdapter(Context context, List<Electronic> list, OnEventClickElectronicComponent onEventClickElectronicComponent) {
        this.context = context;
        this.list = list;
        this.onEventClickElectronicComponent = onEventClickElectronicComponent;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public ElectronicViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_linh_kien, parent, false);
        return new ElectronicViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull ElectronicViewHolder holder, int position) {
        Electronic electronic= list.get(position);
        holder.tvNameElectronic.setText(electronic.getComponentName());
        holder.tvPrice.setText(electronic.getPrice()+"");
        Picasso.get().load(electronic.getComponentImage())
                .placeholder(R.drawable.ic_baseline_home_24)
                .error(R.drawable.ic_baseline_error_24)
                .into(holder.imgElectronic);
        holder.cvContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onEventClickElectronicComponent.onClick(electronic);
            }
        });
    }
    private final int limit = 2;
    @Override
    public int getItemCount() {
        if(list.size() > limit){
            return limit;
        }else {
            return list.size();
        }
    }




    public class ElectronicViewHolder extends RecyclerView.ViewHolder {
        private CardView cvContainer;
        private ImageView imgElectronic;
        private TextView tvNameElectronic;
        private TextView tvPrice;
        public ElectronicViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            cvContainer = itemView.findViewById(R.id.cv_container);
            imgElectronic = itemView.findViewById(R.id.img_electronic);
            tvNameElectronic = itemView.findViewById(R.id.tv_nameElectronic);
            tvPrice = itemView.findViewById(R.id.tv_price);
        }
    }
}
