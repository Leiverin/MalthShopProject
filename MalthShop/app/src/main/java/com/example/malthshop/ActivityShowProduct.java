package com.example.malthshop;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.malthshop.databinding.ActivityShowProductBinding;

import java.text.DecimalFormat;

import Fragments.HomeFragment;
import Fragments.LaptopFragment;
import Fragments.PhoneFragment;
import ModelHome.Component;
import ModelHome.FeaturedProduct;
import ModelHome.SpecialProduct;
import ModelLaptop.ElectronicComponents;
import ModelLaptop.Mouse;
import ModelPhone.Electronic;
import ModelPhone.Product;
import SharePreferencesManager.SavePreferences;
import SubFragmentLaptop.ElectronicComponentsFragment;
import SubFragmentLaptop.MouseFragment;

public class ActivityShowProduct extends AppCompatActivity {
    ActivityShowProductBinding binding;
    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
    private ImageView imgDialog;
    private TextView tvDialogPrice;
    private ImageButton imbDialogCancel;
    private ImageButton imbDecrease;
    private TextView tvQuantity;
    private ImageButton imbIncrease;
    int totalPrice = 0;
    private String linkImg = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // If for special froduct
        SpecialProduct specialProduct = (SpecialProduct) getIntent().getSerializableExtra(HomeFragment.KEY_GET_SPECIAL_PRODUCT);
        if (specialProduct != null) {
            Glide.with(getApplicationContext()).load(specialProduct.getImg()).into(binding.imgProduct);
            binding.tvPriceProduct.setText(
                    decimalFormat.format((specialProduct.getPrice() - (specialProduct.getPrice() * (specialProduct.getPercentSale() / 100))))
                            + " VNĐ");
            linkImg = specialProduct.getImg();
            binding.tvTextDescription.setText(specialProduct.getDescription());
            binding.tvShowProductName.setText(specialProduct.getProductName());
        }

        // If for componentElectric
        Component featuredComponent = (Component) getIntent().getSerializableExtra(HomeFragment.KEY_GET_FEATURED_COMPONENT);
        Component component = (Component) getIntent().getSerializableExtra(HomeFragment.KEY_GET_COMPONENT_PRODUCT);
        if (component != null) {
            linkImg = component.getComponentImage();
            Glide.with(getApplicationContext()).load(component.getComponentImage()).into(binding.imgProduct);
            binding.tvPriceProduct.setText(decimalFormat.format(component.getPrice()) + " VNĐ");
            binding.tvShowProductName.setText(component.getComponentName());
        }

        // If for featuredProduct
        FeaturedProduct featuredProduct = (FeaturedProduct) getIntent().getSerializableExtra(HomeFragment.KEY_GET_FEATURED_PRODUCT);
        if (featuredProduct != null) {
            Glide.with(getApplicationContext()).load(featuredProduct.getImgProduct()).into(binding.imgProduct);
            linkImg = featuredProduct.getImgProduct();
            binding.tvPriceProduct.setText(decimalFormat.format(featuredProduct.getPrice()) + " VNĐ");
            binding.tvTextDescription.setText(featuredProduct.getDescription());
            binding.tvShowProductName.setText(featuredProduct.getProductName());
        }

        // If for featuredComponent
        if (featuredComponent != null) {
            linkImg = featuredComponent.getComponentImage();
            Glide.with(getApplicationContext()).load(featuredComponent.getComponentImage()).into(binding.imgProduct);
            binding.tvPriceProduct.setText(decimalFormat.format(featuredComponent.getPrice()) + " VNĐ");
            binding.tvShowProductName.setText(featuredComponent.getComponentName());
        }

        // If for H Phone
        Product highlightProduct = (Product) getIntent().getSerializableExtra(PhoneFragment.KEY_GET_HIGHLIGHT_PHONE);
        if (highlightProduct != null) {
            linkImg = highlightProduct.getPicture();
            Glide.with(getApplicationContext()).load(highlightProduct.getPicture()).into(binding.imgProduct);
            binding.tvPriceProduct.setText(decimalFormat.format(highlightProduct.getPrice()) + " VNĐ");
            binding.tvShowProductName.setText(highlightProduct.getProductName());
            binding.tvTextDescription.setText(highlightProduct.getDescription());
        }

        // If for Phone Main
        Product product = (Product) getIntent().getSerializableExtra(PhoneFragment.KEY_GET_PHONE);
        if (product != null) {
            linkImg = product.getPicture();
            Glide.with(getApplicationContext()).load(product.getPicture()).into(binding.imgProduct);
            binding.tvPriceProduct.setText(decimalFormat.format(product.getPrice()) + " VNĐ");
            binding.tvShowProductName.setText(product.getProductName());
            binding.tvTextDescription.setText(product.getDescription());
        }

        // If for PHONE ELECTRONIC COMPONENT
        Electronic electronic = (Electronic) getIntent().getSerializableExtra(PhoneFragment.KEY_GET_ELECTRONIC_COMPONENT);
        if (electronic != null) {
            linkImg = electronic.getComponentImage();
            Glide.with(getApplicationContext()).load(electronic.getComponentImage()).into(binding.imgProduct);
            binding.tvPriceProduct.setText(decimalFormat.format(electronic.getPrice()) + " VNĐ");
            binding.tvShowProductName.setText(electronic.getComponentName());
        }

        // If for LAPTOP PRODUCT
        ModelLaptop.Product mLaptopProduct = (ModelLaptop.Product) getIntent().getSerializableExtra(LaptopFragment.KEY_GET_LAPTOP_PRODUCT);
        if (mLaptopProduct != null) {
            linkImg = mLaptopProduct.getImageProduct();
            Glide.with(getApplicationContext()).load(mLaptopProduct.getImageProduct()).into(binding.imgProduct);
            binding.tvPriceProduct.setText(decimalFormat.format(mLaptopProduct.getPrice()) + " VNĐ");
            binding.tvShowProductName.setText(mLaptopProduct.getProductName());
            binding.tvTextDescription.setText(mLaptopProduct.getDescription());
        }

        // If for LAPTOP COMPONENT
        ElectronicComponents electronicComponents = (ElectronicComponents) getIntent().getSerializableExtra(ElectronicComponentsFragment.KEY_GET_COMPONENT_LAPTOP);
        if (electronicComponents != null) {
            linkImg = electronicComponents.getComponentImage();
            Glide.with(getApplicationContext()).load(electronicComponents.getComponentImage()).into(binding.imgProduct);
            binding.tvPriceProduct.setText(decimalFormat.format(electronicComponents.getPrice()) + " VNĐ");
            binding.tvShowProductName.setText(electronicComponents.getComponentName());
        }

        // If for LAPTOP COMPONENT
        Mouse mouse = (Mouse) getIntent().getSerializableExtra(MouseFragment.KEY_GET_MOUSE_LAPTOP);
        if (mouse != null) {
            linkImg = mouse.getMouseImage();
            Glide.with(getApplicationContext()).load(mouse.getMouseImage()).into(binding.imgProduct);
            binding.tvPriceProduct.setText(decimalFormat.format(mouse.getMousePrice()) + " VNĐ");
            binding.tvShowProductName.setText(mouse.getMouseName());
            binding.tvTextDescription.setText(mouse.getMouseDescription());
        }

        binding.btnBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(SavePreferences.getUser(ActivityShowProduct.this).getUsername().length() == 0){
                    SavePreferences.exchangeActivity(ActivityShowProduct.this);
                }else {
                    showDialogBuyNow(Gravity.BOTTOM);
                }
            }
        });

    }

    private void showDialogBuyNow(int bottom) {
        Dialog dialog = new Dialog(ActivityShowProduct.this);
        dialog.setContentView(R.layout.dialog_buy_now);

        Window window = dialog.getWindow();
        if (window == null) {
            return;
        }
//        int height = (int) (getResources().getDisplayMetrics().heightPixels*0.50);
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = bottom;
        windowAttributes.windowAnimations = R.style.DialogAnimation;
        window.setAttributes(windowAttributes);

        if (Gravity.BOTTOM == bottom) {
            dialog.setCancelable(true);
        } else {
            dialog.setCancelable(false);
        }

        initView(dialog);

        tvDialogPrice.setText(binding.tvPriceProduct.getText());
        Glide.with(this).load(linkImg).into(imgDialog);
        imbDialogCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        imbDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(totalPrice > 1){
                    totalPrice--;
                    tvQuantity.setText(totalPrice+"");
                }else{
                    imbDecrease.setEnabled(false);
                }
            }
        });

        imbIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imbDecrease.setEnabled(true);
                totalPrice++;
                tvQuantity.setText(totalPrice+"");
            }
        });
        dialog.show();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    private void initView(Dialog dialog) {
        imgDialog = (ImageView) dialog.findViewById(R.id.img_dialog);
        tvDialogPrice = (TextView) dialog.findViewById(R.id.txt_dialog_price);
        imbDialogCancel = (ImageButton) dialog.findViewById(R.id.imb_dialog_cancel);
        imbDecrease = (ImageButton) dialog.findViewById(R.id.imb_decrease);
        tvQuantity = (TextView) dialog.findViewById(R.id.tv_quantity);
        imbIncrease = (ImageButton) dialog.findViewById(R.id.imb_increase);
    }
}