package ashunevich.uniconverter20;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TabPositionViewModel extends ViewModel {
    private final MutableLiveData<Integer> selected = new MutableLiveData<> ();

    public void select(Integer pos) {
        selected.setValue(pos);
    }

    public LiveData<Integer> getSelected() {
        return selected;
    }

}
