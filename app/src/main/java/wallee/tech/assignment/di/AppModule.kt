package wallee.tech.assignment.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import wallee.tech.purchase_api.PurchaseLauncher
import wallee.tech.purchase_impl.navigation.PurchaseLauncherImpl

val purchaseLaunchersModule = module {
    factoryOf(::PurchaseLauncherImpl).bind<PurchaseLauncher>()
}
