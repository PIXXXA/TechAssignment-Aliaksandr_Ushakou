package wallee.tech.purchase_impl.domain.repository

import wallee.tech.purchase_impl.domain.model.PurchaseTransactionDomainModel

internal interface PurchaseRepository {

    suspend fun getTransactionReceipt(): PurchaseTransactionDomainModel
}
