package ashunevich.uniconverter20.currencyapi;

public class PresenterImp implements CurrencyContractor.Presenter,
        CurrencyContractor.Interactor.OnFinishedListener {

    private final CurrencyContractor.View view;
    private final CurrencyContractor.Interactor interactor;


    public PresenterImp(CurrencyContractor.View mainView,
                        CurrencyContractor.Interactor getInteractor) {
        this.view = mainView;
        this.interactor = getInteractor;
    }


    @Override
    public void requestDataFromServer() {
        interactor.getCurrencyData(this);
    }

    @Override
    public void onFinished(CurrencyResponseObject object) {
        view.parseDataFromResponseToHashmap(object);
    }

    @Override
    public void onFailure(Throwable t) {
        view.onResponseFailure(t);
    }
}
