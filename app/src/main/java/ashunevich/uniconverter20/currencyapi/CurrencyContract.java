package ashunevich.uniconverter20.currencyapi;

public interface CurrencyContract {


    interface CurrencyPresenter {
        void requestDataFromServer();
    }

    interface CurrencyView {

        void onResponseFailure(Throwable throwable);

        void parseDataFromResponseToHashmap(CurrencyResponseObject object);
    }

    interface currencyInteractor {

        interface OnFinishedListener {
            void onFinished(CurrencyResponseObject object);
            void onFailure(Throwable t);
        }

        void getCurrencyData(OnFinishedListener onFinishedListener);
    }
}
