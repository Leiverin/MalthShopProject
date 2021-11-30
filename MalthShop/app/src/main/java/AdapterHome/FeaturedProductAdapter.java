package AdapterHome;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.malthshop.R;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import InterfaceForHomeManager.OnEventShowFeaturedProduct;
import ModelHome.Component;
import ModelHome.FeaturedProduct;
import SharePreferencesManager.SavePreferences;

public class FeaturedProductAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    final int VIEW_COMPONENT = 1;
    final int VIEW_MAIN_PRODUCT = 2;

    private Context mContext;
    private List<FeaturedProduct> mListFeature;
    private List<Component> mListComponent;
    private OnEventShowFeaturedProduct onEventShowFeaturedProduct;

    public FeaturedProductAdapter(Context mContext, List<FeaturedProduct> mListFeature, List<Component> mListComponent, OnEventShowFeaturedProduct onEventShowFeaturedProduct) {
        this.mContext = mContext;
        this.mListFeature = mListFeature;
        this.mListComponent = mListComponent;
        this.onEventShowFeaturedProduct = onEventShowFeaturedProduct;
        notifyDataSetChanged();
    }

    @NonNull
    @NotNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        if(viewType == VIEW_MAIN_PRODUCT){
            return new MainProductViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feature_products, parent, false));
        }else if(viewType == VIEW_COMPONENT){
            return new ComponentProductViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_feature_component_products, parent, false));
        }else{
            return null;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof MainProductViewHolder){
            ((MainProductViewHolder) holder).populate(mListFeature.get(position));
        }
        if(holder instanceof ComponentProductViewHolder){
            ((ComponentProductViewHolder) holder).populate(mListComponent.get(position - mListFeature.size()));
        }
    }

    @Override
    public int getItemCount() {
        return mListComponent.size() + mListFeature.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(position < mListFeature.size()){
            return VIEW_MAIN_PRODUCT;
        }
        if((position - mListFeature.size()) < mListComponent.size()){
            return VIEW_COMPONENT;
        }
        return -1;
    }

    public class MainProductViewHolder extends RecyclerView.ViewHolder {

        private CardView cvContainer;
        private ImageView imgFeatureProduct;
        private TextView tvNameProduct;
        private TextView tvStatus;

        public MainProductViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            cvContainer = (CardView) itemView.findViewById(R.id.cv_container);
            imgFeatureProduct = (ImageView) itemView.findViewById(R.id.img_feature_product);
            tvNameProduct = (TextView) itemView.findViewById(R.id.tv_name_product);
            tvStatus = (TextView) itemView.findViewById(R.id.tv_status);
        }

        public void populate(FeaturedProduct featuredProduct){
            Glide.with(mContext).load(featuredProduct.getImgProduct()).into(imgFeatureProduct);
            tvNameProduct.setText(featuredProduct.getProductName());
            String status = featuredProduct.getStatus() == 0 ? "Còn hàng" : "Hết hàng";
            tvStatus.setText(status);
            cvContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onEventShowFeaturedProduct.onClickShowFeaturedProduct(featuredProduct);
                }
            });
        }
    }

    public class ComponentProductViewHolder extends RecyclerView.ViewHolder {

        private CardView cvContainer;
        private ImageView imgFeatureComponentProduct;
        private TextView tvNameComponentProduct;
        private TextView tvComponentStatus;

        public ComponentProductViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            initView(itemView);
        }

        private void initView(View itemView) {
            cvContainer = (CardView) itemView.findViewById(R.id.cv_container);
            imgFeatureComponentProduct = (ImageView) itemView.findViewById(R.id.img_feature_component_product);
            tvNameComponentProduct = (TextView) itemView.findViewById(R.id.tv_name_component_product);
            tvComponentStatus = (TextView) itemView.findViewById(R.id.tv_component_status);
        }
        public void populate(Component component){
            Glide.with(mContext).load(component.getComponentImage()).into(imgFeatureComponentProduct);
            tvNameComponentProduct.setText(component.getComponentName());
            String status = component.getStatus() == 0 ? "Còn hàng" : "Hết hàng";
            tvComponentStatus.setText(status);
            cvContainer.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onEventShowFeaturedProduct.onClickShowFeaturedComponent(component);
                }
            });
        }
    }
}
