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

import IntefaceForLaptopManager.OnEventClickProductListener;
import ModelLaptop.Product;
import SharePreferencesManager.SavePreferences;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {
    private Context context;
    private List<Product> mListProduct;
    private OnEventClickProductListener onEventClickProductListener;

    public ProductAdapter(Context context, List<Product> mListProduct,OnEventClickProductListener onEventClickProductListener) {
        this.context = context;
        this.mListProduct = mListProduct;
        this.onEventClickProductListener = onEventClickProductListener;
    }

    @NonNull

    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context.getApplicationContext()).inflate(R.layout.item_rv_laptop_new, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = mListProduct.get(position);

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.txtPriceLaptopNew.setText(decimalFormat.format(product.getPrice())+"");
        holder.txtNameLaptopNew.setText(product.getProductName());
        Picasso.get().load(product.getImageProduct())
                .placeholder(R.drawable.laptop)
                .error(R.drawable.ic_home)
                .into(holder.imgLaptopNew);
        holder.lvContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onEventClickProductListener.onClick(product);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mListProduct.size();
    }



    public class ProductViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNameLaptopNew;
        private TextView txtPriceLaptopNew;
        private ImageView imgLaptopNew;
        private LinearLayout lvContainer;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            lvContainer = (LinearLayout) itemView.findViewById(R.id.lv_container);
            txtNameLaptopNew = (TextView) itemView.findViewById(R.id.txtNameLaptopNew);
            txtPriceLaptopNew = (TextView) itemView.findViewById(R.id.txtPriceLaptopNew);
            imgLaptopNew = (ImageView) itemView.findViewById(R.id.imgLaptopNew);
        }
    }
}
