package ridertalk.conoz.com.ridertalk;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        initLayout();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(getArguments()!=null){
            mParam1=getArguments().getString(ARG_PARAM1);
        }
        mContext=getActivity().getApplicationContext();
    }

    protected void changeFragement(int fragmentId, Bundle bundle){
        ((BaseActivity)getActivity()).selectItem(fragmentId, bundle);
    }
}
