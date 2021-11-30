package SubFragmentLaptop;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.malthshop.ActivityShowProduct;
import com.example.malthshop.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import AdapterLaptop.ElectronicComponentsAdapter;
import IntefaceForLaptopManager.OnEventClickComponentLaptopListener;
import ModelLaptop.ElectronicComponents;
import URLServerLink.Sever;


public class ElectronicComponentsFragment extends Fragment {
    public static final String KEY_GET_COMPONENT_LAPTOP = "GET_COMPONENT_LAPTOP";
    private ElectronicComponentsAdapter electronicComponentsAdapter;
    List<ElectronicComponents> mListAccessories;
    private RecyclerView rv;

    public ElectronicComponentsFragment() {

    }


    public static ElectronicComponentsFragment newInstance(String param1, String param2) {
        ElectronicComponentsFragment fragment = new ElectronicComponentsFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_accessory, container, false);
        rv = view.findViewById(R.id.rvAccessory);
        mListAccessories = new ArrayList<>();
        electronicComponentsAdapter = new ElectronicComponentsAdapter(getContext(), mListAccessories, new OnEventClickComponentLaptopListener() {
            @Override
            public void onClick(ElectronicComponents electronicComponents) {
                Intent intent = new Intent(getActivity(), ActivityShowProduct.class);
                intent.putExtra(KEY_GET_COMPONENT_LAPTOP, electronicComponents);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
            }
        });
        rv.setAdapter(electronicComponentsAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 2);
        rv.setLayoutManager(gridLayoutManager);
        GetDataAccessory();
        return view;
    }

    private void GetDataAccessory() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Sever.SourceElectronicComponents, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    String componentImage = "";
                    String componentName = "";
                    int id = 0;
                    int idType = 0;
                    double price = 0;
                    int status = 0;


                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            componentImage = jsonObject.getString("ComponentImage");
                            componentName = jsonObject.getString("ComponentName");
                            id = jsonObject.getInt("Id");
                            idType = jsonObject.getInt("IdType");
                            price = jsonObject.getDouble("Price");
                            status = jsonObject.getInt("Status");
                            mListAccessories.add(new ElectronicComponents(componentImage, componentName, id, idType, price, status));
                            electronicComponentsAdapter.notifyDataSetChanged();


                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getContext(), error.toString(), Toast.LENGTH_SHORT).show();
                Log.d("AAAA", "Lỗi!\n" + error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}