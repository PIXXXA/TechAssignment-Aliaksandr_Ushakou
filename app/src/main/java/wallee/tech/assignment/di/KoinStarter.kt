package wallee.tech.assignment.di

import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.androidx.fragment.koin.fragmentFactory
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import wallee.tech.network.di.networkModule
import wallee.tech.purchase_impl.di.purchaseModule

fun initKoin(context: Context) {
    startKoin {
        androidLogger(Level.ERROR)
        androidContext(context)
        fragmentFactory()
        modules(
            listOf(
                networkModule,
                purchaseLaunchersModule,
                purchaseModule
            )
        )
    }
}
