package wallee.tech.purchase_impl.di

import androidx.navigation.NavController
import org.koin.core.module.dsl.singleOf
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.bind
import org.koin.dsl.module
import wallee.tech.network.di.createWebService
import wallee.tech.purchase_impl.data.api.PurchaseApi
import wallee.tech.purchase_impl.data.repository_impl.PurchaseRepositoryImpl
import wallee.tech.purchase_impl.domain.repository.PurchaseRepository
import wallee.tech.purchase_impl.presentation.purchase.PurchaseViewModel
import wallee.tech.purchase_impl.presentation.receipt.ReceiptViewModel

val purchaseModule by lazy {
    module {
        singleOf(::PurchaseRepositoryImpl).bind<PurchaseRepository>()
        single { createWebService<PurchaseApi>(get()) }

        viewModel { (navController: NavController) ->
            PurchaseViewModel(
                navController = navController
            )
        }

        viewModel { (amount: String) ->
            ReceiptViewModel(
                amount = amount,
                purchaseRepository = get(),
            )
        }
    }
}
