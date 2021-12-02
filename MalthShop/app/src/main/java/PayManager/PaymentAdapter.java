package PayManager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.malthshop.R;

import org.jetbrains.annotations.NotNull;

import java.text.DecimalFormat;
import java.util.List;

public class PaymentAdapter extends RecyclerView.Adapter<PaymentAdapter.PaymentViewHolder> {
    private Context context;
    private List<PayProduct> mListPay;

    public PaymentAdapter(Context context, List<PayProduct> mListPay) {
        this.context = context;
        this.mListPay = mListPay;
    }

    @NonNull
    @NotNull
    @Override
    public PaymentViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pay_product, parent, false);
        return new PaymentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull PaymentAdapter.PaymentViewHolder holder, int position) {
        PayProduct payProduct = mListPay.get(position);
        if(payProduct == null){
            return;
        }else{
            holder.populate(payProduct);
        }
    }

    @Override
    public int getItemCount() {
        return mListPay != null ? mListPay.size() : 0;
    }

    public class PaymentViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgProductPay;
        private TextView tvNamePayProduct;
        private TextView tvTypeProduct;
        private TextView tvPriceProduct;
        private TextView tvQuantityPay;
        private TextView tvPayTotalQuantity;
        private TextView tvTotalPrice;

        public PaymentViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            imgProductPay = (ImageView) itemView.findViewById(R.id.img_product_pay);
            tvNamePayProduct = (TextView) itemView.findViewById(R.id.tv_name_pay_product);
            tvTypeProduct = (TextView) itemView.findViewById(R.id.tv_type_product);
            tvPriceProduct = (TextView) itemView.findViewById(R.id.tv_price_product);
            tvQuantityPay = (TextView) itemView.findViewById(R.id.tv_quantity_pay);
            tvPayTotalQuantity = (TextView) itemView.findViewById(R.id.tv_pay_total_quantity);
            tvTotalPrice = (TextView) itemView.findViewById(R.id.tv_total_price);
        }
        public void populate(PayProduct payProduct){
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            Glide.with(context).load(payProduct.getImgProduct()).into(imgProductPay);
            tvNamePayProduct.setText(payProduct.getNameProduct());
            tvPriceProduct.setText(decimalFormat.format(payProduct.getPrice())+"đ");
            String type = "";
            if(payProduct.getType() == 3){
                type = "Phụ kiện";
            }else if(payProduct.getType() == 1){
                type = "Điện thoại";
            }else if(payProduct.getType() == 2){
                type = "Máy tính";
            }
            tvTypeProduct.setText("Phân loại: "+type);
            tvQuantityPay.setText("x"+payProduct.getQuantity());
            tvPayTotalQuantity.setText("Tổng số tiền ("+payProduct.getQuantity()+" sản phẩm)");
            tvTotalPrice.setText(decimalFormat.format(payProduct.getTotalPrice())+"đ");
        }
    }

}
