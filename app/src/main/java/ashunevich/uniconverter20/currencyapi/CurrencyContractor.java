package ashunevich.uniconverter20.currencyapi;

public interface CurrencyContractor {


    interface Presenter {
        void requestDataFromServer();
    }

    interface View {

        void onResponseFailure(Throwable throwable);

        void parseDataFromResponseToHashmap(CurrencyResponseObject object);
    }

    interface Interactor {

        interface OnFinishedListener {
            void onFinished(CurrencyResponseObject object);

            void onFailure(Throwable t);
        }

        void getCurrencyData(OnFinishedListener onFinishedListener);


    }
}
