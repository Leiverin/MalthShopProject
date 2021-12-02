package PayManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.example.malthshop.ActivityShowProduct;
import com.example.malthshop.R;
import com.example.malthshop.databinding.ActivityPayBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayActivity extends AppCompatActivity {
    private ActivityPayBinding binding;
    private List<PayProduct> mListPay;
    private PaymentAdapter paymentAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPayBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        mListPay = new ArrayList<>();
        paymentAdapter = new PaymentAdapter(this, mListPay);

        int type = getIntent().getIntExtra(ActivityShowProduct.KEY_TYPE_PRODUCT,-1);
        double price = getIntent().getDoubleExtra(ActivityShowProduct.KEY_PRICE_PRODUCT, -1);
        String nameProduct = getIntent().getStringExtra(ActivityShowProduct.KEY_NAME_PRODUCT);
        String linkImgProduct = getIntent().getStringExtra(ActivityShowProduct.LINK_IMAGE_PRODUCT);
        int quantity = getIntent().getIntExtra(ActivityShowProduct.KEY_QUANTITY_PRODUCT, -1);
        String orderDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date().getTime());

        mListPay.add(new PayProduct(nameProduct, linkImgProduct, orderDate, quantity, price, type));

        binding.rvPayProduct.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.rvPayProduct.setAdapter(paymentAdapter);
        if(mListPay.size() > 0){
            binding.viewNoneProduct.setVisibility(View.GONE);
            binding.tvNoneProduct.setVisibility(View.GONE);
        }else{
            binding.viewNoneProduct.setVisibility(View.VISIBLE);
            binding.tvNoneProduct.setVisibility(View.VISIBLE);
        }
    }

//    private void getSpecialProductToPay() {
//        mListFeaturedProduct = new ArrayList<>();
//        if(specialProduct != null){
//            RequestQueue queue = Volley.newRequestQueue(PayActivity.this);
//            StringRequest stringRequest = new StringRequest(Request.Method.POST, ServerLink.URL_GET_SPRODUCT_TO_PAY, new Response.Listener<String>() {
//                @Override
//                public void onResponse(String response) {
//                    try {
//                        JSONArray jsonArray = new JSONArray(response);
//                        for(int i = 0; i < jsonArray.length(); i++){
//                            JSONObject jsonObject = jsonArray.getJSONObject(i);
//                            mListFeaturedProduct.add(new Product(
//                                    jsonObject.getInt("Id"),
//                                    jsonObject.getString("ProductName"),
//                                    jsonObject.getString("Brand"),
//                                    jsonObject.getDouble("Price"),
//                                    jsonObject.getInt("Status"),
//                                    jsonObject.getString("Description"),
//                                    jsonObject.getString("Picture"),
//                                    jsonObject.getInt("IdType")
//                            ));
//                        }
//
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }, new Response.ErrorListener() {
//                @Override
//                public void onErrorResponse(VolleyError error) {
//
//                }
//            }) {
//                @Nullable
//                @org.jetbrains.annotations.Nullable
//                @Override
//                protected Map<String, String> getParams() throws AuthFailureError {
//                    Map<String,String> params = new HashMap<>();
//                    params.put("idSProduct", specialProduct.getId()+"");
//                    return params;
//                }
//            };
//            queue.add(stringRequest);
//        }
//    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_right_in_pay, R.anim.slide_right_out_pay);
    }
}