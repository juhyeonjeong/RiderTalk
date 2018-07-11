package ridertalk.conoz.com.ridertalk;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity implements IFragmentManager {
    protected List<Integer> fragmentsStack;
    protected BaseFragment currentFragment;
    
    public void selectItem(int position, Bundle bundle){
        changeFragment(position, bundle);
    }

    private void changeFragment(int fragmentId, Bundle bundle) {
        BaseFragment newFragment = null;
        if(fragmentId == Common.FRAGMENT_MAIN){
            newFragment = MainFragment.newInstance(bundle);
        }else if (fragmentId == Common.FRAGMENT_MAP){
            newFragment = MapFragment.newInstance(bundle);
        }else if (fragmentId == Common.FRAGMENT_WEATHER){
            newFragment = WeatherFragment.newInstance(bundle);
        }
        if(newFragment!=null){
            if(fragmentsStack==null){
                fragmentsStack=new ArrayList<Integer>();
                fragmentsStack.add(fragmentId);
                currentFragment = newFragment;
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.content_frame, newFragment);
            }
        }
    }


}
