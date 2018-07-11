package ridertalk.conoz.com.ridertalk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainFragment extends BaseFragment{
    private static String TAG = "MainFragment";

    public static MainFragment newInstance(Bundle args){
        MainFragment fragment = new MainFragment();
        if(args!=null)
            fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_main, container, false);
        super.onCreateView(inflater, container, savedInstanceState);
        return mView;
    }

    protected void initLayout(){
        if (getActivity() != null) {
            mContext=getActivity();
        }else {
            return;
        }
        Button btnWeather = (Button)mView.findViewById(R.id.btnWeather);
        btnWeather.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                Bundle bundle = new Bundle();
                bundle.putString(ARG_PARAM1, "1");
                changeFragement(Common.FRAGMENT_WEATHER, bundle);
            }
        });

        ImageButton btnGoMap = (ImageButton) mView.findViewById(R.id.btnGoMap);
        btnGoMap.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                changeFragement(Common.FRAGMENT_MAP, null);
            }
        });

        ListView listView = (ListView)mView.findViewById(R.id.list);
        if(Common.groupList!=null){
            ArrayAdapter<String>itemsAdapter=new ArrayAdapter<String>(mContext, android.R.layout.simple_list_item_1, Common.groupList);
            listView.setAdapter(itemsAdapter);
        }


    }

}
