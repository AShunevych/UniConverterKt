package ashunevich.uniconverter20.ui;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AppViewModel extends ViewModel {
    private final MutableLiveData<Integer> selected = new MutableLiveData<>();
    private final MutableLiveData<String> postNumber = new MutableLiveData<>();

    public void setPostNumber(String textNumber) {
        postNumber.setValue(textNumber);
    }

    public LiveData<String> getPostedNumber() {
        return postNumber;
    }

    public void select(Integer pos) {
        selected.setValue(pos);
    }

    public LiveData<Integer> getSelected() {
        return selected;
    }

}
