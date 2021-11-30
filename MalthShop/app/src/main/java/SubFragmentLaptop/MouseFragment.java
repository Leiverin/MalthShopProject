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

import AdapterLaptop.MouseAdapter;
import IntefaceForLaptopManager.OnEventClickMouseListener;
import ModelLaptop.Mouse;
import URLServerLink.Sever;


public class MouseFragment extends Fragment {
    public static final String KEY_GET_MOUSE_LAPTOP = "GET_MOUSE_LAPTOP";
    ArrayList<Mouse> mListMouse;
    private RecyclerView rv;
    private MouseAdapter mouseAdapter;

    public MouseFragment() {

    }

    public static MouseFragment newInstance(String param1, String param2) {
        MouseFragment fragment = new MouseFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_mouse,container,false);
        mListMouse = new ArrayList<>();
        mouseAdapter = new MouseAdapter(getContext(), mListMouse, new OnEventClickMouseListener() {
            @Override
            public void onClick(Mouse mouse) {
                Intent intent = new Intent(getActivity(), ActivityShowProduct.class);
                intent.putExtra(KEY_GET_MOUSE_LAPTOP, mouse);
                startActivity(intent);
                getActivity().overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

            }
        });
        rv = v.findViewById(R.id.rvFragmentMouse);
        rv.setAdapter(mouseAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),2);

        rv.setLayoutManager(gridLayoutManager);
        GetDataMouse();
        return v;
    }
    // get du lieu san pham
    private void GetDataMouse() {
        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Sever.SourceMouse, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    int Id = 0;
                    String Name = "";
                    double price = 0;
                    int status = 0;
                    String description = "";
                    String image = "";

                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            Id = jsonObject.getInt("Id");
                            description = jsonObject.getString("MouseDescription");
                            image = jsonObject.getString("MouseImage");
                            Name = jsonObject.getString("MouseName");
                            price = jsonObject.getDouble("MousePrice");
                            status = jsonObject.getInt("MouseStatus");

                            mListMouse.add(new Mouse(Id, description, image,Name, price, status));
                            mouseAdapter.notifyDataSetChanged();
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