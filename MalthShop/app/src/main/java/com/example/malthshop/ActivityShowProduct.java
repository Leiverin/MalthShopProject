package com.example.malthshop;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
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
import ModelHome.Product;
import ModelHome.SpecialProduct;
import PayManager.PayActivity;
import SharePreferencesManager.SavePreferences;
import SubFragmentLaptop.EarphoneFragment;
import SubFragmentLaptop.ElectronicComponentsFragment;
import SubFragmentLaptop.MouseFragment;

public class ActivityShowProduct extends AppCompatActivity {

    public static final String KEY_SPECIAL_PRODUCT = "GET_SPECIAL_PRODUCT";
    public static final String KEY_QUANTITY_PRODUCT = "GET_QUANTITY_PRODUCT";
    public static final String KEY_ID_PRODUCT = "GET_ID_PRODUCT";

    ActivityShowProductBinding binding;
    DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
    private ImageView imgDialog;
    private TextView tvDialogPrice;
    private ImageButton imbDialogCancel;
    private ImageButton imbDecrease;
    private TextView tvQuantity;
    private ImageButton imbIncrease;
    private Button btnDialogBuyNow;
    private String linkImg = "";
    private int idProduct = 0;
    private int quantity = 1;
    private SpecialProduct specialProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityShowProductBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // If for special froduct
        specialProduct = (SpecialProduct) getIntent().getSerializableExtra(HomeFragment.KEY_GET_SPECIAL_PRODUCT);
        if (specialProduct != null) {
            Glide.with(getApplicationContext()).load(specialProduct.getImg()).into(binding.imgProduct);
            binding.tvPriceProduct.setText(
                    decimalFormat.format((specialProduct.getPrice() - (specialProduct.getPrice() * (specialProduct.getPercentSale() / 100))))
                            + " VNĐ");
            idProduct = specialProduct.getId();
            linkImg = specialProduct.getImg();
            binding.tvTextDescription.setText(specialProduct.getDescription());
            binding.tvShowProductName.setText(specialProduct.getProductName());
        }

        // If for componentElectric

        Product component = (Product) getIntent().getSerializableExtra(HomeFragment.KEY_GET_COMPONENT_PRODUCT);
        if (component != null) {
            idProduct = component.getId();
            linkImg = component.getImgProduct();
            Glide.with(getApplicationContext()).load(component.getImgProduct()).into(binding.imgProduct);
            binding.tvPriceProduct.setText(decimalFormat.format(component.getPrice()) + " VNĐ");
            binding.tvShowProductName.setText(component.getProductName());
        }

        // If for product
        Product mainProduct = (Product) getIntent().getSerializableExtra(HomeFragment.KEY_GET_FEATURED_PRODUCT);
        if (mainProduct != null) {
            Glide.with(getApplicationContext()).load(mainProduct.getImgProduct()).into(binding.imgProduct);
            idProduct = mainProduct.getId();
            linkImg = mainProduct.getImgProduct();
            binding.tvPriceProduct.setText(decimalFormat.format(mainProduct.getPrice()) + " VNĐ");
            binding.tvTextDescription.setText(mainProduct.getDescription());
            binding.tvShowProductName.setText(mainProduct.getProductName());
        }

        // If for H Phone
        Product highlightProduct = (Product) getIntent().getSerializableExtra(PhoneFragment.KEY_GET_HIGHLIGHT_PHONE);
        if (highlightProduct != null) {
            idProduct = highlightProduct.getId();
            linkImg = highlightProduct.getImgProduct();
            Glide.with(getApplicationContext()).load(highlightProduct.getImgProduct()).into(binding.imgProduct);
            binding.tvPriceProduct.setText(decimalFormat.format(highlightProduct.getPrice()) + " VNĐ");
            binding.tvShowProductName.setText(highlightProduct.getProductName());
            binding.tvTextDescription.setText(highlightProduct.getDescription());
        }

        // If for Phone Main
        Product product = (Product) getIntent().getSerializableExtra(PhoneFragment.KEY_GET_PHONE);
        if (product != null) {
            idProduct = product.getId();
            linkImg = product.getImgProduct();
            Glide.with(getApplicationContext()).load(product.getImgProduct()).into(binding.imgProduct);
            binding.tvPriceProduct.setText(decimalFormat.format(product.getPrice()) + " VNĐ");
            binding.tvShowProductName.setText(product.getProductName());
            binding.tvTextDescription.setText(product.getDescription());
        }

        // If for PHONE ELECTRONIC COMPONENT
        Product electronic = (Product) getIntent().getSerializableExtra(PhoneFragment.KEY_GET_ELECTRONIC_COMPONENT);
        if (electronic != null) {
            idProduct = electronic.getId();
            linkImg = electronic.getImgProduct();
            Glide.with(getApplicationContext()).load(electronic.getImgProduct()).into(binding.imgProduct);
            binding.tvPriceProduct.setText(decimalFormat.format(electronic.getPrice()) + " VNĐ");
            binding.tvShowProductName.setText(electronic.getProductName());
        }

        // If for LAPTOP PRODUCT
        Product mLaptopProduct = (Product) getIntent().getSerializableExtra(LaptopFragment.KEY_GET_LAPTOP_PRODUCT);
        if (mLaptopProduct != null) {
            idProduct = mLaptopProduct.getId();
            linkImg = mLaptopProduct.getImgProduct();
            Glide.with(getApplicationContext()).load(mLaptopProduct.getImgProduct()).into(binding.imgProduct);
            binding.tvPriceProduct.setText(decimalFormat.format(mLaptopProduct.getPrice()) + " VNĐ");
            binding.tvShowProductName.setText(mLaptopProduct.getProductName());
            binding.tvTextDescription.setText(mLaptopProduct.getDescription());
        }

        // If for LAPTOP COMPONENT
        Product electronicComponents = (Product) getIntent().getSerializableExtra(ElectronicComponentsFragment.KEY_GET_COMPONENT_LAPTOP);
        if (electronicComponents != null) {
            idProduct = electronicComponents.getId();
            linkImg = electronicComponents.getImgProduct();
            Glide.with(getApplicationContext()).load(electronicComponents.getImgProduct()).into(binding.imgProduct);
            binding.tvPriceProduct.setText(decimalFormat.format(electronicComponents.getPrice()) + " VNĐ");
            binding.tvShowProductName.setText(electronicComponents.getProductName());
        }

        // If for LAPTOP COMPONENT
        Product mouse = (Product) getIntent().getSerializableExtra(MouseFragment.KEY_GET_MOUSE_LAPTOP);
        if (mouse != null) {
            idProduct = mouse.getId();
            linkImg = mouse.getImgProduct();
            Glide.with(getApplicationContext()).load(mouse.getImgProduct()).into(binding.imgProduct);
            binding.tvPriceProduct.setText(decimalFormat.format(mouse.getPrice()) + " VNĐ");
            binding.tvShowProductName.setText(mouse.getProductName());
            binding.tvTextDescription.setText(mouse.getProductName());
        }

        // If for earphone
        Product earphone = (Product) getIntent().getSerializableExtra(EarphoneFragment.KEY_GET_EARPHONE_LAPTOP);
        if (earphone != null) {
            idProduct = earphone.getId();
            linkImg = earphone.getImgProduct();
            Glide.with(getApplicationContext()).load(earphone.getImgProduct()).into(binding.imgProduct);
            binding.tvPriceProduct.setText(decimalFormat.format(earphone.getPrice()) + " VNĐ");
            binding.tvShowProductName.setText(earphone.getProductName());
            binding.tvTextDescription.setText(earphone.getProductName());
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
        imbDecrease.setEnabled(false);
        quantity = Integer.parseInt(tvQuantity.getText().toString());
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
                if(quantity > 1){
                    quantity--;
                    tvQuantity.setText(quantity+"");
                }else if(quantity == 1){
                    imbDecrease.setEnabled(false);
                }
            }
        });

        imbIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imbDecrease.setEnabled(true);
                quantity++;
                tvQuantity.setText(quantity+"");
            }
        });

        btnDialogBuyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ActivityShowProduct.this, PayActivity.class);
                intent.putExtra(KEY_QUANTITY_PRODUCT, quantity);
                intent.putExtra(KEY_ID_PRODUCT, idProduct);
                if(specialProduct != null){
                    intent.putExtra(KEY_SPECIAL_PRODUCT, specialProduct);
                }
                startActivity(intent);
                overridePendingTransition(R.anim.slide_right_in, R.anim.slide_right_out);
                dialog.dismiss();
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
        btnDialogBuyNow = (Button) dialog.findViewById(R.id.btn_dialog_buy_now);
    }
}