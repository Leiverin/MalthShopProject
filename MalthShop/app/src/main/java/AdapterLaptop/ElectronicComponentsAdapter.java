package AdapterLaptop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.malthshop.R;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

import IntefaceForLaptopManager.OnEventClickComponentLaptopListener;
import ModelLaptop.ElectronicComponents;
import SharePreferencesManager.SavePreferences;

public class ElectronicComponentsAdapter extends RecyclerView.Adapter<ElectronicComponentsAdapter.AccessoryViewHolder> {
    private Context context;
    private List<ElectronicComponents> mListElectronicComponents;
    private OnEventClickComponentLaptopListener onEventClickComponentLaptopListener;

    public ElectronicComponentsAdapter(Context context, List<ElectronicComponents> mListElectronicComponents, OnEventClickComponentLaptopListener onEventClickComponentLaptopListener) {
        this.context = context;
        this.mListElectronicComponents = mListElectronicComponents;
        this.onEventClickComponentLaptopListener = onEventClickComponentLaptopListener;
    }

    @NonNull

    @Override
    public AccessoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_rv_accessory, parent, false);
        return new AccessoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AccessoryViewHolder holder, int position) {
        ElectronicComponents electronicComponents = mListElectronicComponents.get(position);
        holder.txtNameAccessory.setText(electronicComponents.getComponentName());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtPriceAccessory.setText(decimalFormat.format(electronicComponents.getPrice())+"");
        Picasso.get().load(electronicComponents.getComponentImage())
                .placeholder(R.drawable.laptop)
                .error(R.drawable.ic_home)
                .into(holder.imgAccessory);
        holder.lvContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onEventClickComponentLaptopListener.onClick(electronicComponents);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListElectronicComponents.size();
    }



    public class AccessoryViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNameAccessory;
        private TextView txtPriceAccessory;
        private ImageView imgAccessory;
        private LinearLayout lvContainer;

        public AccessoryViewHolder(@NonNull View itemView) {
            super(itemView);
            lvContainer = (LinearLayout) itemView.findViewById(R.id.lv_container);
            txtNameAccessory = (TextView) itemView.findViewById(R.id.txtNameAccessory);
            txtPriceAccessory = (TextView) itemView.findViewById(R.id.txtPriceAccessory);
            imgAccessory = (ImageView) itemView.findViewById(R.id.imgAccessory);


        }
    }
}
