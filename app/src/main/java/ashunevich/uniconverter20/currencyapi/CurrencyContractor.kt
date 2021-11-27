package ashunevich.uniconverter20.currencyapi

open interface CurrencyContractor {
    open interface Presenter {
        fun requestDataFromServer()
    }

    open interface View {
        fun onResponseFailure(throwable: Throwable?)
        fun parseDataFromResponseToHashmap(`object`: CurrencyResponseObject?)
    }

    open interface Interactor {
        open interface OnFinishedListener {
            fun onFinished(`object`: CurrencyResponseObject?)
            fun onFailure(t: Throwable?)
        }

        fun getCurrencyData(onFinishedListener: OnFinishedListener)
    }
}