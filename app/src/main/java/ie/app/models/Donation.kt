package ie.app.models

class Donation {
    var _id: String? = null
    var amount: Int
    var paymenttype: String
    var upvotes: Int

    constructor(amount: Int, method: String, upvotes: Int) {
        this.amount = amount
        paymenttype = method
        this.upvotes = upvotes
    }

    constructor() {
        amount = 0
        paymenttype = ""
        upvotes = 0
    }

    override fun toString(): String {
        return "$_id, $amount, $paymenttype, $upvotes"
    }
}
