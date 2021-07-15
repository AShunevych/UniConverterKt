package ashunevich.uniconverter20.currencyapi;

public class CurrencyPresenterImp implements CurrencyContract.CurrencyPresenter,
        CurrencyContract.currencyInteractor.OnFinishedListener {

    private final CurrencyContract.CurrencyView view;
    private final CurrencyContract.currencyInteractor interactor;


    public CurrencyPresenterImp(CurrencyContract.CurrencyView mainView,
                                CurrencyContract.currencyInteractor getCurrencyInteractor) {
        this.view = mainView;
        this.interactor = getCurrencyInteractor;
    }


    @Override
    public void requestDataFromServer() {
        interactor.getCurrencyData (this);
    }

    @Override
    public void onFinished(CurrencyResponseObject object) {
        view.parseDataFromResponseToHashmap (object);
    }

    @Override
    public void onFailure(Throwable t) {
        view.onResponseFailure (t);
    }
}
