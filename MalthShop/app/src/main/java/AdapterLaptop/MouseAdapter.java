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

import IntefaceForLaptopManager.OnEventClickMouseListener;
import ModelLaptop.Mouse;
import SharePreferencesManager.SavePreferences;

public class MouseAdapter extends RecyclerView.Adapter<MouseAdapter.MouseViewHolder> {
    private Context context;
    private List<Mouse> mListMouse;
    private OnEventClickMouseListener onEventClickMouseListener;

    public MouseAdapter(Context context, List<Mouse> mListMouse, OnEventClickMouseListener onEventClickMouseListener) {
        this.context = context;
        this.mListMouse = mListMouse;
        this.onEventClickMouseListener =onEventClickMouseListener;
    }

    @NonNull

    @Override
    public MouseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_rv_mouse, parent, false);
        return new MouseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MouseViewHolder holder, int position) {
        Mouse product = mListMouse.get(position);
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtPriceMouse.setText(decimalFormat.format(product.getMousePrice())+"");
        holder.txtNameMouse.setText(product.getMouseName());
        Picasso.get().load(product.getMouseImage())
                .placeholder(R.drawable.laptop)
                .error(R.drawable.ic_home)
                .into(holder.imgMouse);
        holder.lvContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onEventClickMouseListener.onClick(product);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mListMouse.size();
    }



    public class MouseViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNameMouse;
        private TextView txtPriceMouse;
        private ImageView imgMouse;
        private LinearLayout lvContainer;

        public MouseViewHolder(@NonNull View itemView) {
            super(itemView);
            lvContainer = (LinearLayout) itemView.findViewById(R.id.lv_container);
            txtNameMouse = (TextView) itemView.findViewById(R.id.txtNameMouse);
            txtPriceMouse = (TextView) itemView.findViewById(R.id.txtPriceMouse);
            imgMouse = (ImageView) itemView.findViewById(R.id.imgMouse);
        }
    }
}
