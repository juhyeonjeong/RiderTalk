package ridertalk.conoz.com.ridertalk;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class WeatherFragment extends BaseFragment {
    private static String TAG = "WeatherFragment";
    private String strFragmentType = "1";

    public static WeatherFragment newInstance(Bundle args){
        WeatherFragment fragment = new WeatherFragment();
        if(args!=null)
            fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        mView = inflater.inflate(R.layout.fragment_weather, container, false);
        super.onCreateView(inflater, container, savedInstanceState);
        return mView;
    }

    @Override
    protected void initLayout(){
        if(getActivity()!=null){
            mContext=getActivity();
        }else {
            return;
        }

        if(mParam1!=null){
            strFragmentType = mParam1;
        }

        Button btnClose = (Button)mView.findViewById(R.id.btnClose);
        btnClose.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v){
                if(strFragmentType.equals("2")){
                    changeFragement(Common.FRAGMENT_MAP,null);
                }else {
                    changeFragement(Common.FRAGMENT_MAIN,null);
                }
            }
        });
    }
}
